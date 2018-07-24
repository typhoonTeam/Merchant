function setImagePreview(avalue) {
			var docObj = document.getElementById("doc");
			//img
			var imgObjPreview = document.getElementById("preview");
			//div
			var divs = document.getElementById("localImag");
			if (docObj.files && docObj.files[0]) {
				//设img属性
				imgObjPreview.style.display = 'block';
				imgObjPreview.style.width = '100px';
				imgObjPreview.style.height = '100px';
				imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
			} else {
				//IE下，使用滤镜
				docObj.select();
				var imgSrc = document.selection.createRange().text;
				var localImagId = document.getElementById("localImag");
				//必须设置初始大小
				localImagId.style.width = "100px";
				localImagId.style.height = "100px";
				//图片异常的捕捉，防止用户修改后缀来伪造图片
				try {
					localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)"
					localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
				} catch (e) {
					alert("格式不正确");
					return false;
				}
				imgObjPreview.style.display = 'none';
				document.selection.empty();
			}
			return true;
		}
		document.getElementById('applyForm').style.display = 'none';
		function applyClick(){
			let creditCode=document.querySelector("#applyForm input[name=creditCode]").value;
			let idCard=document.querySelector("#applyForm input[name=idCard]").value;
			let phone=document.querySelector("#applyForm input[name=phone]").value;
			let corporateName=document.querySelector("#applyForm input[name=corporateName]").value;
			let shopName=document.querySelector("#applyForm input[name=shopName]").value;
			let address=document.querySelector("#applyForm input[name=address]").value;
			let comments=document.querySelector("#applyForm input[name=comments]").value;
			let picture=document.querySelector("#applyForm input[name=picture]").value;
			if(creditCode&&idCard&&phone&&corporateName&&shopName&&address&&comments&&picture){
			var options = {
	                url:"CompleteRegisterInfoServlet",
	                type:"post",
	                dataType: 'json',
	                success: function(){
	                	alert("返回")
	                },
	                error : function(err) {
	                	//alert(err);
	                	render(data)
					}
	            };
	            //jquery.form使用方式
	            $("#applyForm").ajaxSubmit(options);
	            return false;}
					   else{
						   alert("你有信息为空！")
					   }
		}
		function render(data) {
			let status = JSON.parse(data);
			let num = status.checkStatus;
			let myStatus = document.querySelector("#status");
			let status_info = document.querySelector("#status_info");
			let myCol = document.querySelector("#myCol");
			let apply_btn = document.createElement("BUTTON");
			let apply_txt = document.createTextNode("重新申請");
			apply_btn.appendChild(apply_txt);
			var btn = document.createElement("BUTTON");
			if (num == "1") {
				myStatus.style.color = "#699";
				myStatus.textContent = "商家申请状态 :已通过";
				status_info.textContent = "可以自由管理商店"
			} else if (num == "0") {
				myStatus.style.color = "#FFF68F";
				myStatus.textContent = "商家申请状态 :审核中";
				status_info.textContent = "必须等待审核通过"
			} else if (num == "2") {
				myStatus.style.color = "#FFD700";
				myStatus.textContent = "商家申请状态 :驳回或未申请";
				status_info.textContent = "可重新申请"
				document.getElementById('applyForm').style.display = '';
			} else if (num == "3") {
				myStatus.style.color = "#FF6347";
				myStatus.textContent = "商家申请状态 :不通过";
				status_info.textContent = "不通过,无法使用店铺,且将无法再申请"
			}
		}
		window.onload = function() {
			

			let nameReg=/^[a-zA-Z][a-zA-Z0-9_]{3,15}$/;
			let priceReg=/^[1-9]\d?(\.(\d)*)?$/;
			let errors=new Map();
			
			function validate(message) {
	            errors.clear();
	           // if(message.foodName){
	             //   if(!nameReg.test(message.foodName)){errors.set('foodName','name error.');}
	           // }
	            if(message.price){
	                if(!priceReg.test(message.price)){errors.set('price','price error.');}
	            }
			}
			
		 	function renderError(errors) {
		 		let foodNameSpan=document.querySelector("#applyForm input[name=foodName]").nextElementSibling;
		 		foodNameSpan.textContent=errors.get('foodName');

		 		let priceSpan=document.querySelector("#applyForm input[name=price]").nextElementSibling;
		 		priceSpan.textContent=errors.get('price');
			}
		 	
		 	document.querySelector("#applyForm").addEventListener("change",function (e) {
		 		let foodName=document.querySelector("#applyForm input[name=foodName]").value;
		 		let price=document.querySelector("#applyForm input[name=price]").value;
		 		let message={foodName:foodName,price:price};
		 		validate(message);
		 		renderError(errors);
		 		
		 	})
			
			showShopStatus = function() {
				$("input[name='picture']").live('change', function() {
					var file = $(this).val();
					setImagePreview(file);
				});
				
				let url = "/typhoon_merchant/showShopStatusServlet";
				let method = "GET";
				let headers = [ {
					"key" : "Content-Type",
					"value" : "application/json"
				} ];
				///////////////////////////////////////////
				function renderTable(checkStatus) {
				}
				///////////////////////////////////////////
				function getData(method, url, data, headers) {
					$.ajax({
						type : method,
						url : url,
						dataType : "json",
						success : function(data) {
							let checkStatus = JSON.stringify(data)
							render(checkStatus);
						},
						error : function(err) {
							alert(JSON.stringify(err));
						}
					});

				}
				//////////////////////////////////////////

				getData(method, url, null, headers);
			}
			showShopStatus();
		}