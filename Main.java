import JFrame.JF_login;
import JFrame.JF_view_sysset_class;
import appstu.tuil.Commonajdbc;
import  javax.swing.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    boolean packFrame = false;

    public static void main(String[] args) {
        try {
            new Thread() {
                private FileInputStream fis;
                private Scanner scanner;
                private JF_login jf_login;

                @Override
                public void run() {
                    try {
                        initAndRecLog();
// 初始化并记录日志
                        System.out.println("系统正在启动中……");
                        System.out.println("系统启动正常……");
                        System.out.println("进入登录窗体......");
                        fis = new FileInputStream("APPstu. log");
                        scanner = new Scanner(fis);
                        while (scanner.hasNextLine()) {
                            String str = scanner.nextLine();
                            str = "启动信息:" + str;
                            Thread.sleep(400);
                        }
                        scanner.close();
                        fis.close();
                        jf_login.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                private void initAndRecLog() throws FileNotFoundException {
                    FileOutputStream fop = new FileOutputStream("APPStu. log");
                    PrintStream ps = new PrintStream(fop);
                    System.setOut(ps);
                    Commonajdbc Jdbc = new Commonajdbc();
                    if (Commonajdbc.conection != null) {
                        jf_login = new JF_login();
                    }
                }
            }.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
