package com.rw.finance.common.pass.yeepay2.agent;

import java.util.ResourceBundle;

public class Config {
     public static Object object=new Object();
     public static Config config=null;
     public static ResourceBundle  rb=null; 
     public static final String  File_Name="com/rw/finance/common/pass/yeepay2/config/merchantInfo-agent";
   
     public Config(){
    	    rb=ResourceBundle.getBundle(File_Name);
     }
     
     public static Config getInstance(){
    	 synchronized(object){
    		 if(config==null){
    			 config=new Config();
    		 }
    		 return config;
    	 }
		
    	 
     }
     
 	public String getValue(String key) {
		return (rb.getString(key));
	}
 	
 	/*public static void main(String[] args) {
    	System.out.println(Config.getInstance().getValue("customerNumber"));
    	System.out.println(Config.getInstance().getValue("groupNumber"));
     }*/
}
