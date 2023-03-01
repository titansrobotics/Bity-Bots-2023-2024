package frc.robot;

import edu.wpi.first.wpilibj.Encoder;

public class Autonomous {
    private static Encoder driveEncoder = new Encoder(0,1);
    private static int ppr = 2048;
    
    public static void driveToItem(){
        driveEncoder.setDistancePerPulse(360/ppr);
    }

}
