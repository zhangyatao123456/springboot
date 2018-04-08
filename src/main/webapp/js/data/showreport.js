$(function () {
    $("#jqGrid").jqGrid({
        ///mytest/kmap/
        url: '../showreport/list',//请求数据的url地址

        datatype: "json",//请求数据的数据类型
        colModel: [
            {label: 'id', name: 'id', index: 'id', width: 45, hidden: true, key: true},
          {
            label: '所属科目', name: 'file_discipline',hidden:true, width: 80,
          },
          {
            label: '文件名称', name: 'file_name',width: 80,
          },
          {
            label: '文件归类', name: 'file_path', hidden: true ,width: 80,

          },
          {label: '文件下载', name: '', width: 8,
            formatter: function (cellvalue, options, row) {
              var selectHtml="<a href=\"/showreport/export.html?fileName="+row.file_name+"\" style='font-weight: bold'; >点我下载</a>";
              // var selectHtml = "<a onclick=\"viewInfo()\" style='text-decoration:underline;color:blue'>"+cellvalue+"</a>";
              return selectHtml

            }
          },


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
//学生账号
var user_name = null;
//学科
var cname = null;
var user_id = null;


var vm = new Vue({
    el: '#rrapp',
    data: {
        q: {
          file_name: null,
          file_desc: null,
          file_discipline:-1,
          file_parent_folder:-1

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
                postData: {'file_name': vm.q.file_name,'file_desc': vm.q.file_desc,'file_path': vm.q.file_path,'file_discipline': vm.q.file_discipline,'file_parent_folder': vm.q.file_parent_folder},//发送数据
                page: page
            }).trigger("reloadGrid");//重新载入

        }
    }
});
