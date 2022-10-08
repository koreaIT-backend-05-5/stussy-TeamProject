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

const body = document.querySelector("body");
const collectionProducts = document.querySelector(".collection-products")

let page = 1;
let totalPage = 0;
let contentCount = 16;

load(page);

function load(page) {
	
	$.ajax({
		async: false,
		type: "get",
		url: `/api/v1/product/list/${page}`, 
		data: {
			"page" : page,
			"contentCount": contentCount
		},
		dataType: "json", 
		success: (response) => {
			getShopList(response.data);
		},
		error:(error) => {
			console.log(error);
		}
	})
}

function setTotalCount(totalProductCount) {
	totalPage = totalProductCount % contentCount == 0 ? totalProductCount / contentCount : Math.floor(totalProductCount / contentCount) + 1;
}

function getShopList(productList){
	console.log(productList);
	const collectionProducts = document.querySelector(".collection-products")
	setTotalCount(productList[0].totalProductCount);
	if(page == 1){
		collectionProducts.innerHTML = "";		
	}

	productList.forEach(product => {
	
		
		collectionProducts.innerHTML += `
			<li class="collection-product collection-product-${page}">
			<input type="hidden" value="${product.productCode}">
				<div class="shop-box">
					<div class="product-img">
						<a>
							<img src="/image/product/${product.fileName}" alt="${product.fileName}">
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
	
	const collectionProduct = document.querySelectorAll(`.collection-product`);
	
	console.log("collectionProduct: " + collectionProduct[0].classList)
	console.log(productList)
	for(let i = 0; i < collectionProduct.length; i++){
		
		collectionProduct[i].onclick = () => {
			location.href = "/stussy/detail/" + collectionProduct[i].querySelector("input").value;
		}
		
	}
	//alert(page)

}

// console.log("전체 높이: " + collectionProducts.clientHeight) //전체높이
// console.log("현제 보이는 높이: " + collectionBody.offsetHeight) //바디높이
// console.log("스크롤 최상단 위치: " + collectionBody.scrollTop) //scrollTOP
body.onscroll = () => {	
	const de = document.documentElement;
	let checkNum = de.offsetHeight - de.clientHeight - de.scrollTop;

	console.log("결과: " + checkNum);
	console.log(page);
	console.log(totalPage);
	if(checkNum < 200 && checkNum > -1 && page < totalPage){
		//alert("새로운 리스트 가져오기")	
		console.log(page);
		console.log(totalPage);
		page++;
		load(page);
	}
}






























