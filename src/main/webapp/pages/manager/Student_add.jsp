<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加学生</title>
</head>
<body>
<script type="text/javascript">
$(function(){
	$("#btnAddStudent").bind("click",function(){
		
		$('#add_Student').form('submit', {    
		    url:'addStudent',    
		    onSubmit: function(){    
		        // do some check    
		        // return false to prevent submit;    
		       // 学号不能重复       学号   姓名  性别   电话 非空验证
		       var number=$("#number").val();
		       var name=$("#name").val();
		       var sex=$("#sex").val();
		       var phone=$("#phone").val();
		       
		       if(number==""||name==""||sex==""||phone==""){
		    	   $.messager.alert("系统消息","学生信息填写不完整");
		    	   return false;
		       }
		       
		   // 学号不能重复   rows  total
		for(var i=0;i<$("#student_list").datagrid("getData").total;i++){
		    
		   console.log($("#student_list").datagrid("getData").rows[i].number);
		    if($("#student_list").datagrid("getData").rows[i].number==number){
		    	$.messager.alert('系统消息','学号不能重复，请重新添加！');   
		     return false;
		     }
		 }
		       
		    },    
		    success:function(data){    
		    	
		    	 if(data==1){
			    	    //弹出框关闭
			    	  $("#newdialog").dialog("close");
			    	  $.messager.alert('系统消息','添加成功！'); 
			    	    // 重新刷新表格
			    	  $("#student_list").datagrid("reload");
			       }else{
			    	   $.messager.alert('系统消息','添加失败，信息有误，请重新添加！');   
			       }
		    }    
		});  

	})
	
})

</script>
<form action="" method="post" id="add_Student">
<table border="1">
<tr>
<td>学号:</td>
<td><input  id="number" type="text" name="number"></td>
</tr>

<tr>
<td>姓名:</td>
<td><input id="name" type="text" name="name"></td>
</tr>

<tr>
<td>性别:</td>
<td><input id="sex" type="text" name="sex"></td>
</tr>
<tr>

<tr>
<td>电话:</td>
<td><input id="phone" type="text" name="phone"></td>
</tr>

<tr>
<td colspan="2">

<a id="btnAddStudent" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">添加</a></td>
</tr>
</table>  

</form>

</body>
</html>