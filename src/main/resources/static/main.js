requirejs.config({
	baseUrl : ctx + "/lib",
	paths : {
		"echarts" : "echarts"
	}
})
requirejs(['../js/app'])
