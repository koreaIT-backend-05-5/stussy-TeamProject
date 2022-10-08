const sizeBtns = document.querySelector(".size-button");
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
	const productTitle = document.querySelector(".product-title");
	const productPrice = document.querySelector(".product-price span");
	const productSize = document.querySelectorAll(".size-button");
	const productDetails = document.querySelector(".tee-kind");
	const productImages = document.querySelector(".product-imgs");
	
	productTitle.innerHTML = product.productName; 
	productPrice.innerHTML = product.productPrice;
	productSize.innerHTML = product.productSize; 
	productDetails.innerHTML = product.productExplanation; 
	
	productImages.innerHTML = 
	`<img src="/image/product/${product.fileName}" alt="${product.fileName}">
	<img src="/image/product/${product.fileName}" alt="${product.fileName}">`;
	
}

sizeBtns.onclick = () => {
	alert("test");
}



// selectBtn.onclick = (e) => {
//     alert("사이즈를 선택해주세요");
//     location.assign("/cart/cart")
// }

// for(let i = 0; i < sizeBtns.length; i++) {
//     sizeBtns[i].onclick = () => {
//         sizeBtns.forEach(sizeBtn => {
//             sizeBtn.classList.remove("select-size")
//         });
        
//         sizeBtns[i].classList.add("select-size");

//         selectBtn.onclick = () => {
//             if(sizeBtns[i].classList.add){
//                 change();
//             }
//         }
//     }
// }

// function change() {
//     purchaseGroup.innerHTML= "/cart/cart";
//     purchaseGroup.innerHTML= "/cart/cart";
// }
