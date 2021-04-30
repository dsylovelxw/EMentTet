<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'lan.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script src="jquery-3.4.1/jquery-3.4.1.min.js"></script>
<link href="css/layui.css" rel="stylesheet">
<script src="layui-v2.5.5/layui.js"></script>
<link rel="stylesheet" href="layui-v2.5.5/css/layui.css">
<link rel="stylesheet" href="layui-v2.5.5/lay/layui_ext/dtree/dtree.js">
<link rel="stylesheet"
	href="layui-v2.5.5/lay/layui_ext/dtree/font/dtreefont.css">
 
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">layui 管理布局</div>
			<!-- 头部区域（可配合layui已有的水平导航） -->
			<ul class="layui-nav layui-layout-left">
				<li class="layui-nav-item"><a href="">控制台</a></li>
				<li class="layui-nav-item"><a href="">商品管理</a></li>
				<li class="layui-nav-item"><a href="">用户</a></li>
				<li class="layui-nav-item"><a href="javascript:;">其它系统</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">邮件管理</a>
						</dd>
						<dd>
							<a href="">消息管理</a>
						</dd>
						<dd>
							<a href="">授权管理</a>
						</dd>
					</dl></li>
			</ul>
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a href="javascript:;"> <img
						src="http://t.cn/RCzsdCq" class="layui-nav-img"> 贤心
				</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">基本资料</a>
						</dd>
						<dd>
							<a href="">安全设置</a>
						</dd>
					</dl></li>
				<li class="layui-nav-item"><a href="">退了</a></li>
			</ul>
		</div>

		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				 <ul class="layui-nav layui-nav-tree"  lay-filter="test"> 
        <c:forEach   var="list" items="${sessionScope.de }" >
         <li class="layui-nav-item layui-nav-itemed">
               <c:if test="${list.type==1}">
          <a class="" href="javascript:;">${ list.mben }</a>
              
          <c:forEach   var="list1" items="${sessionScope.de }">
		      	  <c:if test="${list.id == list1.fatherid }">    	
		      	   <dl class="layui-nav-child">  
		      	 	<dd>${ list1.mben } 	 	 		
		  	 	 	</dd> 
        </dl>
		      	 </c:if>	      	
		      	</c:forEach>	       
		      	 </c:if>           
           </li>
         </c:forEach>      
         <li class="layui-nav-item"><a href="">云市场</a></li>
         <li class="layui-nav-item"><a href="">发布商品</a></li>
       </ul>
			</div>
		</div>
		
		
		 <div class="layui-body">
	 <script type="text/html" id="toolbarDemo">
       <c:forEach var="List" items="${meunq }"> 
             ${List.mben}  
       </c:forEach>
</script>
		        <!-- 内容主体区域 -->
     <div style="padding: 15px;">	
     
     内容主体区域
		 <table id="demmmm" lay-filter="test"></table>
	 </div>
       </div>

		<div class="sss"></div>
		<div class="layui-footer">
			<!-- 底部固定区域 -->
			© layui.com - 底部固定区域
		</div>
	</div>

 <script src="layui-v2.5.5/layui.js"></script>  
    <script src="jsp/quanxian/treeTable.js"></script> 
 <script src="jquery-3.4.1/jquery-3.4.1.min.js"></script> 
</body>

</html>
