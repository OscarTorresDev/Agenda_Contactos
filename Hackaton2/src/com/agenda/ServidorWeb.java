package com.agenda;

import com.agenda.clases.Agenda;
import com.agenda.clases.Contacto;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;


import java.io.*;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class ServidorWeb
{
    private static Agenda agenda = new Agenda(10);

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // Ruta para listar contactos (GET)
        server.createContext("/listar", new HttpHandler() {
            public void handle(HttpExchange exchange) throws IOException
            {
                if ("GET".equalsIgnoreCase(exchange.getRequestMethod()))
                {
                    System.out.println("listando");
                    List<Contacto> contactos = agenda.getListaContactos();

                    String json = contactos.stream()
                            .map(c -> String.format("{\"nombre\":\"%s\",\"apellido\":\"%s\",\"telefono\":%d}",
                                    c.getNombre(), c.getApellido(), c.getTelefono()))
                            .collect(Collectors.joining(",", "[", "]"));
                    System.out.println(json);
                    addCorsHeaders(exchange);
                    exchange.getResponseHeaders().set("Content-Type", "application/json");

                    exchange.sendResponseHeaders(200, json.length());
                    OutputStream os = exchange.getResponseBody();
                    os.write(json.getBytes());
                    os.close();
                } else {
                    sendMethodNotAllowed(exchange);
                }
            }
        });

        // Ruta para añadir contactos (POST)
        server.createContext("/añadir", new HttpHandler() {
            public void handle(HttpExchange exchange) throws IOException {
                if ("OPTIONS".equalsIgnoreCase(exchange.getRequestMethod())) {
                    handleCorsPreflight(exchange);
                    return;
                }

                if ("POST".equalsIgnoreCase(exchange.getRequestMethod())) {
                    InputStream is = exchange.getRequestBody();
                    String body = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))
                            .lines().collect(Collectors.joining("\n"));

                    System.out.println("Datos recibidos: " + body);

                    // Procesar JSON manualmente (puedes usar una librería JSON como Gson)
                    String[] parts = body.replace("{", "").replace("}", "").replace("\"", "").split(",");
                    String nombre = parts[0].split(":")[1].trim();
                    String apellido = parts[1].split(":")[1].trim();
                    String telefono = parts[2].split(":")[1].trim();

                    agenda.anadirContacto(new Contacto(nombre, apellido, telefono));

                    addCorsHeaders(exchange);
                    exchange.sendResponseHeaders(201, -1); // 201 Created sin respuesta
                } else {
                    sendMethodNotAllowed(exchange);
                }
            }
        });

        server.setExecutor(null);
        server.start();
        System.out.println("Servidor iniciado en http://localhost:8080");
    }

    // Método para agregar los encabezados CORS en todas las respuestas
    private static void addCorsHeaders(HttpExchange exchange) {
        exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
        exchange.getResponseHeaders().set("Access-Control-Allow-Methods", "GET, POST, DELETE, OPTIONS");
        exchange.getResponseHeaders().set("Access-Control-Allow-Headers", "Content-Type");
    }

    // Manejo de preflight CORS
    private static void handleCorsPreflight(HttpExchange exchange) throws IOException {
        addCorsHeaders(exchange);
        exchange.sendResponseHeaders(204, -1); // 204 No Content
    }

    // Método para responder con "405 Method Not Allowed"
    private static void sendMethodNotAllowed(HttpExchange exchange) throws IOException {
        exchange.sendResponseHeaders(405, -1);
    }
}
