define(function(require) {
	const echarts = require('echarts')
	var chart1 = echarts.init(document.getElementById('bar1'));
	fetch("/echarts/bar1").then(function(res) {
		res.json().then(function(json) {
			chart1.setOption(json)
		})
	})
})