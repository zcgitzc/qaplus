define(function(require, exports, module) {
	var constant = {
		INPUT_LENGTH : '200px',
		DIALOG_WIDTH : '640px',
		INPUT_LENGTH_POP: '170px',
		SELECT_TPL : '<a href="#"><span data-role="trigger-content"></span><i class="iconfont" title="下拉">&#xe614;</i></a>',
		DEFAULT_PAGE_SIZE : 10,
		BANK_TYPE : {
			"BANK" : "银行",
			"ALIPAY" : "支付宝"
		},
		TASK_TYPE : {
			"SYNC_TRADE_RECORD" : "交易明细同步任务",
			"CHECK_TRADE_RECORD" : "交易明细对账任务",
			"SYNC_HIS_BALANCE" : "历史余额同步任务",
			"SYNC_REAL_TIME_BALANCE" : "实时余额同步任务",
			"SYNC_ALIPAY_DAILY" : "支付宝日变动同步任务"
		},
		TASK_STATUS : {
			"NEW" : "新创建",
			"HOLDING" : "已领取",
			"PROCESSING" : "处理中",
			"SUCCESS" : "成功",
			"FAIL" : "失败"
		},
		DATA_STATUS : {
			"VALID" : "有效",
			"INVALID" : "失效"
		},
		USER_STATUS : {
			"VALID" : "有效",
			"FREEZE" : "失效"
		},
		CHECK_RESULT_TYPE : {
			"DIFF" : "有差异",
			"MORE" : "银行端缺失",
			"LESS" : "网关端缺失"
		},
		CHECK_RESULT_BUTTON : {
			"DIFF" : "更新",
			"MORE" : "删除",
			"LESS" : "导入"
		},
		COMMON_FLAG : {
			"y" : "是",
			"n" : "否"
		},
		DATA_SOURCE : {
			"MANUAL" : "手工产生",
			"SYSTEM" : "系统产生"
		},
		BANK_CODE : {
			"ABC" : "农业银行",
			"ALIPAY" : "支付宝",
			"CMB" : "招商银行",
			"CMBC" : "民生银行",
			"DBS" : "星展银行",
			"HSBC" : "汇丰银行",
			"ICBC" : "工商银行",
			"PAB" : "平安银行"
		},
		CURRENCY_TYPE : {
			"CNY" : "人民币",
			"GBP" : "英镑",
			"HKD" : "港币",
			"USD" : "美元",
			"CHF" : "瑞士法郎",
			"SGD" : "新加坡元",
			"DKK" : "丹麦克朗",
			"SEK" : "瑞典克朗",
			"NOK" : "挪威克朗",
			"JPY" : "日元",
			"CAD" : "加拿大元",
			"AUD" : "澳大利亚元",
			"EUR" : "欧元",
			"MOP" : "澳门元"
		},
		GROUP : {
			"ALICORP" : "阿里集团",
			"ALIPAY" : "支付宝",
			"CAINIAO" : "菜鸟网络"
		},
		HANDLE_RESULT : {
			"SUCCESS" : "成功",
			"FAILURE" : "失败"
		},
		MESSAGE_TITLE : {
			"HANDLE_FAILURE" : "操作异常",
			"OPERATE_TIPS" : "操作提示"
		},
		PAYMENTNOTICE_STATUS : {
			"NEW" : "新建",
			"HIDDEN" : "隐藏",
			"SUSPEND" : "挂起",
			"CLOSE" : "关闭",
			"WAITING_GEN_PAYMENT" : "待生成付款单",
			"GEN_PAYMENT" : "已生成付款单",
			"PAYED" : "已付款",
			"PAYED_FAIL":"银行已退回"
		},
		PAYMENTNOTICE_TYPE : {
			"PREPAY_MONEY" : "预付款",
			"POSTPAY_MONEY" : "后付款",
			"GUARANTEE_MONEY" : "质量保证金"
		}

	}
	module.exports = constant;
});
