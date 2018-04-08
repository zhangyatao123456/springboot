$(function () {
    $("#jqGrid").jqGrid({
        ///mytest/kmap/
        url: '../user/list',//请求数据的url地址

        datatype: "json",//请求数据的数据类型
        colModel: [
            {label: 'id', name: 'id', index: 'id', width: 45, hidden: true, key: true},
          {label: '学生id', name: 'user_id',  width: 30,
            formatter: function (userId, options, row) {
              user_id = userId;
              return userId;

            }
          },
          {label: '学生姓名', name: 'real_name', width: 50},

          {label: '学生账号', name: 'user_name', width: 50,
            formatter: function (userName, options, row) {
              user_name = userName;
              return userName;

            }
          },
          {label: '线上/线下', name: 'online', width: 50,
            formatter: function (onLine, options, row) {
            if("1"==onLine){
                return "线上";
            }else if("0"==onLine){
                return "线下";
            }


            }

          },
            {
                label: '学校名称', name: 'school_name', width: 80,
            },
            {
                label: '学科', name: 'cname', width: 55,
                formatter: function (cName, options, row) {
                    cname = cName;
                    return cName;

                }
            },
          {label: '学习情况', name: '', width: 25,
            formatter: function (cellvalue, options, row) {
              var selectHtml="<a href=\"/analyse/userDataAnalyse.html?account="+row.user_id+"&&online="+row.online+"\" style='font-weight: bold' >查看</a>";
              // var selectHtml = "<a onclick=\"viewInfo()\" style='text-decoration:underline;color:blue'>"+cellvalue+"</a>";
              return selectHtml

            }
          }
            ,


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
          real_name: null,
          cname:"-- 请选择科目 --"
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

                title: "视图弹窗",
                type: 2,
                skin: 'layui-layer-rim',
                area: ["1050px", "90%"],
                //content :  'viewsvg.html',
                //content :''
                content: '../page/viewsvg.shtml?param=' + user_id
            });
            //loadDb();
            showData(user_id);

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
                postData: {'user_name': vm.$data.q.user_name, 'real_name': vm.$data.q.real_name, 'cname': vm.$data.q.cname, 'online': vm.$data.q.online, 'school_name': vm.$data.q.school_name},//发送数据
                page: page
            }).trigger("reloadGrid");//重新载入

        }
    }
});
