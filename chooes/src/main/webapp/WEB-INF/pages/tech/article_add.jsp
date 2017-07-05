<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<style>
.colorSpan{
	display: inline-block;
    position: relative;
    background-color: #4f99c6 !important;
    border-color: #6fb3e0;
    height: 33px;
    text-align: center;
    line-height: 33px;
    border-radius: 3px;
    color: #fff;
    padding: 0 10px;
    cursor: pointer;
}

.colorInput{
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    opacity: 0;
}
</style>
<form id="submitForm" class="form-horizontal">
	<input type="text" name="uid" value="0" hidden="hidden">
    <div class="form-group">
        <label class="col-sm-2 control-label" for="title"><font color="red">*</font>文章标题：</label>
        <div class="col-sm-8">
            <input class="form-control" type="text" id="title" name="title" placeholder="请输入文章标题"/>
            <div id="validation-title" class="validate-error help-block"></div>
        </div>
    </div>
    
    <div class="form-group">
        <label class="col-sm-2 control-label" for="color"><font color="red">*</font>标题颜色：</label>
        <div class="col-sm-4">
    		<input class="form-control" type="text" id="cValue" name="color" value="#2b2b32" placeholder="请选择标题颜色"/>
        </div>
    	<span class="colorSpan">选择颜色<input type="color" id="color" class="colorInput"/></span>
		<div id="validation-color" class="validate-error help-block"></div>
    </div>
						    
	<div class="form-group">
        <label class="col-sm-2 control-label" for="cover">帖子封面：</label>
		<div class="col-sm-8">
			<input type="text" id="cover" name="cover" class="form-control" readOnly style="margin-bottom: 5px;"/>
			<input id="uploadCover" type="file" class="file">
		</div>
	</div>
	<!-- <div class="form-group">
		<label class="col-sm-3 control-label no-padding-right" for="nowname">上传文件</label>
		<div class="col-sm-8">
			<input type="text" id="filename" name="filename" class="form-control" readOnly style="margin-bottom: 5px;"/>
			<input id="uploadBtn" name="files" type="file" class="file">
			<span style="color: red;">只允许上传.txt;.dat文件</span>
		</div>
	</div> -->
   
	<div class="form-group" style="padding-left: unset; padding-right: unset;">
        <label class="col-sm-2 control-label" for="content"><font color="red">*</font>文章内容：</label>
	    <div class="col-sm-8">
	        <script id="content" name="content" type="text/plain"></script>
	    </div>
	</div>
	
	
	<div class="form-group">
		<label class="col-sm-2 control-label"></label>
		<div class="col-sm-5">
			<div class="signin-with" style="height: 60; color: red">
				<div id="errDiv" style="display: none">
					<i class="fa fa-times-circle"></i><span style="font-size: 16px" id="err"></span>
				</div>
	        </div>
		</div>
	</div>
</form>
	
<div class="form-group">
	<label class="col-sm-2 control-label"></label>
	<div class="col-sm-8" style="text-align: center;">
		<button class="btn btn-info" style="margin-right: 30px;" type="button" onclick="javascript:submit();">
			<i class="ace-icon fa fa-check bigger-110"></i>提交
		</button>
	
		<button class="btn btn-warning" type="reset" onclick="javascript:reback();">
			<i class="ace-icon fa fa-reply bigger-110"></i>返回
		</button>
	</div>
</div>

<script type="text/javascript">
	//初始化富文本编辑器
	initUeditor();
	//颜色改变后触发事件
	document.getElementById("color").onchange = function(){
	    $("#title").css("color", this.value);
	    $("#cValue").css("color", this.value);
	    $("#cValue").val(this.value);
	}
	//上传图片
	uploadImg("uploadCover", "cover", "upload/uploadImg.do", "");
	
	function reback(){
		var title = $("#title").val();
		if("" != title){
			$.Cfm("内容未提交是否返回?",function(){
				goPage('admin/tech/articlePage');
		    });
		}else{
			goPage('admin/tech/articlePage');
		}
	}
	submit = function(){
		frmValidate();
		var data = $("#submitForm").serialize();
		$.ajax({
            url: _urlPath + "admin/tech/addArticle",
            dataType: "json",
            type: "post",
            data: data,
            success: function (req){
                if (req.retcode == 1) {
                	goPage("admin/tech/articlePage")
                } else {
                	$("#errDiv").show();
    				$("#err").html(req.retmsg);
                }
            },
            error: function(req){
            	$("#errDiv").show();
				$("#err").html(req.statusText);
            }
        });
	}
</script>