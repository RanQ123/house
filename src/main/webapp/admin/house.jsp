
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>审核管理</title>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
    <script src="js/jquery-1.8.3.js"></script>
    <!--jquery.easyui.min.js包含了easyUI中的所有插件-->
    <script src="js/jquery.easyui.min.js"></script>
    <script language="JavaScript" src="js/house.js">

    </script>

</head>
<body>
<!--显示所有区域-->
<table id="dg"></table>

<!--制作工具栏-->
<div id="ToolBar">
    <div style="height: 40px;">
        <a href="javascript:addDialog()" class="easyui-linkbutton"
           iconCls="icon-add" plain="true">添加</a> <a
            href="javascript:updateDialog()" class="easyui-linkbutton"
            iconCls="icon-edit" plain="true">修改</a> <a
            href="javascript:deleteMoreDistrict()" class="easyui-linkbutton"
            iconCls="icon-remove" plain="true">多项删除</a>

        标题:<input type="text" id="inputname"  name="name"/>
        区域:<select></select>
        街道:<select></select>
        类型:<select></select>
        价格:<select></select>
        <a id="btn" href="javascript:userSearch();" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
    </div>
</div>


</body>
</html>
