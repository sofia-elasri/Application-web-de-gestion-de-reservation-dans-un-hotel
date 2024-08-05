package org.eclipse.beans;

public class User {
	protected int userId;
	protected String login;
	protected String passwd;
	
	
	public User(String login, String passwd) {
		super();
		this.login = login;
		this.passwd = passwd;
	}





	public User(int userId, String login, String passwd) {
		super();
		this.userId = userId;
		this.login = login;
		this.passwd = passwd;
	}


	public User() {
		super();
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
}
