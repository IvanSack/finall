document.getElementById('formOdontologo').addEventListener('submit', function (event) {
    event.preventDefault();

    const nombre = document.getElementById('nombre').value;
    const apellido = document.getElementById('apellido').value;
    const matricula = document.getElementById('matricula').value;

    fetch('/odontologos', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ nombre, apellido, matricula }),
    })
        .then(response => response.json())
        .then(data => {
            console.log('Odontólogo creado:', data);
        })
        .catch(error => {
            console.error('Error:', error);
        });
});
