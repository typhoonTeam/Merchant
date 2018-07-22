window.onload = function() {

    let url="http://localhost:9090/typhoon_merchant/ShowRestaurantDetailServlet";
    let headers=[{"key":"Content-Type","value":"application/json"}];
    function render(data) {
        $(".openTime").val(data.openTime);
        $(".closeTime").val(data.closeTime);
        $(".delivery").val(data.delivery);
        $(".deliFee").val(data.deliFee);
        $(".img").attr("src",data.picture);
        $(".slogan").val(data.slogan);
        $(".comments").val(data.comments);
    };

    function getData(method,url,data,headers) {
        $.ajax({
            type: method,
            url: url,
            dataType:"json",
            success: function(data){
                render(data);
            },
            error : function(err) {
              // alert(err);
            }
        });
    };
    getData("GET",url,null,headers);

}
function uploadData() {
    var options = {
        url:"UpdateRestaurantServlet",
        type:"post",
        dataType: 'json',
        success: function(){
            //alert("OK");
        },
        error : function(err) {
            //alert(err);
        }
    };
    //jquery.form使用方式
    $("#jvForm").ajaxSubmit(options);
    return false;
};