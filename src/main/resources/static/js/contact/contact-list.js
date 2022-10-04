const searchButton = document.querySelector(".search-button");

let nowPage = 1;

load(nowPage)

function load(nowPage) {
	const searchFlag = document.querySelector(".search-select").value;
	const searchValue = document.querySelector(".search-input").value;
	
	$.ajax({
		async: false,
		type: "get",
		url: "/api/v1/contact/list/" + nowPage,
		data: {
			"searchFlag": searchFlag,
			"searchValue": searchValue
		},
		dataType: "json",
		success: (response) => {
			if(response.data[0] != null) {
				getList(response.data);
				getPageNumbers(response.data[0].totalContactCount);
			} else {
				getList(new Array());
				getPageNumbers(0);
			}
		},
		error: (error) => {
			console.log(error);
		}
	});
}

function getList(list) {
	const tbody = document.querySelector("tbody");
	tbody.innerHTML = "";
	
	list.forEach(contact => {
		tbody.innerHTML += `
			<tr class="contact-row">
                <td>${contact.contactCode}</td>
                <td>${contact.contactTitle}</td>
                <td>${contact.userEamil}</td>
                <td>${contact.createDate}</td>
                <td>${contact.contactCount}</td>
            </tr>
		`;
	});
	
	const contactRows = document.querySelectorAll(".contact-row");
	contactRows.forEach(row => {
		row.onclick = () => {
			const contactCode = row.querySelectorAll("td")[0].textContent;
			location.href = "/contact/view/" + contactCode;
		}
	});
}

function getPageNumbers(totalContactCount) {
	const pageButtons = document.querySelector(".page-buttons");
	
	const totalPageCount = totalContactCount % 10 == 0 ? totalContactCount / 10 : (totalContactCount / 10) + 1;
	
	const startIndex = nowPage % 5 == 0 ? nowPage - 4 : nowPage - (nowPage % 5) + 1;
	const endIndex = startIndex + 4 <= totalPageCount ? startIndex + 4 : totalPageCount;
	
	
	
	pageButtons.innerHTML = ``;
	
	
	if(startIndex != 1) {
		pageButtons.innerHTML += `
			 <button type="button" class="page-button pre">&lt;</button>
		`;
		
	}
	
	for(let i = startIndex; i <= endIndex; i++) {
		pageButtons.innerHTML += `
			 <button type="button" class="page-button">${i}</button>
		`
	}
	
	
	if(endIndex != totalPageCount) {
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
	
	if(endIndex != totalPageCount) {
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



function getWriteButton() {
	
	const contactBtn = document.querySelector(".contact-add-button");
	
	contactBtn.onclick = () => {
		location.href = "/contact/addition";
	}
}

getWriteButton();


searchButton.onclick = () => {
	load(1);
}
			


