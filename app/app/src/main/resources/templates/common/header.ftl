<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Cache-Control" content="no-transform" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>${pageTitle!}Home Page</title>
    <meta name="keywords" content="keywords" />
    <meta name="description" content="description" />
    
    <!-- 引入easyui相关文件 -->
	<link rel="stylesheet" type="text/css" href="/static/easyui/themes/metro/easyui.css">
	<link rel="stylesheet" type="text/css" href="/static/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="/static/easyui/themes/color.css">
	<script type="text/javascript" src="/static/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="/static/easyui/jquery.easyui.min.js"></script>

</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false" title:'Logo' style="height:90px;">north region</div>
	<div data-options="region:'west',split:true,title:'功能菜单'" style="width:120px;">west content</div>
	<div data-options="region:'center',title:'功能区'">