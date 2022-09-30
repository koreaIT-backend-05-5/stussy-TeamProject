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
	
}
