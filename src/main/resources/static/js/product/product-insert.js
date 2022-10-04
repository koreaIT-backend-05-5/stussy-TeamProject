const submitButton = document.querySelector(".submit");

const inputs = document.querySelectorAll("input");
const saveBtn = document.querySelectorAll("button")[0];


submitButton.onclick = () => {

    const textareaValue = document.querySelector("#ir1").value;
  
    
    let formData = new FormData(document.querySelector("form"));
    
    
    let selectOption1 = document.querySelector(".product_category");
    
    console.log(selectOption1);
    
    let selectItem1 = selectOption1.options[selectOption1.selectedIndex].value;
    
    formData.append("productCategory", selectItem1);
    
    
    
    let selectOption2 = document.querySelector(".product_size");
    
    let selectItem2 = selectOption2.options[selectOption2.selectedIndex].value;
    
    formData.append("productSize", selectItem2);
    
  
    
    formData.forEach((v, k) => {
		console.log("key: " + k);
		console.log("value: " + v);
	});
	 
	
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
			alert(response.data + "번 상품등록 완료");
			location.replace("/manager/product-list");

		},
		error: (error) => {
			
			console.log(error);
		}
		
	});
}