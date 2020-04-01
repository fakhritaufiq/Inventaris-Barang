/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

/**
 *
 * @author fakhri
 */
public class ControllerMasuk extends MouseAdapter implements ActionListener {
    private View.MasukBarang masuk;
    private Model.Application app;
    private Model.Barang b;
    
    
    public ControllerMasuk(Model.Application app) {
        this.app = app;
        masuk = new View.MasukBarang();
        masuk.setVisible(true);
        masuk.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src.equals(masuk.getBtlBrgbtn())){
            masuk.setVisible(false);
            ControllerMenu msk = new ControllerMenu(app);
        }
        if (src.equals(masuk.getMsknBrgbtn())){
            try{
            String nama_customer = masuk.getNama_Customer();
            String id_barang = masuk.getID_Barang();
            String nama_barang = masuk.getNama_Barang();
            int jumlah = Integer.parseInt(masuk.getJumlah());
            int berat = Integer.parseInt(masuk.getBerat());
            String Receiver = masuk.getReceiverF();
            String Checker = masuk.getCheckerF();
            String Picker = masuk.getPickerF();
            b = new Model.Barang(nama_customer, id_barang, nama_barang, jumlah, berat, Receiver, Checker, Picker);
            app.addBarang(b);
        }catch(Exception ex){
                ex.printStackTrace();   
        }
        }
    }
}
    
