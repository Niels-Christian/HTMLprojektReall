function logintrial() {
    const userName = document.getElementById("username").value;
    const passWord = document.getElementById("password").value;
    if (userName == "qq" && passWord == "qq") {

        return true;

    } else {
        location.reload();
        alert("WRONG USERNAME OR PASSWORD!!!!")
        return false;
    }
}


