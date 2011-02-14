package spm.Role;

import org.apache.wicket.Session;
import org.apache.wicket.authorization.strategies.role.IRoleCheckingStrategy;
import org.apache.wicket.authorization.strategies.role.Roles;

import spm.admin.Log;
import spm.lookup.Lookup;
import spm.session.MySession;
import spm.user.User;

public class UserRoleAuthorizer implements IRoleCheckingStrategy{

	public UserRoleAuthorizer()
    {
    }

	public boolean hasAnyRole(Roles roles)
    {
		MySession authSession = (MySession)Session.get();
		
		boolean result = authSession.getUserLoggedRoles().hasAnyRole(roles);
		
		if(!result){
			Lookup lookup2 = Lookup.AllLookupStatus();
			User usr = authSession.getLoggedUser();
			String file = lookup2.getLog_file_used();
			String logMessage = "WARNING! User with Account: " + User.displayAccountId(usr.getUser_id()) + " tried to access a restricted page ("+roles.toString()+ " page)";
			Log.loggedAction(lookup2.isLog_enabled(), file, logMessage);
		}
			
		return result;
    }

}
