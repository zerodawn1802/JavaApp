/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
/**
 *
 * @author phuon
 */
public class CaptureScreen {
    public void captureScreen() throws Exception{
//        try
//        {
//            System.out.println("Doi 5 giay nao…");
//            Thread.sleep(5000);
//        }
//        catch(Exception e)
//        {
//            System.exit(1);
//        }
        String outFileName = "screen.jpg";
       
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        Rectangle screenRect = new Rectangle(screenSize);
        Robot robot = new Robot();

        BufferedImage image = robot.createScreenCapture(screenRect);

        ImageIO.write(image, "jpg", new File(outFileName));
        System.out.println(outFileName);
    }
}
