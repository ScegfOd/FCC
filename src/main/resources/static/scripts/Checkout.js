var itemList
var itemCostList

window.addEventListener("DOMContentLoaded", (event) => {
    if(localStorage.getItem("cart")){
        itemList = localStorage.getItem("cart").split(",")
        itemCostList = localStorage.getItem("itemCost").split(",")

        loadTable(itemList, itemCostList)
        document.getElementById("itemTable").style = "display:block"
        document.getElementById("myform").style = "display:flex"
        document.getElementById("noItems").style = "display:none"
        document.getElementById("cartTitle").style = "display:block"
        document.getElementById("billingTitle").style = "display:block"
    }
})

if (document.addEventListener) {
    document.addEventListener("click", handleClick, false);
}

function handleClick(event) {
    console.log(event.target.id)
    console.log(event.target.innerHTML)
    console.log(event.target.name)
    console.log(event)
    console.log(event.target)

    if (event.target.id === "Remove") {
        removeButtonHandler(event)
    }
    else if(event.target.name === "checkout"){
        checkoutButtonHandler()
    }

}

function loadTable(itemList, itemCostList){
    const itemTable = document.getElementById("itemTable")

    let individualItemCostTotal = {}
    let individualItemAmount = {}
    let individualItemList = []
    let itemTotal = 0
    let i = 0
    let count = 0
    for(item of itemList){

        if(!individualItemList.includes(item)){
            individualItemList[i] = item
            individualItemCostTotal[item] = parseFloat(itemCostList[count])
            itemTotal += parseFloat(itemCostList[count])
            individualItemAmount[item] = 1
            i++
        }
        else{
            individualItemCostTotal[item] += parseFloat(itemCostList[count])
            itemTotal += parseFloat(itemCostList[count])
            individualItemAmount[item] += 1
        }
        count++
    }

    for(item of individualItemList){
        const itemRow = document.createElement("tr")

        const itemAmount = document.createElement("td")
        const amountNode = document.createTextNode(individualItemAmount[item]);
        itemAmount.appendChild(amountNode)

        const itemName = document.createElement("td")
        const nameNode = document.createTextNode(item);
        itemName.appendChild(nameNode)

        const itemCost = document.createElement("td")
        const costNode = document.createTextNode(individualItemCostTotal[item].toFixed(2));
        itemCost.appendChild(costNode)

        const removeButton = document.createElement("td")
        const removeButtonNode = document.createElement("input");
        removeButtonNode.type = "button"
        removeButtonNode.name = "Remove"
        removeButtonNode.value = "Remove"
        removeButton.appendChild(removeButtonNode)

        itemTable.appendChild(itemRow)
        itemRow.appendChild(itemAmount)
        itemRow.appendChild(itemName)
        itemRow.appendChild(itemCost)
        itemRow.appendChild(removeButton)
    }

        const itemRow = document.createElement("tr")

        const itemAmount = document.createElement("td")
        const amountNode = document.createTextNode("");
        itemAmount.appendChild(amountNode)

        const itemName = document.createElement("td")
        const nameNode = document.createTextNode("Total");
        itemName.style = "padding-top: 20px"
        itemName.appendChild(nameNode)

        const itemCost = document.createElement("td")
        const costNode = document.createTextNode(itemTotal.toFixed(2));
        itemCost.id = "total"
        itemCost.style = "padding-top: 20px"
        itemCost.appendChild(costNode)

        const removeButton = document.createElement("td")
        const removeButtonNode = document.createTextNode("");
        removeButton.appendChild(removeButtonNode)

        itemTable.appendChild(itemRow)
        itemRow.appendChild(itemAmount)
        itemRow.appendChild(itemName)
        itemRow.appendChild(itemCost)
        itemRow.appendChild(removeButton)
}

function removeButtonHandler(event){
    event.target.parentElement.parentElement.remove()
    element = event.target.parentElement.previousElementSibling.previousElementSibling.innerHTML
    localStorage.removeItem("cart")
    localStorage.removeItem("itemCost")
    while(itemList.includes(element)){
        let i = 0
        for(item of itemList){
            if(item === element){
                itemList.splice(i, 1)
                itemCostList.splice(i, 1)
                localStorage.setItem("cartItemNumber", (localStorage.getItem("cartItemNumber")-1))
            }
            i++
        }
    }
    localStorage.setItem("cart", itemList)
    localStorage.setItem("itemCost", itemCostList)

    total = 0
    count = 0
    for(item of itemCostList){
        total += parseFloat(itemCostList[count])
        count++
    }
    document.getElementById("total").innerHTML = total.toFixed(2)
}

function checkoutButtonHandler(){
    let cNumber = document.getElementById("card").value
    const cvv = document.getElementById("cvv").value
    const date = document.getElementById("date").value

    cNumberLength = cNumber.toString().length

    if(!cNumber){
        console.log("Enter Card Number")
    }
    else if(!cvv){
        console.log("Enter cvv number")
    }
    else if(!date){
        console.log("Enter date")
    }
    else if(cNumberLength !== 16){
        console.log("Use a correct card number")
    }
    else{
        let url = "http://localhost:9000/orders"
        fetch(url, {
            method: "POST",
            mode: "cors",
            body: JSON.stringify(orderBody()),
        }).then(response =>{response.text().then(function(text) {
                localStorage.clear()
                localStorage.setItem("orderId", text)
                window.location.href = "http://localhost:9000/status.html";
            })
        })
    }
}

function orderBody(){
    const obj = {}
    obj["customerId"] = "guest"
    obj["items"] = localStorage.getItem("cart")
    obj["total"] = document.getElementById("total").innerHTML
    obj["timePlaced"] = new Date()

    return obj
}