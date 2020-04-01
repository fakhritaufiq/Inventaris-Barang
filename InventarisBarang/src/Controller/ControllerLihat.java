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
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author fakhri
 */
public class ControllerLihat extends MouseAdapter implements ActionListener {
        private View.LihatBarang barang;
        private Model.Application app;
        private Model.Barang brg;
    
    
    public ControllerLihat(Model.Application app) {
        this.app = app;
        barang = new View.LihatBarang();
        barang.setVisible(true);
        barang.addActionListener(this);
        barang.addMouseAdapter(this);
        app.loadAllbrg();
        barang.setListID(app.getListbrgid());
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src.equals(barang.getHapusbtn())){
            try{
                int pilih = JOptionPane.showConfirmDialog(null, "Asli nih pengen di delete?","Hapus Barang",JOptionPane.YES_NO_OPTION);
                switch(pilih){
                    case JOptionPane.YES_OPTION: 
                        String i = barang.getSelectedID();
                        app.removebarang(i);
                        app.loadAllbrg();
                        barang.setListID(app.getListbrgid());
                    break;
                }
            } catch (Exception ex){
                System.out.println("Deletion Exception: "+ex);
            }
        }
        
        
        
        if (src.equals(barang.getKmblbtn())){
            barang.setVisible(false);
            ControllerMenu menu = new ControllerMenu(app);
        }
        
    }
    
     @Override
    public void mousePressed(MouseEvent me){
        Object src = me.getSource();
        if(src.equals(barang.getListID())){
            String i=barang.getSelectedID();
            barang.setTaDetail(app.getNoId(i));
        }
    }
}
