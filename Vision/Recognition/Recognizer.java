package Vision.Recognition;

import java.util.*;
import java.awt.*;
import java.awt.geom.*;

public class Recognizer {
    private int MAX_POINTS = 100; // number of points on outline
    private int NUM_RADII = 5;
    private int NUM_THETAS = 12;
    // TODO: add HIGH, MEDIUM, LOW thresholds; depends on how points are aligned

    private Point[] tShirtModel; // will hold the set of points for the tShirt
    private Point[] clothModel; // will hold the set of points for the washcloth
    private double[] logDistances = {}; // 5 radiuses values to be hardcoded in
    private double[] thetas = {0, 30, 60, 90, 120, 150, 180,
                                210, 240, 270, 300, 330, 360};

    private Point[] curObject;
    private int[][][] histogram;

    Recognizer () {

        this.curObject = new Point[100];

    }

    public void recognizeObject(Point[] object)  {
        // object is a set of pixel points of the edges of the piece of clothing

        this.curObject = object;
        // for each point on the object, there are 12x5 "bins" holding
        // the number of points on object in each bin
        this.histogram = new int[MAX_POINTS][NUM_THETAS][NUM_RADII];

        calculateHistograms();

    }


    private void calculateHistograms() {



    }

    private void calculateCosts() {


    }

    private void matchGraph() {

    }


}
