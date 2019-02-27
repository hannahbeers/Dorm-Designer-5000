//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P05 Dorm Designer 5000
// Files:           Main.java
// Course:          Comp Sci 300, Spring Semester 2018
//
// Author:          Hananh Beers
// Email:           hlbeers@wisc.edu
// Lecturer's Name: Professor Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    No partner!
// 
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates 
// strangers, etc do.  If you received no outside help from either type of 
// source, then please explicitly indicate NONE.
//
// Persons:         None
// Online Sources:  None
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

// load button class
public class LoadButton extends Button implements DormGUI {
	private static final int WIDTH = 96;
	private static final int HEIGHT = 32;
	private PApplet processing;
	private float[] position;
	private String label;
	
	// constructor for load button class
	//
	//@param x - x position
	//@param y - y position
	//@param PApplet processing
	public LoadButton(float x, float y, PApplet processing) {
		super(x, y, processing);
	}

	// checks if mouse is being clicked
	//
	//@param furniture - array of furniture
	//@see DormGUI#mouseDown()
	public void mouseDown(Furniture furniture[]) {
		try{
			File f = new File("RoomData.ddd");
			 BufferedReader br = new BufferedReader(new FileReader("RoomData.ddd"));
			 String line = null;
			 String [] words = new String [furniture.length*4];
			 int i = 0;
			try { 
				while ((line = br.readLine()) != null) {
					if(line.length() > 0) {
					words = line.split(",|\\:");	
					words[0] = words[0].trim();
					words[1] = words[1].trim();
					words[2] = words[2].trim();
					words[3] = words[3].trim();
					String type = words[0].trim();
					float xPos = Float.parseFloat(words[1]);
					float yPos = Float.parseFloat(words[2]);
					int rotations = Integer.parseInt(words[3]);
					furniture[i] = null;
					furniture[i] = new Furniture(type, xPos, yPos, rotations, processing);
					i++;
					}
			}
			}
			catch(Exception e) {
				System.out.println("“WARNING: Found incorrectly formatted line in file: " + (i+1));
			}
			 
		  	  br.close();
		}
		catch(Exception e) {
			System.out.println("WARNING: Could not load room contents from file RoomData.ddd.");
		}
	}
	
	// unused mouse up check
	//
	//@see DormGUI#mouseUp()
	public void mouseUp() {}
}
