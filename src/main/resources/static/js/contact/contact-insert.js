const submitButton = document.querySelector(".submit");
/*const cancelBtn = document.querySelector(".cancel");*/

let userCode = 0;

userCode = getUserCode();

function getUserCode() {
	if(user != null) {
		return user.user_code;
	}
	
	return 0;
}

submitButton.onclick = () => {
	
	let formData = new FormData(document.querySelector("form"));
	
	formData.forEach((v, k) => {
		console.log("key: " + k);
		console.log("value: " + v);
	});
	
	const contactEmail = document.querySelector(".contactEmail");
	const contactTitle = document.querySelector(".contactTitle");
	const contactContent = document.querySelector(".contactContent");
	
	let insertContact = {
		"userCode" : userCode,
		"userEmail" : contactEmail.value,
		"contactTitle" : contactTitle.value,
		"contactContent" : contactContent.value
	}
	
	console.log(insertContact);
	
	$.ajax({
		async: false,
		type: "post",
		url: "/api/v1/contact",
		contentType: "application/json",
		data: JSON.stringify(insertContact),
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