package clases;

import com.leapmotion.leap.*;

import javax.swing.*;

import java.awt.*;
import java.io.IOException;

public class Main {

    static HandSigns listener = new HandSigns();
    static Controller controller = new Controller();
    static InterfaceHearMeToo window = new InterfaceHearMeToo();
    
    public static void main(String[] args) {


        // Create a sample listener and controller
        // Have the sample listener receive events from the controller
        controller.addListener(listener);
 
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Remove the sample listener when done
        controller.removeListener(listener);
    }
}