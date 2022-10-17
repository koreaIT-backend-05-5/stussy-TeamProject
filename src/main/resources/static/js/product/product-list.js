const categorySelectInput = document.querySelector(".category-select .product-input");
const searchInput = document.querySelector(".product-search .product-input");
const searchButton = document.querySelector(".search-button"); 

let productDataList = null;

let nowPage = 1;

getList(nowPage);

//db 데이터 불러오는 ajax
function getList(nowPage) {
	
	$.ajax({
		async: false,
		type: "get",
		url: "/api/v1/manager/product-list/" + nowPage,
		dataType: "json",
		success: (response) => {
			if(response.data[0] != null) {
				addProducts(response.data);
				getPageNumbers(response.data[0].totalProductCount);
				productDataList = response.data;
                addProducts(productDataList);
			}else{
				addProducts(new Array());
				getPageNumbers(0);
			}
		},
		error: (error) => {
			console.log(error);
		}		
	});
	
}

//상품 리스트 불러오기
function addProducts(list){
	const tbody = document.querySelector("tbody");
	tbody.innerHTML = "";
	
	list.forEach(product => {
		tbody.innerHTML += `
			<tr>
                <td>${product.productCode}</td>
                <td>${product.categoryName}</td>
                <td>${product.productName}</td>
                <td>${product.productPrice}</td>
                <td>${product.productSize}</td>
                <td><button type="button" class="list-button detail-button"><i class="fa-regular fa-file-lines"></i></button></td>
            	<td><button type="button" class="list-button delete-button"><i class="fa-regular fa-trash-can"></i></button></td>             
            </tr>
          	<tr class="product-detail detail-invisible">
            
        	</tr>
		`;
	});
	
	const detailButtons = document.querySelectorAll(".detail-button");
    const productDetails = document.querySelectorAll(".product-detail");

    detailButtons.forEach((detailButton, index) => {
        detailButton.onclick = () => {

            if(productDetails[index].classList.contains("detail-invisible")) {
                let changeRequestFlag = false;
                let changeFlag = false;
                
                productDetails.forEach((productDetail, index2) => {
                    if(!productDetail.classList.contains("detail-invisible") && index2 != index){
                        changeRequestFlag = true;
                        changeFlag = confirm("수정을 취소하시겠습니까?");
                        if(changeFlag) {
                            productDetail.classList.add("detail-invisible");
                            productDetail.innerHTML = "";
                            getProductDetail(productDetails[index], index);
                            productDetails[index].classList.remove("detail-invisible");
                        }
                    }else {
                        if(changeRequestFlag && changeFlag) {
                            getProductDetail(productDetails[index], index);
                            productDetails[index].classList.remove("detail-invisible");
                        }else if(!changeRequestFlag) {
                            getProductDetail(productDetails[index], index);
                            productDetails[index].classList.remove("detail-invisible");
                        }
                    }
                });
                
            }else{
                if(confirm("수정을 취소하시겠습니까?")){
                    productDetails[index].classList.add("detail-invisible");
                    productDetails[index].innerHTML = "";
                }
            }            
        }
    });
}

function getProductDetail(productDetail, index) {
    productDetail.innerHTML = `
    <td colspan="8">
        <table class="product-info">
            <tr>
                <td><input type="text" class="product-input" value="${productDataList[index].prodictPrice}" placeholder="가격"></td>
                <td><input type="text" class="product-input" value="${productDataList[index].productSize}" placeholder="사이즈"></td>
            </tr>
            <tr>
                <td colspan="3">
                    <textarea class="product-input" placeholder="설명">${productDataList[index].productInfo}</textarea>
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    <form enctype="multipart/form-data">
                        <div class="product-img-inputs">
                            <label>상품 이미지</label>
                            <button type="button" class="add-button">추가</button>
                            <input type="file" class="file-input product-invisible" name="file" multiple>
                        </div>
                    </form>
                    <div class="product-images">

                    </div>
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    <button type="button" class="black-button update-button">수정하기</button>
                </td>
            </tr>
        </table>
    </td>
    `;
    
}

	/*------------------------------------------------------------*/
	//상품 삭제
	const deleteBtns = document.querySelectorAll(".delete");
	
		for(let i = 0; i < deleteBtns.length; i++) {
		deleteBtns[i].onclick = () => {
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
	const modifyBtns = document.querySelectorAll(".product-row .modify");	
	
	for(let i = 0; i < modifyBtns.length; i++) {
		modifyBtns[i].onclick = () => {
			location.href = `/manager/product-modify/${list[i].productCode}`
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

