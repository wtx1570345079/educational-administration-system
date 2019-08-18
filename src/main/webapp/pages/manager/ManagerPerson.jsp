<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师个人信息</title>
<style type="text/css">
fieldset {
    
	margin: 0 auto;
}
</style>
</head>
<body>

<script type="text/javascript">
// 个人信息属性表格 
</script>
<fieldset>
<legend><h1>管理员信息</h1></legend>
<table id="managerPerson" style="width:300px;font-size: 19px;font-family: 幼圆">
<tr >
<td style="width: 300px;margin-top:50px;" align="right">管理员编号:</td>
<td ><input  type="text" name="id" value=${user.id} ></td>
</tr>
<tr>
<td style="width: 300px;margin-top: 50px;" align="right">用户名:</td>
<td><input  type="text" name="username" value=${user.username} ></td>
</tr>
<tr style="width: 300px;margin-top: 50px;">
<td style="width: 300px;" align="right">密码:</td>
<td><input  type="text" name="password" value=${user.password} ></td>
</tr>
<tr>
<td style="width: 300px;margin-top: 30px;" align="right">管理员姓名:</td>
<td><input  type="text" name="name" value=${user.name} ></td>
</tr>
</table>  

</fieldset>

</body>
</html>