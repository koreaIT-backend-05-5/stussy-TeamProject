<<<<<<< HEAD

const inputs = document.querySelectorAll("input");
const signupButton = document.querySelector("button");

let checkUsernameFlag = false;

inputs[1].onblur = () => {
	/*
		이메일 중복 확인(스투시에서 아이디는 이메일)
	*/
=======
const inputs = document.querySelectorAll("input");
const signupBtn = document.querySelectorAll("button")[0];

const emailerrorMsg = document.querySelector(".email-input-error-message");
const passworderrorMsg = document.querySelector(".password-input-error-message");

console.log(inputs);

let checkUseremailFlag = false;

inputs[1].onblur = () => {
	// 유효성 검사
>>>>>>> origin/wonyoung
	
	$.ajax({
		async: false,
		type: "get",
<<<<<<< HEAD
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
=======
		url: "/api/v1/auth/signup/validation/useremail",
		data: {useremail : inputs[1].value},
		dataType: "json",
		success: (response) => {
			checkUseremailFlag = response.data;
			
			if(checkUseremailFlag){
				alert("사용 가능한 이메일 입니다.");
			}else{
				alert("이미 사용중인 이메일 입니다.");
>>>>>>> origin/wonyoung
			}
		},
		error: (error) => {
			if(error.status == 400){
<<<<<<< HEAD
                //JSON.stringify -> jsvascript 값을 JSON 문자열로 변환
				alert(JSON.stringify(error.responseJSON.data));
			}else{
				console.log("요청 실패");
				console.log(error);				
=======
				alert(JSON.stringify(error.responseJSON.data));
			}else{
				console.log("요청실패");
				console.log(error);							
>>>>>>> origin/wonyoung
			}
		}
	});
}

<<<<<<< HEAD
signupButton.onclick = () => {
=======

signupBtn.onclick = () => {
>>>>>>> origin/wonyoung
	let signupData = {
		name: inputs[0].value,
		email: inputs[1].value,
		password: inputs[2].value,
<<<<<<< HEAD
		"checkUsernameFlag": checkUsernameFlag
	}
	
	$.ajax({
		async: false,
		type: "post",
		url: "", //회원가입 진행 후 실패, 성공 여부를 나타내는 controller의 맵핑주소(AuthRestController)
=======
		"checkUseremailFlag": checkUseremailFlag
	}
	
	function emailerror() {
      if(signupData.email == ""){
         inputs[1].style.backgroundColor = "#c0392b",
         inputs[1].style.borderColor = "#e74c3c";
         emailerrorMsg.innerHTML = "이메일 은(는) 비워 둘 수 없습니다."
      } else {
         inputs[1].style.backgroundColor = "";
         emailerrorMsg.innerHTML = ""
      }
   }
   
   	function pwerror() {
      if(signupData.password == ""){
         inputs[2].style.backgroundColor = "#c0392b",
         inputs[2].style.borderColor = "#e74c3c";
         passworderrorMsg.innerHTML = "비밀번호 은(는) 비워 둘 수 없습니다."
      } else {
         inputs[2].style.backgroundColor = "";
         passworderrorMsg.innerHTML = ""
      }
   }
	console.log(checkUseremailFlag)
	$.ajax({
		async: false,
		type: "post",
		url: "/api/v1/auth/signup",
>>>>>>> origin/wonyoung
		contentType: "application/json",
		data: JSON.stringify(signupData),
		dataType: "json",
		success: (response) => {
			if(response.data){
<<<<<<< HEAD
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
=======
			alert("회원가입 완료.");
			location.replace("/auth/signin");				
			}
		},
		error:(error) => {
			if(error.status == 400){
				alert(JSON.stringify(error.responseJSON.data))
				emailerror();
				pwerror();
			}
			console.log("요청실패");
			console.log(error);			
		}
	});
}

>>>>>>> origin/wonyoung
