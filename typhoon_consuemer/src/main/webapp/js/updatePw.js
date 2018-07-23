window.onload = function() {
    let pswReg=/^(?![A-Z]+$)(?![a-z]+$)(?!\d+$)\S{6,}$/;
    let errors=new Map();

    let headers=[{"key":"Content-Type","value":"application/json"}];
    function render(data) {
    };
    function validate(message) {
        errors.clear();
        if(message.psw1){
            if(!pswReg.test(message.psw1)){errors.set('psw1','数字/大写/小写字母,至少两种组成，长度不小于6');}else{
            	errors.set('psw1','OK');
            }
        }
        if(message.psw2){
            if(!pswReg.test(message.psw2)){errors.set('psw2','数字/大写/小写字母,至少两种组成，长度不小于6');}else{
            	errors.set('psw2','OK');
                }
        }
        if(message.psw3){
            if(!pswReg.test(message.psw3)){errors.set('psw3','数字/大写/小写字母,至少两种组成，长度不小于6');}else{
            	errors.set('psw3','OK');
                }
        }
    }
    function renderError(errors) {
        let pswSpan1=document.querySelector("#jvForm input[name=password]").nextElementSibling;
        pswSpan1.textContent=errors.get('psw1');
        let pswSpan2=document.querySelector("#jvForm input[name=newPassword]").nextElementSibling;
        pswSpan2.textContent=errors.get('psw2');
        let pswSpan3=document.querySelector("#jvForm input[name=comPassword]").nextElementSibling;
        pswSpan3.textContent=errors.get('psw3');
    }
    document.querySelector("#jvForm").addEventListener("change",function (e) {
        e.preventDefault();
        let psw1=document.querySelector("#jvForm input[name=password]").value;
        let psw2=document.querySelector("#jvForm input[name=newPassword]").value;
        let psw3=document.querySelector("#jvForm input[name=comPassword]").value;
        let message={
            psw1:psw1,
            psw2:psw2,
            psw3:psw3
        };
        validate(message);
        renderError(errors);
    })

    $("#commit").click(function(){
        let flag = true;
        errors.forEach(function(value,key,errors){  
        	if(value!="OK") flag =false;
        })
        if(flag==true){

        	if($(".newPassword").val() == $(".comPassword").val()){
        		  var options = {
                      url:"UpdatePasswordServlet",
                      type:"post",
                      dataType: 'json',
                      success: function(){
                          alert("修改成功！");
                          $(".password").val("");
                          $(".newPassword").val("");
                          $(".comPassword").val("");
                      },
                      error : function() {
                          alert("密码错误！");
                      }
                  };
                  $("#jvForm").ajaxSubmit(options);
                  return false;
        	}else{
        		alert("两次输入的密码一致！");
        	}       	
        }else{
        	alert("请输入正确格式！");
        }
      
    })
}