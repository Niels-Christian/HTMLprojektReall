async function truePersonaleLogin() {
    // Serialiser formen til js-objekt
    let loginform = document.getElementById("personaleform");
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
    const token = await res.text();
    localStorage.setItem("token", token);
    window.location.href = "PersonaleHome.html"
}