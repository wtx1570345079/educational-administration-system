<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加成绩</title>
</head>
<body style="text-align: center">
<script type="text/javascript">
$(function(){	
	
   $("#btnAddScore").bind("click",function(){
	   $('#add_score').form('submit', {    
		    url:'addStudnetCourseScore',    
		    onSubmit: function(){    
		      // do some check    
		      // return false to prevent submit;  
		      // 非空验证    成绩0~100
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
		    	// 成功   两次添加操作   添加关联表和老师基本表
			       if(data==1){
			    	    //弹出框关闭
			    	  $("#newdialog").dialog("close");
			    	  $.messager.alert('系统消息','添加成功！'); 
			    	    // 重新刷新表格
			    	  $("#stuscore_list").datagrid("reload");
			       }else{
			    	   $.messager.alert('系统消息','添加失败，请重新添加！');   
			       }
		    }    
		});  
	   
   })
   
   //下拉列表框   只显示未安排的课程
  /*  $("#course").bind('click',function(){
	   $('#course').combobox({    
		    url:'asignedCourseList',    
		    //基础数据值名称绑定到该下拉列表框
		    valueField:'id',    
		    //基础数据字段名称绑定到该下拉列表框。
		    textField:'name',
		});   
   }); */
   
   /* console.log($("#teacher_list").datagrid("getSelected").course.id);
   
   $("#course").val(
   $("#teacher_list").datagrid("getSelected").course.id
   ); */
  
})
</script>
<form id="add_score" action="" method="post">
<input type="hidden" name="stuid">
<table border="1" style="margin: 0 auto;text-align: center;"> 
<tr><td>成绩：</td><td><input  id="score" type="text" name="score"></td></tr>
<tr><td colspan="2">
<a id="btnAddScore" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">添加</a>  
</td></tr>
</table>
</form>
</body>
</html>