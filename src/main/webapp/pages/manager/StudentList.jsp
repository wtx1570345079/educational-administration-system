<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生统计</title>
</head>
<body>
<script type="text/javascript">
$(function(){
	$('#student_list').datagrid({    
	     // 转发至
	    url:'studentList',    
	    columns:[[    
	        {field:'id',title:'编号',width:100},    
	        {field:'number',title:'学号',width:100},    
	        {field:'name',title:'学生姓名',width:100},
	        {field:'sex',title:'性别',width:100},    
	        {field:'phone',title:'电话',width:100},      
	      /*   {field:'opertae',title:'操作',width:100,formatter: function(value,row,index){
					return "<a href=''>操作</a>";
			  }
				}  */
	    ]],   
	   pagination:true,
	   singleSelect:true,
	   // 通过数组定义工具栏
	   toolbar: [{
			iconCls:'icon-edit',
			text:'修改',
			handler: function(){
		    // 加上判断， 只有选中一行数据的时候才会弹框   getSelections:返回所有被选中的行
		    /* alert($("#student_list").datagrid("getSelections").length); */
		    if($("#student_list").datagrid("getSelections").length==1){
		   //   点击修改的时候弹出对话框
				$('#newdialog').dialog({    
				    title:'修改窗口',    
				    width:400,    
				    height:200,    
				    closed:false,    
				    cache:false,
				    // 相对路径
				    href:'Student_edit.jsp',    
				    modal:true,
				    // onload:加载远程数据时被触发
				    onLoad:function(){
				    	// 先获取到学生编辑界面的input标签，在设置元素的内容为选中对象的属性 field,
				    	// 将选中的一行的数据设置为表单标签input的value值
				   $("#edit_student :text:eq(0)").val($("#student_list").datagrid("getSelected").number);
				   $("#edit_student :text:eq(1)").val($("#student_list").datagrid("getSelected").name);
				   $("#edit_student :text:eq(2)").val($("#student_list").datagrid("getSelected").sex);
				   $("#edit_student :text:eq(3)").val($("#student_list").datagrid("getSelected").phone);
				   $("#edit_student :hidden:eq(0)").val($("#student_list").datagrid("getSelected").id);
				   }
				});   
		    }else{
		    	$.messager.alert('系统消息','请选择一行数据进行操作');  
		    }   }
		},'-',{
			iconCls: 'icon-add',
			text:'添加',
			handler: function(){
	        // 添加窗口
				$("#newdialog").dialog({    
				    title:'添加窗口',    
				    width: 400,    
				    height: 200,    
				    closed: false,    
				    cache: false,    
				    href: 'Student_add.jsp',    
				    modal: true,
		});      
			}
		},'-',{
			iconCls:'icon-remove',
			text:'删除',
			handler: function(){
				 if($("#student_list").datagrid("getSelections").length==1){
					 $("#newdialog").dialog({    
						    title: '删除窗口',    
						    width: 400,    
						    height: 200,    
						    closed: false,    
						    cache: false,    
						    href: 'Student_delete.jsp',    
						    modal: true,
							onLoad:function(){
				$("#delete_student :input:eq(0)").val($("#student_list").datagrid("getSelected").id);
					}
				});      
					 }else{
					$.messager.alert('系统消息','请选择一行数据进行操作');  
			 }  
			}
		}]
	});  
})
</script>
<!--从数据库中  动态获取数据 所以要结合 js+html方式    这个界面是被引进主界面 ，所以不需要引入js文件  -->
<table id="student_list"></table> 
<!-- 弹出对话框 -->
<div id="newdialog"></div>  
</body>
</html>