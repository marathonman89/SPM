package spm.admin;

import org.apache.wicket.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.authorization.strategies.role.metadata.MetaDataRoleAuthorizationStrategy;

import spm.Role.Role;

@AuthorizeInstantiation("Administrator")
public class Help extends Layout{
	public Help(){
		
	}
}
