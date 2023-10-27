package JFrame;

import appstu.tuil.RetrieveObject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author lixiang
 */
public class JF_view_sysset_query_grade_hz extends JFrame {
    String gradeid[]=null;
    String gradename[]=null;
    String examkind[]=null;
    String examkindname[]=null;
    public JF_view_sysset_query_grade_hz() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel2 = new JPanel();
        panel3 = new JPanel();
        label1 = new JLabel();
        comboBox1 = new JComboBox();
        label2 = new JLabel();
        comboBox2 = new JComboBox();
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
                panel3.setLayout(new FlowLayout(FlowLayout.RIGHT));

                //---- label1 ----
                label1.setText("\u67e5\u8be2\u7c7b\u578b\uff1a");
                panel3.add(label1);

                //---- comboBox1 ----
                initialize_examkinds();
                panel3.add(comboBox1);
                //---- label2 ----
                label2.setText("\u5e74\u7ea7\uff1a");
                panel3.add(label2);
                initialize_grade();
                panel3.add(comboBox2);

                //---- button1 ----
                button1.setText("\u67e5\u8be2");
                button1.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {
                    initialize();

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
                table1.setModel(new DefaultTableModel());
                scrollPane1.setViewportView(table1);
            }
            panel2.add(scrollPane1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

            //======== panel4 ========
            {
                panel4.setLayout(new FlowLayout(FlowLayout.LEFT));
                panel4.add(label5);
            }
            panel2.add(panel4, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
        }
        contentPane.add(panel2);
        initialize();
        setSize(910, 595);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }
    public void initialize_examkinds() {
        comboBox1.removeAllItems();
        String sqlStr = null;
        sqlStr = "select kindID,kindname from tb_examkinds";
        RetrieveObject retrieve = new RetrieveObject();
        java.util.Collection collection = null;
        java.util.Iterator iterator = null;
        collection = retrieve.getTableCollection(sqlStr);
        iterator = collection.iterator();
        examkind=new String[collection.size()];
        examkindname=new String[collection.size()];
        int i = 0;
        while (iterator.hasNext()) {
            java.util.Vector vdata = (java.util.Vector) iterator.next();
            examkind[i]=String.valueOf(vdata.get(0));
            examkindname[i]=String.valueOf(vdata.get(1));
            comboBox1.addItem((String) vdata.get(1));
            i++;
        }
    }
    public void initialize(){
        String sqlSubject=null;
        Collection collection=null;
        Object[] objects=null;
        sqlSubject="select * from tb_subject";
        RetrieveObject retrieveObject=new RetrieveObject();
        collection=retrieveObject.getTableCollection(sqlSubject);
        objects=collection.toArray();
        String strCode[]=new String[objects.length];
        String strSubject[]=new String[objects.length];
        String[] tbname=new String[objects.length+2];
        tbname[0]="学生编号";
        tbname[1]="学生姓名";
        String sqlStr="select stuid,stuname,";
        for(int i=0;i<objects.length;i++){
            String code=null,subject=null;
            Vector vdata=null;
            vdata=(Vector) objects[i];
            code=String.valueOf(vdata.get(0));
            subject=String.valueOf(vdata.get(1));
            tbname[i+2]=subject;
            if((i+1)==objects.length){
                sqlStr=sqlStr+" SUM(CASE code WHEN '"+code+"'THEN grade ELSE 0 END) AS '"+subject+"'";
            }else{
                sqlStr=sqlStr+" SUM(CASE code WHEN '"+code+"' THEN grade ELSE 0 END) AS '"+subject+"',";
            }
        }
        String whereStr=" where kind";
        whereStr=" where kindID= '"+examkind[comboBox1.getSelectedIndex()]+"' and subString(stuid,1,2) = '"+gradeid[comboBox2.getSelectedIndex()]+"' ";
        sqlStr=sqlStr+"  from tb_gradeinfo_sub "+whereStr+" GROUP BY stuid,stuname ";
        DefaultTableModel tableModel=null;
        RetrieveObject dbt=new RetrieveObject();
        tableModel=dbt.getTableModel(tbname,sqlStr);
        table1.setModel(tableModel);
        if(tableModel.getRowCount()<=0){
            JOptionPane.showMessageDialog(null,"没有找到满足条件的数据！！！","系统提示",JOptionPane.INFORMATION_MESSAGE);
        }
        table1.setRowHeight(24);
        label5.setText("共有数据【"+String.valueOf(table1.getRowCount())+"】条");
    }
    public void initialize_grade() {
        comboBox2.removeAllItems();
        String sqlStr = null;
        sqlStr = "select gradeID,gradeName from tb_gradeinfo";
        RetrieveObject retrieve = new RetrieveObject();
        java.util.Collection collection = null;
        java.util.Iterator iterator = null;
        collection = retrieve.getTableCollection(sqlStr);
        gradeid=new String[collection.size()];
        gradename=new String[collection.size()];
        iterator = collection.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            java.util.Vector vdata = (java.util.Vector) iterator.next();
            gradeid[i]=(String)vdata.get(0);
            gradename[i]=(String)vdata.get(1);
            comboBox2.addItem((String) vdata.get(1));
            i++;
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel2;
    private JPanel panel3;
    private JLabel label1;
    private JComboBox comboBox1;
    private JLabel label2;
    private JComboBox comboBox2;
    private JButton button1;
    private JButton button2;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel panel4;
    private JLabel label5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
