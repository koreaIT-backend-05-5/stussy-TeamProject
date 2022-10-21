const productCode = location.pathname.substring(location.pathname.lastIndexOf("/") + 1);
const fileInput = document.querySelector(".file-input");

let fileObject = null;


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
}
       
//수정 페이지로 넘어갈 때 value 값도 같이 넘어감
function getModify(productDetailData){
	
	const productDetailDataInput = document.querySelector("section");
	productDetailDataInput.innerHTML = "";
	
	console.log(productDetailData);
	console.log(productDetailData.fileName)

		productDetailDataInput.innerHTML += `
    		 <section>
              	 <select class="product_category product-input">
                    <option value="0">ALL</option>
                    <option value="1">SHIRTS</option>
                    <option value="2">PANTS</option>
                    <option value="3">CAP</option>
                    <option value="4">ACCESSORIES</option>
                </select>

                <input type="text" class="product-input" value="${productDetailData.productName}" placeholder="상품명을 입력하세요">
                <input type="text" class="product-input" value="${productDetailData.productPrice}" placeholder="가격을 입력하세요">
                <input type="text" class="product-input" value="${productDetailData.productCount}" placeholder="수량을 입력하세요">
                
                <div class="product-option">
                    <select class="product_size product-input">
                        <option value="S">S</option>
                        <option value="M">M</option>
                        <option value="L">L</option>
                        <option value="XL">XL</option>
                        <option value="XXL">XXL</option>
                    </select>
                </div>

                <textarea class="product-input" placeholder="설명">${productDetailData.productInfo}</textarea>
               	<form enctype="multipart/form-data">
                <div class="product-img-inputs">
                    <label>상품 이미지</label>
                    <button type="button" class="modify-button">수정</button>
                    <input type="file" class="file-input product-invisible" name="file">
                </div>
        		</form>
        	
                <div class="product-images">
                 	 <div class="img-box">
		                <i class="fa-solid fa-xmark"></i>
		                <img src="/image/product/${productDetailData.fileName}">
	            	</div>
                </div>
                
                
                <button type="button" class="submit-button product-button black-button">수정하기</button>
            </section>
		`;
		
	const deleteButton = document.querySelector(".fa-xmark");
    
    deleteButton.onclick = () => {
        if(confirm("상품 이미지를 지우시겠습니까?")) {
            fileObject = null;
            getImagePreview(fileObject);
    	}
	};
	

	//수정 버튼
	const modifyAddButton = document.querySelector(".modify-button");
	const fileInput = document.querySelector(".file-input");
	
	modifyAddButton.onclick = () => {
    	fileInput.click();
	}	
	
	fileInput.onchange = () => {
	    const formData = new FormData(document.querySelector("form"));
	    let changeFlge = false;
	
	    formData.forEach((value) => {
	        if(value.size != 0) {
	            fileObject = value;
	            changeFlge = true;
	        }
	    });
	    
	        if(changeFlge){
	        getImagePreview(fileObject);
	        fileInput.value = null;
		    }
		}
	
	function getImagePreview(fileObject) {
	    const productImages = document.querySelector(".product-images");
	
	    productImages.innerHTML = "";
	    
	    if(fileObject != null) {
			modifyAddButton.disabled = true;
			modifyAddButton.classList.toggle("selected-image");
			
	    	const reader = new FileReader();
	    
		    reader.onload = (e) => {
		        productImages.innerHTML += `
		            <div class="img-box">
		                <i class="fa-solid fa-xmark"></i>
		                <img class="product-img" src="${e.target.result}">
		            </div>
		        `;
				const deleteButton = document.querySelector(".fa-xmark");
			    
			    deleteButton.onclick = () => {
			        if(confirm("상품 이미지를 지우시겠습니까?")) {
			            fileObject = null;
			            getImagePreview(fileObject);
		        	}
		    	};
			}
		        
		    if(fileObject != null) {
		    	reader.readAsDataURL(fileObject);
			}
			
		}else {
			modifyAddButton.disabled = false;
			modifyAddButton.classList.toggle("selected-image");
			
			}
    }   
 
	
//리스트에서 select value 값 들고 가기
const categorySelect = document.querySelectorAll(".product_category option");
const sizeSelect = document.querySelectorAll(".product_size option");

categorySelect.forEach(option => {
	if(option.textContent == productDetailData.categoryName) {
		option.setAttribute("selected", true);
	};
})

sizeSelect.forEach(option => {
	if(option.value == productDetailData.productSize) {
		option.setAttribute("selected", true);
	};
})
	

	
//수정 버튼 눌렸을 때

let submitButton = document.querySelector(".submit-button");

	submitButton.onclick = () => {
	
	let productInput = document.querySelectorAll(".product-input");
	
	
	let formData = new FormData();
	
		formData.append("categoryCode",productInput[0].value);
		formData.append("productName",productInput[1].value);
		formData.append("productPrice",productInput[2].value);
		formData.append("productCount",productInput[3].value);
		formData.append("productSize",productInput[4].value);
		formData.append("productInfo",productInput[5].value);
		formData.append("file", fileObject);
				
		
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
	}	