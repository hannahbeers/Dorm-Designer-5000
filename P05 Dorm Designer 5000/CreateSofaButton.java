
public class CreateSofaButton extends Button implements DormGUI {

	private static final int WIDTH = 96;
	private static final int HEIGHT = 32;

	private PApplet processing;
	private float[] position;
	private String label;
 
	public CreateSofaButton(float x, float y, PApplet processing) {
		super(x, y, processing, "Create Sofa");
	}
	public void update() {
		super.update();
		//processing.text("Create Sofa", 150, 24);
	}
	public void mouseDown(Furniture[] furniture) {
		// adds new bed when button is clicked
		if(isMouseOver() == true) {
			for(int i = 0; i < furniture.length; i++) {
				if(furniture[i] == null) {
					furniture[i] = new Furniture("sofa", processing);
					break;
				}
			}
		    }
	}
   // After step 10, this method will instead return Furniture	
	public boolean isMouseOver() {
		return super.isMouseOver();
	}
	
	public void mouseUp() {}
}
