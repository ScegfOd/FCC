// this function needs to be refactor to fit with java backend
// this not only gives incorrect login but it should also reset 
// the incorrect login message when user clicks or enters home page address in broswer
async function invalid() {
    let url = 'http://localhost:5000/invalid'
    let response = await fetch(url)
    let element = document.getElementById("invalid")
    if (await response.json() == "invalid"){
        element.innerHTML += "Incorrect Login. Try Again."
    }
}

window.onload = function () {
    this.invalid()
}

