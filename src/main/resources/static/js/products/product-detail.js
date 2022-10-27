const productSizeBtn = document.querySelectorAll(".size-button");
const addBagBtn = document.querySelector(".add-btn");
const buyBtn = document.querySelector(".buy-btn");

 
let size = null;

//url에 찍힌 상품코드 찾기
let productCode = location.pathname.substring(location.pathname.lastIndexOf("/") + 1);

// 상품상세 페이지
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
 // 장바구니 담기
addBagBtn.onclick = request;

productSizeBtn.forEach(button => {
	button.onclick = () => {
		size = button.textContent;
	}
});

function request() {
	console.log(user.user_code);
	console.log(productCode);
	console.log(size);
	$.ajax({
		async: false,
		type: "post",
		url: "/api/v1/cart",
		data: {
			"userCode": user.user_code,
			"productCode": productCode,
			"bagProductSize": size
		},
		dataType: "json",
		success: (response) => {
			alert("완료");
			bagButton.click();
		},
        error: (error) => {
			if(error.status == 400){
				alert("이미 장바구니에 들어있습니다.")
			}else{
	            alert("실패");
	            console.log(error);				
			}
        }
	});
	  
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

