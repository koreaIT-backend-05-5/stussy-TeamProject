const categorySelectInput = document.querySelector(".category-select .product-input");
const searchInput = document.querySelector(".product-search .product-input");
const searchButton = document.querySelector(".search-button"); 

let category = 0;
let searchText = null;
let nowPage = 1;

load(nowPage);

//db 데이터 불러오는 ajax
function load(nowPage) {
	
	setCategoryCodeAndSearchText();
	
	$.ajax({
		async: false,
		type: "get",
		url: `/api/v1/manager/product-list/${nowPage}?productCategoryCode=${category}&searchText=${searchText}`,
		
		dataType: "json",
		success: (response) => {
			if(response.data[0] != null) {
				getList(response.data);
				getPageNumbers(response.data[0].totalProductCount);
			}else{
				getList(new Array());
				getPageNumbers(0);
			}
		},
		error: (error) => {
			console.log(error);
		}		
	});
	
}

categorySelectInput.onchange = () => {
    nowPage = 1;
    clearInputValue(searchInput)
    load(nowPage);
}


searchInput.onkeyup = () => {
    if(window.event.keyCode == 13) {
        searchButton.click();
    }
}

searchButton.onclick = () => {
    nowPage = 1;
    load(nowPage);
}


// 카테고리 코드, 검색 키워드 값 세팅
function setCategoryCodeAndSearchText() {
	category = categorySelectInput.value == "none" ? 0 : categorySelectInput.value;
    searchText = searchInput.value;
}

function clearInputValue(input) {
	input.value = "";
}


//상품 리스트 불러오기
function getList(list){
	const tbody = document.querySelector("tbody");
	tbody.innerHTML = "";
	
	list.forEach(product => {
		tbody.innerHTML += `
			<tr class="productList-${product.productCode}">
                <td>${product.productCode}</td>
                <td>${product.categoryName}</td>
                <td>${product.productName}</td>
                <td>${product.productPrice}</td>
                <td>${product.productCount}</td>
                <td>${product.productSize}</td>
                <td><button type="button" class="list-button detail-button"><i class="fa-regular fa-file-lines"></i></button></td>
            	<td><button type="button" class="list-button delete-btn"><i class="fa-regular fa-trash-can"></i></button></td>             
            </tr>
		`;
	});
	
	//상품 삭제
	const deleteBtns = document.querySelectorAll(".delete-btn");
	
		for(let i = 0; i < deleteBtns.length; i++) {
		deleteBtns[i].onclick = () => {
			console.log(list[i]);
			$.ajax({
				async: false,
				type: "delete",
				url: `/api/v1/manager/product-list/${list[i].productCode}`,
				dataType: "json",
				success: () => {
					alert("삭제 완료");
					location.replace("/manager/product-list");
			
				},
				error: (error) => {
					console.log(error);
			}
		});
		
	}
}

	//상품 수정 페이지로 넘어가기
	const modifyBtns = document.querySelectorAll(".detail-button");	
	
	for(let i = 0; i < modifyBtns.length; i++) {
		modifyBtns[i].onclick = () => {
			location.href = `/manager/product-modify/${list[i].productCode}`
		}
	}
}	
	
	

	
function getPageNumbers(totalProductCount) {
	const pageButtons = document.querySelector(".page-buttons");

	
	const totalPageCount = totalProductCount % 10 == 0 ? totalProductCount / 10 : Math.floor(totalProductCount / 10) + 1;
	
	const startIndex = nowPage % 5 == 0 ? nowPage - 4 : nowPage - (nowPage % 5) + 1;
	const endIndex = startIndex + 4 <= totalPageCount ? startIndex + 4 : totalPageCount;
	
	console.log(
		`
			totalPageCount: ${totalPageCount}
			startIndex: ${startIndex}
			endIndex: ${endIndex}
		`
		
	);
	
	pageButtons.innerHTML = ``;
	
	if(startIndex != 1) {
		pageButtons.innerHTML += `
			<button type="button" class="page-button pre">&lt;</button>
		`;
	}
	
	for(let i = startIndex; i <= endIndex; i++) {
		pageButtons.innerHTML += `
			<button type="button" class="page-button">${i}</button>
		`
	}
	
	if(endIndex != totalPageCount) {
		pageButtons.innerHTML += `
			<button type="button" class="page-button next">&gt;</button>
		`;
	}
	
	
	
	// 다음 페이지로 넘기기
	const pageNumberButtons = document.querySelectorAll(".page-button");
	
		pageNumberButtons.forEach(button => {
			if(button.textContent != "<" && button.textContent != ">"){
				button.onclick = () => {
					nowPage = button.textContent;
					load(nowPage);
				}
			}
		});
	}