<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加课程</title>
</head>
<body style="text-align: center">
<script type="text/javascript">
$(function(){	
	
   $("#btnAddCourse").bind("click",function(){
	   
	   
	   $('#add_course').form('submit', {    
		    url:'addCourse',
		    
		    onSubmit: function(){    
		        // do some check    
		        // return false to prevent submit;   
		        // 获取当前输入框课程的值
		     console.log($("#coursename").val());
		     var coursename=$("#coursename").val();
		     // 获取课程列表的name  判断新添加的课程名是否相同
		     console.log($("#course_list").datagrid("getData").rows);
		     
		     for(var i=0;i<$("#course_list").datagrid("getData").total;i++){
		    	 console.log($("#course_list").datagrid("getData").rows[i].name);
		    	 if($("#course_list").datagrid("getData").rows[i].name==coursename){
				    	$.messager.alert('系统消息','课程已存在，不能重复添加');   
				        return false;
				  } 
		     }
		     if(coursename==''){
		    	 $.messager.alert('系统消息','课程不能为空，添加失败');   
			     return false;
		     }
		     
		 /*   var flag=$.ajax({
		    	//查询课程
				url:'selAllCourse',
				dataType:'json',
				error:function(){
				//alert("请求失败");
				},
				success:function(data){
				//alert("请求成功"+data.length);
				for(var i=0;i<data.length;i++){
					console.log(data[i].name);
					if(data[i].name==text){
					$.messager.alert("系统信息","课程添加重复！");
					// 终止提交
					return false;
					}
				}
				},
				type:'POST'}); */
		    
		    },    
		    success:function(data){    
		    	// 成功   两次添加操作   添加关联表和老师基本表
			       if(data==1){
			    	    //弹出框关闭
			    	  $("#newdialog").dialog("close");
			    	  $.messager.alert('系统消息','添加成功！'); 
			    	  // 重新载入当前页面数据  
			    	  $("#course_list").datagrid("reload");
			       }else{
			    	   $.messager.alert('系统消息','添加失败，请重新添加！');   
			       }
		    }    
		});  
	   
   })
})
</script>
<form id="add_course" action="" method="post">
<table border="1" style="margin: 0 auto;text-align: center;"> 
<tr><td>课程：</td>
<td><input  id="coursename" type="text" name="name"></td>
</tr>
<tr><td colspan="2">
<a id="btnAddCourse" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">添加</a>  
</td></tr>
</table>
</form>
</body>
</html>