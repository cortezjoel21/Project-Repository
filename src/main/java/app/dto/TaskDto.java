package app.dto;

import java.math.BigInteger;

public class TaskDto {

	private BigInteger taskId;
	private BigInteger userId;
	private String taskDesc;
	public BigInteger getTaskId() {
		return taskId;
	}
	public void setTaskId(BigInteger taskId) {
		this.taskId = taskId;
	}
	public BigInteger getUserId() {
		return userId;
	}
	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}
	public String getTaskDesc() {
		return taskDesc;
	}
	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}
	
	
}
