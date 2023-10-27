package appstu.tuil;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.*;

public class RetrieveObject {
    Commonajdbc com=new Commonajdbc();
    public Vector getObjectRow(String sqlStr){
        Vector vdata=new Vector();
        Connection con=com.conection;
        try{
            ResultSet rs=con.prepareStatement(sqlStr).executeQuery();
            ResultSetMetaData rsmd= rs.getMetaData();
            while(rs.next()){
                for(int i=1;i<=rsmd.getColumnCount();i++){
                    vdata.addElement(rs.getObject(i));
                }
            }
        }catch(java.sql.SQLException sql){
            JOptionPane.showMessageDialog(null,"执行的SQL语句错误！！！SQL:"+sqlStr,
                    "系统提示",JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
        return vdata;
    }
    public Collection getTableCollection(String sqlStr){
        Collection collection=new Vector();
        Connection con=com.conection;
        try{
            ResultSet rs=con.prepareStatement(sqlStr).executeQuery();
            ResultSetMetaData rsmd=rs.getMetaData();
            while(rs.next()){
                Vector vdata=new Vector();
                for(int i=1;i<=rsmd.getColumnCount();i++){
                    vdata.addElement(rs.getObject(i));
                }
                collection.add(vdata);
            }
        }catch(java.sql.SQLException sql){
            JOptionPane.showMessageDialog(null,"执行的SQL语句错误！！！SQL:"+sqlStr,
                    "系统提示",JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
        return collection;
    }
    public DefaultTableModel getTableModel(String[] name,String sqlStr) {
        Vector vname = new Vector();
        for (int i = 0; i < name.length; i++) {
            vname.addElement(name[i]);
        }
        DefaultTableModel tableModel = new DefaultTableModel(vname, 0);
        Connection con = com.conection;
        try {
            ResultSet rs = con.prepareStatement(sqlStr).executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                Vector vdata = new Vector();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    vdata.addElement(rs.getObject(i));
                }
                tableModel.addRow(vdata);
            }
        } catch (java.sql.SQLException sql) {
            sql.printStackTrace();
            ;
            return null;
        }
        return tableModel;
    }
}