package spm.user;

import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;


import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class UserQuery implements Serializable{
	private Reader reader 			= null;
	private SqlMapClient sqlMap 	= null;
	public UserQuery() {}
	
	public User fetchData(User usr, String queryId){
		User result			= null;
		try{
			reader = Resources.getResourceAsReader("sqlMapConfig.xml");
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			result = (User)sqlMap.queryForObject(queryId, usr);
		}catch (IOException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public List<User> fetchListOfData(User usr, String queryId){
		List result			= null;
		try{
			reader = Resources.getResourceAsReader("sqlMapConfig.xml");
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			result = (List<User>)sqlMap.queryForList(queryId, usr);
		}catch (IOException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public String getStringOfData(User usr, String queryId){
		String result			= null;
		try{
			reader = Resources.getResourceAsReader("sqlMapConfig.xml");
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			result = (String)sqlMap.queryForObject(queryId, usr);
		}catch (IOException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public Integer getIntegerData(User usr, String queryId){
		Integer result			= null;
		try{
			reader = Resources.getResourceAsReader("sqlMapConfig.xml");
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			result = (Integer)sqlMap.queryForObject(queryId, usr);
		}catch (IOException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public List<User> getNoParamData(String queryId){
		List result			= null;
		try{
			reader = Resources.getResourceAsReader("sqlMapConfig.xml");
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			result = (List<User>)sqlMap.queryForList(queryId);
		}catch (IOException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public void insert(User usr, String queryId){
		try 
		{
			reader = Resources.getResourceAsReader("sqlMapConfig.xml");
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			sqlMap.insert(queryId, usr);
		}catch (IOException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void update(User usr, String queryId){
		try 
		{
			reader = Resources.getResourceAsReader("sqlMapConfig.xml");
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			sqlMap.update(queryId, usr);
		}catch (IOException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void remove(User usr, String queryId){
		try 
		{
			reader = Resources.getResourceAsReader("sqlMapConfig.xml");
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			sqlMap.delete(queryId, usr);
		}catch (IOException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
