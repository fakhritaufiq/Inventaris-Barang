/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Application;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JOptionPane;

/**
 *
 * @author fakhri
 */
public class ControllerMenu extends MouseAdapter implements ActionListener {
    private View.Menu menu;
    private Model.Application app;
    
    
    public ControllerMenu(Model.Application app) {
        this.app = app;
        menu = new View.Menu();
        menu.setVisible(true);
        menu.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src.equals(menu.getMasukbtn())){
            menu.setVisible(false);
            ControllerMasuk msk = new ControllerMasuk(app);
        }
        
        /*if (src.equals(menu.getUpdatebtn())){
            menu.setVisible(false);
            ControllerUpdate update = new ControllerUpdate(app);
        }*/
        
        if (src.equals(menu.getLihatbtn())){
            menu.setVisible(false);
            ControllerLihat lihat = new ControllerLihat(app);
        }
        
        if(src.equals(menu.getLogoutbtn())){
            try{
                int pilih = JOptionPane.showConfirmDialog(null, "Yakin bro mau cabut?","Exit App bro",JOptionPane.YES_NO_OPTION);
                switch(pilih){
                    case JOptionPane.YES_OPTION: 
                        JOptionPane.showMessageDialog(null, "makasih nih ye udah make app ane:)");
                        System.exit(0);
                    break;
                }
            } catch (Exception ex){
                System.out.println(ex);
            }
        }
    }

    
}
