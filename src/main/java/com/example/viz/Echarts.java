package com.example.viz;

import com.example.viz.model.PurchaseOrder;
import com.example.viz.util.SimpleData;
import org.icepear.echarts.Bar;
import org.icepear.echarts.Treemap;
import org.icepear.echarts.charts.treemap.TreemapSeriesItemStyle;
import org.icepear.echarts.charts.treemap.TreemapSeriesLabel;
import org.icepear.echarts.charts.treemap.TreemapSeriesLevel;
import org.icepear.echarts.origin.chart.treemap.TreemapSeriesLevelOption;
import org.icepear.echarts.render.Engine;

import java.util.*;

public class Echarts {

    public String createSampleChart() {
        // All methods in EChart Java supports method chaining
        Bar bar = new Bar()
                .setLegend()
                .setTooltip("item")
                .addXAxis(new String[]{"Matcha Latte", "Milk Tea", "Cheese Cocoa", "Walnut Brownie"})
                .addYAxis()
                .addSeries("2015", new Number[]{43.3, 83.1, 86.4, 72.4})
                .addSeries("2016", new Number[]{85.8, 73.4, 65.2, 53.9})
                .addSeries("2017", new Number[]{93.7, 55.1, 82.5, 39.1});
        Engine engine = new Engine();

        return engine.renderHtml(bar);
    }

    public String createSampleChart2() {
        Random random = new Random();
        List<PurchaseOrder> purchaseOrders = new ArrayList<>();
        for(int i = 0; i < random.nextInt(1, 25) ; i++) {
            purchaseOrders.add(new PurchaseOrder());
        }

        Treemap treemap = new Treemap();
        var series = treemap.createSeries();

        treemap.setLegend()
                .setTooltip("item");
        SimpleData data = new SimpleData();
        for(PurchaseOrder po : purchaseOrders) {
            data.addEntry(po.getPurchaseOrderNumber(), 1);
            SimpleData subData = new SimpleData();
            for(var pol : po.getPurchaseOrderLines()) {
                subData.addEntry(pol.getPosition(), pol.getQuantity());
            }
            data.setSubDataForEntry(po.getPurchaseOrderNumber(), "children", subData);
        }

        series.setData(data.buildData());
        TreemapSeriesLabel treemapSeriesLabel = new TreemapSeriesLabel();

        treemapSeriesLabel.setShow(true).setHeight(30);
        series.setUpperLabel(treemapSeriesLabel);

        TreemapSeriesLevelOption levelOption = new TreemapSeriesLevel();
        TreemapSeriesItemStyle itemStyle = new TreemapSeriesItemStyle();
        itemStyle.setBorderColor("#fadfad");
        itemStyle.setBorderWidth(1);
        itemStyle.setGapWidth(1);
        levelOption.setItemStyle(itemStyle);


        series.setLevels(new TreemapSeriesLevelOption[]{levelOption, levelOption, levelOption});
        treemap.addSeries(series);
        Engine engine = new Engine();
        return engine.renderHtml(treemap);
    }

}
