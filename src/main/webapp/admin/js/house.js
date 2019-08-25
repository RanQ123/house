$(function(){
    //使用datagrid绑定数据库
    $('#dg').datagrid({
        url:'getNoPassHouse',      //服务器地址
        title:"未审核房屋",
        toolbar:"#ToolBar",     //指定工具栏
        pagination:true,        //启用分页
        pageList:[3,6,9,15,20],//设置每页大小
        pageSize:3,             //每页三条
        //singleSelect:true,    //实现单行选择
        columns:[[
            {field:"cb",checkbox:true},
            {field:'id',title:'编号',width:100},
            {field:'title',title:'标题',width:100},
            {field:'tname',title:'类型',width:100},
            {field:'floorage',title:'面积',width:100},
            {field:'price',title:'价格',width:100},
            {field:'contact',title:'联系方式',width:100},
            {field:'dname',title:'区域',width:100},
            {field:'sname',title:'街道',width:100},
            {field:'s',title:'操作',width:200,
                formatter: function(value,row,index){   //当前列的值  当前行对象
                    //发送同步请求
                    // return "<a href=\"deleteDistrict?id="+row.id+"\" class=\"easyui-linkbutton\" iconCls=\"icon-ok\">删除</a>";
                    //发送异步请求Ajax
                    var str = "<a href='javascript:goPass("+row.id+");'>审核</a>"
                    return str;
                }
            }
        ]]
    });
});

//点击添加，打开窗口
function addDialog(){
    //alert("我要添加区域");
    $('#AddDialog').window('setTitle',"添加区域");
    $('#AddDialog').window('open');
}
//关闭对话框
function CloseAddDialog(id){
    $('#'+id).window('close'); //关闭
}

//使用异步请求 ，实现调用审核的服务器接口
function goPass(id) {
    //发送异步请求
    $.post("goYesPassHouse",{"id":id},function (data) {
        if (data.result>0){
            //刷新
            $('#dg').datagrid('load');
        }else {
            $.messager.alert("提示","审核失败","warn");
        }
    },"json")
}

//实现用户搜索功能
function userSearch() {
    //取值
    var name=$("#inputname").val();
    var tel=$("#inputtel").val();
    //重新加载
    // $('#dg').datagrid('load',传递查询条件参数);
    $('#dg').datagrid('load',{
        name: name,
        telephone: tel
    });
}