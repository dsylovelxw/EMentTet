layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;

 /* $.ajax({
	  url:"/EMentTet/JueseServlet?action=allRole",
	  type:"post",
	  success:function(data){
		  
		  var info = eval("("+data+")");
		  var row = info.data;  
		  var role = $("#role1");
		  var html = '';
		  $.each(row,function(index,item){
			
			  html += '<option value="'+item.id+'">'+item.lodName+'</option>';
		  })
		  role.html(html);
		  form.render("select");
	  }
  })
    $.ajax({
	  url:"/EMentTet/JueseServlet?action=allBumeng",
	  type:"post",
	  success:function(data){
		  
		  var info = eval("("+data+")");
		  var row = info.data;
		  
		  var role = $("#bumeng");
		  var html = '';
		  $.each(row,function(index,item){
			
			  html += '<option value="'+item.id+'">'+item.rname+'</option>';
		  })
		  role.html(html);
		  form.render("select");
	  }
  })
    $.ajax({
	  url:"/EMentTet/JueseServlet?action=allZhicheng",
	  type:"post",
	  success:function(data){
		  
		  var info = eval("("+data+")");
		  var row = info.data;
		  
		  var role = $("#zhicheng");
		  var html = '';
		  $.each(row,function(index,item){
			
			  html += '<option value="'+item.id+'">'+item.rname+'</option>';
		  })
		  role.html(html);
		  form.render("select");
	  }
  })*/
 
  function checkUname(uname){
	  var is = false;
	  $.ajax({
		  url:"/EMentTet/bumen?action=addbumrn",
		  data:{"uname":uname},
		  async:false,
		  type:"post",
		  success:function(data){
			 
			  if(data == 0){
				  is = true;
			  }else{
				  is = false;
			  }
			  
		  }
	  })
	  return is;
  }
  
  
  
  $("#tijiao").click(function(){
	  var name = $("#uname").val();
	  var shu = $("#shu").val();
	  var userid = $("#userid").val();
	  var data = {
			  "name":name,
			  "shu":shu,
			  "userid":userid
	  }
	  $.ajax({
	  		url:"/EMentTet/bumen?action=addbumen",
			data:data,
			tyep:"post",
			success:function(data){
				  var info = eval("("+data+")");
				if(data !=0){
					layer.msg("添加成功")
					setTimeout(function(){
						layer.closeAll("iframe");
			            //刷新父页面
			            parent.location.reload();
		        	},1000);
				}else{
					layer.msg("系统异常");
				}
				
			}
	  })
	  return false;
  })
  
});
