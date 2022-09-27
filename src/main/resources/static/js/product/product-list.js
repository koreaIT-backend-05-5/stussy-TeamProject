

let nowPage = 1;

load(nowPage);

//db 데이터 불러오는 ajax
function load(nowPage) {
	
	$.ajax({
		async: false,
		type: "get",
		url: "/api/v1/manager/product-list/" + nowPage,
		
		dataType: "json",
		success: (response) => {
			if(response.data[0] != null) {
				getList(response.data);
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
//상품 리스트 불러오기
function getList(list){
	const tbody = document.querySelector("tbody");
	tbody.innerHTML = "";
	
	list.forEach(product => {
		tbody.innerHTML += `
			<tr class="product-row">
				<td><input type="checkbox"></td>
                <td>${product.productCode}</td>
                <td><img class="product-img" src="/image/product/${product.fileName}"></td>
                <td>${product.productCategory}</td>
                <td>${product.productPrice}</td>
                <td>${product.productSize}</td>
                <td>${product.productExplanation}</td>
                <td>
	                <button type="button" class="detail-button modify">수정</button>
	                <button type="button" class="detail-button delete">삭제</button>
	             </td>
            </tr>
		`;
	});
	
	//상품 수정 페이지로 넘어가기
	const modifyBtns = document.querySelectorAll(".product-row .modify");
	
	
	for(let i = 0; i < modifyBtns.length; i++) {
		modifyBtns[i].onclick = () => {
			location.href = `/manager/product-modify/${list[i].productCode}`
		}
	}
	
	// 상세페이지 넘어가기(회원이 볼 때 하기.)
//	const productRows = document.querySelectorAll(".product-row");
//	productRows.forEach((row) => {
//		row.onclick = () => {
//			const productCode = row.querySelectorAll("td")[0].textContent;
//			//location.href = "/manager/product-list/" + productCode;
//		}
//	});

	
}
