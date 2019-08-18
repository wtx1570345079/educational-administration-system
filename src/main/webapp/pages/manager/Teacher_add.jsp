<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加教师</title>
</head>
<body style="text-align: center">
<script type="text/javascript">
$(function(){	
	
   $("#btnAddTeacher").bind("click",function(){
	   $('#add_teacher').form('submit', {    
		    url:'addTeacher',    
		    onSubmit: function(){    
		        // do some check    
		        // return false to prevent submit;   
		        // 工号    重复验证  非空验证
		        var number=$("#number").val();
		        var name=$("#name").val();
		        var sex=$("#sex").val();
		        var phone=$("#phone").val();
		        // 获取下拉框的值
		        // var course=$(".combo-value").val();
		        console.log(number+"--"+name+"--"+sex+"--"+phone+"--"+course);
		        if(number==""||name==""||sex==""||phone==""){
		        $.messager.alert("系统消息","教师信息填写不完整！");
		        return false;
		        }
		        
		        // 工号重复判断
		       for(var i=0;i<$("#teacher_list").datagrid("getData").total;i++){
		        	if($("#teacher_list").datagrid("getData").rows[i].number==number){
		        		$.messager.alert("系统消息","工号不能重复！");
		        		return false;
		        	}
		        }
		        
		        $("#teacher_list").datagrid("getData")
		        
		    },    
		    success:function(data){    
		    	// 成功   两次添加操作   添加关联表和老师基本表
			       if(data!=0){
			    	    //弹出框关闭
			    	  $("#teadialog").dialog("close");
			    	  $.messager.alert('系统消息','添加成功！'); 
			    	    //  重新载入当前页面数据  
			    	  $("#teacher_list").datagrid("reload");
			       }else{
			    	   $.messager.alert('系统消息','添加失败，请重新添加！');   
			       }
		    }    
		});  
	   
   })
   
   //下拉列表框   只显示未安排的课程
   $("#course").bind('click',function(){
	   $('#course').combobox({    
		    url:'asignedCourseList',    
		    //基础数据值名称绑定到该下拉列表框
		    valueField:'id',    
		    //基础数据字段名称绑定到该下拉列表框。
		    textField:'name',
		});   
   });
   
})
</script>
<form id="add_teacher" action="" method="post">
<table border="1" style="margin: 0 auto;text-align: center;"> 
<tr><td>工号：</td><td><input id="number" type="text" name="number"></td></tr>
<tr><td>姓名：</td><td><input id="name" type="text" name="name"></td></tr>
<tr><td>性别：</td><td><input id="sex" type="text" name="sex"></td></tr>
<tr><td>电话：</td><td><input  id="phone" type="text" name="phone"></td></tr>
<tr><td>安排课程：</td>
<td>
<input type="text" id="course" name="courseid" value="0">  
</td>
</tr>
<tr><td colspan="2">
<a id="btnAddTeacher" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">添加</a>  
</td></tr>
</table>
</form>
</body>
</html>