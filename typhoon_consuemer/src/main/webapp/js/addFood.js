window.onload = function() {
			let nameReg=/^[a-zA-Z][a-zA-Z0-9_]{3,15}$/;//名字是字母开头
			let priceReg=/^[1-9]\d?(\.(\d)*)?$/;//范围是1-99
			let errors=new Map();
			
			function validate(message) {
                errors.clear();
               // if(message.foodName){
                 //   if(!nameReg.test(message.foodName)){errors.set('foodName','name error.');}
               // }
                if(message.price){
                    if(!priceReg.test(message.price)){errors.set('price','price 0~99.');}
                }
			}
			
		 	function renderError(errors) {
		 		let foodNameSpan=document.querySelector("#myForm input[name=foodName]").nextElementSibling;
		 		foodNameSpan.textContent=errors.get('foodName');

		 		let priceSpan=document.querySelector("#myForm input[name=price]").nextElementSibling;
		 		priceSpan.textContent=errors.get('price');
			}
		 	
		 	document.querySelector("#myForm").addEventListener("change",function (e) {
		 		let foodName=document.querySelector("#myForm input[name=foodName]").value;
		 		let price=document.querySelector("#myForm input[name=price]").value;
		 		let message={foodName:foodName,price:price};
		 		validate(message);
		 		renderError(errors);
		 		
		 	})
			showShopStatus = function() {
				let url = "/typhoon_merchant/showShopStatusServlet";
				let method = "GET";
				let headers = [ {
					"key" : "Content-Type",
					"value" : "application/json"
				} ];
				
				function getData(method, url, data, headers) {
					$.ajax({
						type : method,
						url : url,
						dataType:"json",
						success : function(data) {
							let checkStatus = JSON.stringify(data)
							let status = JSON.parse(checkStatus);
							if(status.checkStatus!=1){
								alert("你没有资格")
								window.location.href='showShopStatus.html'
							}
						},
						error : function(err) {
							alert(JSON.stringify(err));
						}
					});

				}
				getData(method, url, null, headers);
			}
			uploadFood = function() {
				let foodName=document.querySelector("#myForm input[name=foodName]").value;
		 		let price=document.querySelector("#myForm input[name=price]").value;
		 		let picture=document.querySelector("#myForm input[name=picture]").value;
		 		let info=document.querySelector("#myForm input[name=info]").value;
		 		let status=document.querySelector("#myForm input[name=status]").value;
		 		
		        if(foodName&&price&&picture&&info&&status&&(errors.size==0)){
					var options = {
			                url: "AddfoodServlet",
			                type: "post",
			                dataType: 'json',
			                success: function (data) {
			                	window.location.href='showMyFoods.html'
			                },
			                error: function (err) {
			                }
			            };
			            //jquery.form使用方式
			            $("#myForm").ajaxSubmit(options);
			            return false;
				}else{
					alert("你输入的信息有误")
				}
	            
	        };
	        showShopStatus();
		}