const updateBtn = document.querySelector(".update-btn");
const updateAddressesArea = document.querySelector(".update-addresses-area");
const addressesShowHideInfo = document.querySelector(".addresses-show-hide-info");
const addAddressesBtn = document.querySelector(".add-addresses-btn");
const addressesListTxt = document.querySelector(".addresses-list-txt");
const createAddressesArea = document.querySelector(".create-addresses-area");

updateBtn.onclick = () => {
    if(updateAddressesArea.style.display != 'none') {
        updateAddressesArea.style.display = 'block'
        addressesShowHideInfo.style.display = 'none';
        addAddressesBtn.style.height = "20px"
    } else {
        updateAddressesArea.style.display = 'none'
    }
     
}

addAddressesBtn.onclick = () => {
    if(updateAddressesArea.style.display == 'block') {
        updateAddressesArea.style.display = 'none'
        updateAddressesArea.style.height = '427px'
        createAddressesArea.style.display = 'block'
    } else {
        addressesShowHideInfo.style.display = 'none';
        addAddressesBtn.style.height = "20px"
        createAddressesArea.style.display = 'block'
    }
}


