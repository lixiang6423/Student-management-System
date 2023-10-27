package JFrame;

import appstu.tuil.JdbcAdapter;
import appstu.tuil.ProduceMaxBh;
import appstu.tuil.RetrieveObject;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import Object.*;
/**
 * @author lixiang
 */
public class JF_view_sysset_subject extends JFrame {
    public JF_view_sysset_subject() {
        initComponents();
    }

    private void initComponents() {
        setVisible(true);
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
        panel5 = new JPanel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        String[] name={"科目编号","科目名称"};
        String kindID[]={"01","02"};

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
                                {null, null},
                                {null, null},
                        },
                        new String[] {
                                "\u79d1\u76ee\u7f16\u53f7", "\u79d1\u76ee\u540d\u79f0"
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
                        sqlStr="select * from tb_subject where code='"+id+"'";
                        Vector vdata=null;
                        RetrieveObject retrive=new RetrieveObject();
                        vdata=retrive.getObjectRow(sqlStr);
                        textField1.setText(vdata.get(0).toString());
                        textField2.setText(vdata.get(1).toString());



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
                    panel2.setLayout(new GridLayout(2, 0));

                    //======== panel3 ========
                    {
                        panel3.setLayout(new BorderLayout());

                        //---- label1 ----
                        label1.setText("\u79d1\u76ee\u7f16\u53f7\uff1a");
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
                        label2.setText("\u79d1\u76ee\u540d\u79f0\uff1a");
                        panel4.add(label2, BorderLayout.WEST);

                        //---- textField2 ----
                        textField2.setColumns(26);
                        textField2.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {
                            Obj_subject obj=new Obj_subject();
                            obj.setCode(textField1.getText());
                            obj.setSubject(textField2.getText());
                            JdbcAdapter jdbcAdapter=new JdbcAdapter();
                            textField1.setText(null);
                            textField2.setText(null);
                            if(jdbcAdapter.InsertOrUpject(obj))
                                buildTable();
                            textField1.requestFocus();

    }});
                        panel4.add(textField2, BorderLayout.EAST);
                    }
                    panel2.add(panel4);
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
                        int result=JOptionPane.showOptionDialog(null,"是否删除科目信息数据？","系统提示",
                                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,new String[]{"是","否"},"否");
                        if(result==JOptionPane.NO_OPTION){
                            return;
                        }
                        String sqlStr="delete from tb_subject  where code =  '"+textField1.getText().trim()+"'";
                        JdbcAdapter jdbcAdapter=new JdbcAdapter();
                        if(jdbcAdapter.DeleteObject(sqlStr)){
                            textField1.setText(null);
                            textField2.setText(null);
                            buildTable();
                        }

    }});
                    panel5.add(button1);

                    //---- button2 ----
                    button2.setText("\u6dfb\u52a0");
                    button2.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {
                        String sqlStr=null,classid=null;
                        sqlStr="select code from tb_subject ";
                        ProduceMaxBh pm=new ProduceMaxBh();
                        System.out.println("我在方法item中"+sqlStr);
                        classid=pm.getMaxbh(sqlStr);
                        textField1.setText(classid);
                        textField2.requestFocus();

    }});
                    panel5.add(button2);

                    //---- button3 ----
                    button3.setText("\u5b58\u76d8");
                    button3.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {
                        Obj_subject obj=new Obj_subject();
                        obj.setCode(textField1.getText());
                        obj.setSubject(textField2.getText());
                        JdbcAdapter jdbcAdapter=new JdbcAdapter();
                        textField1.setText(null);
                        textField2.setText(null);
                        if(jdbcAdapter.InsertOrUpject(obj))
                            buildTable();

    }});
                    panel5.add(button3);

                    //---- button4 ----
                    button4.setText("\u9000\u51fa");
                    button4.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {
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
        contentPane.add(splitPane1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        setSize(455, 350);
        buildTable();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }
    private void buildTable(){
        DefaultTableModel tablemodel=null;
        String[] name={"科目编号","科目名称"};
        String sqlStr="select * from tb_subject ";
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
    private JPanel panel5;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
