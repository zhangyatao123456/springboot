$(function () {
    //时间控件初始化
    $('#date01').daterangepicker(
        {
            endDate: moment().format("YYYY-MM-DD"),
            locale: {
                applyLabel: "确定",
                cancelLabel: "取消",
                format: "YYYY-MM-DD"
            }
        },
        function (start, end, label) {
            vm.q.startDate = start.format('YYYY-MM-DD');
            vm.q.endDate = end.format('YYYY-MM-DD');
        }
    )


    //表格初始化
    $("#jqGrid").jqGrid({
        url: '/data/subject/list',
        datatype: "json",
        colModel: [
            {
                label: '知识点编号',
                name: 'tagCode',
                index: "tagCode",
                width: 70,
                key: true,
                sortable: false,
                resizable: false
            },
            {label: '知识点描述', name: 'tagName', index: "tagName", width: 110, sortable: false, resizable: false},
            {
                label: '题目自定义编号',
                name: 'serialNumber',
                index: "serialNumber",
                width: 100,
                sortable: false,
                resizable: false
            },
            {label: '题目ID', name: 'questionId', index: "questionId", width: 45, sortable: false, resizable: false},
            {label: '题目难度', name: 'difficulty', index: "difficulty", width: 45, sortable: true, resizable: false},
            {label: '次数', name: 'tagCodeCount', index: "tagCodeCount", width: 35, sortable: true, resizable: false},
            {
                label: '平均时间时长（s）',
                name: 'spentTimeAvg',
                index: "spentTimeAvg",
                width: 80,
                sortable: false,
                resizable: false
            },
            {
                label: '预估答题时间（s）',
                name: 'estimatesTimeAvg',
                index: "estimatesTimeAvg",
                width: 80,
                sortable: false,
                resizable: false
            },
            {label: '正答率', name: 'rightRate', index: "rightRate", width: 80, sortable: true, resizable: false}
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
            records: "page.totalCount"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order",
            myparam: 1,
        },
        onSortCol: function (index, colindex, sortorder) {
            if (index == "difficulty") {
                vm.q.orderByParam = "difficulty";
            }
            if (index == "tagCodeCount") {
                vm.q.orderByParam = "tag_code_count";
            }
            if (index == "rightRate") {
                vm.q.orderByParam = "right_rate";
            }
            vm.q.sortCondition = sortorder;
            vm.query();
        },
        gridComplete: function () {
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }
    });

});

var ztree;

var vm = new Vue({
    el: '#rrapp',
    data: {
        q: {
            startDate: moment().format("YYYY-MM-DD"),
            endDate: moment().format("YYYY-MM-DD"),
            difficulty: "",//难度
            tagCodeCount: "",//至少做题次数
            minRightRate: "",//正答率最小值
            maxRightRate: "",//正答率最大值
            orderByParam: "",//当前排序的字段
            sortCondition: "",//当前排序的方式 asc desc
            subject: ""
        },
        c: {
            rightRateChart: [],
            diffcultyChart: []
        },
        showList: true,
        title: null,
        role: {}
    },
    computed: {
        dateSelected: function () {
            return this.q.startDate + " - " + this.q.endDate
        },
        _minRightRate: function () {
            if (vm.q.minRightRate == "") {
                return 0;
            }
            return parseInt(vm.q.minRightRate) / 100;
        },
        _maxRightRate: function () {
            if (vm.q.maxRightRate == "") {
                return 1;
            }
            return parseInt(vm.q.maxRightRate) / 100;
        }
    },
    methods: {
        query: function () {
            if (!this.checkParam()) {
                return false;
            }
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {
                    'startDate': vm.q.startDate,
                    'endDate': vm.q.endDate,
                    'difficulty': vm.q.difficulty,
                    'tagCodeCount': vm.q.tagCodeCount,
                    'minRightRate': vm._minRightRate,
                    'maxRightRate': vm._maxRightRate,
                    'orderByParam': vm.q.orderByParam,
                    'sortCondition': vm.q.sortCondition,
                    'subject': vm.q.subject
                },
                page: 1
            }).trigger("reloadGrid");
            refreshChart();
        },
        down: function () {
            window.location.href = "/data/subject/export?startDate=" + vm.q.startDate + "&endDate=" + vm.q.endDate +
                "&difficulty=" + vm.q.difficulty + "&tagCodeCount=" + vm.q.tagCodeCount + "&minRightRate=" + vm._minRightRate + "&maxRightRate=" + vm._maxRightRate +
                "&orderByParam=" + vm.q.orderByParam + "&sortCondition" + vm.q.sortCondition + "&subject=" + vm.q.subject;
        },
        checkParam: function () {
            var tagCodeCount = vm.q.tagCodeCount.trim();
            var minRightRate = vm._minRightRate;
            var maxRightRate = vm._maxRightRate;
            //检查时间参数
            //检查做题次数必须是数字


            if (!/^[0-9]*$/.test(tagCodeCount)) {
                alert("正答率必须是数字,并且大于0");
                return false;
            }


            //检查正答率必须是数字
            //并且最小正答率要小于最大正答率
            if (minRightRate != "") {
                if (!/^[0-9.]*$/.test(minRightRate)) {
                    alert("正答率必须是数字,并且大于0");
                    return false;
                }
            }
            if (maxRightRate != "") {
                if (!/^[0-9.]*$/.test(maxRightRate)) {
                    alert("正答率必须是数字,并且大于0");
                    return false;
                }
            }
            if (parseInt(minRightRate) > parseInt(maxRightRate)) {
                alert("最小正答率不能大于最大正答率");
                return false;
            }
            return true;
        },


    }
});


var rightRate_option = {
    title: {
        text: '正确率/题目数量对比折线图',
        left: 'left'
    },
    tooltip: {
        trigger: 'item',
        formatter: "难度级别:{a} <br/>正确率:{b} : 题目数量:{c}"
    },
    legend: {
        show: true,
        left: 'right',
        data: []
    },
    xAxis: {
        type: 'category',
        name: '正确率',
        splitLine: {show: false},
        boundaryGap: false,
        data: [],
        nameLocation: 'middle',
        nameGap: '17'
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    yAxis: {
        name: '题目数量'
    },
    series: []
};

var diffculty_option = {
    title: {
        text: '难度/题目数量对比饼图',
        x: 'center'
    },
    tooltip: {
        trigger: 'item',
      formatter: "{b} <br/>占比:{d}% : 题目数量:{c} "
    },
    legend: {
        orient: 'vertical',
        left: 'left',
        data: []
    },
    series: [
        {
            // name: '访问来源',
            type: 'pie',
            radius: '75%',
            center: ['50%', '60%'],
            data: [],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};

var rightRateChart = echarts.init(document.getElementById('main'));
var diffcultyChart = echarts.init(document.getElementById('main1'));

function refreshChart() {
    var data = {
        'startDate': vm.q.startDate,
        'endDate': vm.q.endDate,
        'difficulty': vm.q.difficulty,
        'tagCodeCount': vm.q.tagCodeCount,
        'minRightRate': vm._minRightRate,
        'maxRightRate': vm._maxRightRate,
        'orderByParam': vm.q.orderByParam,
        'sortCondition': vm.q.sortCondition,
        'subject': vm.q.subject
    }

    $.ajax({
        url: "/data/subject/countRightRate",
        data: data,
        success: function (msg) {
            console.log(msg);
            rightRate_option.xAxis.data = msg.data.xAxis;
            rightRate_option.series = msg.data.series;
            rightRate_option.legend.data = msg.data.legend;
            rightRateChart.clear()
            rightRateChart.dispose();
            rightRateChart = echarts.init(document.getElementById('main'));
            rightRateChart.setOption(rightRate_option)
        },
        error: function (data) {
            console.log(data);
        }
    })

    $.ajax({
        url: "/data/subject/countDifficulty",
        data: data,
        dataType: "json",
        success: function (msg) {
            console.log(msg.data);
            diffculty_option.legend.data = msg.data.legend;
            diffculty_option.series[0].data = msg.data.series;
          diffcultyChart.clear()
            diffcultyChart.setOption(diffculty_option)
        },
        error: function (data) {
            console.log(data);
        }
    })

}