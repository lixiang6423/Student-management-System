package JFrame;
import appstu.tuil.JdbcAdapter;
import appstu.tuil.ProduceMaxBh;
import appstu.tuil.RetrieveObject;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLOutput;
import java.util.Vector;
import Object.*;

public class JF_view_sysset_class extends JFrame {

    String gradeID[]=null;
    public JF_view_sysset_class() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        splitPane1 = new JSplitPane();
        panel5 = new JPanel();
        panel7 = new JPanel();
        label4 = new JLabel();
        comboBox1 = new JComboBox<>();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        panel1 = new JPanel();
        panel2 = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        panel3 = new JPanel();
        label2 = new JLabel();
        textField2 = new JTextField();
        panel4 = new JPanel();
        label3 = new JLabel();
        textField3 = new JTextField();

        //======== this ========
        setSize(592,608);
        setTitle("班级信息设置");
        setVisible(true);
        var contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        initialize_grade();

        //======== splitPane1 ========
        {
            splitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);
            splitPane1.setDividerLocation(500);

            //======== panel5 ========
            {
                panel5.setLayout(new GridBagLayout());
                ((GridBagLayout)panel5.getLayout()).columnWidths = new int[] {0, 0};
                ((GridBagLayout)panel5.getLayout()).rowHeights = new int[] {61, 253, 0};
                ((GridBagLayout)panel5.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
                ((GridBagLayout)panel5.getLayout()).rowWeights = new double[] {1.0, 1.0, 1.0E-4};

                //======== panel7 ========
                {
                    panel7.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 12));

                    //---- label4 ----
                    label4.setText("\u9009\u62e9\u5e74\u7ea7\uff1a");
                    panel7.add(label4);

                    //---- comboBox1 ----
                    comboBox1.addItemListener(new ItemListener() {@Override public void itemStateChanged(ItemEvent e) {
                        buildTable();
    }});
                    panel7.add(comboBox1);

                    //---- button1 ----
                    button1.setText("\u5220\u9664");
                    button1.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {
                        int result=JOptionPane.showOptionDialog(null,"是否删除班级信息数据？","系统提示",
                                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,new String[]{"是","否"},"否");
                        if(result==JOptionPane.NO_OPTION){
                            return;
                        }
                        String sqlStr="delete from tb_classinfo  where classID =  '"+textField2.getText().trim()+"'";
                        JdbcAdapter jdbcAdapter=new JdbcAdapter();
                        if(jdbcAdapter.DeleteObject(sqlStr)){
                            textField1.setText(null);
                            textField2.setText(null);
                            textField3.setText(null);
                            buildTable();
                        }

    }});
                    panel7.add(button1);

                    //---- button2 ----
                    button2.setText("\u6dfb\u52a0");
                    button2.addActionListener(new ActionListener() {
                        @Override public void actionPerformed(ActionEvent e) {
                            if(comboBox1.getItemCount()<=0){
                                return;
                            }
                            int index=comboBox1.getSelectedIndex();
                            String gradeid=gradeID[index];
                            String sqlStr=null,classid=null;
                            sqlStr="select classID from tb_classinfo where gradeID='"+gradeid+"'";
                            ProduceMaxBh pm=new ProduceMaxBh();
                            System.out.println("我在方法item中"+sqlStr+";index="+index);
                            classid=pm.getMaxbh(sqlStr,gradeid);
                            textField1.setText(String.valueOf(comboBox1.getSelectedItem()));
                            textField2.setText(classid);
                            textField3.requestFocus();

    }});
                    panel7.add(button2);

                    //---- button3 ----
                    button3.setText("\u5b58\u76d8");
                    button3.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {
                        int index=comboBox1.getSelectedIndex();
                        Obj_class obj_class=new Obj_class();
                        obj_class.setGradeID(gradeID[index]);
                        obj_class.setClassID(textField2.getText());
                        obj_class.setClassName(textField3.getText());
                        JdbcAdapter jdbcAdapter=new JdbcAdapter();
                        textField1.setText(null);
                        textField2.setText(null);
                        textField3.setText(null);
                        if(jdbcAdapter.InsertOrUpject(obj_class))
                            buildTable();

    }});
                    panel7.add(button3);

                    //---- button4 ----
                    button4.setText("\u9000\u51fa");
                    button4.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {
                        dispose();
    }});
                    panel7.add(button4);
                }
                panel5.add(panel7, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));

                //======== scrollPane1 ========
                {

                    //---- table1 ----
                    table1.setModel(new DefaultTableModel(
                            new Object[][] {
                                    {null, null, null},
                            },
                            new String[] {
                                    "\u73ed\u7ea7\u7f16\u53f7", "\u4e13\u4e1a\u7f16\u53f7", "\u73ed\u7ea7\u540d\u79f0"
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
                            sqlStr="select tb_classinfo.classID,tb_gradeinfo.gradeName,tb_classinfo.className from tb_classinfo INNER JOIN"+" tb_gradeinfo" +
                                    " ON tb_classinfo.gradeID=tb_gradeinfo.gradeID"+" where classid='"+id+"'";
                            Vector vdata=null;
                            RetrieveObject retrive=new RetrieveObject();
                            vdata=retrive.getObjectRow(sqlStr);
                            textField1.setText(vdata.get(1).toString());
                            textField2.setText(vdata.get(0).toString());
                            textField3.setText(vdata.get(2).toString());



    }});
                    scrollPane1.setViewportView(table1);
                }
                panel5.add(scrollPane1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
            }
            splitPane1.setTopComponent(panel5);

            //======== panel1 ========
            {
                panel1.setLayout(new GridLayout(3, 0));

                //======== panel2 ========
                {
                    panel2.setLayout(new BorderLayout());

                    //---- label1 ----
                    label1.setText("年级名称：");
                    panel2.add(label1, BorderLayout.WEST);

                    //---- textField1 ----
                    textField1.setColumns(32);
                    panel2.add(textField1, BorderLayout.EAST);
                }
                panel1.add(panel2);

                //======== panel3 ========
                {
                    panel3.setLayout(new BorderLayout());

                    //---- label2 ----
                    label2.setText("\u73ed\u7ea7\u7f16\u53f7\uff1a");
                    panel3.add(label2, BorderLayout.WEST);

                    //---- textField2 ----
                    textField2.setColumns(32);
                    panel3.add(textField2, BorderLayout.EAST);
                }
                panel1.add(panel3);

                //======== panel4 ========
                {
                    panel4.setLayout(new BorderLayout());

                    //---- label3 ----
                    label3.setText("班级名称：");
                    panel4.add(label3, BorderLayout.WEST);

                    //---- textField3 ----
                    textField3.setColumns(32);
                    textField3.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {
                        int index=comboBox1.getSelectedIndex();
                        Obj_class obj_class=new Obj_class();
                        obj_class.setGradeID(gradeID[index]);
                        obj_class.setClassID(textField2.getText());
                        obj_class.setClassName(textField3.getText());
                        JdbcAdapter jdbcAdapter=new JdbcAdapter();
                        textField1.setText(null);
                        textField2.setText(null);
                        textField3.setText(null);
                        if(jdbcAdapter.InsertOrUpject(obj_class))
                            buildTable();


    }});
                    panel4.add(textField3, BorderLayout.EAST);
                }
                panel1.add(panel4);
            }
            splitPane1.setBottomComponent(panel1);
        }
        buildTable();
        contentPane.add(splitPane1);
        setLocation(800,200);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }
    private void buildTable(){
        DefaultTableModel tablemodel=null;
        String[] name={"班级编号","年级编号","班级名称"};
        if(comboBox1.getItemCount()<=0){
            return;
        }
        int index=comboBox1.getSelectedIndex();
        String gradeid=gradeID[index];
        String sqlStr="select * from tb_classinfo where gradeID= '"+gradeid+"'";
        RetrieveObject bdt=new RetrieveObject();
        tablemodel=bdt.getTableModel(name,sqlStr);
        table1.setModel(tablemodel);
        return;
    }
    public void initialize_grade() {
        comboBox1.removeAllItems();
        String sqlStr = null;
        sqlStr = "select gradeID,gradeName from tb_gradeinfo";
        RetrieveObject retrieve = new RetrieveObject();
        java.util.Collection collection = null;
        java.util.Iterator iterator = null;
        collection = retrieve.getTableCollection(sqlStr);
        iterator = collection.iterator();
        gradeID=new String[collection.size()];
        int i = 0;
        while (iterator.hasNext()) {
            java.util.Vector vdata = (java.util.Vector) iterator.next();
            comboBox1.addItem((String) vdata.get(1));
            gradeID[i]=(String)vdata.get(0);
            i++;
        }
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JSplitPane splitPane1;
    private JPanel panel5;
    private JPanel panel7;
    private JLabel label4;
    private JComboBox<String> comboBox1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel panel1;
    private JPanel panel2;
    private JLabel label1;
    private JTextField textField1;
    private JPanel panel3;
    private JLabel label2;
    private JTextField textField2;
    private JPanel panel4;
    private JLabel label3;
    private JTextField textField3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
