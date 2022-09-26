const submitButton = document.querySelector(".submit");

const productCode = location.pathname.substring(location.pathname.lastIndexOf("/") + 1);

console.log(productCode);

submitButton.onclick = () => {
	
       $.ajax({
		async: false,
		type: "get",
		url: "/api/v1/manager/product-modify/{productCode}",	
		dataType: "json",
		success: (response) => {
			
		},
		error: (error) => {
			console.log(error);
		}		
	});
       
}