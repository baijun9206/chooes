<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="page-header" style="padding:10px 20px;margin:-18px 0px 0px">
  <div id="searchForm">
    <div class="col-md-3" style="text-align: left;padding-bottom: unset">
        <button id="addBtn" class="btn btn-labeled btn-primary" onclick="javascript:goPage('admin/tech/addArticlePage');"><span class="btn-label icon fa fa-plus"></span>发表文章</button>
    </div>
  </div>
</div>
<div class="openAppGrid">
	<div id="openAppGrid"></div>
</div>
<script type="text/javascript">
    $(function (){
        $("#openAppGrid").sgrid({
            columns:[
                {field:"id",text:"文章ID", width: 40},
                {field:"uid", text:"用户ID", width: 40},
                {field:"cover",text:"封面",style:"text-align:center",width: 80,formatter:function(index, content, data){
                    return "<img src='" + content + "' height='20px'/>";
                }},
                {field:"title", text:"文章标题",width: 200,limit:15,formatter:function(index, content, data){
                    return "<font color='" + data.color + "'>" + content + "</font>";
                }},
                {field:"content", text:"文章内容",limit:15,formatter:function(index, content, data){
                	content = content.replace(/<(?:.|\s)*?>/g,"");
                	if(content.length > 50){
                		content = content.substr(0, 50) + "...";
                	}
                	return content;
                	//去样式
                    //return "<xmp style='margin: unset;'>" + content + "</xmp>";
                }},
                {field:"posttime", text:"发表时间", width: 150},
                {field:"id", text:"操作", style:"text-align:center", width: 80, formatter:function(index, content, data){
                    var editUrl = "admin/tech/updateArticlePage/" + content;
                    var delUrl = "admin/tech/delArticle/" + content;
                    return "<a href='javascript:goPage(\""+editUrl+"\");' class='btn btn-xs btn-warning add-tooltip'><i class='fa fa-pencil'>修改</i></a>"
                        + "&nbsp;<a href='javascript:showCfm(\"确定删除该记录\", \""+delUrl+"\");' class='btn btn-xs btn-danger add-tooltip'><i class='fa fa-times'>删除</i></a>";
                }}
            ],
            cls: "",
            url: _urlPath + "admin/tech/queryArticlePage",
            sort:"id",
            order:"desc",
            pagination:true,
            onLoad:function(){
                $(".add-tooltip").tooltip();
            }
        });
    });
</script>