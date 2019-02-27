import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

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

// declarations for main
public class Main {
	
	private PApplet processing;
	private PImage backgroundImage;
	private Furniture[] furniture;
	private CreateFurnitureButton bedButton;
	private CreateFurnitureButton sofaButton;
	private CreateFurnitureButton dresserButton;
	private CreateFurnitureButton deskButton;
	private CreateFurnitureButton sinkButton;
	private SaveButton saveButton;
	private LoadButton loadButton;
	private ClearButton clearButton;
	private ArrayList<DormGUI> guiObjects = new ArrayList <DormGUI>();
	
	public static void main (String[] args) {
		Utility.startApplication();
	}
	
	// constructor for Main class
	//
	//@param PApplet processing
	public Main(PApplet processing) {
		this.processing = processing;
		backgroundImage = processing.loadImage("images/background.png");
		this.furniture = new Furniture[6];
		this.bedButton = new CreateFurnitureButton("bed", 50, 24, processing);
		this.sofaButton = new CreateFurnitureButton("sofa", 150, 24, processing);
		this.dresserButton = new CreateFurnitureButton("dresser", 250, 24, processing);
		this.deskButton = new CreateFurnitureButton("desk", 350, 24, processing);
		this.sinkButton = new CreateFurnitureButton("sink", 450, 24, processing);
		this.saveButton = new SaveButton(650, 24, processing);
		this.loadButton = new LoadButton(750, 24, processing);
		this.clearButton = new ClearButton(550, 24, processing);
		guiObjects.add(bedButton);
		guiObjects.add(sofaButton);
		guiObjects.add(dresserButton);
		guiObjects.add(deskButton);
		guiObjects.add(sinkButton);
		guiObjects.add(saveButton);
		guiObjects.add(loadButton);
		guiObjects.add(clearButton);
	}
	
	// updates the GUI images
	//
	//@see DormGUI#update()
	public void update() {
		
    	processing.background(100,150,250);
	processing.image(backgroundImage, processing.width/2, processing.height/2);
	
	for(int i = 0; i < guiObjects.size(); i++) {
			guiObjects.get(i).update();
	}
	
    bedButton.update();
    sofaButton.update();
    saveButton.update();
    loadButton.update();
    clearButton.update();
    
	}
	
	// checks to see if the mouse is being clicked
	//
	//@see DormGUI#mouseDown()
	public void mouseDown(){
		Furniture[] furniture = extractFurnitureFromGUIObjects();
		for (int i = 0; i < guiObjects.size(); i++) {
			if(guiObjects.get(i).isMouseOver()){
				guiObjects.get(i).mouseDown(furniture);
				break;
			}
		}
		replaceFurnitureInGUIObjects(furniture);
	}
	
	// checks if the mouse is not down
	//
	//@see DormGUI#mouseUp()
	public void mouseUp() {
		for (int i = 0; i < guiObjects.size(); i++) {
			if(guiObjects.get(i).isMouseOver()){
				guiObjects.get(i).mouseUp();
				break;
			}
		}
	}
	
	// checks if d or r has been pressed
	//
	//@return void
	public void keyPressed() {
		// deletes a bed when d is pressed
	    if(processing.key == 'd' || processing.key == 'D') {
	         for(int i = 0; i < guiObjects.size(); i++) {
	            	if(guiObjects.get(i).isMouseOver()){
	            		if(guiObjects.get(i) instanceof Furniture) {
	            			guiObjects.remove(i--);
	            			break;
	            		}
			    }
			}
		}
		// rotates a bed when r is pressed
		if(processing.key == 'r' || processing.key == 'R') {
			 for(int i = 0; i < guiObjects.size(); i++) {
	            	if(guiObjects.get(i).isMouseOver()){
	            		if(guiObjects.get(i) instanceof Furniture) {
	            			Furniture temp = (Furniture) guiObjects.get(i);
	            			temp.rotate();
	            			break;
					}
				}
		    }
	    }
	}
	
	// Max number of furniture that LoadButton will be allowed to load at once.    
		private final static int MAX_LOAD_FURNITURE = 100;        
		/**
		 * This method creates a new Furniture[] for the old mouseDown() methods
		 * to make use of.  It does so by copying all Furniture references from
		 * this.guiObjects into a temporary array of size MAX_LOAD_FURNITURE.
		 * @return that array of Furniture references.
		 */
		private Furniture[] extractFurnitureFromGUIObjects() {
		    Furniture[] furniture = new Furniture[MAX_LOAD_FURNITURE];
		    int nextFreeIndex = 0;
		    for(int i=0;i<guiObjects.size() && nextFreeIndex < furniture.length;i++)
		        if(guiObjects.get(i) instanceof Furniture)
		            furniture[nextFreeIndex++] = (Furniture)guiObjects.get(i);        
		    return furniture;        
		}    
		/**
		 * This method first removes all Furniture references from this.guiObjects,
		 * and then adds back in all of the non-null references from it's parameter.
		 * @param furniture contains the only furniture that will be left in 
		 *   this.guiObjects after this method is invoked (null references ignored).
		 */
		private void replaceFurnitureInGUIObjects(Furniture[] furniture) {
		    for(int i=0;i<guiObjects.size();i++)
		        if(guiObjects.get(i) instanceof Furniture)
		            guiObjects.remove(i--);
		    for(int i=0;i<furniture.length;i++)
		        if(furniture[i] != null)
		            guiObjects.add(furniture[i]);
		}
	
}


