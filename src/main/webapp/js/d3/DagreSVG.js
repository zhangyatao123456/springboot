var g;
var states;
var svg;
var alldata;

function buildSvg(tagval) {
    $.ajax({
        url: '../kmap/msvg.shtml',
        type: 'POST', //GET
        async: true,    //或false,是否异步
        data: {selType: tagval},
        timeout: 8000,    //超时时间
        dataType: 'json',    //返回的数据格式：json/xml/html/script/jsonp/text
        beforeSend: function (xhr) {
            //console.log(xhr)
            console.log('发送前')
        },
        success: function (data, textStatus, jqXHR) {
            // console.log(data)
            //  alldata=jQuery.parseJSON(data);
            alldata = jQuery.parseJSON(data);

            //var states=alldata.state;
            //var edges=alldata.edge;
            if (alldata.state == null || alldata.state == '' || alldata.state == undefined) {
                alert("无该图谱数据!");
                return;
            }
            initSVG(alldata.state, alldata.edge);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            //alert(XMLHttpRequest.status);
            //alert(XMLHttpRequest.readyState);
            //alert(textStatus);
            //alert(xhr);
            //console.log(xhr);
            //console.log(textStatus);
        },
        complete: function () {
            console.log('结束')
        }
    })
}

function initSVG(sta_val, edges) {
    //alert(sta_val+"1111");
    g = new dagreD3.graphlib.Graph().setGraph({});

    // States and transitions from RFC 793
    states = sta_val;

    // Automatically label each of the nodes
    states.forEach(function (state) {
        g.setNode(state, {label: state, width: 237, height: 20});
    });

    // Add some custom colors based on state
    for (var index = 0; index < edges.length; index++) {
        g.setEdge(edges[index][0], edges[index][1], {});
    }

    // Set some general styles
    g.nodes().forEach(function (v) {
        var node = g.node(v);
        node.rx = node.ry = 5;
    });
    g.graph().rankdir = "LR";
    // Create the renderer
    var render = new dagreD3.render();
    // Set up an SVG group so that we can translate the final graph.
    svg = d3.select("#svg_kmap"),
        inner = svg.append("g");
    var zoom = d3.behavior.zoom().on("zoom", function () {
        inner.attr("transform", "translate(" + d3.event.translate + ")" +
            "scale(" + d3.event.scale + ")");
    });
    svg.call(zoom);
    // Run the renderer. This is what draws the final graph.
    render(inner, g);

    // Center the graph
    var xCenterOffset = (svg.attr("width") - g.graph().width) / 2;
    inner.attr("transform", "translate(" + xCenterOffset + ", 20)");
    svg.attr("height", g.graph().height + 40);
    d3.select('#btn_savepng').on('click', function () {
        saveSvgAsPng(document.getElementById("svg_kmap"), "diagram.png", {
            backgroundColor: '#fff',
            height: svg.height,
            width: svg.width
        });
    });

    /*  $("#savesvg").click(function(){
        genuri("svg","svg_html");
    });
    $("#btn_savepng").click(function(){
        genuri("png","svg_html");
    });  */
}

$(document).ready(function () {
    $("label[name='lbl_level_rd']").click(function () {
        g = null;
        states = null;
        svg = null;
        alldata = null;
        $("#svg_kmap").html("");
        $("#svg_kmap").html("<g transform=\"translate(327.958984375, 20)\"/>");
        buildSvg(this.id);
    });
});
