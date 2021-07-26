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

    if (event.target.name === "Remove") {
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
        removeButtonNode.id = "Remove"
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
    const nameNode = document.createTextNode("Subtotal");
    itemName.style = "padding-top: 20px"
    itemName.appendChild(nameNode)

    const itemCost = document.createElement("td")
    const costNode = document.createTextNode(itemTotal.toFixed(2));
    itemCost.id = "subtotal"
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


    const itemRow1 = document.createElement("tr")

    const itemAmount1 = document.createElement("td")
    const amountNode1 = document.createTextNode("");
    itemAmount1.appendChild(amountNode1)

    const itemName1 = document.createElement("td")
    const nameNode1 = document.createTextNode("Tax");
    itemName1.appendChild(nameNode1)

    const itemCost1 = document.createElement("td")
    const costNode1 = document.createTextNode((itemTotal * .12).toFixed(2));
    itemCost1.id = "tax"
    itemCost1.appendChild(costNode1)

    const removeButton1 = document.createElement("td")
    const removeButtonNode1 = document.createTextNode("");
    removeButton1.appendChild(removeButtonNode1)

    itemTable.appendChild(itemRow1)
    itemRow1.appendChild(itemAmount1)
    itemRow1.appendChild(itemName1)
    itemRow1.appendChild(itemCost1)
    itemRow1.appendChild(removeButton1)


    const itemRow2 = document.createElement("tr")

    const itemAmount2 = document.createElement("td")
    const amountNode2 = document.createTextNode("");
    itemAmount2.appendChild(amountNode2)

    const itemName2 = document.createElement("td")
    const nameNode2 = document.createTextNode("Total");
    itemName2.appendChild(nameNode2)

    const itemCost2 = document.createElement("td")
    const costNode2 = document.createTextNode(((itemTotal*.12)+itemTotal).toFixed(2));
    itemCost2.id = "total"
    itemCost2.appendChild(costNode2)

    const removeButton2 = document.createElement("td")
    const removeButtonNode2 = document.createTextNode("");
    removeButton2.appendChild(removeButtonNode2)

    itemTable.appendChild(itemRow2)
    itemRow2.appendChild(itemAmount2)
    itemRow2.appendChild(itemName2)
    itemRow2.appendChild(itemCost2)
    itemRow2.appendChild(removeButton2)
}

function removeButtonHandler(event){
    console.log("something")
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
    document.getElementById("subtotal").innerHTML = total.toFixed(2)
    document.getElementById("tax").innerHTML = (total * .12).toFixed(2)
    document.getElementById("total").innerHTML = ((total*.12)+total).toFixed(2)
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