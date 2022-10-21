const sizeBtns = document.querySelector(".product-size");
const selectBtn = document.querySelectorAll(".add-btn, buy-btn");
const addBtn = document.querySelector(".add-btn");
const buyBtn = document.querySelector(".buy-btn"); 
 let productCode = location.pathname.substring(location.pathname.lastIndexOf("/") + 1);

 load("/api/v1/product/");

 function load(uri) {
   
    $.ajax({
       async: false,
       type: "get",
       url: uri + productCode, 
       dataType: "json", 
       success: (response) => {
          console.log(JSON.stringify(response.data));
         getDetail(response.data);
      },
       error:(error) => {
          console.log(error);
       }
    })
 }

 function getDetail(product) {
    const productImages = document.querySelector(".product-imgs");
    const productTitle = document.querySelector(".product-title");
    const productPrice = document.querySelector(".product-price span");
   const productSize = document.querySelectorAll(".size-button");
    const productDetails = document.querySelector(".tee-kind");
   
   productImages.innerHTML = product.fileCode; 
    productTitle.innerHTML = product.productName; 
    productPrice.innerHTML = product.productPrice;
    productSize.innerHTML = product.productSize; 
    productDetails.innerHTML = product.productInfo; 
    
   productImages.innerHTML = 
   
	`<img src="/image/product/${product.fileName}" alt="${product.fileName}">
	<img src="/image/product/${product.fileName}" alt="${product.fileName}">`;
 }


const sizeBtn = document.getElementsByClassName("size-button");

function handleClick(event) {
  console.log(event.target);
  // console.log(this);
  // 콘솔창을 보면 둘다 동일한 값이 나온다

  console.log(event.target.classList);

  if (event.target.classList[1] === "clicked") {
    event.target.classList.remove("clicked");
  } else {
    for (let i = 0; i < sizeBtn.length; i++) {
        sizeBtn[i].classList.remove("clicked");
    }
    event.target.classList.add("clicked");
  }
}

function init() {
  for (let i = 0; i < sizeBtn.length; i++) {
   
    sizeBtn[i].addEventListener("click", handleClick);
  }
  
}

init();

