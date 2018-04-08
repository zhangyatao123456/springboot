$(function () {
    $("#jqGrid").jqGrid({
        ///mytest/kmap/
        url: '../kmap/list',//请求数据的url地址

        datatype: "json",//请求数据的数据类型
        colModel: [
            {label: 'nid', name: 'nid', index: 'nid', width: 45, hidden: true, key: true},
            {
                label: '知识图谱编号', name: 'kcode', width: 70,
                formatter: function (kcode, options, row) {
                    kmapcode = kcode;
                    return kcode;

                }
            },
            {
                label: '知识点编号', name: 'code', width: 75,
                formatter: function (code, options, row) {
                    nodecode = code;
                    return code;

                }
            },
            {label: '直接前置知识点', name: 'prenodes', width: 70},
            {label: '知识点描述', name: 'desc', width: 100},
            {label: '操作人', name: 'operator', width: 40},
            {label: '更新时间', name: 'createtime', width: 80}
        ],
        //总页数
        viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList: [10, 30, 50],
        //
        rownumbers: true,
        rownumWidth: 25,
        autowidth: true,
        multiselect: true,
        pagination: true,
        //loadonce:true,
        pager: "#jqGridPager",
        jsonReader: {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order"
        },
        //完成服务器请求后，回调函数
        //loadError:function(xhr,status,error){
        //    alert(status + " loading data of " + $(this).attr("id") + " : " + error );
        //},
        gridComplete: function () {
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }
    });
});
var pageii = null;
var kmapcode = null;
var g;
var states;
var svg;
var alldata;
var nodecode = null;

function loadDb() {
    //alert($('#layer_notice'));
    alert(111);
}

var vm = new Vue({
    el: '#rrapp',
    data: {
        q: {
            kcode: null,
            operator: null,
            code: null
        },
        showList: true,
        title: null,
        roleList: {},
        user: {
            status: 1,
            roleIdList: []
        }
    },

    methods: {
        query: function () {
            vm.reload();
        },
        see: function () {
            //vm.showList = false;
            var cbox = getSelectedRow();
            //alert(cbox);
            if (cbox == null) {
                return;
            }
            //vm.showList =false;
            pageii = layer.open({

                title: "知识图谱视图",
                type: 2,
                skin: 'layui-layer-rim',
                area: ["1050px", "90%"],
                //content :  'viewsvg.html',
                //content :''
                content: '../page/viewsvg.shtml?kmcode=' + kmapcode
            });
            //loadDb();
            showData(kmapcode);

        },

        update: function () {
            var userId = getSelectedRow();
            if (userId == null) {
                return;
            }

            vm.showList = false;
            vm.title = "修改";

            vm.getUser(userId);
            //获取角色信息
            this.getRoleList();
        },
        del: function () {
            var nids = getSelectedRows();
            if (nids == null) {
                return;
            }

            confirm('确定要删除选中的记录？', function () {
                $.ajax({
                    type: "POST",
                    url: '../kmap/delete.shtml?nodecode=' + nodecode,
                    data: JSON.stringify(nids),
                    success: function (r) {
                        if (r.code == 0) {
                            alert('操作成功', function (index) {
                                vm.reload();
                            });
                        } else {
                            alert(r.msg);
                        }
                    }
                });
            });
        },
        saveOrUpdate: function (event) {
            var url = vm.user.userId == null ? "../sys/user/save" : "../sys/user/update";
            $.ajax({
                type: "POST",
                url: url,
                data: JSON.stringify(vm.user),
                success: function (r) {
                    if (r.code === 0) {
                        alert('操作成功', function (index) {
                            vm.reload();
                        });
                    } else {
                        alert(r.msg);
                    }
                }
            });
        },
        getUser: function (userId) {
            $.get("../sys/user/info/" + userId, function (r) {
                vm.user = r.user;
            });
        },
        getRoleList: function () {
            $.get("../sys/role/select", function (r) {
                vm.roleList = r.list;
            });
        },
        //向后台发送查询关键字请求，根据服务端返回的结果进行响应
        reload: function (event) {

            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {'kcode': vm.q.kcode, 'operator': vm.q.operator, 'code': vm.q.code},//发送数据
                page: page
            }).trigger("reloadGrid");//重新载入

        }
    }
});
