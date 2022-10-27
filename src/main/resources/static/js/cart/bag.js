let bagProductPrices = null;
let varCartListData = null;

const amount = document.querySelector(".amount");


// db 데이터 확인
function cartListLoad() {
	$.ajax({
		async: false,
		type: "get",
		url: "/api/v1/cart/" + user.user_code,	
		dataType: "json",
		success: (response) => {
			if(response.data != null){
				setCartData(response.data);
			}
		},
		error: (error) => {
			console.log(error);
		}		
	});	
}

// 장바구니 추가
function setCartData(cartListData) {
	const bagContainer = document.querySelector(".bag-container");
	
	bagContainer.innerHTML = "";
	
	cartListData.forEach(cartData => {
		let price = getPrice(cartData.productPrice) * cartData.bagAmount;
		price = price.toLocaleString('ko-KR');
		bagContainer.innerHTML += `
		<div class="bag-content">
    		<a href="#" class="bag-img">
    			<img alt="${cartData.productName}" src="/image/product/${cartData.fileName}">
    		</a>	  
        	<div class="bag-info">
        		<i class="fa-regular fa-x delete-button"></i>
        		<h1 class="bag-product-name"><a href="#">${cartData.productName}</a></h1>
        		
        		<span class="bag-product-size">Size / ${cartData.bagProductSize}</span>
        		
        		<div class="bag-row">
            		<div class="product-quantity">
	            		<button class="product-quantity-button minus-button"><span>-</span></button>
	            		<input class="product-quantity-input amount" type="text" value="${cartData.bagAmount}">
	            		<button class="product-quantity-button plus-button"><span>+</span></button>	            		
            		</div>
        			<div class="bag-product-price">
            			<span>₩${price}</span>       			
        			</div> 
         		</div>
        	</div>
    	</div>
	`;
	})
	
	varCartListData = cartListData;
	
	const minusButton = document.querySelectorAll(".minus-button");
	const plusButton = document.querySelectorAll(".plus-button");
	const amountInput = document.querySelectorAll(".amount");
	bagProductPrices = document.querySelectorAll(".bag-product-price span");
	
	//인풋 수량 
	amountInput.forEach((input, index) => {
		input.onchange = (e) => checkAmount(e.target, index);
	});
	
	//마이너스 버튼
	minusButton.forEach((button,index) =>{
		button.onclick = () => {
			let amount = parseInt(amountInput[index].value);
			if(amount - 1 > 0) {
				amount -= 1;
				setAmountView(amountInput[index], amount);
				let price = getPrice(cartListData[index].productPrice) * amount;
				
				setPriceView(bagProductPrices[index], price);
				updateBagAmount(cartListData[index].cartCode, amount);
			}else {
				alert("0개 이하로는 선택 불가능 합니다.")
			}
		}
	});
	
	//플러스 버튼
	plusButton.forEach((button,index) =>{
	button.onclick = () => {
		let amount = parseInt(amountInput[index].value);
		amount += 1;
		setAmountView(amountInput[index], amount);
		let price = getPrice(cartListData[index].productPrice) * amount;
		setPriceView(bagProductPrices[index], price);
		updateBagAmount(cartListData[index].cartCode, amount);
			
		}
	});
	
	//장바구니 상품 삭제
	const deleteButtons = document.querySelectorAll(".delete-button");
	deleteButtons.forEach((button, index) =>{
		button.onclick = () =>{
			$.ajax({
					async: false,
					type: "delete",
					url: `/api/v1/cart/${varCartListData[index].cartCode}`,
					dataType: "json",
					success: () => {
						alert("삭제 완료");
						cartListLoad();
					},
					error: (error) => {
						console.log(error);
				}
			});
			
		}
	})

}

//공통된 부분 따로 만듦
function getPrice(priceString) {
	return parseInt(priceString.substring(1).replaceAll(",", ""));
}

//장바구니 수량 인풋에 들어갈 수량
function setAmountView(input, amount) {
	input.value = amount;
}

//장바구니 제품 가격 
function setPriceView(span, price) {
	span.textContent = "₩" + price.toLocaleString('ko-KR');
}

//장바구니 상품 수량 체크
function checkAmount(input, index) {
	if(input.value < 1) {
		alert("0개 이하로는 선택 불가능 합니다.")
		input.value = 1;
		setPriceView(bagProductPrices[index], varCartListData[index].productPrice.substring(1))
		updateBagAmount(varCartListData[index].cartCode, input.value);

	}else {
		let price = getPrice(varCartListData[index].productPrice) * parseInt(input.value);
		setPriceView(bagProductPrices[index], price);
		updateBagAmount(varCartListData[index].cartCode, input.value);
	}
}

// db에 장바구니 수량 수정 ajax
function updateBagAmount(cartCode, amount) {
	
	$.ajax({
		async: false,
		type: "put",
		url: "/api/v1/cart/" + cartCode,
		data: JSON.stringify({
			"amount": amount
		}),
		contentType: "application/json",
		dataType: "json",
		success: (response) => {
			if(response.data != null){
				setTotalPriceData();
			}
		},
		error: (error) => {
			console.log(error);
		}		
	});	
}

//장바구니 상품 총 상품 가격
function setTotalPriceData() {
	
	const priceSpan = document.querySelectorAll(".bag-product-price span");
	let totalProductPrice = 0;
	
	priceSpan.forEach(priceData => {
		totalProductPrice += getPrice(priceData.textContent);
		
	});
		setTotoalPriceView(totalProductPrice);
}

function setTotoalPriceView(totoalPrice) {
	const totalPriceP = document.querySelector(".total-price");

	totalPriceP.textContent = "₩" + totoalPrice.toLocaleString('ko-KR');
}

const checkButton = document.querySelector(".check-btn");

checkButton.onclick = () => {
	location.href = "/payment/buy";
}


