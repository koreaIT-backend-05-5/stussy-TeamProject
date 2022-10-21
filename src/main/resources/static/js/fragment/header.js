const menuLi = document.querySelectorAll('.category');
const subbox = document.querySelector('.subbox');

const topRight = document.querySelector(".top-right");

const bagButton = document.querySelector(".bag-button");
const bagArea = document.querySelector(".bag-arae");
const bagdeleteButton = document.querySelector(".bag-delete-button");

// let categoryCode = 0;

let user = getPrincipal();


menuLi[0].onmouseover = () => {
	subbox.classList.remove("subbox-visible");
}

subbox.onmouseleave = () => {
    subbox.classList.add("subbox-visible");
    
}

bagButton.onclick = () => {
	bagArea.classList.remove("visible");
}

bagdeleteButton.onclick = () => {
	bagArea.classList.add("visible");
}








function setCategoryTagClickEvent() {
	const categoryTagItems = document.querySelectorAll(".subbox-children a");
	
	
	categoryTagItems.forEach(category => category.onclick = (e) =>  setCategoryCode(e.target));
}

function setCategoryCode(categoryTag) {
	if(categoryTag.textContent == "SHIRT") {
		categoryCode = 1;
	}else if(categoryTag.textContent == "PANTS") {
		categoryCode = 2;
	}else if(categoryTag.textContent == "CAP") {
		categoryCode = 3;
	}else if(categoryTag.textContent == "ACCESSORY") {
		categoryCode = 4;
	}
	
	load(1);
}

function load(page) {
   
   $.ajax({
      async: false,
      type: "get",
      url: `/api/v1/product/list/${page}`, 
      data: {
         "page" : page,
         "contentCount": contentCount,
         "categoryCode": categoryCode
      },
      dataType: "json", 
      success: (response) => {
         getShopList(response.data);
      },
      error:(error) => {
         console.log(error);
      }
   })
}

function setTotalCount(totalProductCount) {
   totalPage = totalProductCount % contentCount == 0 ? totalProductCount / contentCount : Math.floor(totalProductCount / contentCount) + 1;
}

function getShopList(productList){
   console.log(productList);
   // const collectionProducts = document.querySelector(".collection-products")
   setTotalCount(productList[0].totalProductCount);
   if(page == 1){
      collectionProducts.innerHTML = "";      
   }
   
   productList.forEach(product => {
   
      
      collectionProducts.innerHTML += `
         <li class="collection-product collection-product-${page}">
            <div class="shop-box">
               <div class="product-img">
                  <a>
                     <img src="/image/product/${product.fileName}" alt="${product.fileName}">
                  </a>
               </div>
               <a>
                  <p>${product.productName}</p>
               </a>
               <p>${product.productPrice}</p>
            </div>
         </li>
      `;
   });
   
   const collectionProduct = document.querySelectorAll(`.collection-product-${page}`);
   
   console.log("collectionProduct: " + collectionProduct[0].classList)
   for(let i = 0; i < collectionProduct.length; i++){
      
      collectionProduct[i].onclick = () => {
         location.href = "/detail/" + productList[i].productCode;
      }
      
   }

}

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

