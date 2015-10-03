package clases;
import javax.swing.*;
import java.awt.*;

import java.awt.geom.Arc2D;
import java.io.IOException;
import java.lang.Math;
import com.leapmotion.leap.*;
import com.leapmotion.leap.Frame;



public class HandSigns extends Listener{
    public JFrame ventana = new JFrame();
    public void onInit(Controller controller) {
        System.out.println("Initialized");
    }

    public void onConnect(Controller controller) {
        System.out.println("Connected");
        controller.enableGesture(Gesture.Type.TYPE_SWIPE);
        controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
        controller.enableGesture(Gesture.Type.TYPE_SCREEN_TAP);
        controller.enableGesture(Gesture.Type.TYPE_KEY_TAP);


    }

    public void onDisconnect(Controller controller) {

        System.out.println("Disconnected");
    }

    public void onExit(Controller controller) {
        System.out.println("Exited");
    }


    public void onFrame(Controller controller) {

        // Get the most recent frame and report some basic information
        Frame frame = controller.frame();
        //Get hands
        for(Hand hand : frame.hands()) {
           /* if (hand.isLeft()){
                System.out.println("Mano Izquierda");
            }
            else{
                System.out.println("Mano Derecha");
            }*/

            FingerList fingerl = hand.fingers();
            Finger finger0 = fingerl.get(0);
            Finger finger1 = fingerl.get(1);
            Finger finger2 = fingerl.get(2);
            Finger finger3 = fingerl.get(3);
            Finger finger4 = fingerl.get(4);

            Bone.Type boneType[] = Bone.Type.values();

            Bone bone00 = finger0.bone(Bone.Type.TYPE_METACARPAL);
            Bone bone01 = finger0.bone(Bone.Type.TYPE_PROXIMAL);
            Bone bone02 = finger0.bone(Bone.Type.TYPE_INTERMEDIATE);
            Bone bone03 = finger0.bone(Bone.Type.TYPE_DISTAL);

            Bone bone10 = finger1.bone(Bone.Type.TYPE_METACARPAL);
            Bone bone11 = finger1.bone(Bone.Type.TYPE_PROXIMAL);
            Bone bone12 = finger1.bone(Bone.Type.TYPE_INTERMEDIATE);
            Bone bone13 = finger1.bone(Bone.Type.TYPE_DISTAL);

            Bone bone20 = finger2.bone(Bone.Type.TYPE_METACARPAL);
            Bone bone21 = finger2.bone(Bone.Type.TYPE_PROXIMAL);
            Bone bone22 = finger2.bone(Bone.Type.TYPE_INTERMEDIATE);
            Bone bone23 = finger2.bone(Bone.Type.TYPE_DISTAL);

            Bone bone30 = finger3.bone(Bone.Type.TYPE_METACARPAL);
            Bone bone31 = finger3.bone(Bone.Type.TYPE_PROXIMAL);
            Bone bone32 = finger3.bone(Bone.Type.TYPE_INTERMEDIATE);
            Bone bone33 = finger3.bone(Bone.Type.TYPE_DISTAL);

            Bone bone40 = finger4.bone(Bone.Type.TYPE_METACARPAL);
            Bone bone41 = finger4.bone(Bone.Type.TYPE_PROXIMAL);
            Bone bone42 = finger4.bone(Bone.Type.TYPE_INTERMEDIATE);
            Bone bone43 = finger4.bone(Bone.Type.TYPE_DISTAL);

            Vector direction_hand = hand.direction();

            /*System.out.println( "Dedo: " + finger0.type() + "      " + bone00.type()
                    + " bone, start: " + bone00.prevJoint()
                    + ", end: " + bone00.nextJoint()
                    + ", direction: " + bone00.direction());

            System.out.println( "Dedo: " + finger1.type() + "      " + bone10.type()
                    + " bone, start: " + bone10.prevJoint()
                    + ", end: " + bone10.nextJoint()
                    + ", direction: " + bone10.direction());*/


            // CAPTURA DE LA LETRA M Y N      /////////////////////////////////////////////////////////////////////////////

           // Main.window.letraInterpretada("Selecionada", "Opcion 1", "Opcion 2");

            if ((finger0.isExtended()==false && finger4.isExtended()==false)) {

                Vector direction = hand.direction();
                Float eje_y = direction.getY();


                if (eje_y > 0){
                    // CAPTURA DE LA LETRA "V" y "P"
                    if (finger1.isExtended() == true && finger2.isExtended() == true) {
                        if (finger3.isExtended() == true)
                        {
                            double distancia = 0.1;
                            if (Math.abs(finger1.bone(Bone.Type.TYPE_DISTAL).direction().getX() - finger2.bone(Bone.Type.TYPE_DISTAL).direction().getX()) > distancia) {
                                Main.window.letraInterpretada("w", "P", "M");
                            } else {
                                Main.window.letraInterpretada("P", "w", "M");
                            }
                        }
                        else if (finger3.isExtended() == false){
                            double distancia = 0.1;
                            if (finger1.bone(Bone.Type.TYPE_DISTAL).direction().getX() - finger2.bone(Bone.Type.TYPE_DISTAL).direction().getX() > distancia) {
                                Main.window.letraInterpretada("V", "U", "");

                            }
                            else if (finger1.bone(Bone.Type.TYPE_DISTAL).direction().getX() - finger2.bone(Bone.Type.TYPE_DISTAL).direction().getX() < -0.2) {
                                Main.window.letraInterpretada("R", "U", "");
                            }else {
                                Main.window.letraInterpretada("U", "V", "");
                            }
                        }
                    }
                }
                else if (eje_y < 0) {

                    if (finger2.isExtended() == true && finger1.isExtended() == true && finger3.isExtended() == true) {

                        System.out.println("Posibles letras: 'M' -- 'N'\nSeleccion actual: 'M'.");

                        Main.window.letraInterpretada("M", "M", "N");

                    } else if (finger2.isExtended() == true && finger1.isExtended() == true && finger3.isExtended() == false) {

                        System.out.println("Posibles letras: 'M' -- 'N'\nSeleccion actual: 'N'.");

                        Main.window.letraInterpretada("N", "M", "N");

                    }
                    else if( bone13.direction().getY() >=-0.3 && bone13.direction().getY()<0.2  ){
                        //   CAPTURA DE LA H  ///////////////////////////////////////////////////////////////////////////////////

                        Main.window.letraInterpretada("H", "H", "G");
                    }
                }
            }
            //CAPTURA DE LA LETRA "Y"
            else if (finger0.isExtended()==true && finger1.isExtended()==false && finger2.isExtended()==false && finger3.isExtended()==false && finger4.isExtended()==true )
            {
                System.out.println("Seleccion actual: 'Y'." );

                Main.window.letraInterpretada("Y","","");
            }

            else if (( finger1.isExtended()==false && finger2.isExtended()==false && finger3.isExtended()==false && finger4.isExtended()==false)){

                //  CAPTURAR LETRA A  //////////////////////////////////////////////////////

                if ( bone12.direction().getY()>= 0.9 && bone22.direction().getY()>= 0.85 && bone32.direction().getY()>= 0.7 ){//&& bone42.direction().getY()>= 0.5  ){//&& bone11.direction().getY()>= -0.3 && bone21.direction().getY()>= -0.3 && bone31.direction().getY()>= -0.3 && bone41.direction().getY()>= -0.3){

                    //bone02.direction().getY()<-0.75 &&

                    Main.window.letraInterpretada("A", "S", "T" );

                }

                //   CAPTURA DE LA E //////////////////////////////////////////////////////////////////////////////////////
                else if (bone11.direction().getY() <=-0.88 && bone21.direction().getY() <=-0.88 && bone31.direction().getY() <=-0.88 && bone41.direction().getY() <=-0.88 && bone03.direction().getX() <=-0.4){

                    Main.window.letraInterpretada("E", "C", "A" );

                }


                //  CAPTURAR LETRA C  //////////////////////////////////////////////////////

                else //if (bone03.direction().getY()>0 && bone13.direction().getY()<=0 && bone23.direction().getY()<=0 && bone33.direction().getY()<=0 && bone43.direction().getY()<=0 ){



                    Main.window.letraInterpretada("C", "C", "O" );

            }


            //   CAPTURA DE LA B //////////////////////////////////////////////////////////////////////////////////////

            else if ((finger0.isExtended()==false && finger1.isExtended()==true && finger2.isExtended()==true && finger3.isExtended()==true && finger4.isExtended()==true)){



                Main.window.letraInterpretada("B", "A", "B" );

            }

            //   CAPTURA DE LA D //////////////////////////////////////////////////////////////////////////////////////

            else if (( finger1.isExtended()==true && finger2.isExtended()==false && finger3.isExtended()==false && finger4.isExtended()==false)){

                Float eje_y = direction_hand.getY();


                if (eje_y > 0.2 && bone22.direction().getY()>= 0.85 && bone32.direction().getY()>= 0.7 ){//&& bone42.direction().getY()>= 0.5  ){//&& bone11.direction().getY()>= -0.3 && bone21.direction().getY()>= -0.3 && bone31.direction().getY()>= -0.3 && bone41.direction().getY()>= -0.3){

                    //bone02.direction().getY()<-0.75 &&

                    Main.window.letraInterpretada("D", "D", "C" );
                }

                else if (eje_y <= 0.2){

                    Main.window.letraInterpretada("G", "G", "H" );

                }

            }


            //   CAPTURA DE LA F //////////////////////////////////////////////////////////////////////////////////////

            else if ((finger0.isExtended()==false && finger1.isExtended()==false && finger2.isExtended()==true && finger3.isExtended()==true && finger4.isExtended()==true)){


                if ( bone12.direction().getY()>= 0.85 && bone03.direction().getY()<= -0.6 ){

                    Main.window.letraInterpretada("F", "A", "F" );

                }



            }



            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        }
    }
}