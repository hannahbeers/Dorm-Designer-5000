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

// class that creates a new generic furniture button
public class CreateFurnitureButton extends Button implements DormGUI {

	// constructor for createFurnitureButton class
	//
	//@param type - type of furniture
	//@param x - x position
	//@param y - y position
	//@param PApplet processing
	public CreateFurnitureButton(String type, float x, float y, PApplet processing) {
		super(x, y, processing);
		label = type;
	}

	// checks if mouse is down
	//
	//@param furniture - array of furniture
	//@see DormGUI#mouseDown()
	public void mouseDown(Furniture[] furniture) {
		// adds new bed when button is clicked
		for(int i = 0; i < furniture.length; i++) {
			if(furniture[i] == null) {
				furniture[i] = new Furniture(label, processing);
				break;
				}
			}
		}
}

