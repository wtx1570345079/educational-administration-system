<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/easyui/js/easyui/themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="/easyui/js/easyui/themes/icon.css">   
<script type="text/javascript" src="/easyui/js/jquery-1.7.2.js"></script>   
<script type="text/javascript" src="/easyui/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
  $(function(){
 /* 	  
          菜单对象的属性应该跟下面一致，否则无效
          每个节点具有以下属性：
	id：节点ID，对加载远程数据很重要。
	text：显示节点文本。
	state：节点状态，'open' 或 'closed'，默认：'open'。如果为'closed'的时候，将不自动展开该节点。
	checked：表示该节点是否被选中。  对话框的时候使用
	attributes: 被添加到节点的自定义属性。
	children: 一个节点数组声明了若干节点。 */
	//菜单列表项
	  $("#tree").tree({ 
        
	  	// 控制器路径且返回json数据       相对路径就必须要与控制器位置相匹配，或者写全路径
	      url:'showMenu',
	    // 设置事件  node:事件参数   表示节点对象    再通过节点node可以获取属性值    菜单节点点击事件
	     onClick:function(node){
	    	 // 如果选项卡面板已经存在就不去添加新的面板
	    	 // getTab  获取指定选项卡面板，'which'参数可以是选项卡面板的标题或者索引。
	    	 if($("#tabs").tabs('getTab',node.text)==null){
	    		   // 往选项卡tabs里面加新的选项卡面板
		    	 $('#tabs').tabs('add',{
		    			title: node.text,
		    			//表示可关闭
		    			closable:true,   
	                    //表示立即显示
		    			selected:true,
		    			//只能引进对应界面中body标签中的内容 ，body外部的不显示
		    			href:node.attributes.filename
		    		});
	          
	    	 }else{
	       // select 选择一个选项卡面板，'which'参数可以是选项卡面板的标题或者索引。
	    		 $("#tabs").tabs('select',node.text);
	    	 }
	    }

	  });  
  })
</script>
<title>管理员主界面</title>
</head>
<body class="easyui-layout"> 
     <!-- 色块定位法 -->
   <div data-options="region:'north',title:'系统'" style="height:110px;">
   <img src="/easyui/images/title.jpg" style="width:300px;height:80px;float: left;">
   <span style="height:80px;width:450px;font-size: 25px;line-height: 80px;float:left;margin-left: 20px;">
        学 生 成 绩 管 理 系 统
   </span>
   <img src="/easyui/images/dog.gif" style="width:130px;height:80px;float: right;">
   <span style="height:80px;width:240px;color:gray;font-size: 18px;float:right;line-height: 80px">
         您好,${sessionScope.user.username},欢迎登陆！ 
   <a href="<%=request.getContextPath()%>/quit" style="text-decoration: none;">
         退出</a>
   </span>
    </div>   
    <div data-options="region:'south',title:'版权所有方'" style="height:100px;text-align: center">
    <span style="width: 200px;height:70px;line-height: 70px;font-size: 22px;">CopyRight &copy;  吴天雄</span>
   </div>   
    
    <div data-options="region:'west',title:'菜单选项'" style="width:220px;">
    <!--使用树状菜单  -->
     <b>
     <ul id="tree" style="font-size:25px;font-family: 幼圆  "></ul> 
     </b>
    </div>   
    
    <div data-options="region:'center',title:'主界面'" style="padding:5px;background:#eee;">
    <div id="tabs" class="easyui-tabs" style="width:500px;height:250px;" data-options="fit:'true'">   
    <div title="首页" style="padding:20px;">   
         <h1>欢迎使用学生成绩管理系统！</h1>  
    </div>   
    
    </div>  
    </div>   
    
    
</body>  

</html>