package spm.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.wicket.authorization.strategies.role.Roles;

public class User implements Serializable{
	
	public static String ActiveAcct = "ACTIVE";
	public static String PendingAcct = "PENDING";
	public static String BlockAcct = "BLOCK";
	
	private int user_id;
	//private String username;
	private String fname;
	private String mname;
	private String lname;
	private String bdate;
	private String address; 
	private String password;
	private int role_id;
	private String role_name;
	//private int numOfEntry;
	private String acct_status;
	
	private Roles roles;
	
	public User(){}
	
	
	public User(int user_id){
		this.user_id = user_id;
	}
	
	public User(int user_id, String[] spmRoles){
		this.user_id = user_id;
		roles = new Roles(spmRoles);
	}
	
	public User(int user_id, String spmRoles){
		this.user_id = user_id;
		roles = new Roles(spmRoles);
	}
	
	public User(int user_id, String fname, String mname, String lname, String bdate,
			        String address, String password, String acct_status, int role_id){
		super();
		this.user_id = user_id;
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
		this.bdate = bdate;
		this.address = address;
		this.password = password;
		this.acct_status = acct_status;
		this.role_id = role_id;
	}

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int userId) {
		user_id = userId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int roleId) {
		role_id = roleId;
	}
	public String getRole_name(){
		return role_name;
	}
	public void setRole_name(String role_name){
		this.role_name = role_name;
	}

	public static String displayAccountId(int id){
		String str = Integer.toString(id);
		return str.substring(0,4)+"-"+str.substring(4, str.length());
	}
	public static List selectEntries(List list, int first, int count, final org.apache.wicket.extensions.markup.html.repeater.util.SortParam sortParam) {
		List sortedEntries = new ArrayList(list);
		if (sortParam != null) {
			if (sortParam.getProperty().equals("user_id")) {
				Collections.sort(sortedEntries, new Comparator() {
					public int compare(Object arg0, Object arg1) {
						User entry1 = (User) arg0;
						User entry2 = (User) arg1;
						int result = ((Integer)entry1.getUser_id()).compareTo((Integer)entry2.getUser_id());
					return sortParam.isAscending() ? result : -result;
				}
				});
			}
			if (sortParam.getProperty().equals("name")) {
				Collections.sort(sortedEntries, new Comparator() {
					public int compare(Object arg0, Object arg1) {
						User entry1 = (User) arg0;
						User entry2 = (User) arg1;
						int result = entry1.getLname().compareTo(entry2.getLname());
					return sortParam.isAscending() ? result : -result;
				}
				});
			}
			if (sortParam.getProperty().equals("acct_status")) {
				Collections.sort(sortedEntries, new Comparator() {
					public int compare(Object arg0, Object arg1) {
						User entry1 = (User) arg0;
						User entry2 = (User) arg1;
						int result = entry1.getAcct_status().compareTo(entry2.getAcct_status());
					return sortParam.isAscending() ? result : -result;
				}
				});
			}
		}
		return sortedEntries.subList(first, first + count);
		//return list.subList(first, first + count);
	}

	public String getAcct_status() {
		return acct_status;
	}

	public void setAcct_status(String acctStatus) {
		acct_status = acctStatus;
	}
	public boolean hasAnyRole(Roles roles)
    {
        return this.roles.hasAnyRole(roles);
    }
	
}

