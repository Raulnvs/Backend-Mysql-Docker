
window.onload = function() {
    const select = document.getElementById("potencial");
    const pacienteInputs = document.getElementById("pacienteInputs");
    const guardarDatosButton = document.getElementById("guardarDatos");
    const tratamientoInputs = document.getElementById("tratamientoInputs");
    const guardarDatosTratamientoButton = document.getElementById("guardarDatosTratamiento");

    pacienteInputs.style.display = "none"; // Ocultar los campos de entrada inicialmente
    guardarDatosButton.style.display = "none"; // Ocultar el botón "Guardar Datos" inicialmente
    tratamientoInputs.style.display = "none"; // Ocultar los campos de entrada de tratamiento inicialmente
    guardarDatosTratamientoButton.style.display = "none"; // Ocultar el botón "Guardar Datos de Tratamiento" inicialmente

    select.addEventListener("change", function () {
        if (select.value === "A") {
            pacienteInputs.style.display = "flex"; // Mostrar los campos de entrada si se selecciona "Añadir Paciente"
            guardarDatosButton.style.display = "flex"; // Mostrar el botón "Guardar Datos"
            tratamientoInputs.style.display = "none"; // Ocultar los campos de entrada de tratamiento
            guardarDatosTratamientoButton.style.display = "none"; // Ocultar el botón "Guardar Datos de Tratamiento"
        } else if (select.value === "B") {
            pacienteInputs.style.display = "none"; // Ocultar los campos de entrada
            guardarDatosButton.style.display = "none"; // Ocultar el botón "Guardar Datos"
            tratamientoInputs.style.display = "flex"; // Mostrar los campos de entrada de tratamiento
            guardarDatosTratamientoButton.style.display = "flex"; // Mostrar el botón "Guardar Datos de Tratamiento"
        } else {
            pacienteInputs.style.display = "none"; // Ocultar los campos de entrada en otras opciones seleccionadas
            guardarDatosButton.style.display = "none"; // Ocultar el botón "Guardar Datos"
            tratamientoInputs.style.display = "none"; // Ocultar los campos de entrada de tratamiento
            guardarDatosTratamientoButton.style.display = "none"; // Ocultar el botón "Guardar Datos de Tratamiento"
        }
    });

    // Boton para guardar datos del paciente
    guardarDatosButton.addEventListener("click", function () {
        // Obtener los valores del paciente
        const id = document.getElementById("id").value;
        const nombre = document.getElementById("nombre").value;
        const apellidos = document.getElementById("apellidos").value;
        const telefono = document.getElementById("telefono").value;
        const email = document.getElementById("email").value;
        const dni = document.getElementById("dni").value;
        const fechaNac = document.getElementById("fechaNac").value;

        const data = {
            id: id,
            nombre: nombre,
            apellidos: apellidos,
            telefono: telefono,
            email: email,
            dni: dni,
            fechaNac: fechaNac
        };

//Enviar los datos del paciente a la api con fetch y el metodo post
        fetch("http://localhost:8080/insertPaciente?parametro=jsonPaciente", {
            method: "POST",
            headers: {
                "Content-Type": "application/json" // Tipo de contenido json
            },
            body: JSON.stringify(data) // Convierte el objeto en una cadena json
        })
            .then(response => response.json()) // Convierte la respuesta en json
            .then(result => {
                console.log("Respuesta de la API:", result); // Muestra la respuesta de la api
            })
            .catch(error => {
                console.error("Error al guardar los datos del paciente:", error);
            });

        // Reiniciar los valores
        document.getElementById("id").value = "";
        document.getElementById("nombre").value = "";
        document.getElementById("apellidos").value = "";
        document.getElementById("telefono").value = "";
        document.getElementById("email").value = "";
        document.getElementById("dni").value = "";
        document.getElementById("fechaNac").value = "";
    });

    // Botón para guardar datos de tratamiento.
    guardarDatosTratamientoButton.addEventListener("click", function () {
        // Obtener los valores del tratamiento
        const idTratamiento = document.getElementById("idTratamiento").value;
        const idPaciente = document.getElementById("idPaciente").value;
        const fecha = document.getElementById("fecha").value;
        const descripcion = document.getElementById("descripcion").value;
        const coste = document.getElementById("coste").value;


    //Crear objeto con los datos del tratamiento
        const data = {
            idTratamiento: idTratamiento,
            idPaciente: idPaciente,
            fecha: fecha,
            descripcion: descripcion,
            coste: coste
        };
        // Envia los datos del tratamiento a la api utilizando fetch y metodo post
        fetch("http://localhost:8080/insertTratamiento?parametro=jsonTratamiento", {
            method: "POST",
            headers: {
                "Content-Type": "application/json" // Tipo de contenido json
            },
            body: JSON.stringify(data) // Convierte el objeto en cadena json
        })
            .then(response => response.json()) // Convierte la respuesta en json
            .then(result => {
                console.log("Respuesta de la API:", result); // Muestra la respuesta de la api
            })
            .catch(error => {
                console.error("Error al guardar los datos del tratamiento:", error);
            });

        // Reiniciar los valores
        document.getElementById("idTratamiento").value = "";
        document.getElementById("idPaciente").value = "";
        document.getElementById("fecha").value = "";
        document.getElementById("descripcion").value = "";
        document.getElementById("coste").value = "";
    });
};
