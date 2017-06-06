package com.lrs.springboot.service;

import org.springframework.stereotype.Service;

import com.github.abel533.echarts.Label;
import com.github.abel533.echarts.LabelLine;
import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.LineType;
import com.github.abel533.echarts.code.Magic;
import com.github.abel533.echarts.code.MarkType;
import com.github.abel533.echarts.code.Position;
import com.github.abel533.echarts.code.Sort;
import com.github.abel533.echarts.code.Tool;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.data.Data;
import com.github.abel533.echarts.data.PointData;
import com.github.abel533.echarts.feature.MagicType;
import com.github.abel533.echarts.series.Bar;
import com.github.abel533.echarts.series.Funnel;
import com.github.abel533.echarts.style.LineStyle;
import com.github.abel533.echarts.style.TextStyle;

@Service
public class EchartsExampleService {

	public Option getBar1() {
		Option option = new Option();
		// 标题文档，副标题文档
		option.title().text("某地区蒸发量和降水量").subtext("纯属虚构");
		// 标签提示触发，轴线
		option.tooltip().trigger(Trigger.axis);
		// 图例
		option.legend("降水量", "蒸发量");
		// 工具箱：数据视图，还原，作为图片保存
		option.toolbox().show(true).feature(Tool.mark, Tool.dataView,
				// 折线图，柱状图
				new MagicType(Magic.line, Magic.bar).show(true), Tool.restore, Tool.saveAsImage);
		option.calculable(true);
		// 设置x轴:月份，y轴：数值
		option.xAxis(
				new CategoryAxis().data("1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"));

		option.yAxis(new ValueAxis());

		// 降水量
		Bar bar1 = new Bar("降水量");
		bar1.data(2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3);
		bar1.markPoint().data(new PointData("年最高", 182.2).xAxis(7).yAxis(183).symbolSize(18),
				new PointData("年最低", 2.3).xAxis(11).yAxis(3));
		bar1.markLine().data(new PointData().type(MarkType.average).name("平均值"));
		// 蒸发量
		Bar bar2 = new Bar("蒸发量");
		bar2.data(2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3);
		// 统计数据添加
		bar2.markPoint().data(new PointData().type(MarkType.max).name("最大值"),
				new PointData().type(MarkType.min).name("最小值"));
		bar2.markLine().data(new PointData().type(MarkType.average).name("平均值"));
		// series：系列列表，每个系列通过type决定自己的类型
		option.series(bar1, bar2);
		return option;
	}

	// 全国主要城市空气质量
	public Option getFunnel() {
		Option option = new Option();
		option.title().text("漏斗图").subtext("纯属虚构");
		option.tooltip().trigger(Trigger.item).formatter("{a} <br/>{b} : {c}%");
		option.toolbox().show(true).feature(Tool.mark, Tool.dataView, Tool.restore, Tool.saveAsImage);
		option.legend("展现", "点击", "访问", "咨询", "订单");
		option.calculable(true);

		Funnel funnel = new Funnel("漏斗图");
		funnel.x("10%").y(60).width("80%").min(0).max(100).minSize("0%").maxSize("100%").sort(Sort.descending).gap(10);
		funnel.itemStyle().normal().borderColor("#fff").borderWidth(1).label(new Label().show(true).position(
				Position.inside)).labelLine(new LabelLine().show(false).length(10).lineStyle(new LineStyle().width(1)
						.type(LineType.solid)));
		funnel.itemStyle().emphasis().borderColor("red").borderWidth(5).label(new Label().show(true).formatter(
				"{b}:{c}%").textStyle(new TextStyle().fontSize(20))).labelLine(new LabelLine().show(true));

		funnel.data(new Data().value(60).name("访问"),
				new Data().value(40).name("咨询"),
				new Data().value(20).name("订单"),
				new Data().value(80).name("点击"),
				new Data().value(100).name("展现"));

		option.series(funnel);
		return option;
	}

}
