package spm.lookup;

import java.io.Serializable;

public class Lookup implements Serializable{

	private String log_file_used;
	private Boolean log_enabled;
	
	public Lookup(){}

	public String getLog_file_used() {
		return log_file_used;
	}

	public void setLog_file_used(String logFileUsed) {
		log_file_used = logFileUsed;
	}

	public Boolean isLog_enabled() {
		return log_enabled;
	}

	public void setLog_enabled(Boolean logEnabled) {
		log_enabled = logEnabled;
	}
	
	/**Static methods or function**/

	public static Lookup AllLookupStatus(){
		LookupQuery query = new LookupQuery();
		return query.fetchData("getAllLookupStatus");
	}
	public static String LogFile(){
		LookupQuery query = new LookupQuery();
		return query.fetchDatum("LogFileName");
	}
}

