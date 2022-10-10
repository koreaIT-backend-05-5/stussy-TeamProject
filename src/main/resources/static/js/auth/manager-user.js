const searchButton = document.querySelector(".search-button");
const userContentList = document.querySelector(".user-content-list");

searchButton.onclick = () => {
   load(1); 
}

let nowPage = 1;

load(nowPage)

function load(nowPage) {
   const searchFlag = document.querySelector(".search-select").value;
   const searchValue = document.querySelector(".search-input").value;

    $.ajax({
        async: false,
        type: "get",
        url: "/api/v1/manager/manager-user/" + nowPage,
        data: {
         "searchFlag": searchFlag,
         "searchValue": searchValue
      },
      dataType: "json", 
        success: (response) => {
         if(response.data[0] != null) {
            getUserList(response.data);
            getPageNumbers(response.data[0].totalUserCount);
         }else {
            getUserList(new Array());
            getPageNumbers(0);
         }
        },
        error: (error) => {
            console.log(error);
        }
    });
}

function getUserList(userList) {
    const tbody = document.querySelector("tbody");
    tbody.innerHTML = "";

    userList.forEach(user => {
        tbody.innerHTML += `
           <tr class = "user-content">
               <td><input type="checkbox"></td>
               <td>${user.userCode}</td>
               <td>${user.userName}</td>
               <td>${user.userEmail}</td>
               <td>${user.userPhone}</td>
               <td>${user.createDate}</td>
               <td><button type="button" class="delete-button">삭제</button></td>
           </tr>
        `;
    });
    
    const userContentItems = document.querySelectorAll(".user-content");
   const deleteButtons = document.querySelectorAll(".delete-button");
   
   addDeleteButtonClickEvent(deleteButtons, userList, userContentItems);
}

function addDeleteButtonClickEvent(deleteButtons, userList, userContentItems) {
   for(let i = 0; i < deleteButtons.length; i++) {
      
      deleteButtons[i].onclick = () => {
         
         deleteUser(userContentItems[i], userList[i].userCode);
      }
   }
}

function getPageNumbers(totalUserCount) {
   const pageButtons = document.querySelector(".page-buttons");
   
   const totalPageCount = totalUserCount % 10 == 0 ? totalUserCount / 10 : (totalUserCount / 10) + 1;
   
   const startIndex = nowPage % 5 == 0 ? nowPage - 4 : nowPage - (nowPage % 5) + 1;
   const endIndex = startIndex + 4 <= totalPageCount ? startIndex + 4 : totalPageCount; 
   
   console.log(
      `
         totalPageCount: ${totalUserCount}
         startIndex: ${startIndex}
         endIndex: ${endIndex}
      `
   );
   
   pageButtons.innerHTML = ``;
   
   if(startIndex != 1) {
      pageButtons.innerHTML += `
         <button type="button" class="page-button pre">&lt;</button>
      `;
   }
   
   for(let i = startIndex; i <= endIndex; i++){
      pageButtons.innerHTML += `
         <button type="button" class="page-button">${i}</button>
      `;
   }
   
   if(endIndex != totalUserCount) {
      pageButtons.innerHTML += `
         <button type="button" class="page-button next">&gt;</button>
      `;
   }
   
   if(startIndex != 1) {
      const prePageButton = document.querySelector(".pre");
      prePageButton.onclick = () => {
         nowPage = startIndex - 1;
         load(nowPage);
      }
   }
   
   if(endIndex != totalUserCount) {
      const nextPageButton = document.querySelector(".next");
      nextPageButton.onclick = () => {
         nowPage = endIndex + 1;
         load(nowPage);
      }
   }
   

   const pageNumberButtons = document.querySelectorAll(".page-button");
   pageNumberButtons.forEach(button => {
      if(button.textContent != "<" && button.textContent != ">") {
         button.onclick = () => {
            nowPage = button.textContent;
            load(nowPage); 
         }
      }
   });

}

function deleteUser(userContent, userCode) {
   $.ajax({
      type: "delete",
      url: `/api/v1/manager/user/${userCode}`,
      async: false,
      dataType: "json",
      success: (response) => {
         if(response.data) {
            userContentList.removeChild(userContent);
         }
      },
      error: (error) => {
            console.log(error);
        }
   })
}

















