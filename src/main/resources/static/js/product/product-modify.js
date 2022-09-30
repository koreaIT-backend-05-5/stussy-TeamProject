const productCode = location.pathname.substring(location.pathname.lastIndexOf("/") + 1);

getProductDetailData();
console.log(productCode);

//데이터를 가져오는 ajax
function getProductDetailData () {
	
		
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
       
//수정 페이지로 넘어갈 때 value 값도 같이 넘어감
function getModify(productDetailData){
	
	const productDetailDataInput = document.querySelector("table");
	productDetailDataInput.innerHTML = "";
	
	console.log(productDetailDataInput);
	
		productDetailDataInput.innerHTML = `
        <tr>
            <td>카테고리</td>
            <td>
                <select class="product_category" >
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
        <td><input value="${productDetailData.productName}" type="text" name="productName" id="productName"></td>
    </tr>
    
    <tr>
        <td>가격</td>
        <td><input value="${productDetailData.productPrice}" type="text" name="productPrice" id="productPrice"></td>
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
		
	let = submitButton = document.querySelector(".submit");
	let = cancelButton = document.querySelector(".cancel");
	
	//select value 값 들고 가기
	const categorySelect = document.querySelectorAll(".product_category option");
	const sizeSelect = document.querySelectorAll(".product_size option");
	
	categorySelect.forEach(option => {
		if(option.value == productDetailData.productCategory) {
			option.setAttribute("selected", true);
		};
	})
	
	sizeSelect.forEach(option => {
		if(option.value == productDetailData.productSize) {
			option.setAttribute("selected", true);
		};
	})
	

	
//수정 버튼 눌렸을 때

submitButton.onclick = () => {
	
	let productNameInput = document.querySelector("#productName");
	let productPriceInput = document.querySelector("#productPrice");
	let textArea = document.querySelector("#ir1");
	
	let productCategorySelect = document.querySelector(".product_category");
	let productSizeSelect = document.querySelector(".product_size");

	
	let selectCategoryData = productCategorySelect.options[productCategorySelect.selectedIndex].value;	
	let selectSizeData = productSizeSelect.options[productSizeSelect.selectedIndex].value;
	
	
	
	let formData = new FormData(document.querySelector("form"));
	/*
		formData.append("productName",productNameInput.value);
		formData.append("productPrice",productPriceInput.value);
		formData.append("productExplanation",textArea.value);
		*/
		formData.append("productCategory",selectCategoryData);
		formData.append("productSize",selectSizeData);
		
		formData.forEach((v, k) => {
			console.log("key: " + k);
			console.log("value: " + v);
		});
	
       $.ajax({
		async: false,
		type: "put",
		url: `/api/v1/manager/product-modify/${productCode}`,
		enctype: "multipart/form-data",
		contentType: false,
		processData: false,
		data: formData,
		dataType: "json",
		success: () => {
			
			alert("상품 수정 완료");
			location.replace("/manager/product-list");
			
		},
		error: (error) => {
			console.log(error);
		}		
	});
       
}

//취소 버튼 눌렸을 때
cancelButton.onclick = () => {
	location.replace("/manager/product-list");
		}
	}
}
	


	
	
