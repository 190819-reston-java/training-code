package com.revature;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class App {
	
	private static int optionNotRecognizedCounter = 0;
	private static int wordProcessorFileErrorCounter = 0;
	
	private static Scanner sc = new Scanner(System.in);

	// make sure the logs from this class are associated with this class
	public static Logger logger = Logger.getLogger(App.class);
	
	public static void main(String[] args) {
		
		menu();
		

	}

	private static void menu() {
		logger.info("Menu started");
		System.out.println("Welcome to _____ App!");
		System.out.println("Please choose an option:");
		System.out.println("1 - Word Processor");
		System.out.println("2 - Something Else");
		System.out.println("3 - Exit");
		
		String usersOption = sc.nextLine();
		logger.debug("Received user input: " + usersOption);
		switch(usersOption) {
		case "1":
			wordProcessor();
			break;
		case "2":
			System.out.println("Something else should go here");
			break;
		case "3":
			System.out.println("Thanks, bye!");
			System.exit(0);
		default:
			System.out.println("Option not recognized");
			optionNotRecognizedCounter++;
			logger.debug(usersOption + " was not recognized.");
			logger.debug("This has occurred " + optionNotRecognizedCounter + " times.");
			
			if(optionNotRecognizedCounter > 10) {
				logger.fatal("Failed to recognize option 10 times, exiting");
				System.exit(1);
			}
			
			break;
		}
		menu();
		
		
	}

	private static void wordProcessor() {
		System.out.println("Please write your filename:");
		
		String proposedFileName = sc.nextLine();
		
		logger.debug("Recevied user input: " + proposedFileName);
		
		Path p;
		try {
			//abstract factory design pattern:
			p = Files.createFile(Paths.get(proposedFileName));
		} catch (IOException e) {
			wordProcessorFileErrorCounter++;
			logger.error("File Creation Failed", e);
			logger.debug("File creation has failed this many times: " + wordProcessorFileErrorCounter);
			logger.info("Problem encountered. Restarting word processor method");
			
			if (wordProcessorFileErrorCounter > 5) {
				logger.fatal("File creation has failed >5 times", e);
				System.exit(1);
			}
			
			wordProcessor();
			
			return; // just stops this iteration of the method
		}
		
		logger.info("File successfully created: " + p);
		
		System.out.println("OK, file created!  Type away.");
		System.out.println("Use 'STOP!' to stop.");
		
		//writing line-by-line -- could be more efficient with a BufferedWriter
		while(sc.hasNext()) {
			String nextLine = sc.nextLine();
			if(nextLine.equals("STOP!")) {
				break;
			}
			// Collections is a utility class
			// singleton is a set with only one element
			// the options provided say how we interact with the file
			// StandardOpenOption is an example of an enum:
			//	an enum just being a fixed set of options
			try {
				Files.write(p, Collections.singleton(nextLine), StandardOpenOption.APPEND);
			} catch (IOException e) {
				logger.fatal("Writing to file failed, exiting.", e);
			}
			logger.trace("Wrote line to file: " + nextLine);
		}
		logger.info("All lines written to file successfully, exiting.");
		
	}

}
