$(function () {
    $("#jqGrid").jqGrid({
        ///mytest/kmap/
        url: '../cache/keylist',//请求数据的url地址

        datatype: "json",//请求数据的数据类型
        colModel: [
            {label: '缓存键值', name: 'key', index: "key", width: 45, key: true}
            //{ label: '缓存键值', name: 'key',  width: 70 }
        ],
        //总页数
        viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList: [10, 30, 50],
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
var vm = new Vue({
    el: '#rrapp',
    data: {
        q: {
            key: null
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

                title: "缓存",
                type: 2,
                skin: 'layui-layer-rim',
                area: ["700px", "70%"],
                //content :  'viewsvg.html',
                //content :''
                content: '../cache/viewcache.shtml?key=' + cbox
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
            var key = getSelectedRows();
            //var key = vm.showList.colModel.name.key;
            if (key == null) {
                return;
            }

            confirm('确定要删除选中的记录？', function () {
                $.ajax({
                    type: "POST",
                    url: '../cache/deletecache.shtml',

                    data: JSON.stringify(key),
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
                postData: {'key': vm.q.key},//发送数据
                page: page
            }).trigger("reloadGrid");//重新载入

        }
    }
});
