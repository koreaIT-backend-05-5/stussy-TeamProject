const submitBtn = document.querySelector(".submit");

submitBtn.onclick = () => {
	const address = document.querySelector(".address");
	const title = document.querySelector(".title");
	const message = document.querySelector(".message");
	
	let sendMail = {
		"address" :address.value,
		"title" :title.value,
		"message" :message.value
	}
	
	console.log(sendMail)
	$.ajax({
		async: false,
		type: "post",
		url: "/api/v1/auth/findPassword",
		data:sendMail,
		dataType:"json",
		success:(response) => {
				if(response.data){
			alert("전송");
			location.replace("/auth/signin");				
			}
		},
		error:(error) => {
			console.log(error);
		}
	});
}