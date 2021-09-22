if (document.readyState == 'loading') {
    document.addEventListener('DOMContentLoaded', ready)
} else {
    ready()
}

function ready() {
    var removeCartItemButtons = document.getElementsByClassName('btn-danger') //will return all "REMOVE" cart item buttons
    for (var i = 0; i < removeCartItemButtons.length; i++) {
        var button = removeCartItemButtons[i]
        //this is how we add a listener to know when to do something on button
        button.addEventListener('click', removeCartItem)
    }

    var addItemButtons = document.getElementsByClassName('shop-item-button') //should return all "ADD TO CART" buttons
    for (var i = 0; i < addItemButtons.length; i++) {
        var button = addItemButton[i]
        //this is how we add a listener to know when to do something on button
        button.addEventListener('click', addItem)
    }
}

function removeCartItem(event) {
    //target is whatever button we clicked on from the event listener 
    var buttonClicked = event.target
    buttonClicked.parentElement.parentElement.remove() //to get the cart row we want to remove
    updateCartTotal()
}

//not sure how to do this one yet - still following video
function addItem(event){
    //target is whatever button we clicked on from the event listener 
    var buttonClicked = event.target
    updateCartTotal()
}

function updateCartTotal() {
    //only want the first cart item, since this returns an array of elements but we only have one "cart-items" element
    var cartItemContainer = document.getElementsByClassName('cart-items')[0]
    //this will return all of the items that we have available for purchase
    var cartRows = cartItemContainer.getElementsByClassName('cart-row')
    //total of cart
    var total = 0;
    for (var i = 0; i <cartRows.length; i++) {
        var cartRow = cartRows[i]
        //get the price of the element we are looping over
        var priceElement = cartRow.getElementsByClassName('cart-price')[0]
        //get the quantity of items within this element in the cart
        var quantityElement = cartRow.getElementsByClassName('cart-quantity-input')[0]
        //get the actual price amount in a variable to be used, rather than the element like above
        var price = parseFloat(priceElement.innerText.replace('$', '')) //replace used to remove dollar sign, and need it to be a float
        var quantity = quantityElement.value
        total = total + (price * quantity)
    }
    document.getElementsByClassName('cart-total-price')[0].innerText = '$' + total
}