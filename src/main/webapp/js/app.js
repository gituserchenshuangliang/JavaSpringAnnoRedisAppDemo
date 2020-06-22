$("#A").click(function () {
    //show("class/1");
    show("showRole",{role:"8-奶妈-加血"})
});

var show = function (url,param) {
    $.get(url,param ,function (data) {
            $("msg").text(data);
        }
    );
}