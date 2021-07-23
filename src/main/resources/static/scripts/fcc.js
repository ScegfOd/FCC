async function invalid() {
    let url = 'http://localhost:9000/invalid'
    let response = await fetch(url)
    let element = document.getElementById("invalid")
    let login_status = await response.json()
    if (login_status == "invalid"){
        element.innerHTML += "Incorrect Login. Try Again."
    } else if (login_status == "not manager") {
		element.innerHTML += "Must be logged in as a manager<br>to access that page."
	} else if (login_status == "not employee") {
		element.innerHTML += "Must be logged in as an employee<br>to access that page."
	}
}

window.onload = function () {
    this.invalid()
}

