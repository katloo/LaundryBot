package Vision.CornerDetection;

import DataTypes.*;

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
    private ArrayList<FeaturePoint> c;
    
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
    // FAST CORNER DETECTION (12 POINT)
    //      By: Edward Rosten
    //
    public ArrayList<FeaturePoint> FASTDetection(BufferedImage im, int thresh) {
        // init params
        this.im = im;
        this.threshold = thresh;
        this.xsize = im.getWidth();
        this.ysize = im.getHeight();
        
        this.c = new ArrayList<FeaturePoint>();
        
        // grayscale image
        this.im_gray = new BufferedImage(xsize, ysize, BufferedImage.TYPE_BYTE_GRAY);
        Graphics g = im_gray.getGraphics();
        g.drawImage(im, 0, 0, null);
        g.dispose();
        
        // retrieve pixel matrix
        byte[] data = ((DataBufferByte) im_gray.getRaster().getDataBuffer()).getData();
        int[][] im_mat = new int[xsize][ysize];
        for (int j = 0; j < ysize; j++) {
            for (int i = 0; i < xsize; i++) {
                im_mat[i][j] = data[i + j*xsize];
            }
        }
        
        // fast12 detection
        c = Fast12.detect(im_mat, xsize, ysize, thresh);
        
        // return center points
        return c;
    }

    
    // ACCESS METHODS
    public BufferedImage getGrayscale() {
        return im_gray;
    }



}