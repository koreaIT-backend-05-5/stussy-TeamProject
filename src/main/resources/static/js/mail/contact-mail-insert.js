const submitButton = document.querySelector(".submit");
const cancelButton = document.querySelector(".cancel");

submitButton.onclick = () => {
	const address = document.querySelector(".address");
	const title = document.querySelector(".title");
	const message = document.querySelector(".message");
	
	let sendMail = {
		"address" : address.value,
		"title" : title.value,
		"message": message.value
	}
	
	$.ajax({
		async: false,
		type: "post",
		url: "/api/v1/mail",
		data: sendMail,
		dataType: "json",
		success: (response) => {
			alert("메일 작성완료");
			window.close();
		},
		error: (error) => {
			console.log(error);
		}	
	});
	
	
}

cancelButton.onclick = () => {
	alert("취소 되었습니다.")
	window.close();
}

function completeAnswer() {
	
}