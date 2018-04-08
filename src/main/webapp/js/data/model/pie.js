var pieOption = {
  title : {
    text: '',
    x:'center'
  },
  noDataLoadingOption: {
    text: '暂无数据',
    effect: 'bubble',
    effectOption: {
      effect: {
        n: 0
      }
    }
  },
  tooltip : {
    trigger: 'item',
    formatter: "{a} <br/>{b} : {c} ({d}%)"
  },
  legend: {
    type: 'scroll',
    orient: 'vertical',
    right: 10,
    top: 20,
    bottom: 20,
    data: [],
    selected: []
  },
  series : [
    {
      name: '',
      type: 'pie',
      radius : '55%',
      center: ['40%', '50%'],
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

function buildPie(title,legend,dataArray,serieName){
  var pieInit=cloneObj(pieOption);
  pieInit.title.text=title;
  pieInit.legend.data=legend;
  pieInit.legend.selected=legend;
  pieInit.series[0].data=dataArray;
  return pieInit;
}