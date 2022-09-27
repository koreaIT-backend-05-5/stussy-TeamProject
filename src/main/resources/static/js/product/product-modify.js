let submitButton = document.querySelector(".submit");

const productCode = location.pathname.substring(location.pathname.lastIndexOf("/") + 1);
 
getProductDetailData();
console.log(productCode);

//데이터를 가져오는 ajax

function getProductDetailData () {
		
		let productDetailData = null;
		
       $.ajax({
		async: false,
		type: "get",
		url: `/api/v1/manager/product-detail/${productCode}`,	
		dataType: "json",
		success: (response) => {
			productDetailData = response.data;
			getModify(productDetailData); 
		},
		error: (error) => {
			console.log(error);
		}		
	});
       

function getModify(productDetailData){
	const productDetailDataInput = document.querySelector("table");
	productDetailDataInput.innerHTML = "";
	
	console.log(productDetailDataInput);
	
		productDetailDataInput.innerHTML = `
        <tr>
            <td>카테고리</td>
            <td>
                <select class="product_category">
                    <option value="ALL">ALL</option>
                    <option value="SHIRT">SHIRT</option>
                    <option value="PANTS">PANTS</option>
                    <option value="CAP">CAP</option>
                    <option value="ACCESSORY">ACCESSORY</option>
                </select>
            </td>
        </tr>

        <tr>
            <td>사이즈</td>
            <td>
                <select class="product_size">
                    <option value="S">S</option>
                    <option value="M">M</option>
                    <option value="L">L</option>
                    <option value="XL">XL</option>
                    <option value="XXL">XXL</option>
                </select>
            </td>
        </tr>
        
    <tr>
        <td>상품명</td>
        <td>${productDetailData.productName}</td>
    </tr>
    
    <tr>
        <td>가격</td>
        <td>${productDetailData.productPrice}</td>
    </tr>
    
    <tr>
        <td>상품설명</td>
        <td>
            <textarea id="ir1" name="productExplanation">${productDetailData.productExplanation}</textarea>
        </td>
    </tr>
    
    <tr>
        <td>상품이미지</td>
		<td>
			<input type="file"name="file" multiple="multiple" accept=".jpg, .jpeg, .png, .gif">
			${productDetailData.fileName}
		</td>
    </tr>
    
    <tr>
        <td colspan="2" align="center">
       	 	<button type="button" class="product-button submit" >수정</button>
        	<button type="button" class="product-button cancel" >취소</button>
        </td>
    </tr>
		`;
		submitButton = document.querySelector(".submit");
	}
	


//버튼 눌렸을때
submitButton.onclick = () => {
	
       $.ajax({
		async: false,
		type: "get",
		url: "/api/v1/manager/product-modify/${productCode}",	
		dataType: "json",
		success: (response) => {
			alert(response.data + "번 상품 수정 완료");
			location.replace("/manager/product-list");
			
		},
		error: (error) => {
			console.log(error);
		}		
	});
       
}


}