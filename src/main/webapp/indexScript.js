async function personaleLogin() { //Stjålet fra Christian
    // Serialiser formen til js-objekt
    let loginform = document.getElementById("loginform");
    const formData = new FormData(loginform);
    const object = Object.fromEntries(formData);
    console.log(object)
    //Bruger fetch-API til at sende data - POST. JSON.stringify for at serialisere objekt til string.
    const res = await fetch("api/login", {
        method: "POST",
        body: JSON.stringify(object),
        headers: {
            "content-type": "application/json"
        }
    })
    window.location.href="PersonaleLogin.html"
}

async function patientLogin() { //Stjålet fra Christian
    // Serialiser formen til js-objekt
    let loginform = document.getElementById("patientlogin");
    const formData = new FormData(loginform);
    const object = Object.fromEntries(formData);
    console.log(object)
    //Bruger fetch-API til at sende data - POST. JSON.stringify for at serialisere objekt til string.
    const res = await fetch("api/login", {
        method: "POST",
        body: JSON.stringify(object),
        headers: {
            "content-type": "application/json"
        }
    })
    window.location.href="PatientLogin.html"
}