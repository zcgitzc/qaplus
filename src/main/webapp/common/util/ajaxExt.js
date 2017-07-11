define(function(require, exports, module) {
	var ajax=require("./ajax");
	var layerLoadIndex;
	require("../../static/layer/layer.js");
	require("../../static/layer/skin/layer.css");
	if(! window.$){
		window.$ = $;
	}
	ajax.ajaxSettings = {
		ifModified: false,
		type: "POST",
		dataType: "JSON",
		cache: false
	}
	ajax.commonBeforeSend=function(){
		layerLoadIndex = layer.load(2, {time: 10*1000});
	}
	ajax.commonSuccess = function(context, result, textStatus, xhr){
		layer.close(layerLoadIndex);
		if(!result.hasError){
			if(typeof this.success === "function"){
				this.success.call(context, result, textStatus, xhr);
			}else{
				//如果外面没有定义success，默认就是提示：操作成功，1s后刷新页面
				layer.msg(result.msg, {
					icon : 6,
					time : 1000
				}, function() {
					window.location.reload(true);
				});
			}
		}else{
			if(typeof this.error === "function"){
				this.error.call(context, result.msg, textStatus, xhr);
			}else{
				//如果外面没有定义error，默认就是提示：提示显示后台的错误信息
				if(result.msg){
					layer.msg(result.msg, {
						icon : 5,
						time:5000
					});
				}else{
					layer.msg("操作失败", {
						icon : 5,
						time:5000
					});
				}
			}
		}
		if(typeof this.finalize === "function"){
			this.finalize.call(context, result, textStatus, xhr);
		}
	}
	//请求后台失败时（404） 提示错误信息
	ajax.commonError = function(context, result, textStatus, xhr){
		if(result.responseText){
			layer.msg(result.responseText, {
				icon : 5
			});
		}else {
			layer.msg("服务器繁忙，请稍后重试", {
				icon : 5
			});
		}
	}
	function undecode(str) {
		return str.replace(/&#(x)?([^&]{1,5});?/g, function(a, b, c) {
			return String.fromCharCode(parseInt(c, b ? 16 : 10))
		});
	}
});