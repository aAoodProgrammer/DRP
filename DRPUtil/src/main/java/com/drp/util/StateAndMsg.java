package com.drp.util;

/** 
* @ClassName: StateAndMsg 
* @Description: 业务逻辑层处理结果 :state处理状态（1 成功 -1 失败）msg(提示语句)
* @author 王春
* @date 2017年11月15日 上午10:29:31 
*  
*/
public class StateAndMsg {
	private int state;//处理状态
	private String msg;//提示语句
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public StateAndMsg(int state, String msg) {
		super();
		this.state = state;
		this.msg = msg;
	}
	public StateAndMsg() {
		super();
		
	}
	
}
