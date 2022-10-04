const submitButton = document.querySelector(".submit");
<<<<<<< HEAD
const cancelBtn = document.querySelector(".cancel");

submitButton.onclick = () => {
	
	let formData = new FormData(document.querySelector("form"));
	
	formData.forEach((v, k) => {
=======

submitButton.onclick = () => {
    /*
        editor의 내용을 textarea로 옮겨주는 역할
    */
    // oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
    // const textareaValue = document.querySelector("#ir1").value;
    
    let formData = new FormData(document.querySelector("form"));
    
    formData.append("userCode", getUser().user_code);
    
    formData.forEach((v, k) => {
>>>>>>> origin/eastzi
		console.log("key: " + k);
		console.log("value: " + v);
	});
	
	$.ajax({
		async: false,
		type: "post",
<<<<<<< HEAD
		url: "/api/v1/contact",
=======
		url: "/api/v1/notice",
>>>>>>> origin/eastzi
		enctype: "multipart/form-data",
		contentType: false,
		processData: false,
		data: formData,
		dataType: "json",
		success: (response) => {
<<<<<<< HEAD
			alert("문의사항 작성 완료");
			location.href = "/contact/view/" + response.data;
=======
			alert(response.data + "번 공지사항 작성 완료");
			location.href = "/notice/detail/" + response.data;
>>>>>>> origin/eastzi
		},
		error: (error) => {
			console.log(error);
		}
		
	});
<<<<<<< HEAD
}


function cancel() {
     alert("취소되었습니다.");
     history.back(); 
     location.href = "/contact/contact";
}


cancelBtn.onclick = () => {
	 cancel()
=======
    
>>>>>>> origin/eastzi
}