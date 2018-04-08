function init() {

    // Create the input graph
    var g = new dagreD3.graphlib.Graph().setGraph({});

    ////------------- simple example

    //// Fill node "A" with the color green
    //g.setNode("A", { style: "fill: #afa" });

    //// Make the label for node "B" bold
    //g.setNode("B", { labelStyle: "font-weight: bold" });

    //// Double the size of the font for node "C"
    //g.setNode("C", { labelStyle: "font-size: 2em" });

    //g.setNode("D", {});


    ////---------------- simple English example

    //// States and transitions from RFC 793
    //var states = ["介词与名词搭配", "介词与副词搭配", "位置介词用法", "范围介词用法"];

    //// Automatically label each of the nodes
    //states.forEach(function (state) { g.setNode(state, { label: state, width: 120, height: 30 }); });

    //// Add some custom colors based on state
    //g.node('介词与名词搭配').style = "fill: #f77";
    //g.node('位置介词用法').style = "fill: #7f7";

    //// Make the edge from "A" to "B" red, thick, and dashed
    //g.setEdge("介词与名词搭配", "位置介词用法", {
    //    style: "stroke: #f66; stroke-width: 3px; ",
    //    arrowheadStyle: "fill: #f66"
    //});

    //// Make the label for the edge from "C" to "B" italic and underlined
    //g.setEdge("介词与副词搭配", "位置介词用法", {
    //    //label: "A to C",
    //    //labelStyle: "font-style: italic; text-decoration: underline;"
    //});

    //// Make the edge between A and D smoother. 
    //// see available options for lineInterpolate here: https://github.com/mbostock/d3/wiki/SVG-Shapes#line_interpolate
    //g.setEdge("介词与名词搭配", "范围介词用法", {
    //    //label: "line interpolation different",
    //    lineInterpolate: 'basis'
    //});


    ////------------------- Formal English course


    // States and transitions from RFC 793
    var states = ["人称代词主格", "Be动词", "形容词性物主代词", "指示代词",
        "特殊疑问词What", "特殊疑问词Who", "特殊疑问词Where", "特殊疑问词When", "特殊疑问词Why",
        "方位介词in,on,under", "Have的一般现在时", "Like的一般现在时", "序数词", "'s所有格",
        "名词性物主代词", "常用名词数变化", "特殊疑问词How much"];

    // Automatically label each of the nodes
    states.forEach(function (state) {
        g.setNode(state, {label: state, width: 117, height: 20});
    });

    // Add some custom colors based on state
    //g.node('介词与名词搭配').style = "fill: #f77";
    //g.node('位置介词用法').style = "fill: #7f7";


    g.setEdge("特殊疑问词Who", "Have的一般现在时", {});

    g.setEdge("特殊疑问词Who", "特殊疑问词Where", {});

    g.setEdge("指示代词", "特殊疑问词Who", {});

    g.setEdge("Have的一般现在时", "Like的一般现在时", {});

    g.setEdge("名词性物主代词", "Have的一般现在时", {});

    g.setEdge("特殊疑问词Where", "特殊疑问词When", {});

    g.setEdge("指示代词", "方位介词in,on,under", {});

    g.setEdge("方位介词in,on,under", "特殊疑问词Where", {});

    g.setEdge("序数词", "特殊疑问词When", {});

    g.setEdge("特殊疑问词When", "特殊疑问词Why", {});

    g.setEdge("序数词", "'s所有格", {});

    g.setEdge("常用名词数变化", "序数词", {});

    g.setEdge("常用名词数变化", "特殊疑问词How much", {});

    g.setEdge("常用名词数变化", "Like的一般现在时", {});

    g.setEdge("名词性物主代词", "常用名词数变化", {});

    g.setEdge("形容词性物主代词", "名词性物主代词", {});

    g.setEdge("人称代词主格", "Have的一般现在时", {});

    g.setEdge("人称代词主格", "名词性物主代词", {});

    g.setEdge("Be动词", "特殊疑问词What", {});

    g.setEdge("特殊疑问词What", "特殊疑问词Who", {});
    //// Make the edge from "A" to "B" red, thick, and dashed
    //g.setEdge("介词与名词搭配", "位置介词用法", {
    //    style: "stroke: #f66; stroke-width: 3px; ",
    //    arrowheadStyle: "fill: #f66"
    //});

    //// Make the label for the edge from "C" to "B" italic and underlined
    //g.setEdge("介词与副词搭配", "位置介词用法", {
    //    //label: "A to C",
    //    //labelStyle: "font-style: italic; text-decoration: underline;"
    //});

    //// Make the edge between A and D smoother. 
    //// see available options for lineInterpolate here: https://github.com/mbostock/d3/wiki/SVG-Shapes#line_interpolate
    //g.setEdge("介词与名词搭配", "范围介词用法", {
    //    //label: "line interpolation different",
    //    lineInterpolate: 'basis'
    //});


    // Set some general styles
    g.nodes().forEach(function (v) {
        var node = g.node(v);
        node.rx = node.ry = 5;
    });

    g.graph().rankdir = "LR";

    // Create the renderer
    var render = new dagreD3.render();

    // Set up an SVG group so that we can translate the final graph.
    var svg = d3.select("#svg_kmap"),
        inner = svg.append("g");

    // Set up zoom support
    //var zoom = d3.behavior.zoom().on("zoom", function () {
    //    inner.attr("transform", "translate(" + d3.event.translate + ")" +
    //                                "scale(" + d3.event.scale + ")");
    //});
    //svg.call(zoom);

    // Run the renderer. This is what draws the final graph.
    render(inner, g);

    // Center the graph
    var xCenterOffset = (svg.attr("width") - g.graph().width) / 2;
    inner.attr("transform", "translate(" + xCenterOffset + ", 20)");
    svg.attr("height", g.graph().height + 40);


    //var renderer = new dagreD3.Renderer();
    ///// left->right layout
    //var layout = dagreD3.layout()
    //                .nodeSep(20)
    //                .rankDir("LR");
    //renderer.layout(layout).run(g, d3.select("svg g"));
}
