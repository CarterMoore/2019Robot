package frc.robot;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// dt,x,y,position,velocity,acceleration,jerk,heading

public class MotionProfile {

    private double[][] leftPath, rightPath;
    private double[][] leftPathRev, rightPathRev;

    public MotionProfile(String name) {

        String leftFile = "/home/lvuser/deploy/paths" + name + ".left.pf1.csv";
        String rightFile = "/home/lvuser/deploy/paths" + name + ".right.pf1.csv";

        leftPath = getValues(leftFile, false);
        rightPath = getValues(rightFile, false);

        leftPathRev = getValues(rightFile, true); // Left side of robot becomes right side when moving in reverse
        rightPathRev = getValues(leftFile, true); // Same as above but opposite

    }

    private double[][] getValues(String path, boolean isReversed) {

        byte[] encoded = new byte[0];
        try {
            encoded = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String file = new String(encoded, Charset.defaultCharset());

        String[] lines = file.split("\n");
        String[][] entries = new String[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            entries[i] = lines[i].split(",");
        }

        double[][] values = new double[entries.length][entries[0].length];

        for (int i = 1; i < entries.length; i++) {
            values[i-1][0] = Double.parseDouble(entries[i][0]); // dt
            values[i-1][1] = isReversed ? -Double.parseDouble(entries[i][3]) : Double.parseDouble(entries[i][3]); // position
            values[i-1][2] = isReversed ? -Double.parseDouble(entries[i][4]) : Double.parseDouble(entries[i][4]); // velocity
        }
        return values;
    }

    public double[][] getLeftPath() {
        return leftPath;
    }

    public double[][] getRightPath() {
        return rightPath;
    }

    public double[][] getLeftPathRev() {
        return leftPathRev;
    }

    public double[][] getRightPathRev() {
        return rightPathRev;
    }
}
