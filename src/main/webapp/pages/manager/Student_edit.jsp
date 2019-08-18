<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生编辑页面</title>
</head>
<body style="text-align: center">
<script type="text/javascript">
$(function(){	
	
   $("#btnUpdateStudent").bind("click",function(){
	   $('#edit_student').form('submit', {    
		    url:'updateStudent',    
		    onSubmit: function(){    
		        // do some check    
		        // return false to prevent submit;   
		        // 修改学生非空验证  
		        var number=$("#number").val();
		        var name=$("#name").val();
		        var sex=$("#sex").val();
		        var phone=$("#phone").val();
		        if(number==""||name==""||sex==""||phone==""){
		        	$.messager.alert("系统消息","信息填写不完整");
		        	return false;
		        }
		        
		    },    
		    success:function(data){    
		    	// 成功
			       if(data==1){
			    	    //弹出框关闭
			    	  $("#newdialog").dialog("close");
			    	  $.messager.alert('系统消息','修改成功！'); 
			    	    // 重新刷新表格
			    	  $("#student_list").datagrid("reload");
			       }else{
			    	   $.messager.alert('系统消息','修改失败，请重新修改！');   
			       }
		    }    
		});  
	   
   })
  
})	
</script>
<form id="edit_student" action="" method="post">
<input type="hidden" name="id">
<table border="1" style="margin: 0 auto;text-align: center;"> 
<tr><td>学号：</td><td><input type="text" id="number" name="number" readonly="readonly"></td></tr>
<tr><td>姓名：</td><td><input type="text" id="name" name="name"></td></tr>
<tr><td>性别：</td><td><input type="text"  id="sex" name="sex"></td></tr>
<tr><td>电话</td><td><input type="text" id="phone" name="phone"></td></tr>
<tr><td colspan="2">
<a id="btnUpdateStudent" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">修改</a>  
</td></tr>
</table>
</form>
</body>
</html>