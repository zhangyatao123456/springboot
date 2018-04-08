$(function () {
//表格初始化
  $("#jqGrid").jqGrid({
    url: '/systemUse/getTable',
    datatype: "json",
    colModel: [
      {
        label: '课次ID',
        name: 'sectionId',
        index: "sectionId",
      },
      {
        label: '开始时间',
        name: 'starTime',
      },
      {
        label: '结束时间',
        name: 'endTime',
      },
      {
        label: '学生水平',
        name: 'questionId',
      },
      {
        label: '做题时间',
        name: 'spendTime',
      },
      {
        label: '平均时间',
        name: 'averageSpentTime',
      },
      {
        label: '题量',
        name: 'questionNum',
      },
      {
        label: '正答率',
        name: 'isRight',
      },
    ],
    viewrecords: false,
    height: 385,
    rowNum: 10,
    rowList: [10, 30, 50],
    rownumbers: true,
    rownumWidth: 25,
    autowidth: true,
    multiselect: false,
    pager: "#jqGridPager",
    jsonReader: {
      root: "page.list",
      page: "page.currPage",
      total: "page.totalPage",
      records: "page.totalCount",
      userId:1
    },
    prmNames: {
      page: "page",
      rows: "limit",
      order: "order",
      myparam: 1,
    },
    postData:{
      userId:1
    },
    gridComplete: function () {
      //隐藏grid底部滚动条
      $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
    }
  });
  var vm = new Vue({
    el: '#rrapp',
    data: {
      q: {
        userId: "1"
      },
    },
    method:{
      query: function () {
        $("#jqGrid").jqGrid('setGridParam', {
          postData: {
            'userId': vm.q.userId,
          },
          page: 1
        }).trigger("reloadGrid");
      },
    },
    created: function(){
      // alert(${account});
      $("#jqGrid").jqGrid('setGridParam', {
        postData: {
          'userId': 1
        },
        page: 1
      }).trigger("reloadGrid");
    }
  })
})