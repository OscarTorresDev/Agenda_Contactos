async function añadirContacto() {
    const nombre = document.getElementById("nombre").value;
    const apellido = document.getElementById("apellido").value;
    const telefono = document.getElementById("telefono").value;

    if (!nombre || !apellido || !telefono) {
        alert("Todos los campos son obligatorios.");
        return;
    }

    const data = { nombre, apellido, telefono };

    const response = await fetch("http://localhost:8080/añadir", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    });

   /* const result = await response.json();
    alert(result.message);*/
    obtenerContactos();
}

async function obtenerContactos() {
    console.log("obteniendo");
    const response = await fetch("http://localhost:8080/listar");
    const contactos = await response.json();

    const tbody = document.getElementById("listaContactos");
    tbody.innerHTML = "";
    
    contactos.forEach(contacto => {
        const row = `<tr>
            <td>${contacto.nombre}</td>
            <td>${contacto.apellido}</td>
            <td>${contacto.telefono}</td>
            <td><button onclick="eliminarContacto('${contacto.nombre}', '${contacto.apellido}')">Eliminar</button></td>
        </tr>`;
        tbody.innerHTML += row;
    });
}

async function eliminarContacto(nombre, apellido) {
    const response = await fetch(`http://localhost:8080/eliminar?nombre=${nombre}&apellido=${apellido}`, {
        method: "DELETE"
    });

    const result = await response.json();
    alert(result.message);
    obtenerContactos();
}

document.addEventListener("DOMContentLoaded", obtenerContactos);
