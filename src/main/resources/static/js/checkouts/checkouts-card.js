const diffrenceShippingAddressesBtn = document.querySelector("#diffrence-shipping-addresses");
const sameShippingAddressesBtn = document.querySelector(".same-shipping-addresses-btn");
const diffrenceAddressesInfoArea = document.querySelector(".diffrence-addresses-info-area");

diffrenceShippingAddressesBtn.onclick = () => {
    diffrenceAddressesInfoArea.style.display = 'block';
}

sameShippingAddressesBtn.onclick = () => {
    diffrenceAddressesInfoArea.style.display = 'none';
}