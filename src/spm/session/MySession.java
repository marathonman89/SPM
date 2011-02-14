package spm.session;

import java.util.List;

import org.apache.wicket.Application;
import org.apache.wicket.Request;
import org.apache.wicket.protocol.http.WebSession;

import spm.Role.Role;
import spm.user.User;

@SuppressWarnings("serial")
public class MySession extends WebSession{
	
	private User user;
	private List<User> userAcctSearch;
	private User userSearch;
	private boolean successOnAddUser;
	private User userLoggedRoles;

	public MySession(Request request) {
		super(request);
	}
	
	@SuppressWarnings("deprecation")
	public MySession(Application application, Request request) {
		super(application, request);
	}
	
	public void setLoggedUser(User user){
		this.user = user;
	}
	
	public User getLoggedUser(){
		return user;
	}
	
	public boolean isSessionSet(){
		if(user == null)
			return false;
		return true;
	}
	
	public List<User> getUserAcctSearch() {
		return userAcctSearch;
	}

	public void setUserAcctSearch(List<User> userAcctSearch) {
		this.userAcctSearch = userAcctSearch;
	}

	public boolean isSuccessOnAddUser() {
		return successOnAddUser;
	}

	public void setSuccessOnAddUser(boolean successOnAddUser) {
		this.successOnAddUser = successOnAddUser;
	}

	public User getUserSearch() {
		return userSearch;
	}
	
	public void setUserSearch(User userSearch) {
		this.userSearch = userSearch;
	}
	
	public User getUserLoggedRoles() {
		return userLoggedRoles;
	}

	public void setUserLoggedRoles(User userLoggedRoles) {
		this.userLoggedRoles = userLoggedRoles;
	}
	
}
