<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="text-align: center">
<script type="text/javascript">
$(function(){	
	
   $("#btnUpdateScore").bind("click",function(){
	   
	   $('#edit_score').form('submit', {    
		    url:'updateScore',    
		    onSubmit: function(){    
		        // do some check    
		        // return false to prevent submit; 
		        //  非空验证   0~100
		    	  var score=$("#score").val();
			      if(score==""){
			         $.messager.alert("系统消息","录入成绩不能为空！");
			         return false;
			    }
			      // 分数是在0~100范围内
			      if(parseInt(score)<0||parseInt(score)>100){
			    	$.messager.alert("系统消息","录入分数必须在0~100范围内！");
				    return false; 
			  }
			        
		        
		    },    
		    success:function(data){    
		    	// 成功  两次修改操作
			       if(data==1){
			    	//弹出框关闭
			    	
			    	$("#newdialog").dialog("close");
				    $.messager.alert('系统消息','修改成功！'); 
				    // 重新刷新表格
				    
				    $("#score_list").datagrid("reload");
				    // 加载和显示第一页的所有行
				   /*  $('#teacher_list').datagrid('load',{
				    		code: '01',
				    		name: 'name01'
				     }); */
			       }else{
			    	   $.messager.alert('系统消息','修改失败，请重新修改！');   
			       }
		    }    
		});  
	   
   })
   //获取到本身为修改的课程的id
   // var cid=$("#teacher_list").datagrid("getSelected").course.id;
    
    		  
})	
</script>
<form id="edit_score" action="" method="post">
<input type="hidden" name="id">
<table border="1" style="margin: 0 auto;text-align: center;"> 
<tr>
<td>成绩:</td>
<td><input type="text" id="score" name="score" ></td>
</tr>
<tr><td colspan="2">
<a id="btnUpdateScore" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">修改</a>  
</td></tr>
</table>
</form>
</body>
</html>