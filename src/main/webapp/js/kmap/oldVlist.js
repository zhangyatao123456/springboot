var pageii = null;
var grid = null;

$(function () {
    grid = lyGrid({
        pagId: 'paging',
        l_column: [{
            colkey: "km_code",
            name: "知识图谱编号",
            width: "9%",
            isSort: true
        }, {
            colkey: "ext_1",
            name: "知识图谱描述",
            width: "15%"
        }, {
            colkey: "kn_item_code",
            name: "包含知识点",
            align: "left"
        }, {
            colkey: "update_user",
            name: "更新人",
            width: "6%"
        }, {
            colkey: "update_time",
            name: "更新时间",
            renderData: function (rowindex, data, rowdata, column) {
                return new Date(data).format("yyyy-MM-dd hh:mm:ss");
            },
            width: "10%"
        }],
        jsonUrl: rootPath + '/kmap/findKmapView.shtml',
        checkbox: true,
        checkValue: 'km_code' // 当checkbox为true时，需要设置存放checkbox的值字段 默认存放字段id的值
    });
    $("#akmap_search").click("click", function () {// 绑定查询按扭
        var searchParams = $("#kmapSearchForm").serializeJson();// 初始化传参数
        grid.setOptions({
            data: searchParams
        });
    });
    $("#delKmap").click("click", function () {
        delKmap();
    });
    $("#viewKmap").click("click", function () {
        viewMap();
    });
});

function viewMap() {
    var cbox = grid.getSelectedCheckbox();
    if (cbox == "") {
        layer.msg("请选择查看对象！");
        return;
    }
    if (cbox.length > 1) {
        layer.msg("请选择一个对象！");
        return;
    }
    pageii = layer.open({
        title: "图谱",
        type: 2,
        area: ["1000px", "80%"],
        content: rootPath + '/kmap/viewsvg.shtml?kmcode=' + cbox
    });
}

function delKmap() {
    var cbox = grid.getSelectedCheckbox();
    if (cbox == "") {
        layer.msg("请选择删除项！！");
        return;
    }
    var unparam = cbox.unique();
    var aler_massage = '是否删除,知识图谱：' + unparam + "?";
    layer.confirm(aler_massage, function (index) {
        var url = rootPath + '/kmap/deleteByKmap.shtml';
        var s = CommnUtil.ajax(url, {
            kmaps: unparam.join(",")
        }, "json");
        if (s == "success") {
            layer.msg('删除成功');
            grid.loadData();
        } else {
            layer.msg('删除失败');
        }
    });
}

function uploadMaps() {
    pageii = layer.open({
        title: "上传",
        type: 2,
        area: ["600px", "80%"],
        content: rootPath + '/kmap/toupload.shtml'
    });
}

Array.prototype.unique = function () {
    var res = [];
    var json = {};
    for (var i = 0; i < this.length; i++) {
        if (!json[this[i]]) {
            res.push(this[i]);
            json[this[i]] = 1;
        }
    }
    return res;
}