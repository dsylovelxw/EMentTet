layui.extend({
	dtree: '{/}layui-v2.5.5/lay/layui_ext/dtree/dtree' 
}).use(['form','layer','laydate','table','laytpl',],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;
    var dtree = layui.dtree, layer = layui.layer, $ = layui.jquery;
    

    /*------------- 加载用户数据 --------------------------------*/
    var tableIns = table.render({
        elem: '#demmmm',
        url : '/EMentTet/BumenServletZXD?action=BumenAll',
        toolbar: '#toolbarDemo',
        page : true,
        height: 'full-145',
        limit : 10,
        limits : [10,15,20,25],
        cols : [[
        	{fixed:"left",type: "checkbox", width:50},
            {field: 'id', title: 'id',  align:'center',hide:true},
            {field: 'meng_name', title: '班级名称',  align:'center'},
            {field: 'renshu_id', title: '班级人数', minWidth:100, align:"center"},
            {field: 'userId', title: '用户id', minWidth:100, align:"center",hide:true},
            
        ]]
   
    });
    
	 
 
    
     //工具栏事件
	  table.on('toolbar(demmmm)', function(obj){
	    var checkStatus = table.checkStatus(obj.config.id);
	    var data = checkStatus.data;
	    var userid = '';
	    for(i=0;i<data.length;i++){
	    	userid = data[i].id;
	    }
	    
	    switch(obj.event){
	      case 'fenFunc':	//分配班级
				if(data.length == 0 || data.length > 1){
					layer.msg("请选择一行数据进行操作")
					return ;
				}else{
					hairMenu(userid);
				}
	      break;
	      case 'addFunc'://新增班级
	  		     
		    	  layer.open({
		        		title : "添加班级",
		        		type : 2,
		        		content : "/EMentTet/jsp/bumen/userAdd.jsp",
		        		area:['800px','700px'],
		    	  })
		      break;
		      
		      case 'editFun':	//修改班级
		    	  upUser(userid);
		      break;
			        
		      case 'delFunc':	//删除班级
		    	  if(data.length == 0 || data.length > 1){
						layer.msg("请选择一行数据进行操作shan")
						return ;
					}else{
						layer.confirm('确定删除班级吗', {icon: 3, title:'提示'}, function(index){
							var loginName = $("#loginName").val();
							if(userid == loginName){
								layer.msg("你正在登录当前账号,无法删除")
							}else{
								delUser(userid);
								layer.close(index);
							}
			            });
					}
		      break;
	    };
	  });
    
	  //修改班级
	    function upUser(userid){
	    	layui.layer.open({
	    		title : "修改班级信息",
	    		type : 2,
	    		content : "jsp/bumen/userInfo.jsp",
	    		area:['400px','540px'],
	    		success:function(layero, index){
	    			$.ajax({
	    				url:"/EMentTet/BuMenSerlvetDSY?action=allUserByUserid",
	    				type:"post",
	    				data:{"userid":userid},
	    				success:function(data){
	    					
	    					var info = eval('(' + data + ')');
	          				var body = layui.layer.getChildFrame('body', index);
	          				body.find("#id").val(info.id);          				
	    					body.find("#uname2").val(info.meng_name);
	    					body.find("#uname").val(info.meng_name);
	    					
	    					body.find("#renshu").val(info.renshu_id);
	    					body.find("#userid").val(info.userId);
	    				 
	    									
	                        //获取新窗口对象
	                        var iframeWindow = layero.find('iframe')[0].contentWindow;
	                        //重新渲染
	                        iframeWindow.layui.form.render();
	    				}
	    			})
	    		}
	    	})
	    }
	    //新增班级
	    function addUser(){
	    	layui.layer.open({
	    		title : "添加班级",
	    		type : 2,
	    		content : "/EMentTet/jsp/yonghu/userAdd.jsp",
	    		area:['400px','490px'],
	    		success:function(layero, index){
	    			/*------下拉框赋值--------*/
					$.ajax({
						  url:"/EMentTet/JueseServlet?action=allRole",
						  type:"post",
						  success:function(data){	
							 
							  var info = eval("("+data+")");
							  var row = info;
							 alert(row);
							 var body = layui.layer.getChildFrame('body', index);
							  var role = body.find("#role1");
							  var html = '';
	    							  $.each(row,function(index,item){
	    								  html += '<option value="'+item.id+'">'+item.lodName+'</option>';
	    								  
	    							  })
	    							  role.html(html);
	    							//获取新窗口对象
			                        var iframeWindow = layero.find('iframe')[0].contentWindow;
			                        //重新渲染
			                        iframeWindow.layui.form.render();
								  }
							  })
							  
							  	$.ajax({
						  url:"/EMentTet/JueseServlet?action=allBumeng",
						  type:"post",
						  success:function(data){		 
							  var info = eval("("+data+")");
							  var row = info;
							 
							  var html = '';
							  var body = layui.layer.getChildFrame('body', index);
							  var role = body.find("#bumeng");
							 
	    							  $.each(row,function(index,item){
	    								  html += '<option value="'+item.id+'">'+item.meng_name+'</option>';
	    							  })
	    							  role.html(html);
	    							//获取新窗口对象
			                        var iframeWindow = layero.find('iframe')[0].contentWindow;
			                        //重新渲染
			                        iframeWindow.layui.form.render();
								  }
							  })
							  	$.ajax({
						  url:"/EMentTet/JueseServlet?action=allZhicheng",
						  type:"post",
						  success:function(data){		 
							  var info = eval("("+data+")");
							  var row = info;
							 
							  var html = '';
							  var body = layui.layer.getChildFrame('body', index);
							  var role = body.find("#zhicheng");
						 
							 /* var role = body.find("#zhicheng");*/
	    							  $.each(row,function(index,item){
	    								  html += '<option value="'+item.id+'">'+item.zhi_name+'</option>';
	    								 
	    							  })
	    							  role.html(html);
	    							//获取新窗口对象
			                        var iframeWindow = layero.find('iframe')[0].contentWindow;
			                        //重新渲染
			                        iframeWindow.layui.form.render();
								  }
							  })
						  }
					  })
	    		}
	    	 
	  
	    //删除班级
	    function delUser(userid){
	    	$.ajax({
	    		url:"bumen?action=delbumen",
	    		data:{"userid":userid},
	    		type:"post",
	    		success:function(data){
	    			  var info = eval("("+data+")");
	    			if(data == 1){
	    				layer.msg("删除成功")
	    				tableIns.reload("#newsList");
	    			}
	    		}
	    	})
	    }
    
	 
    
     

})