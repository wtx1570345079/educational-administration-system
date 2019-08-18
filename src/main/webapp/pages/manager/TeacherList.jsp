<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师信息界面</title>
</head>
<body>
<script type="text/javascript">
$(function(){
	
	$('#teacher_list').datagrid({    
	     // 转发至
	    url:'teacherList',    
	    columns:[[    
	        {field:'id',title:'编号',width:100},    
	        {field:'number',title:'工号',width:100},  
	        {field:'name',title:'教师姓名',width:100},  
	        {field:'sex',title:'性别',width:100},  
	        {field:'phone',title:'电话',width:100}, 
	        // value：字段值。 rowData：行记录数据。rowIndex: 行索引。
	        {field:'cname',title:'课程',width:100,formatter:function(value,row,index){
				return row.course.name;
				
			}
	        },
	        // value：字段值。 rowData：行记录数据。rowIndex: 行索引。
	        {field:'oldcid',title:'课程编号',width:100,formatter:function(value,row,index){
	        	if( row.course.id==0){
	        		return "无";
	        	}
				return row.course.id;
			}
	        },
	     /*    {field:'opertae',title:'操作',width:100,formatter: function(value,row,index){
					return "<a href=''>课程</a>";
			  }
				}  */
	    ]],   
	   pagination:true,
	   singleSelect:true,
	   // 通过数组定义工具栏
	   toolbar: [{
			iconCls: 'icon-edit',
			text:'修改',
			handler: function(){
		    // 加上判断， 只有选中一行数据的时候才会弹框   getSelections:返回所有被选中的行
		    /* alert($("#student_list").datagrid("getSelections").length); */
		    if($("#teacher_list").datagrid("getSelections").length==1){
		   //   点击修改的时候弹出对话框
				$('#teadialog').dialog({    
				    title:'修改窗口',    
				    width:400,    
				    height:200,    
				    closed:false,    
				    cache:false,
				    // 相对路径
				    href:'Teacher_edit.jsp',    
				    modal:true,
				    // onload:加载远程数据时被触发
				    onLoad:function(){
				    	// 先获取到学生编辑界面的input标签，在设置元素的内容为选中对象的属性 field,
				    	// 将选中的一行的数据设置为表单标签input的value值
				   $("#edit_teacher :text:eq(0)").val($("#teacher_list").datagrid("getSelected").number);
				   $("#edit_teacher :text:eq(1)").val($("#teacher_list").datagrid("getSelected").name);
				   $("#edit_teacher :text:eq(2)").val($("#teacher_list").datagrid("getSelected").sex);
				   $("#edit_teacher :text:eq(3)").val($("#teacher_list").datagrid("getSelected").phone);
				   $("#edit_teacher :text:eq(4)").val($("#teacher_list").datagrid("getSelected").course.id);
				   $("#edit_teacher :hidden:eq(0)").val($("#teacher_list").datagrid("getSelected").id);
				   var oldcid=$("#teacher_list").datagrid("getSelected").course.id;
				   console.log("oldcid："+oldcid);
				   var cname=$("#teacher_list").datagrid("getSelected").course.name;
				   console.log("cname:"+cname);
				   $("#edit_teacher :hidden:eq(1)").val($("#teacher_list").datagrid("getSelected").course.id);
				    }
				});   
		    }else{
		    	$.messager.alert('系统消息','请选择一行数据进行操作');  
		    }   }
		},'-',{
			iconCls: 'icon-add',
			text:'添加',
			handler: function(){
		    // 获取课程的总记录数
		   $.ajax({
			url:'courseList',
			dataType:'json',
			error:function(){
			alert("请求失败");
			},
			success:function(data){
			  //alert("请求成功");
			var total=data.total;
			console.log("数据total："+total);
		   // 加上一个判断 
		   //当前gird的总记录数
		 var datagridTotal=($("#teacher_list").datagrid('getData').total);
	        // 添加窗口   判断当前班级课程已经安排完
	        if(datagridTotal>=total){
	        $.messager.alert('系统消息','课程老师已安排完全，无法操作！');
	        }else{
	        	$("#teadialog").dialog({    
				    title: '添加窗口',    
				    width: 400,    
				    height: 200,    
				    closed: false,   
				    cache: false,    
				    href: 'Teacher_add.jsp',    
				    modal: true,
				    // 添加不需要id值
		    });  
	        }
			},
			type:'POST'
		   }); 
		    
			}
		},'-',{
			iconCls:'icon-remove',
			text:'删除',
			handler: function(){
		
					 if($("#teacher_list").datagrid("getSelections").length==1){
						 $("#teadialog").dialog({    
							    title: '删除窗口',    
							    width: 400,    
							    height: 200,    
							    closed: false,    
							    cache: false,    
							    href: 'Teacher_delete.jsp',    
							    modal: true,
								onLoad:function(){
				      $("#delete_teacher :hidden:eq(0)").val($("#teacher_list").datagrid("getSelected").id);
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
<table id="teacher_list"></table> 
<!-- 弹出对话框 -->
<div id="teadialog"></div>  

</body>
</html>