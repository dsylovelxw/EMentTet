layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;

 
  
  function checkUname(uname){
	  var is = false;
	  $.ajax({
		  url:"/EMentTet/BuMenSerlvetDSY?action=isUname",
		  data:{"uname":uname},
		  async:false,
		  type:"post",
		  success:function(data){
			  var info = eval("("+data+")");
			  if(info == 0){
				  layer.msg("班级名称重复");
				  
				  is = true;
			  }else{
				  is = false;
			  }
		  }
	  })
	  return is;
  }
  
  $("#uname").blur(function(){
	  var name = $("#uname").val();
	  var name2 = $("#uname2").val();

  })
  
  
  $("#xiugai").click(function(){
	  var id = $("#id").val();
	  var name = $("#uname").val();
	  var name2 = $("#uname2").val();
	  var renshu = $("#renshu").val();
	  var userid = $("#userid").val();
	 
 
	 
	  var data = {
			  "id":id,
			  "name":name,
			  "renshu":renshu, 
			  "userid":userid		  
	  }
	  if(name.length<3){
		  layer.alert("班级名称不能小于3位数")
		  return false;
	  } 
		  
	  
	 
	 
	  $.ajax({
	  		url:"/EMentTet/BuMenSerlvetDSY?action=updateUserByAdmin",
			data:data,
			tyep:"post",
			success:function(data){
				  var info = eval("("+data+")");
				if(info !=0){
					layer.msg("班级信息修改成功");
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
 