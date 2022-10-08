

let nowPage = 1; 

load(nowPage)

function load(nowPage) {
    $.ajax({
        async: false,
        type: "get",
        url: "/api/v1/cart/" + nowPage,
		dataType: "json", 
        success: (response) => {
			if(response.data[0] != null) {
				getCartList(response.data);
				getPageNumbers(response.data[0].totalCartCount);
			}else {
				getCartList(new Array());
				getPageNumbers(0);
			}
        },
        error: (error) => {
            console.log(error);
        }
    });
}

function getCartList(cartList) {
	const rowData = document.querySelector(".row data")
    rowData.innerHTML = "";

    cartList.forEach(cart => {
        rowData.innerHTML += `
            <div class="subdiv">
                <div class="check"><input type="checkbox" name="buy" value="260" checked="" onclick="javascript:basket.checkItem();">&nbsp;</div>
                <div class="img"><img src="./image/product/${cart.fileName}" width="60"></div>
                <div class="pname">
                    <span>${cart.productName}</span>
                </div>
            </div>
            <div class="subdiv">
                <div class="basketprice"><input type="hidden" name="p_price" id="p_price1" class="p_price" value="20000">${cart.productPrice}</div>
                <div class="num">
                    <div class="updown">
                        <span onclick="javascript:basket.changePNum(1);"><i class="down">-</i></span>
                        <input type="text" name="p_num1" id="p_num1" size="2" maxlength="4" class="p_num" value="2" onkeyup="javascript:basket.changePNum(1);">
                        <span onclick="javascript:basket.changePNum(1);"><i class="up">+</i></span>
                    </div>
                </div>
                <div class="sum">40,000원</div>
            </div>
            <div class="subdiv">
                <div class="basketcmd"><a href="javascript:void(0)" class="abutton" onclick="javascript:basket.delItem();">삭제</a></div>
            </div>
        `; 
    });
    
    const subDiv = document.querySelector(".subdiv");
	const deleteButtons = document.querySelectorAll(".delete-button");
	
	addDeleteButtonClickEvent(deleteButtons, cartList, subDiv);
}

function addDeleteButtonClickEvent(deleteButtons, cartList, subDiv) {
	for(let i = 0; i < deleteButtons.length; i++) {
		
		deleteButtons[i].onclick = () => {
			
			deleteUser(subDiv[i], cartList[i].productCode);
		}
	}
}

function getPageNumbers(totalCartCount) {
	const pageButtons = document.querySelector(".page-buttons");
	
	const totalPageCount = totalCartCount % 5 == 0 ? totalCartCount / 5 : (totalCartCount / 5) + 1;
	
	const startIndex = nowPage % 5 == 0 ? nowPage - 4 : nowPage - (nowPage % 5) + 1;
	const endIndex = startIndex + 4 <= totalPageCount ? startIndex + 4 : totalPageCount; 
	
	console.log(
		`
			totalPageCount: ${totalCartCount}
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
		`
	}
	
	if(endIndex != totalCartCount) {
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
	
	if(endIndex != totalCartCount) {
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

function deleteCart(cartContent, productCode) {
	$.ajax({
		type: "delete",
		url: `/api/v1/cart/remove/${productCode}`,
		async: false,
		dataType: "json",
		success: (response) => {
			if(response.data) {
				userContentList.removeChild(cartContent);
			}
		},
		error: (error) => {
            console.log(error);
        }
	})
}