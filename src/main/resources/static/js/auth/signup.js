const inputs = document.querySelectorAll("input");
const signupBtn = document.querySelectorAll("button")[0];

const emailerrorMsg = document.querySelector(".email-input-error-message");
const passworderrorMsg = document.querySelector(".password-input-error-message");

console.log(inputs);

let checkUseremailFlag = false;

inputs[1].onblur = () => {
   // 유효성 검사
   
   $.ajax({
      async: false,
      type: "get",
      url: "/api/v1/auth/signup/validation/useremail",
      data: {useremail : inputs[1].value},
      dataType: "json",
      success: (response) => {
         checkUseremailFlag = response.data == null;
         
         if(checkUseremailFlag){
            alert("사용 가능한 이메일 입니다.");
         }else{
            alert("이미 사용중인 이메일 입니다.");
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


signupBtn.onclick = () => {
   let signupData = {
      name: inputs[0].value,
      email: inputs[1].value,
      password: inputs[2].value,
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
      contentType: "application/json",
      data: JSON.stringify(signupData),
      dataType: "json",
      success: (response) => {
         if(response.data){
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
