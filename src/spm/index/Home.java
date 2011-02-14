package spm.index;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.time.Duration;

import spm.user.User;
import spm.user.UserQuery;
import spm.Role.Role;
import spm.session.*;

public class Home extends Index{
	
	private Form form;
	private Model roleModel;
	private User usr;
	private Link home;
	private Link account;
	private Link logout;
	
	public Home(){
		usr = ((MySession)getSession()).getLoggedUser();
		
		List list = getRoles();
		String arrayOfRoles[] = new String[list.size()]; 
		for(int i = 0; i < list.size(); i++) arrayOfRoles[i] = (String)list.get(i);
		((MySession)getSession()).setUserLoggedRoles(new User(usr.getUser_id(), arrayOfRoles));
		//((MySession)getSession()).setUserLoggedRoles(new User(usr.getEmployee_id(), "Admission"));
		
		form = new Form("jumpTo");

		roleModel = new Model();
		final DropDownChoice choices = new DropDownChoice("choices", roleModel, getRoles());
		form.add(choices);
		add(form);
		choices.add(new AjaxFormComponentUpdatingBehavior("onchange")
        {
            @Override
            protected void onUpdate(AjaxRequestTarget target)
            {
            	String str = (String) roleModel.getObject();
                 if(str.equals(Role.administrator)){
                	 System.out.println("admin test");
                	 setResponsePage(spm.admin.Help.class);
                 } /*
                 if(str.equals(Role.productOwner)){
                	 System.out.println("product owner test");
                	 setResponsePage(spm.productOwner.Help.class);
                 }
                 if(str.equals(Role.projectManager)){
                	 System.out.println("project manager test");
                	 setResponsePage(spm.projectMember.Help.class);
                 }
                 if(str.equals(Role.projectMember)){
                	 System.out.println("projectMember test");
                	 setResponsePage(spm.projectMember.Help.class);
                 }
                 if(str.equals(Role.scrumMaster)){
                	 System.out.println("scrum master test");
                	 setResponsePage(spm.scrumMaster.Help.class);
                 }*/
            }
        });
		add(new Link("home"){
			public void onClick(){
				setResponsePage(spm.index.Home.class);
			}
		});
		add(new Link("account"){
			public void onClick(){
				this.setAutoEnable(true);
			}
		});
		add(new Link("logout") {
			public void onClick() {
			getSession().invalidate();
			setResponsePage(spm.index.Login.class);
			}});
	}
	
	public List getRoles(){
		UserQuery query = new UserQuery();
		List<User> tmp = query.fetchListOfData(usr, "getUserRoles");
		List roles = new ArrayList();
		
		for(int i = 0; i < tmp.size(); i++){
			roles.add(((User)tmp.get(i)).getRole_name());
		}
		return roles;
	}
	
	public void downloadFile(String URL, String file) throws MalformedURLException, IOException{
		java.io.BufferedInputStream in = new java.io.BufferedInputStream(new
		java.net.URL(URL).openStream());
		java.io.FileOutputStream fos = new java.io.FileOutputStream(file);
		java.io.BufferedOutputStream bout = new BufferedOutputStream(fos,1024);
		byte[] data = new byte[1024];
		int x=0;
		while((x=in.read(data,0,1024))>=0)
		{
		bout.write(data,0,x);
		}
		bout.close();
		in.close();
	}
	
}