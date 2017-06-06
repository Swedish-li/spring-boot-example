const currentVersion = new Date().getTime()

requirejs.config({
	urlArgs: "v=" + currentVersion,
	baseUrl : "/lib",
	paths : {
		"echarts" : "echarts"
	}
})

requirejs(['../js/app'])
