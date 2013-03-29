package Vision.CornerDetection;

import javax.swing.*;
import java.util.ArrayList;
import java.lang.*;


public class CornerDetectionMain {    
    
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // create app frame
                CornerDetectionFrame frame = new CornerDetectionFrame();
                // build controller
                CornerDetectionController appController = new CornerDetectionController(frame);
                
            }
        });
    }
}
