// 비밀번호 찾기 이벤트
const findPasswordInfoArea = document.querySelector(".findPassword-info-area"); 
const findPassword = document.querySelector(".find-password a");
const signinInfo = document.querySelector(".signin-info");
const cancleBtn = document.querySelector(".cancle-btn");

const emailCheck = document.querySelector(".email-check-content");
const emailInput = document.querySelector(".email-input");



const okBtn = document.querySelector(".account-ok-btn");

okBtn.onclick = () => {
   // db에 이메일 있나 유효성 검사
   
	console.log(emailInput);
	console.log(emailInput.value);
   $.ajax({
      async: false,
      type: "get",
      url: "/api/v1/auth/checkemail/validation/useremail",
      data: {"useremail" : emailInput.value},
      dataType: "json",
      success: (response) => {
   		if(response.data){
			emailCheck.classList.remove("visible"); //true면 글자 사라짐.
		}else{
			sendEmail();
		}
      },
      error: (error) => {
         if(error.status == 400){
            alert(JSON.stringify(error.responseJSON.data));
         }else{
            console.log("요청실패");
            console.log(error);                     
         }
      }
   });
}

//이메일 보내기
function sendEmail() {
	let password = null;
	
	console.log(emailInput);
	 $.ajax({
      async: false,
      type: "post",
      url: "/api/v1/mail/random/password",
      data: {"email" : emailInput.value},
      dataType: "json",
      success: (response) => {
         if(response.data != null){
		password = response.data;
		updateUserPassword(password);
         alert("발송 완료");        
         }
      },
      error:(error) => {
         if(error.status == 400){
            alert(JSON.stringify(error.responseJSON.data))
         }
         console.log("요청실패");
         console.log(error);         
      }
   });
	
}

function updateUserPassword(password) {
	alert(password)
	$.ajax({
      async: false,
      type: "put",
      url: "/api/v1/auth/password",
      data: {
		"email" : emailInput.value,
       "password" : password
       },
      dataType: "json",
      success: (response) => {
         if(response.data){
			alert("변경")      
         }else {
	alert("변경 중 오류")
}
      },
      error:(error) => {
         if(error.status == 400){
            alert(JSON.stringify(error.responseJSON.data))
         }
         console.log("요청실패");
         console.log(error);         
      }
   });
}

findPassword.onclick = () => {
    signinInfo.classList.add("visible"); //add가 visible이라는 클래스를 추가
    findPasswordInfoArea.classList.remove("visible"); //add가 visible이라는 클래스를 삭제

}

cancleBtn.onclick = () => {
    signinInfo.classList.remove("visible");
    findPasswordInfoArea.classList.add("visible");
}





