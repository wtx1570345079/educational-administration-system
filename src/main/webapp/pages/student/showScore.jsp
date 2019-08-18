<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看成绩</title>
</head>
<body>
<script type="text/javascript">
$(function(){
	$('#score_list').datagrid({    
	     // 转发至
	    url:'stuscoreList?id=${user.id}',    
	    columns:[[    
	        {field:'id',title:'编号',width:100},    
	        {field:'number',title:'学号',width:100,formatter:function(value,row,index){
				return row.student.number;
			}},
	        {field:'name',title:'学生姓名',width:100,formatter:function(value,row,index){
				return row.student.name;
			}},  
	        {field:'sex',title:'性别',width:100,formatter:function(value,row,index){
				return row.student.sex;
			}},  
	        // value：字段值。 rowData：行记录数据。rowIndex: 行索引。
	        {field:'cname',title:'课程',width:100,formatter:function(value,row,index){
				return row.course.name;
			}
	        },
	        // value：字段值。 rowData：行记录数据。rowIndex: 行索引。
	        {field:'score',title:'成绩',width:100},
	     /*    {field:'opertae',title:'操作',width:100,formatter: function(value,row,index){
					return "<a href=''>课程</a>";
			  }
				}  */
	    ]],   
	    
	   pagination:true,
	   singleSelect:true,
	});  
	
	
})
</script>
<!--从数据库中  动态获取数据 所以要结合 js+html方式    这个界面是被引进主界面 ，所以不需要引入js文件  -->
<table id="score_list"></table> 
<!-- 弹出对话框 -->
<div id="newdialog"></div>  

</body>
</html>