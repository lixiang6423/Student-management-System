package JFrame;

import appstu.tuil.JdbcAdapter;
import appstu.tuil.RetrieveObject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.*;
import Object.*;

/**
 * @author lixiang
 */
public class JF_view_sysset_user_modify extends JFrame {
    public JF_view_sysset_user_modify() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        splitPane1 = new JSplitPane();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        panel4 = new JPanel();
        label2 = new JLabel();
        textField2 = new JTextField();
        panel6 = new JPanel();
        label3 = new JLabel();
        textField3 = new JTextField();
        panel5 = new JPanel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();

        //======== this ========
        setResizable(false);
        var contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {0, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {0, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

        //======== splitPane1 ========
        {
            splitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);
            splitPane1.setDividerLocation(200);

            //======== scrollPane1 ========
            {

                //---- table1 ----
                table1.setModel(new DefaultTableModel(
                        new Object[][] {
                                {null, null, null},
                                {null, null, null},
                        },
                        new String[] {
                                "\u7528\u6237ID", "\u7528\u6237\u59d3\u540d", "\u7528\u6237\u53e3\u4ee4"
                        }
                ));
                table1.addMouseListener(new MouseAdapter() {
                    @Override public void mouseClicked(MouseEvent e) {
                        boolean insertflag=false;
                        String id=null;
                        String sqlStr=null;
                        int selectrow=0;
                        selectrow=table1.getSelectedRow();
                        if(selectrow<0)
                            return;
                        id=table1.getValueAt(selectrow,0).toString();
                        sqlStr="select * from tb_user where userID='"+id+"'";
                        Vector vdata=null;
                        RetrieveObject retrive=new RetrieveObject();
                        vdata=retrive.getObjectRow(sqlStr);
                        textField1.setText(vdata.get(0).toString());
                        textField2.setText(vdata.get(1).toString());
                        textField3.setText(vdata.get(2).toString());



                    }});
                scrollPane1.setViewportView(table1);
            }
            splitPane1.setTopComponent(scrollPane1);

            //======== panel1 ========
            {
                panel1.setLayout(new GridBagLayout());
                ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {455, 0};
                ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {68, 47, 0};
                ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 1.0E-4};
                ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

                //======== panel2 ========
                {
                    panel2.setLayout(new GridLayout(3, 0));

                    //======== panel3 ========
                    {
                        panel3.setLayout(new BorderLayout());

                        //---- label1 ----
                        label1.setText("\u7528\u6237ID:");
                        panel3.add(label1, BorderLayout.WEST);

                        //---- textField1 ----
                        textField1.setColumns(26);
                        panel3.add(textField1, BorderLayout.EAST);
                    }
                    panel2.add(panel3);

                    //======== panel4 ========
                    {
                        panel4.setLayout(new BorderLayout());

                        //---- label2 ----
                        label2.setText("\u7528\u6237\u59d3\u540d");
                        panel4.add(label2, BorderLayout.WEST);

                        //---- textField2 ----
                        textField2.setColumns(26);
                        panel4.add(textField2, BorderLayout.EAST);
                    }
                    panel2.add(panel4);

                    //======== panel6 ========
                    {
                        panel6.setLayout(new BorderLayout());

                        //---- label3 ----
                        label3.setText("\u7528\u6237\u5bc6\u7801\uff1a");
                        panel6.add(label3, BorderLayout.WEST);

                        //---- textField3 ----
                        textField3.setColumns(26);
                        textField3.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {
                            Obj_user obj=new Obj_user();
                            obj.setUserid(textField1.getText());
                            obj.setUsername(textField2.getText());
                            obj.setPass(textField3.getText());
                            JdbcAdapter jdbcAdapter=new JdbcAdapter();
                            textField1.setText(null);
                            textField2.setText(null);
                            textField3.setText(null);
                            if(jdbcAdapter.InsertOrUpject(obj))
                                buildTable();

    }});
                        panel6.add(textField3, BorderLayout.EAST);
                    }
                    panel2.add(panel6);
                }
                panel1.add(panel2, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));

                //======== panel5 ========
                {
                    panel5.setLayout(new FlowLayout(FlowLayout.RIGHT));

                    //---- button1 ----
                    button1.setText("\u5220\u9664");
                    button1.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {
                        int result=JOptionPane.showOptionDialog(null,"是否删除用户信息数据？","系统提示",
                                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,new String[]{"是","否"},"否");
                        if(result==JOptionPane.NO_OPTION){
                            return;
                        }
                        String sqlStr="delete from tb_user  where userID =  '"+textField1.getText().trim()+"'";
                        JdbcAdapter jdbcAdapter=new JdbcAdapter();
                        if(jdbcAdapter.DeleteObject(sqlStr)){
                            textField1.setText(null);
                            textField2.setText(null);
                            textField3.setText(null);
                            buildTable();
                        }

    }});
                    panel5.add(button1);

                    //---- button3 ----
                    button3.setText("\u5b58\u76d8");
                    button3.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {
                        Obj_user obj=new Obj_user();
                        obj.setUserid(textField1.getText());
                        obj.setUsername(textField2.getText());
                        obj.setPass(textField3.getText());
                        JdbcAdapter jdbcAdapter=new JdbcAdapter();
                        textField1.setText(null);
                        textField2.setText(null);
                        textField3.setText(null);
                        if(jdbcAdapter.InsertOrUpject(obj))
                            buildTable();

    }});
                    panel5.add(button3);

                    //---- button4 ----
                    button4.setText("\u9000\u51fa");
                    button4.addActionListener(new  ActionListener() {@Override public void actionPerformed(ActionEvent e) {
                        dispose();

    }});
                    panel5.add(button4);
                }
                panel1.add(panel5, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
            }
            splitPane1.setBottomComponent(panel1);
        }
        contentPane.add(splitPane1);
        pack();
        buildTable();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }
    private void buildTable(){
        DefaultTableModel tablemodel=null;
        String[] name={"用户编号","用户姓名","用户口令"};
        String sqlStr="select * from tb_user ";
        RetrieveObject bdt=new RetrieveObject();
        tablemodel=bdt.getTableModel(name,sqlStr);
        table1.setModel(tablemodel);
        return;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JSplitPane splitPane1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JLabel label1;
    private JTextField textField1;
    private JPanel panel4;
    private JLabel label2;
    private JTextField textField2;
    private JPanel panel6;
    private JLabel label3;
    private JTextField textField3;
    private JPanel panel5;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}