var cost = []
var items = []
var cartItemNumber = 0
if(localStorage.getItem("cart")){
    let itemArray = localStorage.getItem("cart").split(",")
    let costArray = localStorage.getItem("itemCost").split(",")

    let i = 0;
    for(item of itemArray){
        items[i] = item
        cost[i] = costArray[i]
        i++
    }

    cartItemNumber = localStorage.getItem("cartItemNumber")
}

if (document.addEventListener) {
    document.addEventListener("click", handleClick, false);
}

window.addEventListener("DOMContentLoaded", (event) => {
    let count = 0
    for(productNameClass of document.getElementsByClassName("productName")){
        productName = productNameClass.firstElementChild.innerHTML
        for(item of items){
            if(item === productName){
                document.getElementsByClassName("count")[count].firstElementChild.innerHTML = parseInt(document.getElementsByClassName("count")[count].firstElementChild.innerHTML) + 1
            }
        }
        count++
    }
})

function handleClick(event) {

    if(event.target.id === "add"){
        addButtonHandler(event)
    }
    else if(event.target.id === "subtract"){
        subtractButtonHandler(event)
    }

}

function addButtonHandler(event){
    const thisCost = parseFloat(event.target.parentElement.previousElementSibling.previousElementSibling.firstElementChild.innerHTML.split("$")[0])
    const thisItemName = event.target.parentElement.previousElementSibling.previousElementSibling.previousElementSibling.firstElementChild.innerHTML
    let thisItemCount = event.target.parentElement.nextElementSibling.firstElementChild.innerHTML

    if(thisItemCount < 99){
        event.target.parentElement.nextElementSibling.firstElementChild.innerHTML = parseInt(event.target.parentElement.nextElementSibling.firstElementChild.innerHTML) + 1

        cost[cartItemNumber] = thisCost.toFixed(2)
        items[cartItemNumber] = thisItemName
        cartItemNumber++

        localStorage.setItem("cart", items)
        localStorage.setItem("cartItemNumber", cartItemNumber)
        localStorage.setItem("itemCost", cost)
    }
}

function subtractButtonHandler(event){
    const thisCost = parseFloat(event.target.parentElement.previousElementSibling.previousElementSibling.previousElementSibling.previousElementSibling.firstElementChild.innerHTML.split("$")[0])
    const thisItemName = event.target.parentElement.previousElementSibling.previousElementSibling.previousElementSibling.previousElementSibling.previousElementSibling.firstElementChild.innerHTML

    let count = 0
    for(item of items){
        if(item === thisItemName){
            items.splice(count, 1)
            cost.splice(count, 1)
            cartItemNumber -= 1
            event.target.parentElement.previousElementSibling.firstElementChild.innerHTML = parseInt(event.target.parentElement.previousElementSibling.firstElementChild.innerHTML) - 1
            break
        }
        count++
    }
    
    localStorage.setItem("cart", items)
    localStorage.setItem("cartItemNumber", cartItemNumber)
    localStorage.setItem("itemCost", cost)
}