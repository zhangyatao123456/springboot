
var boxOption = {
  title: [
    {
      text: '',
      left: 'center',
    },

  ],
  noDataLoadingOption: {
    text: '暂无数据',
    effect: 'bubble',
    effectOption: {
      effect: {
        n: 0
      }
    }
  },
  tooltip: {
    trigger: 'item',
    axisPointer: {
      type: 'shadow'
    }
  },
  grid: {
    left: '10%',
    right: '10%',
    bottom: '15%'
  },
  xAxis: {
    type: 'category',
    data: [],
    name:'',
    boundaryGap: true,
    nameGap: 30,
    splitArea: {
      show: false
    },
    axisLabel: {
      formatter: '{value}'
    },
    splitLine: {
      show: false
    }
  },
  yAxis: {
    type: 'value',
    name: '能力值',
    splitArea: {
      show: true
    }
  },
  series: [
    {
      name: 'boxplot',
      type: 'boxplot',
      data: [],
      tooltip: {
        formatter: function (param) {
          return [
            'Experiment ' + param.name + ': ',
            'upper: ' + param.data[5],
            'Q3: ' + param.data[4],
            'median: ' + param.data[3],
            'Q1: ' + param.data[2],
            'lower: ' + param.data[1]
          ].join('<br/>')
        }
      }
    },
    {
      name: 'outlier',
      type: 'scatter',
      data: []
    }
  ]
};

/**
 *
 * @param title 标题
 * @param xAxis x轴参数
 * @param dataArray箱线图数据集
 */
function buildBox(title,xAxis,dataArray){
  var boxInit=cloneObj(boxOption);
  boxInit.title[0].text=title;
  boxInit.xAxis.data=xAxis;
  boxInit.series[1].data=dataArray.outliers
  var data = dataArray.boxData;
  boxInit.series[0].data=data;
  return boxInit;
}
