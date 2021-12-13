
/**
 * Draw a pretty picture composed of shape objects on a canvas
 * 
 * @author: (Your name)
 * @version: (Date)
 * 
 */
import java.io.File;
import java.io.IOException;

public class Picture {
    public static void main(String[] args) {
        // Get a reference to the canvas for this drawing
        Canvas pic = Canvas.getCanvas();

        // Set the title and background for the picture
        pic.setTitle("Ducky by Grant");
        pic.setBackgroundColor("cyan");

        // Draw my picture
        
        //making the ground
        Arc arc1 = new Arc();
        arc1.makeVisible();
        arc1.changeArcBeginning(0);
        arc1.changeArcEnd(180);
        boolean work = true;
        arc1.setX(-500);
        arc1.setY(550);
        arc1.changeSize(1600);
        arc1.changeColor("#008000");
        
        //making the grass
        boolean first = true;
        int move = 0;
        
        Triangle[] grass = new Triangle[24]; 
            for(int i=0; i<24; i++) 
            {
                grass[i] = new Triangle();
                grass[i].makeVisible();
                
                move = i;
                while (move > 0)
                {
                    grass[i].moveRight();
                    move--;
                }
                
            }
        
        //making sun
        Arc sun = new Arc(-100, -100, 200, 270, 360, "yellow", true);
        
        //making duckbody & duckhead
        Circle duckBody = new Circle(); 
        duckBody.changeColor("yellow");
        duckBody.changeSize(150);
        duckBody.makeVisible();
        duckBody.moveHorizontal(230);
        duckBody.moveVertical(410);
        
        Circle duckHead = new Circle();
        duckHead.changeColor("yellow");
        duckHead.changeSize(100);
        duckHead.makeVisible();
        duckHead.moveHorizontal(310);
        duckHead.moveVertical(350);
        
        //making beak
        Triangle beak = new Triangle();
        beak.changeColor("#FFA500");
        beak.changeSize(20, 60);
        beak.moveHorizontal(400);
        beak.moveVertical(-190);
        beak.makeVisible();
        
        Arc beakB = new Arc(350, 370, 60, 270, 90, "yellow", true);
        boolean doneBeak = true;
        
        //making duck eyes
        if (doneBeak)
        {
            Circle duckEye = new Circle();
            duckEye.changeColor("white");
            duckEye.changeSize(30);
            duckEye.makeVisible();
            duckEye.moveHorizontal(360);
            duckEye.moveVertical(360);
            
            Rect duckPupil = new Rect();
            duckPupil.changeColor("black");
            duckPupil.makeVisible();
            duckPupil.moveHorizontal(365);
            duckPupil.moveVertical(372);
        }   
        
        //making wing
        Triangle wing = new Triangle();
        wing.moveHorizontal(295);
        wing.moveVertical(-140);
        wing.changeColor("#FFFF90");
        wing.makeVisible();
        
        
        
        
                
                
                
            
        

        // Get the filename to save to from the command line arguments, defaulting to
        // MyPicture.png if no argument is given
        String filename;
        if (args.length > 0 && args[0] != null && !args[0].isEmpty()) {
            filename = args[0];
        }
        else {
            filename = "MyPicture.png";
        }

        // Save the picture to a file
        try {
            pic.saveToFile(new File(filename));
            System.out.println("Picture saved to " + filename);
        } catch (IOException e) {
            System.err.println(e);
            System.err.println("Could not save file.");
        }
    }
}