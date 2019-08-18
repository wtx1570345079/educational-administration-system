<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除学生界面</title>
</head>
<body>
<script type="text/javascript">
$(function(){
	// 点击事件提交函数
		
   $("#btnDeleteStudent").bind("click",function(){
	   $('#delete_student').form('submit', {    
		    url:'deleteStudent',    
		    onSubmit: function(){    
		        // do some check    
		        // return false to prevent submit;    
		    },    
		    success:function(data){    
		    	// 成功
		    	console.log(data);
			    if(data==1){
			    	    //弹出框关闭
			    	  $("#newdialog").dialog("close");
			    	  $.messager.alert('系统消息','删除成功！'); 
			    	    // 重新刷新表格
			    	  $("#student_list").datagrid("reload");
			       }else{
			    	   $.messager.alert('系统消息','删除失败，请重新删除！');   
			       }
		    }    
		});  
	   
   })

})
</script>
<div style="margin: 0 auto;">
<form id="delete_student" action="" method="post">
<input type="hidden" name="id">
<p style="margin: 0 auto;">您确定要删除吗！</p>
<br>
<a id="btnDeleteStudent" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">删除</a>  
</form>

</div>


</body>
</html>