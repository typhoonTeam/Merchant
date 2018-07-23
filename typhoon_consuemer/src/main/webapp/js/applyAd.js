window.onload = function() {
    let headers=[{"key":"Content-Type","value":"application/json"}];
    function render(data) {

    };
}
function uploadData() {
    var options = {
        url:"ApplyServlet",
        type:"post",
        dataType: 'json',
        success: function(){
            alert("广告已经发送！");
        },
        error : function(err) {
            //alert(err);
        }
    };
    //jquery.form使用方式
    $("#jvForm").ajaxSubmit(options);
    return false;
};