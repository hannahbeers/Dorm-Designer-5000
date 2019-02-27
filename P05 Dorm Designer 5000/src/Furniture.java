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

public class Furniture implements DormGUI {
	
	private PApplet processing;
	private PImage image;
	private float[] position;
	private boolean isDragging;
	private int rotations = 0;
	private boolean didRotate = false;
	private String furnitureType = null;
	
	// initializes the fields of a new bed object positioned in the center of the display
	//
	//@param type - type of furniture
	//@param PApplet processing
	//@throws exception if image not found
	public Furniture(String type, PApplet processing) {
		this.processing = processing;
		furnitureType = type;
		try {
		image = processing.loadImage("images/" + type + ".png");
		position = new float[2];
		position[0] = processing.width/2;
		position[1] = processing.height/2;
		}
		catch(Exception e) {
			System.out.println("WARNING: Could not find an image for a furniture object of type: " + type);
		}
	}
	
	//overloaded Furniture constructor
	//
	//@param type - type of furniture
	//@param xPos - x position
	//@param yPos - y position
	//@param roatations - number of rotations
	//@param PApplet processing
	public Furniture(String type, float xPos, float yPos, int rotations, PApplet processing) {
		this.processing = processing;
		this.furnitureType = type;
		try {
		this.image = processing.loadImage("images/" + type + ".png");
		}
		catch(Exception e) {
			System.out.println("WARNING: Could not find an image for a furniture object of type: " + type);
		}
		this.position = new float[2];
		this.position[0] = xPos;
		this.position[1] = yPos;
		int w = 0;
		while(w < rotations) {
		this.rotate();
		w++;
		}
	}
	
	// draws this bed at its current position
	//
	//@see DormGUI#update()
	public void update() {
		 if(isDragging == true) {
			 position[0] = processing.mouseX;
			 position[1] = processing.mouseY;
		 }
		 if(didRotate == true) {
			 processing.image(image, position[0], position[1], rotations*PApplet.PI/2);
		 }
		 else {
			 processing.image(image, position[0], position[1]);
		 }
	}
	
	// used to start dragging the bed, when the mouse is over this bed when it is pressed
	//
	//@param furniture - furniture array
	public void mouseDown(Furniture[] furniture) { 
		for (int i = 0; i < position.length; i++) {	
	        if(position != null){
	        	// checks if mouse is within bounds of bed image
	        	if(processing.mouseX <= (position[0] + (image.width/2))  &&
	    				processing.mouseX >= (position[0] - (image.width/2)) &&
	    						processing.mouseY <= (position[1] + (image.height/2)) &&
	    								processing.mouseY >= (position[1] - (image.height/2))) {
    		     	isDragging = true;
	        }
		}
		}
	}
	
	// used to indicate that the bed is no longer being dragged
	//
	//@see DormGUI#mouseUp()
	public void mouseUp() {
		isDragging = false;
	}
	
	// helper method to determine whether the mouse is currently over this bed
	//
	//@return true if mouse is over object
	//@return false if mouse is not over object
	public boolean isMouseOver() {
	   	if(processing.mouseX <= (position[0] + (image.width/2))  &&
				processing.mouseX >= (position[0] - (image.width/2)) &&
						processing.mouseY <= (position[1] + (image.height/2)) &&
								processing.mouseY >= (position[1] - (image.height/2))) {
	     	return true;
    }
	   	else {
	   		return false;
	   	}
	}
	
	// rotates the bed
	//
	//@return void
	public void rotate() {
		rotations++;
		didRotate = true;
	}
	
	// gets type of furniture
	//
	//@return type of furniture
	public String getType(){
 		return furnitureType;
 }
	
	// gets x position of furniture
	//
	//@return x position
	public float getXPosition(){
		return position[0];
}
	
	// gets y position of furniture
	//
	//@return y position
	public float getYPosition() {
		return position[1];
}
	
	// gets number of rotations of furniture
	//
	//@return number of rotations
    public int getRotations(){
    		return rotations;
    }
}
