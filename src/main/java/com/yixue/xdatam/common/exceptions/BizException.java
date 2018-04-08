package com.yixue.xdatam.common.exceptions;

/**
 * @Description : 业务异常定义.
 * @Author : robinwb.
 * @Date : 2017年03月20日 12:56
 * 100xx 表示系统级别错误代码
 * 200xx 表示服务级别错误代码
 *
 */
public class BizException extends RuntimeException {

	private static final long serialVersionUID = 7544316414162709565L;


    /**
	 * EXCEL模板格式
	 */
	public static final BizException EXCEL_ERROR = new BizException(10000, "模板格式存在问题,请修正,谢谢！");

    /**
     * EXCEL模板格式
     */
    public static final BizException EXCEL_MORE_ERROR = new BizException(10001, "模板数据列有多余,请核对,谢谢！");

	
	/**
	 * 异常信息
	 */
	protected String msg;

	/**
	 * 具体异常码
	 */
	protected int code;

	public BizException(int code, String msgFormat, Object... args) {
		super(String.format(msgFormat, args));
		this.code = code;
		this.msg = String.format(msgFormat, args);
	}

	public BizException() {
		super();
	}

	public String getMsg() {
		return msg;
	}

	public int getCode() {
		return code;
	}

	/**
	 * 实例化异常
	 *
	 * @param msgFormat
	 * @param args
	 * @return
	 */
	public BizException newInstance(String msgFormat, Object... args) {
		return new BizException(this.code, msgFormat, args);
	}

	public BizException(String message, Throwable cause) {
		super(message, cause);
	}

	public BizException(Throwable cause) {
		super(cause);
	}

	public BizException(String message) {
		super(message);
	}
}
