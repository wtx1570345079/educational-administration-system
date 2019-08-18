<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑老师</title>
</head>
<body style="text-align: center">
<script type="text/javascript">
$(function(){	
	
   $("#btnUpdateTeacher").bind("click",function(){
	   
	   $('#edit_teacher').form('submit', {    
		    url:'updateTeacher',    
		    onSubmit: function(){    
		        // do some check    
		        // return false to prevent submit;   
		        // 修改教师  非空验证
		        var number=$("#number").val();
		        var name=$("#name").val();
		        var sex=$("#sex").val();
		        var phone=$("#phone").val();
		        // 这里的值空不了，所=所以不需要获取隐藏数据框的值
		        var course=$("#course").val();
		        if(number==""||name==""||sex==""||phone==""||course==""){
		        	$.messager.alert("系统消息","信息填写不完整！");
		        	 return false;
		        }
		        
		    },    
		    success:function(data){    
		    	// 成功  两次修改操作
			       if(data!=0){
			    	//弹出框关闭
			    	$("#teadialog").dialog("close");
				    $.messager.alert('系统消息','修改成功！'); 
				    // 重新刷新表格
				    
				    $("#teacher_list").datagrid("reload");
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
   
   //设置课程为自身所教的id
   $("#course").val(
   $("#teacher_list").datagrid("getSelected").course.id
   );
   
   $("#course").bind('click',function(){
	   $('#course').combobox({    
		    url:'asignedCourseList',    
		    //基础数据值名称绑定到该下拉列表框
		    valueField:'id',    
		    //基础数据字段名称绑定到该下拉列表框。
		    textField:'name'
		});   
   });
   
    
    		  
})	
</script>
<form id="edit_teacher" action="" method="post">
<input type="hidden" name="id">
<input type="hidden" name="oldcid">
<table border="1" style="margin: 0 auto;text-align: center;"> 
<tr><td>工号：</td><td><input id="number" type="text" name="number" readonly="readonly"></td></tr>
<tr><td>姓名：</td><td><input id="name" type="text" name="name"></td></tr>
<tr><td>性别：</td><td><input id="sex" type="text" name="sex"></td></tr>
<tr><td>电话：</td><td><input id="phone" type="text" name="phone"></td></tr>
<tr><td>安排课程：</td>
<td>
<input type="text" id="course" name="courseid" >  
</td>
</tr>
<tr><td colspan="2">
<a id="btnUpdateTeacher" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">修改</a>  
</td></tr>
</table>
</form>
</body>
</html>