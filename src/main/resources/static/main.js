/* global requirejs */
const currentVersion = new Date().getTime()

requirejs.config({
  urlArgs: 'v=' + currentVersion,
  baseUrl: '/lib',
  paths: {
    'echarts': '//cdn.bootcss.com/echarts/3.6.2/echarts.min'
  }
})

requirejs(['../js/app'])
