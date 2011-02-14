package spm.Role;

import java.io.Serializable;

public class Role implements Serializable{
	
	public static String administrator = "Administrator";
	public static String productOwner = "Product Owner";
	public static String projectManager = "Project Manager";
	public static String projectMember = "Project Member";
	public static String scrumMaster = "Scrum Master";

	
	private String role_name;
	private int role_id;
	
	public Role(){}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String roleName) {
		role_name = roleName;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int roleId) {
		role_id = roleId;
	}
}

