<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>
<link rel="stylesheet" type="text/css" href="js/easyui/themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">   
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>   
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script> 
<script type="text/javascript">
 $(function(){    
    $('#btn').bind('click', function(){   
    	// ajax方式提交表单
    	$('#login_form').form('submit', {   
    		//提交路径
    	    url:'login',    
    	    onSubmit: function(){    
    	        // do some check    
    	        // return false to prevent submit;    
    	        // 非空验证
    	        if($("#username").val()==""){
    	        $.messager.alert('系统信息','用户名不能为空!');  
    	        }else if($("#password").val()==""){
    	        	 $.messager.alert('系统信息','密码不能为空!');  
    	        }else if($("select").val()==""){
    	        	 $.messager.alert('系统信息','用户角色不能为空!');  
    	        }else if($("#validcode").val()==""){
    	        	 $.messager.alert('系统信息','验证码不能为空!');  
    	        }
    	       
    	    },    
    	    success:function(data){    
    	       if(data=="01"){
    	    	   // 警告框    模式框
    	    	   $.messager.alert('系统信息','用户名或密码错误!');   
    	       } else if(data=="02"){
    	    	   $.messager.alert('系统信息','验证码错误!');  
    	       } else if(data=="03"){
    	    	   $.messager.alert('系统信息','登录用户与用户类型不匹配!');  
    	       } else if(data=="1"){
    	    	   $.messager.alert('系统信息','管理员登录成功!');  
    	    	   location.href="/easyui/pages/manager/ManagerMain.jsp";
    	       } else if(data=="2"){
    	    	   $.messager.alert('系统信息','学生登录成功!');  
    	    	   location.href="/easyui/pages/student/StudentMain.jsp";
    	       } else if(data=="3"){
    	    	   $.messager.alert('系统信息','教师登录成功!');  
    	    	   location.href="/easyui/pages/teacher/TeacherMain.jsp";
    	       } 
    	    }    
    	}); 
    });    
});  
</script>
</head>
<body style="background-image:url(images/background2.jpg);background-repeat:no-repeat;background-size:100%;background-attachment: fixed;">


<div style="margin: 110px 340px;width: 400px;" >
<div id="p" class="easyui-panel" title="登录"     
      style="width:600px;height:460px;padding:10px;background:aliceblue;"   
      data-options="iconCls:'icon-reload',maximizable:true,">      
 <form id="login_form" action="login" method="post">
 <table style="width: 500px;margin: 0 60px;text-align: center;" cellpadding="15">
 <thead>
 <tr><td colspan="2">
 <h1>
  学 生 成 绩 管 理 系 统</h1></td></tr>
 </thead>
 <tbody>
 <tr>
 <td align="right" style="font-size: 20px;">用户名:</td>
 <td align="left"><input type="text" id="username" name="username" size="30"></td>
 </tr>
 
 <tr>
 <td  align="right" style="font-size: 20px;">密码:</td>
 <td align="left"><input type="password" id="password" name="password" size="30"></td>
 </tr>
 
 <tr>
 <td  align="right" style="font-size: 20px;">用户角色:</td>
 <td align="left">
<select class="easyui-combobox" name="type" id="type" style="width:245px;">  
    <option value="2">学生</option>   
    <option value="3">教师</option>   
    <option value="1">管理员</option>   
</select>  
</td>
 </tr>
 
  <tr>
 <td  align="right" style="font-size: 20px;">验证码:</td>
 <td align="left" style="height: 10px;line-height: 10px;">
 <input type="text"  id="validcode" name="validcode" size="10" style="vertical-align:bottom;">
 <img src="validcode" width="80" height="30px"><a href="">看不清，下一张</a>
 </td>
 </tr>
 <tr>
 <td colspan="2">
 <span id="btn"  class="easyui-linkbutton" 
 data-options="iconCls:'icon-ok',size:'large'"><span style="font-size: 19px;font-family: 幼圓;margin-right: 7px;">登录</span></span>  
 </td></tr>
 </tbody>
 </table>
 </form>
</div>    
</div>


</body>
</html>