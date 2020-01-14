package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight {

    private NetworkTable table;

    public Limelight(int pipeline) {
        table = NetworkTableInstance.getDefault().getTable("limelight");
        setEntry("pipeline", pipeline);
    }

    public double getEntry(String key) {
        return table.getEntry(key).getDouble(0);
    }

    public void setEntry(String key, int value) {
        table.getEntry(key).setNumber((byte)value);
    }
}
