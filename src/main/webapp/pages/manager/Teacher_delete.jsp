<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除教师</title>
</head>
<body style="text-align: center">
<script type="text/javascript">
$(function(){	
	
   $("#btnDeleteTeacher").bind("click",function(){
	   $('#delete_teacher').form('submit', {    
		    url:'deleteTeacher',    
		    onSubmit: function(){    
		        // do some check    
		        // return false to prevent submit;    
		    },
		    success:function(data){    
		      // 成功  两次操作或者一次
			       if(data!=0){
			    	    //弹出框关闭
			    	  $("#teadialog").dialog("close");
			    	  $.messager.alert('系统消息','删除成功！'); 
			    	    // 重新刷新表格
			    	  $("#teacher_list").datagrid("reload");
			       }else{
			    	   $.messager.alert('系统消息','删除失败，请重新删除！');  
			       }
		    }    
		});  
   })
})	

</script>
<form id="delete_teacher" action="" method="post">
<input type="hidden" name="id">
<span style="margin: 0 auto;">您确定要删除吗?</span>
<table style="margin: 0 auto;text-align: center;"> 
<tr><td colspan="2">
<a id="btnDeleteTeacher" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">删除</a>  
</td></tr>
</table>
</form>
</body>
</html>