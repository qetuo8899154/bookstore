package com.my.bookStore.user.web;

public class Verify {
	private boolean usernameFlag;
	private boolean passwordFlag;
	private boolean emailFlag;
	public boolean isUsernameFlag() {
		return usernameFlag;
	}
	public void setUsernameFlag(boolean usernameFlag) {
		this.usernameFlag = usernameFlag;
	}
	public boolean isPasswordFlag() {
		return passwordFlag;
	}
	public void setPasswordFlag(boolean passwordFlag) {
		this.passwordFlag = passwordFlag;
	}
	public boolean isEmailFlag() {
		return emailFlag;
	}
	public void setEmailFlag(boolean emailFlag) {
		this.emailFlag = emailFlag;
	}
	
}
