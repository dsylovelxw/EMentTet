<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>新增班级</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	  <link rel="stylesheet" href="<%=basePath %>/css/layui.css" media="all" />
	 
	<link rel="stylesheet" href="<%=basePath %>/css/public.css" media="all" />
</head>
<body class="childrenBody">
<form class="layui-form layui-form-pane" action="Javascript:void(0)">
  <div class="layui-form-item">
    <label class="layui-form-label">班级编号</label>
    <div class="layui-input-inline">
      <input type="text" name="id" id="id" lay-verify="required" disabled="" placeholder="班级编号" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">班级名称</label>
    <div class="layui-input-inline">
    	<input type="text" name="uname2" id="uname2" style="display:none" lay-verify="required" placeholder="请输入班级"  autocomplete="off" class="layui-input">
      <input type="text" name="uname" id="uname" lay-verify="required" placeholder="请输入班级" autocomplete="off" class="layui-input">
    </div>
  </div>
  

  
   <div class="layui-form-item">
    <label class="layui-form-label">班级人数</label>
    <div class="layui-input-inline">
      <input type="text" name="renshu" id="renshu" lay-verify="required" placeholder="请输入班级人数" autocomplete="off" class="layui-input">
    </div>
  </div>
  
 
 
  
  
  
    <div class="layui-form-item">
    <label class="layui-form-label">userid</label>
    <div class="layui-input-inline">
      <input type="text" name="userid" id="userid" lay-verify="required" placeholder="请输入userid" autocomplete="off" class="layui-input">
    </div>
  </div>
  
  
 

 
 
 
 
  
  <div class="layui-form-item">
    <button class="layui-btn layui-btn-fluid" id="xiugai" lay-filter="addUser">修改班级</button>
  </div>
</form>
 <script src="<%=basePath %>/jquery-3.4.1/jquery-3.4.1.min.js"></script> 

   <script src="<%=basePath %>/jsp/yonghu/layui-v2.5.5/layui.js"></script>
  <script type="text/javascript" src="<%=basePath %>/js/bumen/userInfo.js"></script>
  

</body>
</html>