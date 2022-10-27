package org.baseClass;

public class StudPOJO {
	private String stdID;
	private String stdName;
	private String mobNo;
	private String cRank;
	private String dRank;
	private String sRank;
	
	
	
	public StudPOJO(String stdID, String stdName, String mobNo, String cRank, String dRank, String sRank) {
		this.stdID = stdID;
		this.stdName = stdName;
		this.mobNo = mobNo;
		this.cRank= cRank;
		this.dRank= dRank;
		this.sRank= sRank;
	
		
	}
	public String getStdID() {
		return stdID;
	}
	public String getStdName() {
		return stdName;
	}
	public String getMobNo() {
		return mobNo;
	}
				
	public String getcRank() {
		return cRank;
	}
	
	public String getdRank() {
		return dRank;
	}
	
	public String getsRank() {
		return sRank;
	}
	
	public String toString() {
		return "ID: "+stdID+"\n"+
				"Name: "+stdName+"\n"+
				"Mobile: "+mobNo+"\n"+
				"cRank: "+cRank+"\n"+
				"dRank: "+dRank+"\n"+
		        "sRank: "+sRank+"\n";
			
	}

	
	
}
