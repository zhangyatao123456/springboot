$(function () {
    $("#jqGrid").jqGrid({
        ///mytest/kmap/
        url: '../campus/list',//请求数据的url地址

        datatype: "json",//请求数据的数据类型
        colModel: [
            {label: 'id', name: 'id', index: 'id', width: 45, hidden: true, key: true},
          {
            label: '学校id', name: 'school_id',hidden: true, width: 80,
          },
            {
                label: '学校名称', name: 'school_name', width: 80,
            },

          {label: '校区基本情况', name: '', width: 12,
            formatter: function (cellvalue, options, row) {
              var selectHtml="<a href=\"/analyse/OverallLearning.html?schoolId="+row.school_id+"&&schoolName="+row.school_name+"\" style='font-weight: bold' >查看</a>";
              // var selectHtml = "<a onclick=\"viewInfo()\" style='text-decoration:underline;color:blue'>"+cellvalue+"</a>";
              return selectHtml

            }
          },
          {label: '学生水平情况', name: '', width: 12,
            formatter: function (cellvalue, options, row) {
              var selectHtml="<a href=\"/analyse/StudentLevel.html?schoolId="+row.school_id+"&&schoolName="+row.school_name+"\" style='font-weight: bold' >查看</a>";
              // var selectHtml = "<a onclick=\"viewInfo()\" style='text-decoration:underline;color:blue'>"+cellvalue+"</a>";
              return selectHtml

            }
          },
          {label: '学生课次情况', name: '', width: 12,
            formatter: function (cellvalue, options, row) {
              var selectHtml="<a href=\"/analyse/StudentCourse.html?schoolId="+row.school_id+"&&schoolName="+row.school_name+"\" style='font-weight: bold'; >查看</a>";
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
          user_name: null,
          real_name: null

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
                postData: {'school_name': vm.q.school_name,'school_id': vm.q.school_id},//发送数据
                page: page
            }).trigger("reloadGrid");//重新载入

        }
    }
});
