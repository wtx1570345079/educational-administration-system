<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除课程</title>
</head>
<body style="text-align: center">
<script type="text/javascript">
$(function(){	
	
   $("#btnDeleteCourse").bind("click",function(){
	   $('#delete_course').form('submit', {    
		    url:'deleteCourse',    
		    onSubmit: function(){    
		        // do some check    
		        // return false to prevent submit;    
		    },    
		    success:function(data){    
		    	// 成功   两次删除操作   删除课程表的基本信息  和关联表
			       if(data==2){
			    	    //弹出框关闭
			    	  $("#newdialog").dialog("close");
			    	  $.messager.alert('系统消息','删除成功！'); 
			    	    // 重新刷新表格
			    	  $("#course_list").datagrid("reload");
			       }else{
			    	   $.messager.alert('系统消息','删除失败，请重新删除！');   
			       }
		    }    
		});  
	   
   })
})
</script>
<form id="delete_course" action="" method="post">
<!-- 课程id -->
<input type="hidden" name="id">
<table border="1" style="margin: 0 auto;text-align: center;"> 
<tr><td colspan="2">
<a id="btnDeleteCourse" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">添加</a>  
</td></tr>
</table>
</form>
</body>
</html>