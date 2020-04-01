/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JOptionPane;

/**
 *
 * @author fakhri
 */
public class ControllerLogin extends MouseAdapter implements ActionListener{
    private Model.Application app;
    private View.Login login;
    
    public ControllerLogin(Model.Application app){
        this.app = app;
        login = new View.Login();
        login.setVisible(true);
        login.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src.equals(login.getLoginbtn())){
            try{
                if(login.getUnameF().equals("admin") && login.getPnameF().equals("admin123")){
                    JOptionPane.showMessageDialog(null, "Login Success!");
                    ControllerMenu menu = new ControllerMenu(app);                   
                    login.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Login Failed!");
                }
            } catch (Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        
        if(src.equals(login.getCancelbtn())){
            try{
                int pilih = JOptionPane.showConfirmDialog(null, "Yakin bro mau cabut?","Exit App bro",JOptionPane.YES_NO_OPTION);
                switch(pilih){
                    case JOptionPane.YES_OPTION: 
                        JOptionPane.showMessageDialog(null, "makasih nih ye udah make app ane:)");
                        System.exit(0);
                    break;
                }
            } catch (Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());;
            }
        }
    }
}
