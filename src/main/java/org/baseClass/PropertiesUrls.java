package org.baseClass;



public class PropertiesUrls extends BaseClass{
	
	
	public void stdUrlLaunch() {
		
		driver.get("http://maplogik.com/index.php/student/login");
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
				
			}
	
}
