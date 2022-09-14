const updateBtn = document.querySelector(".update-btn");
const updateAddressesArea = document.querySelector(".update-addresses-area");
const addressesShowHideInfo = document.querySelector(".addresses-show-hide-info");
const addAddressesBtn = document.querySelector(".add-addresses-btn");
const addressesListTxt = document.querySelector(".addresses-list-txt");
const createAddressesArea = document.querySelector(".create-addresses-area");
const cancelBtn = document.querySelector(".cancel-btn");

cancelBtn.onclick = () => {
    alert("삭제 하시겠습니까 ?")
}

updateBtn.onclick = () => {
    if(updateAddressesArea.style.display != 'none') {
        updateAddressesArea.style.display = 'block'
        addressesShowHideInfo.style.display = 'none';
        addAddressesBtn.style.height = "20px"
    } else {
        updateAddressesArea.style.display = 'none'
    }
     
}

addAddressesBtn.onclick = () => {
    if(updateAddressesArea.style.display == 'block') {
        updateAddressesArea.style.display = 'none';
        updateAddressesArea.style.height = '427px';
        createAddressesArea.style.display = 'block';
       
    } else {
        addressesShowHideInfo.style.display = 'none';
        addAddressesBtn.style.height = "20px";
        createAddressesArea.style.display = 'block';
        addAddressesBtn.style.color = 'black';
    }
}

function findAddresses_Postcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            let addr = ''; // 주소 변수
            let extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr != ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById("addresses-txt").value = extraAddr;
            
            } else {
                document.getElementById("addresses-txt").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('find-addresses_postcode').value = data.zonecode;
            document.getElementById("addresses-txt").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("find-detailAddress-txt").focus();
        }
    }).open();
}

function createAddresses_Postcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            let addr = ''; // 주소 변수
            let extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr != ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById("create-addresses-txt").value = extraAddr;
            
            } else {
                document.getElementById("create-addresses-txt").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('create-addresses_postcode').value = data.zonecode;
            document.getElementById("create-addresses-txt").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("create-detailAddress-txt").focus();
        }
    }).open();
}