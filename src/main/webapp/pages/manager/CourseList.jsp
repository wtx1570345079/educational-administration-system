<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>课程</title>
</head>
<body>
<script type="text/javascript">
$(function(){
	$('#course_list').datagrid({    
	     // 转发至
	    url:'courseList',    
	    columns:[[    
	        {field:'id',title:'编号',width:100},    
	        {field:'name',title:'课程名称',width:100},
	      /*   {field:'opertae',title:'操作',width:100,formatter: function(value,row,index){
					return "<a href=''>操作</a>";
			  }
				}  */
	    ]],   
	   pagination:true,
	   singleSelect:true,
	   // 通过数组定义工具栏
	  toolbar: [{
			iconCls: 'icon-add',
			text:'添加',
			handler: function(){
	        // 添加窗口
				$("#newdialog").dialog({    
				    title: '添加窗口',    
				    width: 400,    
				    height: 200,    
				    closed: false,    
				    cache: false,    
				    href: 'Course_add.jsp',    
				    modal: true,
		});      
			}
		}/* ,'-',{
			iconCls:'icon-remove',
			text:'删除',
			handler: function(){
				 if($("#course_list").datagrid("getSelections").length==1){
					 $("#newdialog").dialog({    
						    title: '删除窗口',    
						    width: 400,    
						    height: 200,    
						    closed: false,    
						    cache: false,    
						    href: 'Course_delete.jsp',    
						    modal: true,
							onLoad:function(){
				$("#delete_course :hidden:eq(0)").val($("#course_list").datagrid("getSelected").id);
					}
				});      
					 }else{
					$.messager.alert('系统消息','请选择一行数据进行操作');  
			 }
			}
		} */]
	});  
})
</script>
<!--从数据库中  动态获取数据 所以要结合 js+html方式    这个界面是被引进主界面 ，所以不需要引入js文件  -->
<table id="course_list"></table> 
<!-- 弹出对话框 -->
<div id="newdialog"></div>  
</body>
</html>