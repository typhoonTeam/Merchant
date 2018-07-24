window.onload = function() {
    let url = "/typhoon_merchant/ShowFoodsServletbyPage";
    let method = "GET";
    let headers = [ {
        "key" : "Content-Type",
        "value" : "application/json",

    } ];
    showShopStatus = function() {
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
    function renderTable(data) {//渲染
        let tbody = document.querySelector("#tb");
        for (let i = 0; i < data.length; i++) {
            let tr = $("<tr>");
            $("<td>").text(data[i].id).appendTo(tr);
            $("<td>").text(data[i].foodName).appendTo(tr);
            $("<td>").append(
                $("<img width='130'>").attr('src',
                    data[i].picture)).appendTo(tr);
            $("<td>").text(data[i].price).appendTo(tr);
            $("<td>").text(data[i].info).appendTo(tr);
            let updateA = $(
                "<a href='updateFood.html?id=" + data[i].id
                + "'>").append(
                $("<i class='icon-pencil'>"))
            updateA.appendTo(tr)
            let deleteA = $(
                "<a href='#myModal' role='button' data-toggle='modal'>")
                .append($("<i class='icon-remove'>"))
            tr.appendTo(tbody).addClass("datas");
        }
    }
    function getData(method, url, data, headers) {
        $.ajax({
            type : method,
            url : url,
            data:"pageSize="
                + $("#pageSize").val()
                + "&currentPage="
                + $("#currentPage").val(),
            dataType : "json",
            success : function(data) {
                makePage(data)
                renderTable(data.dataList)
            },
            error : function(err) {
                alert(JSON.stringify(err));
            }
        });
    }
    function makePage(data) {
        let totalPage = data.totalPage;
        let totalCount = data.totalCount;
        $(".pagination").remove();
        let page = $("#page");
        let ul = $("<ul>").addClass("pagination");
        ul.appendTo(page);
        let li1 = $("<li>").addClass("lis").appendTo(ul);
        let a1 = $("<a>").attr("href", "#").attr("aria-label",
            "Previous").appendTo(li1);
        $("<span>").attr("aria-hidden", "true").text("首页")
            .appendTo(a1);
        for (let i = 0; i < totalPage; i++) {
            let li = $("<li>").addClass("lis");
            $("<a>").attr("href", "#").text(i + 1).appendTo(li);
            li.appendTo(ul);
        }
        let li2 = $("<li>").addClass("lis").appendTo(ul);
        let a2 = $("<a>").attr("href", "#").attr("aria-label",
            "Previous").appendTo(li2);
        $("<span>").attr("aria-hidden", "true").text("尾页")
            .appendTo(a2)
        $("#totalPage").text(data.totalPage);
        $("#totalCount").text(data.totalCount);
        $(".lis").on("click", function() {
            if ($(this).text() == "首页") {
                $("#currentPage").val(1);
            } else if ($(this).text() == "尾页") {
                $("#currentPage").val(totalPage);
            } else {
                $("#currentPage").val($(this).text());
            }
            $(".datas").remove();
            getData(method, url, null, headers);
        })
    }

    $("#pageSize").on("blur", function() {
        $(".datas").remove();
        getData(method, url, null, headers);
    })
showShopStatus();
    getData(method, url, null, headers)
}