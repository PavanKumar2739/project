package ExtendRepo;

import java.util.ArrayList;

import org.apache.poi.ss.usermodel.IndexedColors;

import java.util.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class logTheData {public static void main(String[] args) {
	ExtentReports exReports=new ExtentReports();
	ExtentSparkReporter sR=new ExtentSparkReporter("report3LogsInfo.html");
	exReports.attachReporter(sR);
	
	exReports.createTest("Test 1")
	.log(Status.INFO, "passed")
	.log(Status.INFO,"<i>info</i>")
	.log(Status.INFO,"<b>failed</b>")
	.log(Status.INFO, "<b><i>Skiped</i></b>");
	
	String xmlData="<book category=\"web\" cover=\"paperback\">\r\n"
			+ "    <title lang=\"en\">Learning XML</title>\r\n"
			+ "    <author>Erik T. Ray</author>\r\n"
			+ "    <year>2003</year>\r\n"
			+ "    <price>39.95</price>\r\n"
			+ "  </book>";
	
	String jsonFile="{\"type\": \"array\",\r\n"
			+ "    \"title\": \"Keybindings configuration\",\r\n"
			+ "    \"items\": {\r\n"
			+ "        \"type\": \"object\",\r\n"
			+ "        \"required\": [\"key\"],\r\n"
			+ "        \"defaultSnippets\": [\r\n"
			+ "            {\r\n"
			+ "                \"label\": \"New keybinding\",\r\n"
			+ "                \"description\": \"Binds a key to a command for a given state\",\r\n"
			+ "                \"body\": { \"key\": \"$1\", \"command\": \"$2\", \"when\": \"$3\" }\r\n"
			+ "            }\r\n"
			+ "        ],\r\n"
			+ "        \"properties\": {\r\n"
			+ "            \"key\": {\r\n"
			+ "                \"type\": \"string\"\r\n"
			+ "            }\r\n"
			+ "            ...\r\n"
			+ "        }\r\n"
			+ "    }\r\n"
			+ "}";
//	exReports.createTest("xml data")
//	.log(Status.INFO,xmlData);
	exReports.createTest("json data")
	.log(Status.INFO,jsonFile);
	
	exReports.createTest("xml data")
	.log(Status.INFO,MarkupHelper.createCodeBlock(xmlData,CodeLanguage.XML));
	exReports.createTest("json data")
	.log(Status.INFO,MarkupHelper.createCodeBlock(jsonFile,CodeLanguage.JSON));
	
	//list type of data
	List<String> list=new ArrayList<>();
	list.add("pavan");
	list.add("kumar");
	list.add("yadav");
	
	exReports.createTest("list unordered data")
	.info(MarkupHelper.createUnorderedList(list));
	
	exReports.createTest("list ordered data")
	.info(MarkupHelper.createOrderedList(list));
	
	exReports.createTest("hilights data")
	.info(MarkupHelper.createLabel("hilight message",ExtentColor.RED));
	
	try {
		int i=5/0;
	} catch (Exception e) {
		exReports.createTest("exception data")
		.info(e);
	}
	Throwable t= new RuntimeException("This is a custom exception");
	exReports.createTest("exception data2")
	.info(t);
	exReports.flush();
	
}


}
