package com.agenda.proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgendaGUI extends JFrame {
    private Agenda agenda;
    private JTextField nombreField, apellidoField, telefonoField;
    private JTextArea displayArea;

    public AgendaGUI() {
        agenda = new Agenda();
        setTitle("Agenda de Contactos");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Campos de entrada
        nombreField = new JTextField(10);
        apellidoField = new JTextField(10);
        telefonoField = new JTextField(10);

        // Área de texto para mostrar contactos
        displayArea = new JTextArea(15, 30);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        // Botones
        JButton addButton = new JButton("Añadir Contacto");
        JButton listButton = new JButton("Listar Contactos");
        JButton searchButton = new JButton("Buscar Contacto");
        JButton deleteButton = new JButton("Eliminar Contacto");

        // Listeners de los botones
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addContact();
            }
        });

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listContacts();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchContact();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteContact();
            }
        });

        // Añadir componentes a la interfaz
        add(new JLabel("Nombre:"));
        add(nombreField);
        add(new JLabel("Apellido:"));
        add(apellidoField);
        add(new JLabel("Teléfono:"));
        add(telefonoField);
        add(addButton);
        add(listButton);
        add(searchButton);
        add(deleteButton);
        add(scrollPane);

        setVisible(true);
    }

    private void addContact() {
        String nombre = nombreField.getText().trim();
        String apellido = apellidoField.getText().trim();
        int telefono;
        try {
            telefono = Integer.parseInt(telefonoField.getText().trim());
            Contacto contacto = new Contacto(nombre, apellido, telefono);
            if (agenda.añadirContacto(contacto)) {
                displayArea.setText("Contacto añadido:\n" + contacto);
            }
        } catch (NumberFormatException e) {
            displayArea.setText("Error: Teléfono debe ser un número.");
        } catch (IllegalArgumentException e) {
            displayArea.setText(e.getMessage());
        }
    }

    private void listContacts() {
        displayArea.setText("Lista de contactos:\n");
        for (Contacto c : agenda.getContactos()) {
            displayArea.append(c + "\n");
        }
    }

    private void searchContact() {
        String nombre = nombreField.getText().trim();
        String apellido = apellidoField.getText().trim();
        Contacto contactoBuscado = new Contacto(nombre, apellido, 0);

        if (agenda.existeContacto(contactoBuscado)) {
            displayArea.setText("Contacto encontrado: " + contactoBuscado);
        } else {
            displayArea.setText("Contacto no encontrado.");
        }
    }

    private void deleteContact() {
        String nombre = nombreField.getText().trim();
        String apellido = apellidoField.getText().trim();
        Contacto contactoEliminar = new Contacto(nombre, apellido, 0);

        if (agenda.eliminarContacto(contactoEliminar)) {
            displayArea.setText("Contacto eliminado.");
        } else {
            displayArea.setText("Error: El contacto no existe.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AgendaGUI());
    }
}
