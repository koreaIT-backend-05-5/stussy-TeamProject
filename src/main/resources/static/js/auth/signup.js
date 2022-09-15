
const inputs = document.querySelectorAll("input");
const signupButton = document.querySelector("button");

let checkUsernameFlag = false;

inputs[1].onblur = () => {
	/*
		이메일 중복 확인(스투시에서 아이디는 이메일)
	*/
	
	$.ajax({
		async: false,
		type: "get",
		url:"", //회원가입시 아이디 중복을 체크할 controller의 맵핑주소(AuthRestController)
        //수트시 아이디인 이메일을 data로 잡음
		data: {email : inputs[1].value},
		dataType: "json",
		success: (response) => {
			checkUsernameFlag = response.data;
			
			if(checkUsernameFlag) {
				alert("사용 가능한 아이디입니다.");
			}else{
				alert("이미 사용중인 아이디입니다.");
			}
		},
		error: (error) => {
			if(error.status == 400){
                //JSON.stringify -> jsvascript 값을 JSON 문자열로 변환
				alert(JSON.stringify(error.responseJSON.data));
			}else{
				console.log("요청 실패");
				console.log(error);				
			}
		}
	});
}

signupButton.onclick = () => {
	let signupData = {
		name: inputs[0].value,
		email: inputs[1].value,
		password: inputs[2].value,
		"checkUsernameFlag": checkUsernameFlag
	}
	
	$.ajax({
		async: false,
		type: "post",
		url: "", //회원가입 진행 후 실패, 성공 여부를 나타내는 controller의 맵핑주소(AuthRestController)
		contentType: "application/json",
		data: JSON.stringify(signupData),
		dataType: "json",
		success: (response) => {
			if(response.data){
				alert("회원가입 완료.");
				location.replace("/auth/signin"); //회원가입 성공시 이동할 페이지 
			}
		},
		error: (error) => {
			if(error.status == 400){
				alert(JSON.stringify(error.responseJSON.data));
			}else{
				console.log("요청 실패");
				console.log(error);				
			}
		}
	})
}