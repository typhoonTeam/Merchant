window.onload = function() {
    let pswReg=/^(?![A-Z]+$)(?![a-z]+$)(?!\d+$)\S{6,}$/;
    let errors=new Map();

    let headers=[{"key":"Content-Type","value":"application/json"}];
    function render(data) {
    };
    function validate(message) {
        errors.clear();
        if(message.psw1){
            if(!pswReg.test(message.psw1)){errors.set('psw1','数字/大写/小写字母,至少两种组成，长度不小于6');}
        }
        if(message.psw2){
            if(!pswReg.test(message.psw2)){errors.set('psw2','数字/大写/小写字母,至少两种组成，长度不小于6');}
        }
        if(message.psw3){
            if(!pswReg.test(message.psw3)){errors.set('psw3','数字/大写/小写字母,至少两种组成，长度不小于6');}
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
//    	if(!errors){
//    		alert("OK")
//    	}else{
//    		alert("NO");
//    	}
        var options = {
            url:"UpdatePasswordServlet",
            type:"post",
            dataType: 'json',
            success: function(data){
                //alert(data);
            },
            error : function(err) {
                //alert(err);
            }
        };
        $("#jvForm").ajaxSubmit(options);
        return false;
    })
}