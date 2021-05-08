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
                return d.soignid == "0" ? "<span class='layui-badge layui-bg-red'>未签到</span>" : "<span class='layui-badge layui-bg-green'>已签到</span>";
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
	      case 'addFunc':	//我要签到
	    	  addSign();
	      break;
	  
	    };
	  });
    
  
    
	  //我要签到
	    function addSign(){
	    	$.ajax({
	    		url:"SignServlet?action=isSgin",
	    		type:"post",
	    		success:function(data){
	    			  var info = eval("("+data+")");
	    			/*alert(info.data);*/
	    			if(info.data == 1){
	    				layer.msg("签到成功！")
	    				var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
	    				parent.layer.close(index); //再执行关闭
	    				parent.layui.table.reload("demmmm");
	    			}else if(info.data==2){
	    				layer.msg("您当天已签到！")
	    			}else if(info.data==0){
	    				layer.msg("签到失败！")
	    			}
	    		}
	    	})
	    }
     

})