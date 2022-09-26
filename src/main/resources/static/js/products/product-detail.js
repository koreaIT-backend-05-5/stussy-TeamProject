const sizeBtns = document.querySelector(".product-size");
const selectBtn = document.querySelectorAll(".add-btn, buy-btn");
// const addBtn = document.querySelector(".add-btn");
// const buyBtn = document.querySelector(".buy-btn"); 

sizeBtns.onclick = (e) => {
    confirm("사이즈 확실함?")
}

selectBtn.onclick = (e) => {
    alert("사이즈를 선택해주세요");
    location.assign("/cart/cart")
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
