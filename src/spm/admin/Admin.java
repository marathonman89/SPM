package spm.admin;

import org.apache.wicket.authorization.strategies.role.annotations.AuthorizeInstantiation;

import spm.index.Home;
import spm.session.MySession;
import spm.user.User;

@AuthorizeInstantiation("Administration")
public class Admin extends Home{
	
	public Admin(){

	}
}