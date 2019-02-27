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

// creates a clear button that sets all furniture to null

public class ClearButton extends Button{

	// constructor for ClearButton class
	//
	//@param x - x position
	//@param y - y position
	//@param PApplet processing
	public ClearButton(float x, float y, PApplet processing) {
		super(x, y, processing);
	}
	
	// if button is being clicked, set all furniture references to null
	//
	//@param furniture - array of furniture
	public void mouseDown(Furniture[] furniture) {
		for(int i = 0; i < furniture.length; i++) {
			furniture[i] = null;
		}
	}
}
