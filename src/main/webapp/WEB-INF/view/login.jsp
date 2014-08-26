<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
	<title>登录页</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>

<body>
	<h1>登录页</h1>
	<form id="loginForm" action="/login" method="post">
		<div class="control-group">
			<label for="username" class="control-label">名称:</label>
			<div class="controls">
				<input type="text" id="username" name="username" value="" class="input-medium required"/>
			</div>
		</div>
		<div class="control-group">
			<label for="password" class="control-label">密码:</label>
			<div class="controls">
				<input type="password" id="password" name="password" class="input-medium required"/>
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<label class="checkbox inline" for="rememberMe"> <input type="checkbox" id="rememberMe" name="rememberMe"/> 记住我</label>
				<input id="submit_btn" class="btn" type="submit" value="登录"/>
				<p class="help-block">(管理员：<b>admin/admin</b>, 普通用户你好：<b>user/user</b>)</p>
			</div>
		</div>
	</form>
	
	<script>
		$(document).ready(function() {
			$("#loginForm").validate();
		});
	</script>
</body>
</html>
