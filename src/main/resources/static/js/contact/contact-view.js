const preBtn = document.querySelector(".pre");
const nextBtn = document.querySelector(".next");
const listBtn = document.querySelector(".list");
const modifyBtn = document.querySelector(".modify");
const deleteBtn = document.querySelector(".delete");

let contactCode = location.pathname.substring(location.pathname.lastIndexOf("/") + 1);

load("/api/v1/contact/");


function load(uri) {
	$.ajax({
		async: false,
		type: "get",
		url: uri + contactCode,
		dataType: "json",
		success: (response) => {
			console.log(JSON.stringify(response.data));
			getContact(response.data);
		},
		error: (error) => {
			console.log(error);
		}
	})
}

function deleteContactContent() {
	$.ajax({
		async: false,
		type: "delete",
		url: `/api/v1/contact/view/${contactCode}`,
		dataType: "json",
		success: () => {
			alert("삭제 되었습니다.");
			location.replace("/contact/contact");
		},
		error: (error) => {
			alert("요청 실패");
			console.log(error);
		}
	})
}


function getContact(contact) {
	const contactViewTitle = document.querySelector(".contact-view-title");
	const contactViewDescriptions = document.querySelectorAll(".contact-view-description h3");
	const viewContent = document.querySelector(".view-content");
	
	contactCode = contact.contactCode;
	
	contactViewTitle.innerHTML = contact.contactTitle;
	contactViewDescriptions[0].innerHTML = "작성자: " + contact.userEmail;
	contactViewDescriptions[1].innerHTML = "작성일: " + contact.createDate;
	contactViewDescriptions[2].innerHTML = "조회수: " + contact.contactCount;
	viewContent.innerHTML = contact.contactContent;	
	
}

deleteBtn.onclick = () => {
	deleteContactContent();
}

modifyBtn.onclick = () => {
	location.href = "/contact/modify/" + contactCode;
}

listBtn.onclick = () => {
	location.href = "/contact/contact";
}

preBtn.onclick = () => {
	load("/api/v1/contact/pre/");
}

nextBtn.onclick = () => {
	load("/api/v1/contact/next/");
}