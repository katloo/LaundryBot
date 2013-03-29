package Vision.CornerDetection;

import java.awt.Graphics;
import java.awt.image.*;
import java.awt.Point;
import java.util.*;

public class CornerDetectionDetector {

    // args
    // input
    private BufferedImage im;
    private BufferedImage im_gray;
    private int threshold;
    
    // params
    private int xsize;
    private int ysize;
    
    // output
    private ArrayList<Point> c;
    
    // FAST Detection Parameters
    private static final int splat_subtree = 1;
    private static final int corner_pointers = 2;
    private static final int force_first_question = 0;
    private static final int corner_type = 9;
    private static final int barrier = 25;
    
    
    
    // CONSTRUCTOR METHOD
    public CornerDetectionDetector() {
        // NULL CONSTRUCTOR
        
    }
    
    // IMPLEMENTATION METHOD
    // FAST CORNER DETECTION (9 POINT)
    //      By: Edward Rosten
    //
    public ArrayList<Point> FASTDetection(BufferedImage im, int thresh) {
        // init params
        this.im = im;
        this.threshold = thresh;
        this.xsize = im.getWidth();
        this.ysize = im.getHeight();
        
        this.c = new ArrayList<Point>();
        
        // grayscale image
        this.im_gray = new BufferedImage(xsize, ysize, BufferedImage.TYPE_BYTE_GRAY);
        Graphics g = im_gray.getGraphics();
        g.drawImage(im, 0, 0, null);
        g.dispose();
        
        // image traversal
        imageTraverse();
        
        // non max suppression
        nonmax_suppression();
        
        // return center points
        return c;
    }
    
    
    // PROTECTED HELPER FUNCTIONS
    // IMAGE TRAVERSAL
    protected void imageTraverse() {
        // put pixels into array
        byte[] data = ((DataBufferByte) im_gray.getRaster().getDataBuffer()).getData();
        System.out.println(data.length);
        
        /*
        // traverse image
        for (int x = 4; x < xsize - 3; x++) {
            for (int y = 4; y < ysize - 3; y++) {
                int cb = data[x + y*xsize];
            }
        }
        */
        
    }
    
    // NON MAX SUPPRESSION
    protected void nonmax_suppression() {
        
    }
    
    // ACCESS METHODS
    public BufferedImage getGrayscale() {
        return im_gray;
    }



}