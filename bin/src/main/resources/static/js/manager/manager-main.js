
const productUpdateBtn = document.querySelector(".product-update-btn");
const productListBtn = document.querySelector(".product-list-btn");
const contactBtn = document.querySelector(".contact-btn");


productUpdateBtn.onclick = () => {
	location.href = "/manager/product-update";
}
	

productListBtn.onclick = () => {
	location.href = "/manager/product-list";
}

contactBtn.onclick = () => {
	location.href = "/contact/manager/list";
}
	
	

