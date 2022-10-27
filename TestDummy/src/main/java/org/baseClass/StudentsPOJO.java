package org.baseClass;

public class StudentsPOJO {
	private String stdID;
	private String studName;
	private String mobileNo;
	private String average;
	private String cRank;
	
	
	
	public StudentsPOJO(String stdID, String studName, String mobileNo, String average, String cRank) {
		this.stdID = stdID;
		this.studName = studName;
		this.mobileNo = mobileNo;
		this.average = average;
		this.cRank= cRank;
	
		
	}
	public String getStdID() {
		return stdID;
	}
	public String getStudName() {
		return studName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public String getAverage() {
		return average;
	}
	
		
	public String getcRank() {
		return cRank;
	}
	
	
	public String toString() {
		return "ID: "+stdID+"\n"+
				"Name: "+studName+"\n"+
				"Mobile: "+mobileNo+"\n"+
				"Average: "+average+"\n"+
		        "Rank: "+cRank+"\n";
		
		
	}

	
	
}
