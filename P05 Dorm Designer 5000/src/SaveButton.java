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

import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;

// creates a save button
public class SaveButton extends Button implements DormGUI {
	private static final int WIDTH = 96;
	private static final int HEIGHT = 32; 
	private PApplet processing;
	private float[] position;
	private String label;

	// constructor for save button class
	//
	//@param x - x position
	//@param y - y position
	//@param PApplet processing
	public SaveButton(float x, float y, PApplet processing) {
		super(x, y, processing);
	}

	 // checks if mouse is over this object
	//
	//@see DormGUI#mouseOver()
	//@return true if mouse is over object
	//@return false if mouse is not over object
	public boolean isMouseOver() {
		return super.isMouseOver();
	}
	
	//checks if mouse is clicked
	//
	//@param furniture - furniture array
	//@see DormGUI#mouseDown()
	public void mouseDown(Furniture furniture[]) {
		try {
	  	    File f = new File("RoomData.ddd");
	  	    int newLength = 0;
	  	    PrintWriter pw = new PrintWriter("RoomData.ddd");
	  	  for(int i = 0; i < furniture.length; i++) {
	  		  if(furniture[i] != null) {
	  			  newLength++;
	  		  }
	  	  }
	  	  for(int i = 0; i < newLength; i++) {
	  	    pw.write((furniture[i].getType()).trim() + ": ");
	  	    pw.write((Float.toString(furniture[i].getXPosition())).trim() + ", ");
	  	    pw.write((Float.toString(furniture[i].getYPosition())).trim() + ", ");
	  	    pw.write(furniture[i].getRotations() + "\n");
	  	  }
	  	  pw.close();
		}
		catch(Exception e) {
			System.out.println("WARNING: Could not save room contents from file RoomData.ddd.");
		}
	}
	
	//unused mouse up check
	//
	//@see DormGUI#mouseUp()
	public void mouseUp() {}
}
