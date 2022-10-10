const menuListBtn = document.querySelector(".menu-list");

setManagerButtons();

console.log(user);

function setManagerButtons() {
	
	if(getUser() != null) {
		console.log(getUser().userRoles)
		if(getUser().userRoles.includes("ROLE_ADMIN")) {
			menuListBtn.innerHTML += `
				<li><a href="#" class="manager-btn">관리자 페이지</a></li>
			`;
			
			const logoutBtn = document.querySelector(".logout-btn");
			const managerBtn = document.querySelector(".manager-btn");
			
			
			setLogoutButtonClickEvent(logoutBtn);
			setManagerButtonClickEvent(managerBtn);
			
		} else if(getUser().userRoles.includes("ROLE_USER")) {
		
			const logoutBtn = document.querySelector(".logout-btn");
			setLogoutButtonClickEvent(logoutBtn);
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
