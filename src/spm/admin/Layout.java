package spm.admin;

import org.apache.wicket.authorization.strategies.role.annotations.AuthorizeInstantiation;

import spm.index.Home;

@AuthorizeInstantiation("Administrator")
public class Layout extends Home{
	public Layout(){
	}
}

