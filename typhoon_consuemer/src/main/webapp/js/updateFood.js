
    window.onload = function () {
    	

		let nameReg=/^[a-zA-Z][a-zA-Z0-9_]{3,15}$/;
		let priceReg=/^[1-9]\d?(\.(\d)*)?$/;
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
    	
    	
    	
        function renderForm(data) {
            $("#id").val(data.id)
            $("#foodName").val(data.foodName)
            $("#price").val(data.price)

            $("#prevImg").attr("src", data.picture)
            $("#info").val(data.info)
            $("#status").val(data.status)
        }

        function GetRequest() {
            var url = location.search; //获取url中"?"符后的字串
            var theRequest = new Object();
            if (url.indexOf("?") != -1) {
                var str = url.substr(1);
                strs = str.split("&");
                for (var i = 0; i < strs.length; i++) {
                    theRequest[strs[i].split("=")[0]] = unescape(strs[i]
                        .split("=")[1]);
                }
            }
            return theRequest;
        }

        var param = GetRequest().id;
        showFoodDetail = function () {
            let url = "/typhoon_merchant/FoodDetailServlet?id="
                + param;
            let method = "GET";
            let headers = [{
                "key": "Content-Type",
                "value": "application/json"
            }];

            ///////////////////////////////////////////
            function renderTable(checkStatus) {
            }

            ///////////////////////////////////////////
            function getData(method, url, data, headers) {
                $.ajax({
                    type: method,
                    url: url,
                    dataType: "json",
                    success: function (data) {
                        renderForm(data)
                    },
                    error: function (err) {
                        alert(JSON.stringify(err));
                    }
                });

            }

            //////////////////////////////////////////

            getData(method, url, null, headers);
        }

        updateFood = function() {
        	let foodName=document.querySelector("#myForm input[name=foodName]").value;
	 		let price=document.querySelector("#myForm input[name=price]").value;
	 		let picture=document.querySelector("#myForm input[name=picture]").value;
	 		let info=document.querySelector("#myForm input[name=info]").value;
	 		let status=document.querySelector("#myForm input[name=status]").value;
	 		
	        if(foodName&&price&&picture&&info&&status&&(errors.size==0)){
        	
            var options = {
                url: "UpdatefoodServlet",
                type: "post",
                dataType: 'json',
                success: function (data) {
                	renderForm(data)
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
        showFoodDetail();
    }
