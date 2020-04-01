/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author fakhri
 */
public class Application {
    private ArrayList<Admin> adminList;
    private ArrayList<Barang> barangList;
    private Database.Database db;
    Connection con;
    Statement stm;
    ResultSet rs;

    public Application() {
        adminList = new ArrayList();
        barangList = new ArrayList();
        db = new Database.Database();
        db.connect();
    }
    
    public void login(Model.Admin u){
        db.Login(u);
    }
    
    public void addBarang(Model.Barang b ){
        barangList.add(b);
        db.MasukBarang(b);
    }
    public void loadAllbrg(){
        barangList = db.loadAllbrg();
    } 
    
    public String[] getListbrgid(){
        String[] idList = new String[barangList.size()];
        for (int i = 0; i < idList.length; i++) {
            idList[i] = barangList.get(i).getID_Barang();
        }
        return idList;
    }
    
    public String getNoId(String noid){
        Barang c = db.loadid(noid);
        return c.toString();
    }
    
    public void removebarang(String noid){
        Barang c = db.loadid(noid);
        barangList.remove(c);
        db.DeleteBarang(c);
    }
    
    
    
}
