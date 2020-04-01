/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author fakhri
 */
public class Barang {
    private String Nama_Customer;
    private String ID_Barang;
    private String Nama_Barang;
    private int Jumlah;
    private int Berat;
    private String Receiver;
    private String Checker;
    private String Picker;

    public Barang(String Nama_Customer, String ID_Barang, String Nama_Barang, int Jumlah, int Berat, String Receiver, String Checker, String Picker) {
        this.Nama_Customer = Nama_Customer;
        this.ID_Barang = ID_Barang;
        this.Nama_Barang = Nama_Barang;
        this.Jumlah = Jumlah;
        this.Berat = Berat;
        this.Receiver = Receiver;
        this.Checker = Checker;
        this.Picker = Picker;
    }

    public String getNama_Customer() {
        return Nama_Customer;
    }

    public void setNama_Customer(String Nama_Customer) {
        this.Nama_Customer = Nama_Customer;
    }

    public String getID_Barang() {
        return ID_Barang;
    }

    public void setID_Barang(String ID_Barang) {
        this.ID_Barang = ID_Barang;
    }

    public String getNama_Barang() {
        return Nama_Barang;
    }

    public void setNama_Barang(String Nama_Barang) {
        this.Nama_Barang = Nama_Barang;
    }

    public int getJumlah() {
        return Jumlah;
    }

    public void setJumlah(int Jumlah) {
        this.Jumlah = Jumlah;
    }

    public int getBerat() {
        return Berat;
    }

    public void setBerat(int Berat) {
        this.Berat = Berat;
    }

    public String getReceiver() {
        return Receiver;
    }

    public void setReceiver(String Receiver) {
        this.Receiver = Receiver;
    }

    public String getChecker() {
        return Checker;
    }

    public void setChecker(String Checker) {
        this.Checker = Checker;
    }

    public String getPicker() {
        return Picker;
    }

    public void setPicker(String Picker) {
        this.Picker = Picker;
    }
    
    
    public String toString(){
        return "Nama_Customer: "+getNama_Customer()+"\nID_Barang: "+getID_Barang()+ 
                "\nNama_Barang: "+getNama_Barang()+"\nJumlah: "+
                getJumlah()+"\nBerat: "+getBerat()+
                "\nReceiver: "+getReceiver()+"\nChecker: "+getChecker()
                +"\nPicker: "+getPicker();
    }
}
