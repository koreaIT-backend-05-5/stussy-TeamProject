const submitBtn = document.querySelector(".submit");
const cancelBtn = document.querySelector(".cancel");


function getContactCode() {
	return location.pathname.substring(location.pathname.lastIndexOf("/") + 1);
}

function updateContactContent() {
	let formData = new FormData(document.querySelector("form"));
	let contactCode = getContactCode();
	
	formData.forEach((v, k) => {
		console.log("key" + k);
		console.log("value" + v);
	});
	
	$.ajax({
		async: false,
		type: "put",
		url: `/api/v1/contact/modify/${contactCode}`,
		enctype: "multipart/form-data",
		contentType: false,
		processData: false,
		data: formData,
		dataType: "json",
		success: (response) => {
			if(response.data) {
				alert("수정 완료");
				location.replace("/contact/contact");
			}
		},
		error: (error) => {
			if(error.status == 400) {
				alert(JSON.stringify(error.responseJSON.data));
			}else {
				console.log("요청 실패");
				console.log(error);
			}
		}
	});
}

function cancel(){
     alert("취소되었습니다.");
     history.back(); 
     location.href = "/contact/view/" + getContactCode();
}



submitBtn.onclick = () => {
	updateContactContent()
}


cancelBtn.onclick = () => {
	cancel()
}

