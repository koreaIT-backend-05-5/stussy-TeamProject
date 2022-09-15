const sizeBtns = document.querySelectorAll(".size-button");
const selectBtn = document.querySelector(".product-button");

selectBtn.onclick = (e) => {
    alert("사이즈를 선택해주세요");
}

for(let i = 0; i < sizeBtns.length; i++) {
    sizeBtns[i].onclick = () => {
        sizeBtns.forEach(sizeBtn => {
            sizeBtn.classList.remove("select-size")
        });
        
        sizeBtns[i].classList.add("select-size");

        selectBtn.onclick = () => {
            if(sizeBtns[i].classList.add){
                change();
            }
        }
    }
}

function change() {
    purchaseGroup.innerHTML= "/cart/cart";
    purchaseGroup.innerHTML= "/cart/cart";
}
