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

//DormGUI interface to reduce redundant code

public interface DormGUI {
	
	// updates GUI images
	//
	//@return void
	public void update();
	
	//checks if mouse is clicking any furniture piece
	//
	//@return void
	public void mouseDown(Furniture[] furniture);
	
	//checks if mouse is up
	//
	//@return void
	public void mouseUp();
	
	//checks if mouse is over an object
	//
	//@return true if mouse is over object
	//@return false if mouse is not over object
	public boolean isMouseOver();
	
}
