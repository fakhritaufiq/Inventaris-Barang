/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;
import Model.Barang;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.JOptionPane;

/**
 *
 * @author fakhri
 */
public class Database {
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private ArrayList<Barang> barang = new ArrayList<>();

    /*public Database() {
        loadBarang();
    }*/        
    public void connect(){
        try {
            String url = "jdbc:mysql://localhost:3306/sql.php?db=barang&table=t_barang&pos=0";
            String user = "root";
            String pass = "";
            con = DriverManager.getConnection(url,user,pass);
            stmt = con.createStatement();
            JOptionPane.showMessageDialog(null, "connect!");
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void disconnect(){
        try {
            con.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Login(Model.Admin u){
        try{
            stmt = con.createStatement();
            String sql = "select * from user where username= '"+u.getUsername()+"' AND Password= '"+u.getPassword()+"'";
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Berhasil");
            } else {
                JOptionPane.showMessageDialog(null, "Username atau Password salah");
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"0");
        }
    }
           
    public void MasukBarang(Model.Barang c){
        try{
                String query = "INSERT INTO `t_barang`(`Nama_Customer`, `ID_Barang`, `Nama_Barang`, `Jumlah`,`Berat`, `Receiver`,`Checker`,`Picker`) "
                        + "VALUES ("+"\""+c.getNama_Customer()+"\""+","+"\""+c.getID_Barang()+"\""+","+"\""+c.getNama_Barang()+"\""+","+"\""+c.getJumlah()+"\""+","
                        + ""+"\""+c.getBerat()+"\""+","+"\""+c.getReceiver()+"\""+","+"\""+c.getChecker()
                        +"\""+","+"\""+c.getPicker()+"\""+");";
                stmt = con.createStatement();
                stmt.executeUpdate(query);
                System.out.println("Alhamdulillah Sukses");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ""+ex.getMessage());
        }
    }
    
    public void DeleteBarang(Model.Barang c){
        try{
            String query = "delete from t_barang where ID_Barang='"+c.getID_Barang()+"'";
            Statement s = con.createStatement();
            s.executeUpdate(query);
            System.out.println("Barang Sudah di Hapus");
        } catch (SQLException ex){
            System.out.println("Error boy");
            ex.printStackTrace();
        }
    }
    
    public Model.Barang loadid(String Noid){
        try{
            Statement stmt = con.createStatement();
            String query = "select * from t_barang where ID_Barang='"+Noid+"';";
            ResultSet rs = stmt.executeQuery(query);
            Model.Barang c = null;
            while (rs.next()){
                String nama_customer = rs.getString("Nama_Customer");
                String ID_Barang = rs.getString("ID_Barang");
                String Nama_Barang = rs.getString("Nama_Barang");
                int jumlah = rs.getInt("Jumlah");
                int berat = rs.getInt("Berat");
                String Receiver = rs.getString("Receiver");
                String Checker = rs.getString("Checker");
                String Picker = rs.getString("Picker");
                c = new Model.Barang(nama_customer, ID_Barang, Nama_Barang, jumlah, berat, Receiver, Checker, Picker);
            }
            return c;
        } catch (SQLException e){
            System.out.println("Error While Loading");
            return null;
        }    
    }
    
    public ArrayList<Model.Barang> loadAllbrg(){
        try{
            ArrayList<Model.Barang> listBarang = new ArrayList();
            Statement stmt = con.createStatement();
            String query = "Select * from t_barang";
            ResultSet rs = stmt.executeQuery(query);
            Model.Barang c = null;
            while (rs.next()){
                String nama_customer = rs.getString("Nama_Customer");
                String ID_Barang = rs.getString("ID_Barang");
                String Nama_Barang = rs.getString("Nama_Barang");
                int jumlah = rs.getInt("Jumlah");
                int berat = rs.getInt("Berat");
                String Receiver = rs.getString("Receiver");
                String Checker = rs.getString("Checker");
                String Picker = rs.getString("Picker");
                c = new Model.Barang(nama_customer, ID_Barang, Nama_Barang, jumlah, berat, Receiver, Checker, Picker);
                listBarang.add(c);
            }
            return listBarang;
            
        } catch (Exception e){
            System.out.println("Error While Loading List");
            return null;
        }
    }   
}
