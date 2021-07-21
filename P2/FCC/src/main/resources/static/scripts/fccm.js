async function get_stats() {
	let url = 'http://localhost:9000/orders/stats'
	let response = await fetch(url)
	let stats = await response.json()
	let table = document.getElementById("statsTable")
	var rowCount = table.rows.length
	var row = table.insertRow(rowCount)
	row.insertCell(0).innerHTML = stats["Q1 Revenue"]
	row.insertCell(1).innerHTML = stats["Q2 Revenue"]
	row.insertCell(2).innerHTML = stats["Q3 Revenue"]
	row.insertCell(3).innerHTML = stats["Q4 Revenue"]
	row.insertCell(4).innerHTML = stats["Total Revenue"]
}

async function get_orders() {
	let url = 'http://localhost:9000/orders'
	let response = await fetch(url)
	let orders = await response.json()
	for (let key in orders) {
		let table = document.getElementById("ordersTable")
		var rowCount = table.rows.length
		var row = table.insertRow(rowCount)
		row.insertCell(0).innerHTML = orders[key].id
		row.insertCell(1).innerHTML = orders[key].items
		row.insertCell(2).innerHTML = '$' + orders[key].total.toFixed(2)
		row.insertCell(3).innerHTML = orders[key].status
		if (orders[key].status != 'canceled') {
			row.insertCell(4).innerHTML = '<input type="button" value = "cancel" id="cancel' + `${rowCount}` + '" onClick="Javacsript:Cancel(this)">'			
		}
		else{
			row.insertCell(4).innerHTML = 'refunded'
		}
	}
}

function Cancel(obj) {
    let index = obj.parentNode.parentNode.rowIndex
    fetch('http://localhost:9000/orders/cancel/'+`${index}`, {
      method: 'PATCH',
      headers: {
        'content-type': 'application/json',
        authorization: 'Bearer 123abc456def'
               },
            body: JSON.stringify({"employeeId":"admin22","notes":"canceled by customer"})
    })
    setTimeout(location.reload.bind(location), 600);
}

disableEnterKey: function disableEnterKey(e){
        var key;
        if(window.event)
            key = window.event.keyCode; //IE
        else
            key = e.which; //firefox
        return (key != 13);
}

window.onload = function() {
	this.get_stats()
	this.get_orders()
}