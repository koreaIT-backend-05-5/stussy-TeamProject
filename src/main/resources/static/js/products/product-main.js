/*
let nowPage = 1;

load(nowPage)

function load(nowPage) {
	const searchFlag = document.querySelector(".").value;
	const searchValue = document.querySelector(".").value;
	
	$.ajax({
		async: false, 
		type: "get",
		url: "/api/v1/product" + nowPage,
		data: {
			"searchFlag" : searchFlag,
			"searchValue" : searchValue
		},
		dataType: "json",
		success: (response) => {
			getShopList(response.data);
		},
		error: (error) => {
			console.log(error); 
		}
		
	});
}
*/
let page = 1;

load(page);

function load(page) {
	
	$.ajax({
		async: false,
		type: "get",
		url: `/api/v1/product/list/${page}`, 
		dataType: "json", 
		success: (response) => {
			getShopList(response.data);
		},
		error:(error) => {
			console.log(error);
		}
	})
}

function getShopList(productList){
	console.log(productList);
	const collectionProducts = document.querySelector(".collection-products")
	collectionProducts.innerHTML = "";
	
	productList.forEach(product => {
		collectionProducts.innerHTML += `
			<li class="collection-product">
				<div class="shop-box">
					<div class="product-img">
						<a>
							${product.productCode}
						</a>
					</div>
					<a>
						<p>${product.productName}</p>
					</a>
					<p>${product.productPrice}</p>
				</div>
			</li>
		`;
	}); 
}































