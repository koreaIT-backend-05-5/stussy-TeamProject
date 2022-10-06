const submitButton = document.querySelector(".submit");
/*const cancelBtn = document.querySelector(".cancel");*/

submitButton.onclick = () => {
	
	let formData = new FormData(document.querySelector("form"));
	
	formData.forEach((v, k) => {
		console.log("key: " + k);
		console.log("value: " + v);
	});
	
	$.ajax({
		async: false,
		type: "post",
		url: "/api/v1/contact",
		enctype: "multipart/form-data",
		contentType: false,
		processData: false,
		data: formData,
		dataType: "json",
		success: (response) => {
			alert("문의사항 작성 완료");
			location.href = "/contact/addition/complete";
		},
		error: (error) => {
			console.log(error);
		}
		
	});
}


/*function cancel() {
     alert("취소되었습니다.");
     history.back(); 
     location.href = "/contact/manager/list";
}*/


/*cancelBtn.onclick = () => {
	 cancel()
}*/