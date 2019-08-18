<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师个人信息</title>
</head>
<body>
<script type="text/javascript">
$(function(){
	$.ajax({
		url:'/easyui/selTeaUser',
		data:{"number":'${user.username}',"name":'${user.name}'},
		dataType:'json',
		error:function(){
			alert("请求失败")
			},
		success:function(data){
		  $("#number").val(data.number);
		  $("#name").val(data.name);
		  $("#sex").val(data.sex);
		  $("#phone").val(data.phone);
		  $("#course").val(data.course.name);
		  
		},
		type:'POST'
		}); 
})

</script>
<fieldset>
<legend><h1>教师信息</h1></legend>
<table id="TeaPerson" style="width:300px;font-size: 19px;font-family: 幼圆">
<tr>
<td style="width: 300px;" align="right">工号:</td>
<td ><input  type="text" id="number" name="number" ></td>
</tr>
<tr>
<td style="width: 300px;" align="right">教师姓名:</td>
<td><input  type="text" id="name" name="name"  ></td>
</tr>
<tr>
<td style="width: 300px;" align="right">性别:</td>
<td><input  type="text" id="sex" name="sex" ></td>
</tr>
<tr>
<td style="width: 300px;" align="right">电话:</td>
<td><input  type="text" id="phone" name="phone" ></td>
</tr>

<tr>
<td style="width: 300px;" align="right">课程:</td>
<td><input  type="text" id="course" name="course" ></td>
</tr>
</table>  

</fieldset>


</body>
</html>