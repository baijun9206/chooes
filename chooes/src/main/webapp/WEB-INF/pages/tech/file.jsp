<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="page-header" style="padding:10px 20px;margin:-18px 0px 0px">
  <div id="searchForm">
    <div class="col-md-3" style="text-align: left;padding-bottom: unset">
        <button id="addBtn" class="btn btn-labeled btn-primary" onclick="javascript:showModal('添加文件', 'admin/tech/addFilePage');"><span class="btn-label icon fa fa-plus"></span>添加文件</button>
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
                {field:"id",text:"文件ID"},
                {field:"filename", text:"文件名称"},
                {field:"savepath", text:"存放位置"},
                {field:"url", text:"文件地址"},
                {field:"filetype", text:"文件类型"},
                {field:"filesize", text:"文件大小(字节)"},
                {field:"addtime", text:"上传时间"},
                {field:"id", text:"操作", style:"text-align:center", formatter:function(index, content, data){
                    var editUrl = "admin/tech/updateFilePage/" + content;
                    //可直接通过downUrl=data.url获取文件访问路径直接下载,但是那种方式会直接在浏览器打开文件
                    var downUrl = _urlPath + "upload/downFile.do?id=" + content;
                    var delUrl = "admin/tech/delFile/" + content;
                    return "<a href='javascript:showModal(\"修改文件\", \""+editUrl+"\");' class='btn btn-xs btn-warning add-tooltip'><i class='fa fa-pencil'>修改</i></a>"
                        + "&nbsp;<a href='"+downUrl+"' class='btn btn-xs btn-success add-tooltip'><i class='ace-icon fa fa-download'>下载</i></a>"
                        + "&nbsp;<a href='javascript:showCfm(\"确定删除该记录\", \""+delUrl+"\");' class='btn btn-xs btn-danger add-tooltip'><i class='fa fa-times'>删除</i></a>";
                }}
            ],	
            cls: "",
            url: _urlPath + "admin/tech/queryFilePage",
            sort:"id",
            order:"desc",
            pagination:true,
            onLoad:function(){
                $(".add-tooltip").tooltip();
            }
        });
    });
</script>