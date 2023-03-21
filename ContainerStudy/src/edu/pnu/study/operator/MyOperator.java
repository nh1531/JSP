package edu.pnu.study.operator;

import java.util.Calendar;

public abstract class MyOperator {

	private String cmd;
	private Calendar createdTime;
	private Calendar lastUsedTime;
	
	public MyOperator(String cmd) {
		this.cmd = cmd;
		// 시간 저장
		createdTime = lastUsedTime = Calendar.getInstance();
	}
	
	public abstract int operate(int a, int b);

	public String getCmd() {
		return cmd;
	}

	public Calendar getCreatedTime() {
		return createdTime;
	}

	public Calendar getLastUsedTime() {
		return lastUsedTime;
	}

	public void setLastUsedTime(Calendar lastUsedTime) {
		// 마지막으로 사용된 시간
		this.lastUsedTime = lastUsedTime;
	}
}
