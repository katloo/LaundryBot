package Vision.EdgeDetection;

import javax.swing.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;

import april.jcam.*;
import april.util.*;
import april.jmat.*;


public class EdgeDetectorMain {

    public static void main(String[] args) {

            JFrame jf = new JFrame ("edge detector");
            JImage jim = new JImage();

            jim.setFit(true);
            jf.setLayout(new BorderLayout());
            jf.add(jim, BorderLayout.CENTER);
            jf.setSize(1024, 768);
            jf.setVisible(true);
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            ArrayList<String> urls = ImageSource.getCameraURLs();

            String url = null;
            if (urls.size()==1)
                    url = urls.get(0);

            if (args.length > 0)
                    url = args[0];

            if (url == null) {
                System.out.printf("Cameras found:\n");
                for (String u : urls)
                        System.out.printf("  %s\n", u);
                System.out.printf("Please specify one on the command line.\n");
                return;
            }
            ImageSource is;
            ImageSourceFormat fmt;
            try {
                is = ImageSource.make(url);
                is.start();
                fmt = is.getCurrentFormat();
                while (true) {

                    byte buf[] = is.getFrame().data;
                    BufferedImage im = ImageConvert.convertToImage(fmt.format, fmt.width, fmt.height, buf);

                    CannyEdgeDetector detector = new CannyEdgeDetector();
                    detector.setLowThreshold(0.5f);
                    detector.setHighThreshold(1f);
                    detector.setSourceImage(im);
                    detector.process();
                    BufferedImage edges = detector.getEdgesImage();
                    jim.setImage(im);
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
}
