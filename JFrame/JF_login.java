package JFrame;
import appstu.tuil.Commonajdbc;
import appstu.tuil.RetrieveObject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class JF_login extends JFrame{
    public JF_login() {
        initComponents();
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        label2 = new JLabel();
        textField1 = new JTextField();
        panel2 = new JPanel();
        label1 = new JLabel();
        passwordField1 = new JPasswordField();
        panel3 = new JPanel();
        button1 = new JButton();
        button2 = new JButton();
        panel4 = new JPanel();
        label3 = new JLabel();

        //======== this ========
        setTitle("\u7528\u6237\u767B\u5F55");
        setResizable(false);
        var contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(4, 1));
        {
            panel4.setLayout(new GridLayout());

            //---- label3 ----
            label3.setIcon(new ImageIcon(getClass().getResource("/wsy/login.png")));
            label3.setVerticalAlignment(SwingConstants.TOP);
            label3.setHorizontalAlignment(SwingConstants.CENTER);
            panel4.add(label3);
        }
        contentPane.add(panel4);


        //======== panel1 ========
        {
            panel1.setPreferredSize(new Dimension(59, 17));
            panel1.setLayout(new FlowLayout(FlowLayout.LEFT, 59, 17));

            //---- label2 ----
            label2.setText("用户名：");
            panel1.add(label2);

            //---- textField1 ----
            textField1.setColumns(15);
            textField1.addActionListener(new ActionListener() {
                @Override public void actionPerformed(ActionEvent e) {
                    passwordField1.requestFocus();
    }});
            panel1.add(textField1);
        }
        contentPane.add(panel1);

        //======== panel2 ========
        {
            panel2.setPreferredSize(new Dimension(65, 14));
            panel2.setLayout(new FlowLayout(FlowLayout.LEFT, 65, 14));

            //---- label1 ----
            label1.setText("密码：");
            panel2.add(label1);

            //---- passwordField1 ----
            passwordField1.setColumns(15);
            passwordField1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (textField1.getText().trim().length() == 0 || passwordField1.getPassword().length == 0) {
                        JOptionPane.showMessageDialog(null, "用户和密码不允许为空", "系统提示",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    String name = textField1.getText();
                    String pass = String.valueOf(passwordField1.getPassword());
                    String sqlStr = "select * from tb_user where userid = '" + name.trim() +"'";
                    try {
                        Connection con = Commonajdbc.conection;
                        Statement pstmt = con.prepareStatement(sqlStr);
                        ResultSet rs = pstmt.executeQuery(sqlStr);
                        if (rs.next()) {
                                sqlStr = sqlStr + "and pass = '" + pass + "'";
                                pstmt = con.prepareStatement(sqlStr);
                                rs = pstmt.executeQuery(sqlStr);
                                if (rs.next()) {
                                    JF_AppMain Jmain=new JF_AppMain();
                                    Jmain.setVisible(true);
                                    dispose();
                                }
                                else {
                                    JOptionPane.showMessageDialog(null, "密码错误！！！请重新输入", "系统提示",
                                            JOptionPane.ERROR_MESSAGE);
                                    passwordField1.setText(null);
                                    passwordField1.requestFocus();
                                }
                            }
                    else {
                            JOptionPane.showMessageDialog(null, "用户名或密码错误！！！请重新输入", "系统提示",
                                    JOptionPane.ERROR_MESSAGE);
                            textField1.setText(null);
                            passwordField1.setText(null);
                            textField1.requestFocus();
                        }
                    } catch (java.sql.SQLException sql) {
                        sql.printStackTrace();
                        return;
                    }
                }
            });
            panel2.add(passwordField1);
        }
        contentPane.add(panel2);

        //======== panel3 ========
        {
            panel3.setPreferredSize(new Dimension(80, 16));
            panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 80, 16));

            //---- button1 ----
            button1.setText("登录");
            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (textField1.getText().trim().length() == 0 || passwordField1.getPassword().length == 0) {
                        JOptionPane.showMessageDialog(null, "用户和密码不允许为空", "系统提示",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    String name = textField1.getText();
                    String pass = String.valueOf(passwordField1.getPassword());
                    String sqlStr = "select * from tb_user where userid = '" + name.trim() +"'";
                    try {
                        Connection con = Commonajdbc.conection;
                        Statement pstmt = con.prepareStatement(sqlStr);
                        ResultSet rs = pstmt.executeQuery(sqlStr);
                        if (rs.next()) {
                            if (!rs.wasNull()) {
                                sqlStr = sqlStr + "and pass = '" + pass + "'";
                                pstmt = con.prepareStatement(sqlStr);
                                rs = pstmt.executeQuery(sqlStr);
                                if (rs.next()) {
                                        JF_AppMain Jmain=new JF_AppMain();
                                        Jmain.setVisible(true);
                                        dispose();
                                }
                                else {
                                    JOptionPane.showMessageDialog(null, "密码错误！！！请重新输入", "系统提示",
                                            JOptionPane.ERROR_MESSAGE);
                                    passwordField1.setText(null);
                                    passwordField1.requestFocus();
                                }
                            }
                        }else {
                            JOptionPane.showMessageDialog(null, "用户名或密码错误！！！请重新输入", "系统提示",
                                    JOptionPane.ERROR_MESSAGE);
                            textField1.setText(null);
                            passwordField1.setText(null);
                            textField1.requestFocus();
                        }
                    } catch (java.sql.SQLException sql) {
                        sql.printStackTrace();
                        return;
                    }
                }
            });
            panel3.add(button1);

            //---- button2 ----
            button2.setText("取消");
            button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int result = JOptionPane.showConfirmDialog(null, "是否确定退出登录页面！！！",
                            "系统提示", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION)
                        System.exit(0);
                }
            });
            panel3.add(button2);
        }
        contentPane.add(panel3);
        setSize(400, 215);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JPanel panel4;
    private JLabel label3;
    private JLabel label2;
    private JTextField textField1;
    private JPanel panel2;
    private JLabel label1;
    private JPasswordField passwordField1;
    private JPanel panel3;
    private JButton button1;
    private JButton button2;
}
