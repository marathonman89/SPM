package spm.index;

import org.apache.wicket.Request;
import org.apache.wicket.Response;
import org.apache.wicket.Session;
import org.apache.wicket.authorization.strategies.role.RoleAuthorizationStrategy;
import org.apache.wicket.authorization.strategies.role.metadata.MetaDataRoleAuthorizationStrategy;
import org.apache.wicket.protocol.http.WebApplication;

import spm.Role.Role;
import spm.Role.UserRoleAuthorizer;
import spm.session.MySession;

public class MyApp extends WebApplication{
	public Class getHomePage(){
		return Login.class;
	}
		
	public Session newSession(Request request, Response response) {
		return new MySession(MyApp.this, request);
	}
	
	public void init(){
		super.init();
		getDebugSettings().setAjaxDebugModeEnabled(false);
		getSecuritySettings().setAuthorizationStrategy(new RoleAuthorizationStrategy(new UserRoleAuthorizer()));
	}
	
}
