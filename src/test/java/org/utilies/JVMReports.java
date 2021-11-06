package org.utilies;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JVMReports {
	public static void generateTheJVMReport(String Jsonpath) {
		// 1.create a folder for storing report in org.utilities
		File f = new File(System.getProperty("user.dir") + "\\target\\Report");

		// 2.Add details to the report
//		Configuration con = new Configuration(f, "FB");
//		con.addClassifications("Browser", "Chrome");
//		con.addClassifications("Browser", "version 95");
//		con.addClassifications("Platform", "Windows");

		Configuration con = new Configuration(f, "Facebook");
		con.addClassifications("Browser", "Sathischrome");
		con.addClassifications("Browser", "Version 104");
		con.addClassifications("Platform", "Linux");
		
		
//		//3.Add the json filepath to a List
//		List<String> li=new ArrayList<String>();
//		li.add(Jsonpath);
		
		List<String> li = new ArrayList<String>();
		li.add(Jsonpath);
		//4.Create an object for reportBuild file
		
//		ReportBuilder r=new ReportBuilder(li, con);
//		r.generateReports();
		ReportBuilder r = new ReportBuilder(li, con);
		r.generateReports();

	}

}
