package com.lrs.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.Magic;
import com.github.abel533.echarts.code.MarkType;
import com.github.abel533.echarts.code.Tool;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.data.PointData;
import com.github.abel533.echarts.feature.MagicType;
import com.github.abel533.echarts.series.Bar;

@RestController
@RequestMapping("echarts")
public class EchartsExampleController {
	@RequestMapping("bar1")
	public ResponseEntity<Option> bar1() {
		Option option = new Option();
		// 标题，副标题
		option.title().text("某地区蒸发量和降水量").subtext("纯属虚构");
		// 标签提示触发，轴线
		option.tooltip().trigger(Trigger.axis);
		// 图例
		option.legend("蒸发量", "降水量");
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

		// 添加数据
		option.series(bar1);
		return ResponseEntity.ok(option);
	}
}
