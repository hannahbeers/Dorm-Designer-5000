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

// parent class for all Button classes
public class Button implements DormGUI {
	
	private static final int WIDTH = 96;
	private static final int HEIGHT = 32;
	protected PApplet processing;
	private float[] position;
	protected String label;

	// constructor for Button class
	//
	//@param x - x position
	//@param y - y position
	//@param PApplet processing
	public Button(float x, float y, PApplet processing) {
		this.processing = processing;
		this.position = new float[2];
		this.position[0] = x;
		this.position[1] = y;
		this.label = "Button";
	}
	 
	// update GUI images
	//
	//@see DormGUI#update()
	public void update() {
		if(isMouseOver()) {
			processing.fill(100);
		}
		else {
			processing.fill(200);
		}
		processing.rect(position[0] - (WIDTH/2), position[1] - (HEIGHT/2), position[0] + (WIDTH/2), position[1] + (HEIGHT/2));
		processing.fill(0);
		
		if(position[0] == 50 || position[0] == 150 || position[0] == 250 || position[0] == 350 || position[0] == 450) {
			processing.text("Create "+label.substring(0,1).toUpperCase()+label.substring(1), position[0], position[1]);
		}
		else if(position[0] == 550){
			processing.text("Clear Room", position[0], position[1]);
		}
		else if(position[0] == 650){
			processing.text("Save Room", position[0], position[1]);
		}
		else if(position[0] == 750){
			processing.text("Load Room", position[0], position[1]);
		}
	}
	
	// checks if mouse clicked
	//
	//@see DormGUI#mouseDown()
	public void mouseDown(Furniture[] furniture) {
		for(int i = 0; i < furniture.length; i++) {
			if(furniture[i] == null) {
				furniture[i] = new Furniture(label, processing);
				break;
			}
		}
	}
	
	// checks if mouse is up (not used)
	//
	//@see DormGUI#mouseUp()
	public void mouseUp() {}
	
	// checks if mouse is over an object
	//
	//@see DormGUI#isMouseOver()
	//@returns true if mouse is over object
	//@returns false if mouse is not over object
	public boolean isMouseOver() {
		if(processing.mouseX <= (position[0] + (WIDTH/2))  &&
				processing.mouseX >= (position[0] - (WIDTH/2)) &&
				processing.mouseY <= (position[1] + (HEIGHT/2)) &&
						processing.mouseY >= (position[1] - (HEIGHT/2))){
							return true;
						}
		else {
				return false;
		}
	}
}
