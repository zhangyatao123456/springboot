$(function () {
    $("#jqGrid").jqGrid({
        ///mytest/kmap/
        url: '../data/list',//请求数据的url地址

        datatype: "json",//请求数据的数据类型
        colModel: [
            {label: '记录ID', name: 'rid', index: "rid", width: 45, key: true},
            {label: 'Session编号', name: 'sessionId', width: 70},
            {label: '知识图谱编号', name: 'tcode', width: 75},
            {label: '知识点编号', name: 'ncode', width: 70},
            {
                label: '学测阶段', name: 'stage', width: 65,
                formatter: function (value, options, row) {
                    if ("1011" == value) {
                        return "学前测试";
                    } else if ("1021" == value) {
                        return "学习阶段";
                    } else if ("1031" == value) {
                        return "学后测试";
                    }
                }
            },
            {label: '最新能力值', name: 'ability', width: 40},
            {label: '创建时间', name: 'createtime', width: 80}
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
var vm = new Vue({
    el: '#rrapp',
    data: {
        q: {
            tcode: null,
            ncode: null,
            sessionId: null
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


        del: function () {
            var rids = getSelectedRows();
            if (rids == null) {
                return;
            }

            confirm('确定要删除选中的记录？', function () {
                $.ajax({
                    type: "POST",
                    url: "../data/delete",
                    data: JSON.stringify(rids),
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


        //向后台发送查询关键字请求，根据服务端返回的结果进行响应
        reload: function (event) {

            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {'tcode': vm.q.tcode, 'ncode': vm.q.ncode, 'sessionId': vm.q.sessionId},//发送数据
                page: page
            }).trigger("reloadGrid");//重新载入

        }
    }
});
