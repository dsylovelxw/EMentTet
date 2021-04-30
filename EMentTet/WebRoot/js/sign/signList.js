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
        url : '/EMentTet/SignServlet?action=signAll',
        toolbar: '#toolbarDemo',
        page : true,
        height: 'full-145',
        limit : 10,
        limits : [10,15,20,25],
        cols : [[
        	{fixed:"left",type: "checkbox", width:50},
            {field: 'id', title: 'id',  align:'center',hide:"hide"},
            {field: 'userName', title: '学生姓名',  align:'center'},
            {field: 'phone', title: '学生手机号', minWidth:100, align:"center"},
            {field: 'address', title: '学生住址', minWidth:100, align:"center"},
            {field: 'soignid', title: '是否签到', align:'center',templet:function(d){
                return d.isStatus == "0" ? "<span class='layui-badge layui-bg-green'>正常</span>" : "<span class='layui-badge layui-bg-red'>冻结</span>";
            }},
            {field: 'date', title: '签到日期', minWidth:100, align:"center"},
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
	      case 'fenFunc':	//分配角色
				if(data.length == 0 || data.length > 1){
					layer.msg("请选择一行数据进行操作")
					return ;
				}else{
					hairMenu(userid);
				}
	      break;
	  
	    };
	  });
    
  
    
	//分配角色
	    function hairMenu(userid){
	    	 
	    	layui.layer.open({
	    		title : "分配角色",
	    		type : 1,
	    		content : $('#dtree1'),
	    		area:['300px','500px'],
	    		success:function(){
	    		    //给dtree树加载数据
	    			
	    			dtree.render({
					  elem: "#dataTree3",
					  url: "/EMentTet/QuanServletInterface?action=allMenuDtree",
					  dataStyle: "layuiStyle",  //使用layui风格的数据格式
				  dataFormat: "list",  //配置data的风格为list
					  response:{message:"msg",statusCode:0},  //修改response中返回数据的定义
					  checkbar:true,
					  line: true,  // 显示树线
					  done: function(res, $ul, first){
						  
						  $.ajax({
							  url:"/EMentTet/QuanServletInterface?action=menuByUseridType1",
							  type:"post",
							  data:{"userid":userid},
							  success:function(res){
								  
								  var cs = eval('(' + res + ')');
								  $.each(cs,function(index,row){
									dtree.chooseDataInit("dataTree3",[row.id]); // 初始化选中
								  })
							  }
						  })
	  		    	  }
	    			});
	    		} ,
	    	 btn:['分配角色'],
	    		yes: function(index, layero){
	    			var params = dtree.getCheckbarNodesParam("dataTree3");
	    			var infos = JSON.stringify(params);
	    			var cs = eval('(' + infos + ')');
	    			var menuidList = new Array();	//所有选中值的权限id
	    			//alert(menuidList.length);
	    			$.each(cs,function(index,row){
						menuidList[index] = row.nodeId;
	    			})
	    			$.ajax({
	    				url:"/EMentTet/QuanServletInterface?action=menuByUserid",
	    				data:{"array":menuidList,"userid":userid},
	    				type:"post",
	    				traditional:true,
	    				success:function(data){
	    					var demo = eval('(' + data + ')');
	    					if(demo.status == 1){
	    						layer.msg(demo.message);
	    						layer.close(index)	//关闭
	    					}else{
	    						layer.msg("分配失败");
	    					}
	    				}
	    			})
	    		}  
	    	})
	    }
  
    
     

})