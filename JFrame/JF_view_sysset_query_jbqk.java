package JFrame;

import appstu.tuil.RetrieveObject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author lixiang
 */
public class JF_view_sysset_query_jbqk extends JFrame {
    String sqlStr1="select s.stuid,c.className,s.stuname,s.sex,s.age,s.addr,s.phone" +
            " from tb_studentinfo s INNER JOIN tb_classinfo c ON s.classID=c.classID";
    String[] jTame={"学生编号","班级名称","学生名称","性别","年龄","家庭住址","联系电话"};
    String zdname=null;
    String ysname="like";
    public JF_view_sysset_query_jbqk() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel2 = new JPanel();
        panel3 = new JPanel();
        label1 = new JLabel();
        comboBox1 = new JComboBox<>();
        label2 = new JLabel();
        comboBox2 = new JComboBox();
        label3 = new JLabel();
        comboBox3 = new JComboBox<>();
        label4 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        panel4 = new JPanel();
        label5 = new JLabel();

        //======== this ========
        setResizable(false);
        var contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());

        //======== panel2 ========
        {
            panel2.setLayout(new GridBagLayout());
            ((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {879, 0};
            ((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {49, 480, 24, 0};
            ((GridBagLayout)panel2.getLayout()).columnWeights = new double[] {0.0, 1.0E-4};
            ((GridBagLayout)panel2.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};

            //======== panel3 ========
            {
                panel3.setLayout(new FlowLayout());

                //---- label1 ----
                label1.setText("\u67e5\u8be2\u7c7b\u578b\uff1a");
                panel3.add(label1);

                //---- comboBox1 ----
                comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
                        "\u5b66\u751f\u4fe1\u606f",
                        "\u6559\u5e08\u4fe1\u606f"
                }));
                comboBox1.addItemListener(new  ItemListener() {@Override public void itemStateChanged(ItemEvent e) {
                    comboBox2.removeAllItems();
                    if(comboBox1.getSelectedIndex()==0){
                        sqlStr1="select s.stuid,c.className,s.stuname,s.sex,s.age,s.addr,s.phone" +
                                " from tb_studentinfo s INNER JOIN tb_classinfo c ON s.classID=c.classID";
                        String[] name={"学生编号","班级名称","学生名称","性别","年龄","家庭住址","联系电话"};
                        jTame=name;
                        comboBox2.removeAllItems();
                        comboBox2.addItem("学生编号");
                        comboBox2.addItem("班级编号");
                    }
                    if(comboBox1.getSelectedIndex()==1){
                        sqlStr1="select t.teaid,c.className,t.teaname,t.sex,t.konwledge,t.konwlevel from" +
                                " tb_teacher t INNER JOIN  tb_classinfo c ON c.classID=t.classID";
                        String[] name={"教师编号","班级名称","教师姓名","性别","教师职称","教师等级"};
                        jTame=name;
                        comboBox2.removeAllItems();
                        comboBox2.addItem("教师编号");
                        comboBox2.addItem("班级编号");
                    }

    }});
                panel3.add(comboBox1);

                //---- label2 ----
                label2.setText("\u5b57\u6bb5\uff1a");
                panel3.add(label2);
                comboBox2.addItemListener(new ItemListener() {@Override public void itemStateChanged(ItemEvent e) {
                    if(comboBox1.getSelectedIndex()==0){
                        if(comboBox2.getSelectedIndex()==0)
                            zdname="s.stuid";
                        if(comboBox2.getSelectedIndex()==1)
                            zdname="s.classID";
                    }
                    if(comboBox1.getSelectedIndex()==1){
                        if(comboBox2.getSelectedIndex()==0)
                            zdname="t.teaid";
                        if(comboBox2.getSelectedIndex()==1)
                            zdname="t.classID";
                    }

    }});
                panel3.add(comboBox2);

                //---- label3 ----
                label3.setText("\u67e5\u8be2\u6761\u4ef6\uff1a");
                panel3.add(label3);

                //---- comboBox3 ----
                comboBox3.setModel(new DefaultComboBoxModel<>(new String[] {
                        "like",
                        ">",
                        "=",
                        "<",
                        ">=",
                        "<="
                }));
                comboBox3.addItemListener(new ItemListener() {@Override public void itemStateChanged(ItemEvent e) {
                    ysname=String.valueOf(comboBox3.getSelectedItem());

    }});
                panel3.add(comboBox3);

                //---- label4 ----
                label4.setText("\u6570\u503c");
                panel3.add(label4);

                //---- textField1 ----
                textField1.setColumns(9);
                textField1.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {
                    String sqlStr=null,whereSql=null;
                    String valueStr=textField1.getText().trim();
                    sqlStr=sqlStr1;
                    if(ysname=="like"){
                        whereSql=" and "+zdname+" "+ysname+" '%"+valueStr+"%'";
                    }else if(ysname==null){
                        whereSql="  ";

                    } else{
                        whereSql=" and "+zdname+""+ysname+" '"+valueStr+"'";
                    }
                    RetrieveObject retrieve=new  RetrieveObject();
                    DefaultTableModel defaultmodel=null;
                    defaultmodel=retrieve.getTableModel(jTame,sqlStr+whereSql);
                    table1.setModel(defaultmodel);
                    if(table1.getRowCount()<=0){
                        JOptionPane.showMessageDialog(null,"没有找到满足条件的数据!!!!","系统提示",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    table1.setRowHeight(24);
                    label5.setText("共有数据【"+String.valueOf(table1.getRowCount())+"】条");

    }});
                panel3.add(textField1);

                //---- button1 ----
                button1.setText("\u67e5\u8be2");
                button1.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {
                    String sqlStr=null,whereSql=null;
                    String valueStr=textField1.getText().trim();
                    sqlStr=sqlStr1;
                    if(ysname=="like"){
                        whereSql=" and "+zdname+" "+ysname+" '%"+valueStr+"%'";
                    }else if(ysname==null){
                        whereSql="  ";

                    } else{
                        whereSql=" and "+zdname+""+ysname+" '"+valueStr+"'";
                    }
                    RetrieveObject retrieve=new  RetrieveObject();
                    DefaultTableModel defaultmodel=null;
                    defaultmodel=retrieve.getTableModel(jTame,sqlStr+whereSql);
                    table1.setModel(defaultmodel);
                    if(table1.getRowCount()<=0){
                        JOptionPane.showMessageDialog(null,"没有找到满足条件的数据!!!!","系统提示",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    table1.setRowHeight(24);
                    label5.setText("共有数据【"+String.valueOf(table1.getRowCount())+"】条");

    }});
                panel3.add(button1);

                //---- button2 ----
                button2.setText("\u9000\u51fa");
                button2.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {
                    dispose();

    }});
                panel3.add(button2);
            }
            panel2.add(panel3, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

            //======== scrollPane1 ========
            {

                //---- table1 ----
                table1.setModel(new DefaultTableModel(
                        new Object[][] {
                        },
                        new String[] {
                                "学生编号","班级名称","学生名称","性别","年龄","家庭住址","联系电话"
                        }
                ));
                scrollPane1.setViewportView(table1);
            }
            panel2.add(scrollPane1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

            //======== panel4 ========
            {
                panel4.setLayout(new FlowLayout(FlowLayout.LEFT));

                //---- label5 ----
                label5.setText("text");
                panel4.add(label5);
            }
            panel2.add(panel4, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
        }
        label5.setText(null);
        comboBox2.addItem("学生编号");
        comboBox2.addItem("班级编号");
        DefaultTableModel defaultmodel=null;
        RetrieveObject retrieve=new  RetrieveObject();
        defaultmodel=retrieve.getTableModel(jTame,this.sqlStr1);
        table1.setModel(defaultmodel);
        comboBox1.setSelectedIndex(0);
        contentPane.add(panel2);
        setSize(890, 605);
        setVisible(true);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel2;
    private JPanel panel3;
    private JLabel label1;
    private JComboBox<String> comboBox1;
    private JLabel label2;
    private JComboBox comboBox2;
    private JLabel label3;
    private JComboBox<String> comboBox3;
    private JLabel label4;
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel panel4;
    private JLabel label5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
