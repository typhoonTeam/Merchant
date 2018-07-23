window.onload = function() {
    let url = "http://localhost:9090/typhoon_merchant/ShowRestaurantInfoServlet";
    let method = "GET";
    let headers = [ {
        "key" : "Content-Type",
        "value" : "application/json"
    } ];
    ///////////////////////////////////////////
    function render(data) {
        $(".shopId").text(data.shopId);
        $(".creditCode").text(data.creditCode);
        $(".idCard").text(data.idCard);
        $(".corporateName").text(data.corporateName);
        $(".picture").attr("src",data.picture);
        $(".phone").text(data.phone);
        $(".shopName").text(data.shopName);
        $(".address").text(data.address);
        $(".comments").text(data.comments);

    }
    ///////////////////////////////////////////
    function getData(method, url, data, headers) {
        $.ajax({
            type : method,
            url : url,
            dataType:"json",
            success : function(data) {
                render(data);
            },
            error : function(err) {
               // alert(err);
            }
        });

    }
    //////////////////////////////////////////

    getData(method, url, null, headers);
}