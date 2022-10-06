const topRight = document.querySelector(".top-right");

let user = getPrincipal();


setManagerButtons();




function getPrincipal() {
	let user = null;
	
	$.ajax({
		async: false,
		type: "get",
		url: "/api/v1/auth/principal",
		dataType: "json",
		success: (response) => {
			user = response.data;
		},
		error: (error) => {
			console.log(error);
		}
	});
	
	return user;	
}



function getUser() {
	return user;
}



function setManagerButtons() {
	
	if(getUser() != null) {
		if(getUser().userRoles.includes("ROLE_ADMIN") || getUser().userRoles.includes("ROLE_USER")) {
			topRight.innerHTML += `
				<button type="button" class="logout-btn">로그아웃</button>
				<button type="button" class="manager-btn">관리자 페이지</button>
			`;
			
			const logoutBtn = document.querySelector(".logout-btn");
			const managerBtn = document.querySelector(".manager-btn");
			
			
			setLogoutButtonClickEvent(logoutBtn);
			setManagerButtonClickEvent(managerBtn);
			
		}
	}

}

function setLogoutButtonClickEvent(logoutBtn) {
	logoutBtn.onclick = () => {
				location.href = "/logout";
	}
	
}

function setManagerButtonClickEvent(managerBtn) {
	managerBtn.onclick = () => {
				location.href = "/manager/main";
				
	}
	
}

