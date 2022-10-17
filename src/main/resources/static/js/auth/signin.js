// 비밀번호 찾기 이벤트
const findPasswordInfoArea = document.querySelector(".findPassword-info-area"); 
const findPassword = document.querySelector(".find-password a");
const signinInfo = document.querySelector(".signin-info");
const cancleBtn = document.querySelector(".cancle-btn");

//이메일 유무 체크
const emailCheck = document.querySelector(".email-check-content");
const emailInput = document.querySelector(".email-input");

//비밀번호 동일 체크
const passwordInput = document.querySelector(".password-input");
const passwordCheck = document.querySelector(".password-check-input");

const userEmail = location.pathname.substring(location.pathname.lastIndexOf("/") + 1);

//버튼 이벤트
const accountOkBtn = document.querySelector(".account-ok-btn");
const passwordOkBtn = document.querySelector(".password-click-btn");

//url에 저 문자가 포함되있는가 확인
if(location.pathname.indexOf("auth/signin") != -1) {
	accountOkBtn.onclick = () => {
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
   		if(response.data == null){
			
			emailCheck.classList.remove("visible"); //true면 글자 사라짐.
		}else{
			sendEmail(response.data);
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
   
   findPassword.onclick = () => {
	    signinInfo.classList.add("visible"); //add가 visible이라는 클래스를 추가
	    findPasswordInfoArea.classList.remove("visible"); //add가 visible이라는 클래스를 삭제

	}

	cancleBtn.onclick = () => {
	    signinInfo.classList.remove("visible");
	    findPasswordInfoArea.classList.add("visible");
	}
}else {
	passwordOkBtn.onclick = updateUserPassword;	
}

//이메일 보내기
function sendEmail(userEmail) {
	
	console.log(emailInput);
	 $.ajax({
      async: false,
      type: "post",
      url: "/api/v1/mail",
      data: {"address" : emailInput.value,"userEmail" : userEmail},
      dataType: "json",
      success: (response) => {
         if(response.data != null){
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


function updateUserPassword() {
	
	if(passwordInput.value == passwordCheck.value) {
		$.ajax({
	      async: false,
	      type: "put",
	      url: `/api/v1/auth/resetPassword/${userEmail}`,
	      data: {
	       	"password" : passwordInput.value
	       },
	      dataType: "json",
	      success: (response) => {
	         if(response.data){
				alert("변경 완료")
		
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
	}else {
		alert("비밀번호가 일치하지 않습니다.");
	}
	
}








