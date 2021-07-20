function get_order_status(){
	let url = "http://localhost:9000/orders/id/" + document.getElementById("idinput").value
	fetch(url, {
		method: "GET",
		mode: "cors",
	}).then(response =>{
		console.log("reply:")
		console.log(response)
		return response.json()
	}).catch(err =>{
		console.log("mistakes were made:")
		console.log(err)
	}).then(response_dict =>{
		console.log("final step:")
		console.log(response_dict)
		console.log(typeof(response_dict))
		if (typeof(response_dict) == "object"){
			let img = document.getElementById("statusimg")
			if (response_dict.status === "completed"){
				img.src = "images/status3.jpg"
			}else if (response_dict.status === "ready for pickup"){
				img.src = "images/status2.jpg"
			}else if (response_dict.status === "canceled"){
				img.src = "images/status0.jpg"
			}else{
				img.src = "images/status1.jpg"
			}
		}else{
			document.getElementById("statusimg").src = "images/status.jpg"
			input = document.getElementById("idinput")
			input.style.border = "1em solid red"
			msg = document.getElementById("msg")
			msg.textContent = "invalid order id"
			msg.style.border = "1em solid red"
			msg.style.textAlign = "center"
			setTimeout(()=>{
				input.style.border = "0em solid red"
				input.value = ""
				msg.style.border = "0em solid red"
				msg.textContent = ""
			}, 3000)
		}
	})
}

function reset_img(){
	document.getElementById("statusimg").src = "images/status.jpg"
	document.getElementById("idinput").value = ""
}
