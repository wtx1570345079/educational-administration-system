<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>成绩录入</title>
</head>
<body>
<script type="text/javascript">
$(function(){
	$('#stuscore_list').datagrid({    
	     // 转发至
	    url:'stuscoreList',    
	    columns:[[    
	        {field:'id',title:'编号',width:100},    
	        {field:'number',title:'学号',width:100},
	        {field:'name',title:'学生姓名',width:100},  
	        // value：字段值。 rowData：行记录数据。rowIndex: 行索引。
	        {field:'score',title:'成绩',width:100,formatter: function(value,row,index){
				return row.score.score;
			}
},
	     /*    {field:'opertae',title:'操作',width:100,formatter: function(value,row,index){
					return "<a href=''>课程</a>";
			  }
				}  */
	    ]],   
	    
	   pagination:true,
	   singleSelect:true,
	   toolbar: [{
			iconCls: 'icon-edit',
			text:'录入成绩',
			handler: function(){
		    // 加上判断， 只有选中一行数据的时候才会弹框   getSelections:返回所有被选中的行
		    /* alert($("#student_list").datagrid("getSelections").length); */
		    if($("#stuscore_list").datagrid("getSelections").length==1){
		   //   点击修改的时候弹出对话框
				$('#newdialog').dialog({    
				    title:'录入成绩',    
				    width:400,    
				    height:200,    
				    closed:false,    
				    cache:false,
				    // 相对路径
				    href:'insertScore.jsp',    
				    modal:true,
				    // onload:加载远程数据时被触发
				    onLoad:function(){
				    	// 先获取到学生编辑界面的input标签，在设置元素的内容为选中对象的属性 field,
				    	// 将选中的一行的数据设置为表单标签input的value值
				   $("#add_score :hidden:eq(0)").val($("#stuscore_list").datagrid("getSelected").id);
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
<table id="stuscore_list"></table> 
<!-- 弹出对话框 -->
<div id="newdialog"></div>  

</body>
</html>