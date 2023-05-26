window.onload = function() {
    const select = document.getElementById("potencial");
    const pacienteInputs = document.getElementById("pacienteInputs");

    select.addEventListener("change", function () {
        if (select.value === "A") {
            pacienteInputs.classList.remove("hidden");
        } else {
            pacienteInputs.classList.add("hidden");
        }
    });
};