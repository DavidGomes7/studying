/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgcreationtools;

import static java.lang.Math.random;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author jdavi
 */
public class Dado {
    Random roll = new Random();
    
    // d20
    public static void rolarD20(){
        double roll = random() * 2;
        roll = Math.round(roll * 10);
        JOptionPane.showMessageDialog(null, roll, "D20", JOptionPane.PLAIN_MESSAGE);
    }
    
    // d4
    public static void rolarD4(){
        Random roll = new Random();
        JOptionPane.showMessageDialog(null, roll.nextInt(4) + 1, "D4", JOptionPane.PLAIN_MESSAGE);
    }
    
    // d6
    public static void rolarD6(){
        Random roll = new Random();
        JOptionPane.showMessageDialog(null, roll.nextInt(6) + 1, "D6", JOptionPane.PLAIN_MESSAGE);
    }
    
    // d8
    public static void rolarD8(){
        Random roll = new Random();
        JOptionPane.showMessageDialog(null, roll.nextInt(8) + 1, "D8", JOptionPane.PLAIN_MESSAGE);
    }
    
    // d10
    public static void rolarD10(){
        Random roll = new Random();
        JOptionPane.showMessageDialog(null, roll.nextInt(10) + 1, "D10", JOptionPane.PLAIN_MESSAGE);
    }
    
    // d12  
    public static void rolarD12(){
        Random roll = new Random();
        JOptionPane.showMessageDialog(null, roll.nextInt(12) + 1, "D12", JOptionPane.PLAIN_MESSAGE);
    }
    
}
