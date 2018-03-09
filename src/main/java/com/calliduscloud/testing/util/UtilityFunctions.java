package com.calliduscloud.testing.util;

import java.io.File;
import java.io.FileFilter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.relevantcodes.extentreports.LogStatus;

public class UtilityFunctions {

	public static String get_ToDayDate()
	{
		SimpleDateFormat oDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date=new Date();
		return oDateFormat.format(date);	
	}	
	public static String generate_fldID(String fldLable)
	{
		//SimpleDateFormat oDateFormat = new SimpleDateFormat("MMddhhmmss");
		SimpleDateFormat oDateFormat = new SimpleDateFormat("MMddhhmmss");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String cTime=oDateFormat.format(timestamp);
		String fldID=fldLable+cTime;		
		return fldID;
	}

	public static String randomNumber(int maxValue, int minValue)
	{
		Random rand=new Random();
		int iRandNo=rand.nextInt((maxValue - minValue) + 1) + minValue;	
		return Integer.toString(iRandNo);
	}
	
	public static void deleteFolder(File folder) {
		File[] files = folder.listFiles();
		if(files!=null) { 
			for(File f: files) {
				if(f.isDirectory()) {
					deleteFolder(f);
				} else {
					f.delete();
				}
			}
		}
		
		

	}
	public static String lastFileModified(String dir) throws Exception {
		 
        Thread.sleep(10000);
        File fl = new File(dir);
        File[] files = fl.listFiles(new FileFilter() {         
               public boolean accept(File file) {
                     return file.isFile();
               }
        });
        long lastMod = Long.MIN_VALUE;
        File choice = null;
        for (File file : files) {
               if (file.lastModified() > lastMod) {
                     choice = file;
                     lastMod = file.lastModified();
               }
        }
        return choice.toString();
 }


}