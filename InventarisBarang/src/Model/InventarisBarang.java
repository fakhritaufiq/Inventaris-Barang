/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.ControllerLogin;
import Model.Application;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fakhri
 */
public class InventarisBarang {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Model.Application app = new Application();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Logger.getLogger(InventarisBarang.class.getName()).log(Level.SEVERE, null, e);
        }
        Controller.ControllerLogin login = new ControllerLogin(app);
   
    }
    
}
