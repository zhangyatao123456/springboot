var barOption = {
  title : {
    text: '',
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
    trigger: 'axis'
  },
  toolbox: {
    show : true,
    feature : {
      saveAsImage : {show: true}
    }
  },
  calculable : true,
  xAxis : [
    {
      type : 'category',
      data : [],
      splitLine: {show: true},
      splitArea : {show : true},
      axisLabel:{
        formatter:"",
        interval:0,
        rotate:45,//倾斜度 -90 至 90 默认为0
        margin:10,
        textStyle:{
          color:"#000000"
        },
      },
    }
  ],
  yAxis : [
    {
      type : 'value',
      show: true,
      splitLine: {show: true},
      splitArea : {show : true},
      name:''
    }
  ],
  series : [
  ]
};

function buildBar(title,xAxis,showyAxis){
  var barInit=cloneObj(barOption);
  barInit.title.text=title;
  barInit.xAxis[0].data=xAxis;
  barInit.xAxis[0].formatter=formatter;
  if(showyAxis==true){
    barInit.yAxis[0].show=showyAxis;
  }else{
    barInit.yAxis[0].show=showyAxis;
  }
  return barInit;
}

function buildEmptyBar(){
  var barInit=cloneObj(barOption);
  return barInit;
}

function formatter(value, index) {
  if(param.length>5){
    return param.substr(0,5)+"...";
  }
  return param;
}

function addSerie(barInit,serie){
  barInit.series.push(serie);
  return barInit;
}

function addYaxisName(option,name){
    option.yAxis.name=name;
    return option;
}