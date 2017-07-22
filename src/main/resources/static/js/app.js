/* global define fetch */

define(function (require) {
  const echarts = require('echarts')

  console.info('Echarts ' + echarts.version)

  var chart1 = echarts.init(document.getElementById('bar1'))

  fetch('/echarts/bar1').then(function (res) {
    res.json().then(function (json) {
      chart1.setOption(json)
    })
  })

  var chart2 = echarts.init(document.getElementById('bar2'))

  fetch('/echarts/funnel').then(function (res) {
    res.json().then(function (json) {
      chart2.setOption(json)
    })
  })
})
