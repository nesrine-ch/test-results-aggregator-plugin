package com.jenkins.testresultsaggregator.reporter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.List;

import org.apache.commons.jelly.JellyContext;
import org.apache.commons.jelly.XMLOutput;

import com.jenkins.testresultsaggregator.data.Aggregated;
import com.jenkins.testresultsaggregator.helper.Colors;
import com.jenkins.testresultsaggregator.helper.Helper;
import com.jenkins.testresultsaggregator.helper.LocalMessages;

import hudson.FilePath;

public class HTMLReporter {
	
	private static final String OVERVIEW_FILE = "index.html";
	private static final String FOLDER = "html";
	private static final String REPORT = "htmlreport.jelly";
	private PrintStream logger;
	private FilePath workspace;
	
	public HTMLReporter(PrintStream logger, FilePath workspace) {
		this.logger = logger;
		this.workspace = workspace;
	}
	
	public String createOverview(Aggregated aggregated, List<LocalMessages> columns, String theme, boolean showGroups) {
		try {
			logger.print(LocalMessages.GENERATE.toString() + " " + LocalMessages.HTML_REPORT.toString());
			File directory = Helper.createFolder(workspace, FOLDER);
			String file = directory + System.getProperty("file.separator") + OVERVIEW_FILE;
			OutputStream output = new FileOutputStream(file);
			JellyContext context = new JellyContext();
			// Variables
			context.setVariable("name", "Test Result Aggregator");
			context.setVariable("showGroups", showGroups);
			context.setVariable("columns", columns);
			context.setVariable("aggregated", aggregated);
			// Themes light and dark
			context.setVariable("theme", theme);
			// Header & footer color
			context.setVariable("headerColor", Colors.htmlHEADER());
			context.setVariable("footerColor", Colors.htmlFOOTER());
			context.setVariable("footerTextColor", Colors.htmlFOOTERTEXT());
			// Line Seperator color
			context.setVariable("lineSeperatorcolor", Colors.htmlLINESEPERATOR());
			XMLOutput xmlOutput = XMLOutput.createXMLOutput(output);
			URL template = HTMLReporter.class.getResource("/" + REPORT);
			JellyContext jellyContext = context.runScript(template, xmlOutput);
			xmlOutput.endDocument();
			xmlOutput.flush();
			output.close();
			xmlOutput.close();
			jellyContext.clear();
			logger.println(LocalMessages.FINISHED.toString() + " " + LocalMessages.HTML_REPORT.toString());
			return file;
		} catch (Exception e) {
			logger.println("");
			logger.printf(LocalMessages.ERROR_OCCURRED.toString() + ": " + e.getMessage());
		}
		return null;
	}
	
}
