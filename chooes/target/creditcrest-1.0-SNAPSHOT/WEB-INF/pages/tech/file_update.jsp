<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<form id="submitForm" class="form-horizontal" enctype="multipart/form-data" method="post">
	<input name="id" value="${file.id}" type="text" hidden="hidden">
	<div class="form-group">
		<label class="col-sm-3 control-label no-padding-right" for="nowname">上传文件</label>
		<div class="col-sm-8">
			<input type="text" id="filename" name="filename" value="${file.filename}" class="form-control" readOnly style="margin-bottom: 5px;"/>
			<input id="uploadBtn" name="files" type="file" class="file">
			<span style="color: red;">只允许上传.txt;.dat;.docx;.xlsx;.zip;.rar文件</span>
		</div>
	</div>
	
	<div class="form-group" style="display: none;">
		<label class="col-sm-3 control-label no-padding-right" for="filename">文件名称</label>
		<div class="col-sm-8">
			<input type="text" id="nowname" name="nowname" value="${file.filename}" class="form-control" readOnly/>
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-3 control-label no-padding-right" for="savepath">存放位置</label>
		<div class="col-sm-8">
			<input type="text" id="savepath" name="savepath" value="${file.savepath}" class="form-control" readOnly/>
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-3 control-label no-padding-right" for="url">访问地址</label>
		<div class="col-sm-8">
			<input type="text" id="url" name="url" value="${file.url}" class="form-control" readOnly/>
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-3 control-label no-padding-right" for="filetype">文件类型</label>
		<div class="col-sm-5">
			<input type="text" id="filetype" name="filetype" value="${file.filetype}" class="form-control" readOnly/>
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-3 control-label no-padding-right" for="filesize">文件大小</label>
		<div class="col-sm-5">
			<input type="text" id="filesize" name="filesize" value="${file.filesize}" class="form-control" readOnly/>
		</div>
		<span class="col-sm-2" style="color: red;padding-left: 0px;width: 100px;">(单位:字节)</span>
	</div>
</form>

<script type="text/javascript">
	//上传文件
	$("#uploadBtn").fileinput({
		enctype: "multipart/form-data",
	    uploadUrl: _urlPath + "upload/uploadFile.do",
		language: "zh",
	    browseLabel: "选择文件",
	    maxFileCount: 10,
		showUpload: true, //是否显示上传按钮
		showRemove: true, //是否显示移除按钮
		showPreview: false,//是否显示预览图
	    showCaption: false,//是否显示标题
	    dropZoneEnabled: false,//是否显示预览区域
	    initialPreviewShowDelete: false,
		browseClass: "btn btn-info",
	    allowedFileExtensions : ["txt","dat","docx","xlsx","zip","rar"]//接收的文件后缀
	}).on("fileuploaded", function(event, ret, previewId, index){
		if(0 == ret.response.retcode){
			modalErr(ret.response.retmsg);
			return;
		}else{
			$("#nowname").val(ret.response.data.nowname);
			$("#savepath").val(ret.response.data.savepath);
			$("#filetype").val(ret.response.data.filetype);
			$("#filesize").val(ret.response.data.filesize);
			$("#url").val(ret.response.data.url);
		}
	}).on("change", function(event){
		var filename = event.target.value;
		filename = filename.substring(filename.lastIndexOf("\\") + 1, filename.length);
		$("#filename").val(filename);
		return false;
	});

	submit = function(){
		var savepath = $("#savepath").val();
		if("" == savepath){
			modalErr("请先上传文件");
			return;
		}
		var data = $("#submitForm").serialize();
		ajaxRequest("admin/tech/updateFile", data);
	}
</script>