window.onload = function () {
    const select = document.getElementById("potencial");
    const pacienteInputs = document.getElementById("pacienteInputs");
    const guardarDatosButton = document.getElementById("guardarDatos");
    const tratamientoInputs = document.getElementById("tratamientoInputs");
    const guardarDatosTratamientoButton = document.getElementById("guardarDatosTratamiento");
    const listarPacienteApellidosInputs = document.getElementById("listarPacienteApellidos");
    const listarPacienteButton = document.getElementById("listarPaciente");
    const listarTratamientoDNIInputs = document.getElementById("listarTratamientoDNIpacienteInputs");
    const listarTratamientoDNIbutton = document.getElementById("listarTratamientoButton");
    const cobrarInput = document.getElementById("cobrarInput");
    const cobrarButton = document.getElementById("cobrarButton");


  
    pacienteInputs.style.display = "none"; // Ocultar los campos de entrada inicialmente
    guardarDatosButton.style.display = "none"; // Ocultar el botón "Guardar Datos" inicialmente
    tratamientoInputs.style.display = "none"; // Ocultar los campos de entrada de tratamiento inicialmente
    guardarDatosTratamientoButton.style.display = "none"; // Ocultar el botón "Guardar Datos de Tratamiento" inicialmente
    listarPacienteApellidosInputs.style.display = "none";
    listarPacienteButton.style.display = "none";
    listarTratamientoDNIInputs.style.display = "none";
    listarTratamientoDNIbutton.style.display = "none";
    cobrarInput.style.display="none";
    cobrarButton.style.display="none";
  
  
    select.addEventListener("change", function () {
      if (select.value === "A") {
        pacienteInputs.style.display = "flex"; // Mostrar los campos de entrada si se selecciona "Añadir Paciente"
        guardarDatosButton.style.display = "flex"; // Mostrar el botón "Guardar Datos"
        tratamientoInputs.style.display = "none"; // Ocultar los campos de entrada de tratamiento
        guardarDatosTratamientoButton.style.display = "none"; // Ocultar el botón "Guardar Datos de Tratamiento"
        listarPacienteButton.style.display = "none";
        listarPacienteApellidosInputs.style.display = "none";
        listarTratamientoDNIbutton.style.display = "none";
        listarTratamientoDNIInputs.style.display = "none";
        cobrarInput.style.display="none";
        cobrarButton.style.display="none";
      } else if (select.value === "B") {
        tratamientoInputs.style.display = "flex"; // Mostrar los campos de entrada de tratamiento
        guardarDatosTratamientoButton.style.display = "flex"; // Mostrar el botón "Guardar Datos de Tratamiento"
  
        pacienteInputs.style.display = "none"; // Ocultar los campos de entrada
        guardarDatosButton.style.display = "none"; // Ocultar el botón "Guardar Datos"
        listarPacienteButton.style.display = "none";
        listarPacienteApellidosInputs.style.display = "none";
        listarPacienteButton.style.display = "none";
        listarTratamientoDNIbutton.style.display = "none";
        listarTratamientoDNIInputs.style.display = "none";
        cobrarInput.style.display="none";
        cobrarButton.style.display="none";
  
      } else if (select.value === "C") {
        listarPacienteButton.style.display = "flex";
        listarPacienteApellidosInputs.style.display = "flex";
  
        pacienteInputs.style.display = "none"; // Ocultar los campos de entrada
        guardarDatosButton.style.display = "none"; // Ocultar el botón "Guardar Datos"
        tratamientoInputs.style.display = "none"; // Mostrar los campos de entrada de tratamiento
        guardarDatosTratamientoButton.style.display = "none"; // Mostrar el botón "Guardar Datos de Tratamiento"
        listarTratamientoDNIbutton.style.display = "none";
        listarTratamientoDNIInputs.style.display = "none";
        cobrarInput.style.display="none";
        cobrarButton.style.display="none";
      } else if (select.value === "D") {
        listarPacienteButton.style.display = "none";
        listarTratamientoDNIInputs.style.display = "flex";
        listarTratamientoDNIbutton.style.display = "flex";
  
        pacienteInputs.style.display = "none"; // Ocultar los campos de entrada
        guardarDatosButton.style.display = "none"; // Ocultar el botón "Guardar Datos"
        tratamientoInputs.style.display = "none"; // Mostrar los campos de entrada de tratamiento
        guardarDatosTratamientoButton.style.display = "none"; // Mostrar el botón "Guardar Datos de Tratamiento"
        listarPacienteButton.style.display = "none";
        listarPacienteApellidosInputs.style.display = "none";
        cobrarInput.style.display="none";
        cobrarButton.style.display="none";
      }else if(select.value === "E"){
        cobrarInput.style.display="flex";
        cobrarButton.style.display="flex";
        listarPacienteButton.style.display = "none";
        listarTratamientoDNIInputs.style.display = "none";
        listarTratamientoDNIbutton.style.display = "none";
  
        pacienteInputs.style.display = "none"; // Ocultar los campos de entrada
        guardarDatosButton.style.display = "none"; // Ocultar el botón "Guardar Datos"
        tratamientoInputs.style.display = "none"; // Mostrar los campos de entrada de tratamiento
        guardarDatosTratamientoButton.style.display = "none"; // Mostrar el botón "Guardar Datos de Tratamiento"
        listarPacienteButton.style.display = "none";
        listarPacienteApellidosInputs.style.display = "none";
        
      }else {
        listarPacienteButton.style.display = "none";
        listarTratamientoDNIInputs.style.display = "none";
        listarTratamientoDNIbutton.style.display = "none";
  
        pacienteInputs.style.display = "none"; // Ocultar los campos de entrada
        guardarDatosButton.style.display = "none"; // Ocultar el botón "Guardar Datos"
        tratamientoInputs.style.display = "none"; // Mostrar los campos de entrada de tratamiento
        guardarDatosTratamientoButton.style.display = "none"; // Mostrar el botón "Guardar Datos de Tratamiento"
        listarPacienteButton.style.display = "none";
        listarPacienteApellidosInputs.style.display = "none";
        cobrarInput.style.display="none";
        cobrarButton.style.display="none";
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
        fechaNac: fechaNac,
      };
  
      // Enviar los datos del paciente a la API con fetch y el método POST
      fetch("http://localhost:8080/paciente", {
        method: "POST",
        headers: {
          "Content-Type": "application/json", // Tipo de contenido json
        },
        body: JSON.stringify(data), // Convierte el objeto en una cadena json
      })
        .then((response) => response.json()) // Convierte la respuesta en json
        .then((result) => {
          console.log("Respuesta de la API:", result); // Muestra la respuesta de la API
        })
        .catch((error) => {
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
  
      // Crear objeto con los datos del tratamiento
      const data = {
        idTratamiento: idTratamiento,
        idPaciente: idPaciente,
        fecha: fecha,
        descripcion: descripcion,
        coste: coste,
      };
  
      // Enviar los datos del tratamiento a la API utilizando fetch y método POST
      fetch("http://localhost:8080/tratamiento", {
        method: "POST",
        headers: {
          "Content-Type": "application/json", // Tipo de contenido json
        },
        body: JSON.stringify(data), // Convierte el objeto en cadena json
      })
        .then((response) => response.json()) // Convierte la respuesta en json
        .then((result) => {
          console.log("Respuesta de la API:", result); // Muestra la respuesta de la API
        })
        .catch((error) => {
          console.error("Error al guardar los datos del tratamiento:", error);
        });
  
      // Reiniciar los valores
      document.getElementById("idTratamiento").value = "";
      document.getElementById("idPaciente").value = "";
      document.getElementById("fecha").value = "";
      document.getElementById("descripcion").value = "";
      document.getElementById("coste").value = "";
    });
  
    listarPacienteButton.addEventListener("click", function () {
      const apellidos = document.getElementById("listarPacienteApellidos").value;
  
      fetch("http://localhost:8080/listarPaciente?apellidos=" + apellidos)
        .then((response) => response.json())
        .then((result) => {
          console.log("Respuesta de la API:", result); // Muestra la respuesta de la API
        })
        .catch((error) => {
          console.error("Error al listar los pacientes:", error);
        });
  
      // Reiniciar el valor
      document.getElementById("listarPacienteApellidos").value = "";
    });
  
    listarTratamientoDNIbutton.addEventListener("click", function () {
      const dni = document.getElementById("listarTratamientoDNIpacienteInputs").value;
  
      fetch("http://localhost:8080/listarTratamiento?dni=" + dni)
        .then((response) => response.json())
        .then((result) => {
          console.log("Respuesta de la API:", result); // Muestra la respuesta de la API
        })
        .catch((error) => {
          console.error("Error al listar los tratamientos:", error);
        });
  
      // Reiniciar el valor
      document.getElementById("listarTratamientoDNIpacienteInputs").value = "";
    });
    cobrarButton.addEventListener("click", function () {
        const codigoTratamiento = document.getElementById("cobrarInput").value;
      
        fetch("http://localhost:8080/verificarCobro?codigoTratamiento=" + codigoTratamiento)
          .then((response) => response.json())
          .then((result) => {
            if (result.valid) {
              if (result.cobrado) {
                console.log("El tratamiento ya está cobrado.");
              } else {
                console.log("El tratamiento no está cobrado. Proceder con el cobro.");
                // Aquí puedes realizar las acciones necesarias para efectuar el cobro del tratamiento
              }
            } else {
              console.log("El código de tratamiento no corresponde al paciente.");
            }
          })
          .catch((error) => {
            console.error("Error al verificar el cobro del tratamiento:", error);
          });
      
        // Reiniciar el valor
        document.getElementById("cobrarInput").value = "";
      });
      


  };
  