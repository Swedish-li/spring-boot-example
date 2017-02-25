<#assign ctx = request.contextPath />
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="Swedish-li">
	<title>spring boot example</title>
	<link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="page-header">
			<h1>Echarts Example</h1>
			<h3>时间：${currentDatetime?datetime}</h3>
		</div>
		<div>
			
		</div>
		<footer class="footer">
			<div class="container">
				<p class="text-muted">&copy;${currentDatetime?string("yyyy")} Swedish-li</p>
			</div>
		</footer>
	</div>
	
	<script>
		const ctx = '${ctx}'
	</script>
	<script src="http://apps.bdimg.com/libs/require.js/2.1.9/require.min.js" data-main="${ctx}/js/app"></script>
		
</body>
</html>