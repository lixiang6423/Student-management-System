package appstu.tuil;

import java.sql.Connection;
import java.sql.DriverManager;

public class Commonajdbc {
    public static Connection conection=null;
    public Commonajdbc(){
        getCon();
    }
    private Connection getCon() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/text_ks?useUnicode=true&characterEncoding=GBK ",
                    "root","166310");
        } catch (java.lang.ClassNotFoundException classNotfound) {
            classNotfound.printStackTrace();
        } catch (java.sql.SQLException sql) {
            sql.printStackTrace();
        }
        return conection;
    }
}
