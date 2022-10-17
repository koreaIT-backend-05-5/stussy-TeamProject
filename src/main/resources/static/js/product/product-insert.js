const fileAddButton = document.querySelector(".add-button");
const fileInput = document.querySelector(".file-input");
const submitButton = document.querySelector(".submit-button");

let fileObject = null;

fileAddButton.onclick = () => {
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
		fileAddButton.disabled = true;
		fileAddButton.classList.toggle("selected-image");
		
	}else {
		fileAddButton.disabled = false;
		fileAddButton.classList.toggle("selected-image");
		
	}

   
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
	
}

submitButton.onclick = () => {
    const productInputs = document.querySelectorAll(".product-input");

	console.log(productInputs);
	
    let formData = new FormData();
    

    formData.append("categoryCode", productInputs[0].value);
    formData.append("productName", productInputs[1].value);
    formData.append("productPrice", productInputs[2].value);
    formData.append("productSize", productInputs[3].value);
    formData.append("productInfo", productInputs[4].value);
	formData.append("file", fileObject);

   

    request(formData);
}

function request(formData) {
    $.ajax({
        async: false,
        type: "post",
        url: "/api/v1/manager/",
        enctype: "multipart/form-data",
        contentType: false,
        processData: false,
        data: formData,
        dataType: "json",
        success: (response) => {
            alert("상품 등록 완료");
        },
        error: (error) => {
            alert("상품 등록 실패");
            console.log(error);
        }
    });
}