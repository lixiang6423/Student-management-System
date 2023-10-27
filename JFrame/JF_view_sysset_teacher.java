package JFrame;

import appstu.tuil.JdbcAdapter;
import appstu.tuil.ProduceMaxBh;
import appstu.tuil.RetrieveObject;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import Object.*;

import javax.swing.table.DefaultTableModel;

public class JF_view_sysset_teacher extends JFrame {
    String[] ClassID=null;
    String[]  teaKnowlevel={"高级","一级","二级","三级"};
    String [] teaKnowledge={"助教","讲师","副教授","教授"};
    JLabel jLabel1 = new JLabel("教师编号");
    JTextField jTextField1 = new JTextField();
    JLabel jLabel2 = new JLabel("班级名称");
    JComboBox jComboBox1 = new JComboBox();
    JLabel jLabel3 = new JLabel("教师姓名");
    JTextField jTextField3 = new JTextField();
    JLabel jLabel4 = new JLabel("性别");
    JComboBox jComboBox2 = new JComboBox();
    JLabel jLabel5 = new JLabel("教师职称");
    JComboBox jComboBox3 = new JComboBox();
    JLabel jLabel6 = new JLabel("教师等级");
    JButton jBrefresh = new JButton("刷新");
    JButton jBadd = new JButton("添加");
    JButton jBdel = new JButton("删除");
    JButton jBsave = new JButton("存盘");
    JButton jBexit = new JButton("退出");
    BorderLayout borderLayout1 = new BorderLayout();
    JSplitPane jSplitPane1 = new JSplitPane();
    JPanel jPanel1 = new JPanel();
    FlowLayout flowLayout1 = new FlowLayout();
    JPanel jPanel3 = new JPanel();
    GridLayout gridLayout1 = new GridLayout();
    JScrollPane jScrollPane1 = new JScrollPane();
    JTable jTable1 = new JTable();
    JComboBox jComboBox4 = new JComboBox();
    String classid[] = null;
    public JF_view_sysset_teacher(){

        Init();
    }
    private void Init(){
        setBounds(200,200,800,600);
        Container container = getContentPane();
        getContentPane().setLayout(borderLayout1);
        jSplitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setOpaque(false);
        jSplitPane1.setVerifyInputWhenFocusTarget(false);
        jPanel1.setLayout(flowLayout1);
        jBadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sqlStr=null,teaid=null;
                sqlStr="select teaid from tb_teacher ";
                ProduceMaxBh pm=new ProduceMaxBh();
                System.out.println("我在方法item中"+sqlStr);
                teaid=pm.getMaxbh(sqlStr,true);
                jTextField1.setText(teaid);
                jTextField3.requestFocus();
            }
        });
        jBsave.setMnemonic('0');
        jBsave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Obj_teacher obj=new Obj_teacher();
                obj.setTeaid(jTextField1.getText());;
                obj.setClassID(ClassID[jComboBox1.getSelectedIndex()]);
                obj.setTeaname(jTextField3.getText());
                obj.setSex(jComboBox2.getSelectedItem().toString());
                obj.setKnowledge(jComboBox3.getSelectedItem().toString());
                obj.setKnowlevel(jComboBox4.getSelectedItem().toString());
                JdbcAdapter jdbcdapter=new JdbcAdapter();
                if(jdbcdapter.InsertOrUpject(obj))
                { Refrush();
                    jTextField1.setText(null);
                    jTextField3.setText(null);
                }
            }
        });
        jPanel3.setLayout(gridLayout1);
        gridLayout1.setColumns(4);
        gridLayout1.setRows(3);
        jTextField1.setEnabled(false);
        jTextField1.setText("");
        jTextField3.setText("");

        jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jBrefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    Refrush();
            }
        });
        jBexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        jBdel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result=JOptionPane.showOptionDialog(null,"是否删除班级信息数据？","系统提示",
                        JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,new String[]{"是","否"},"否");
                if(result==JOptionPane.NO_OPTION){
                    return;
                }
                String sqlStr="delete from tb_teacher  where teaid =  '"+jTextField1.getText().trim()+"'";
                JdbcAdapter jdbcAdapter=new JdbcAdapter();
                if(jdbcAdapter.DeleteObject(sqlStr)){
                    jTextField1.setText(null);
                    jTextField3.setText(null);
                    Refrush();
                }

            }
        });
        flowLayout1.setAlignment(FlowLayout.RIGHT);
        jBdel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        Refrush();
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Table_MouseClick();
            }
        });
        jComboBox2.setEditable(true);
        jComboBox4.setEditable(true);
        jPanel1.add(jBrefresh);
        jPanel1.add(jBadd);
        jPanel1.add(jBdel);
        jPanel1.add(jBsave);
        jPanel1.add(jBexit);
        jSplitPane1.add(jPanel3, JSplitPane.BOTTOM);
        jPanel3.add(jLabel1);
        jPanel3.add(jTextField1);
        jPanel3.add(jLabel2);
        jPanel3.add(jComboBox1);
        jPanel3.add(jLabel3);
        jPanel3.add(jTextField3);
        jPanel3.add(jLabel4);
        jPanel3.add(jComboBox3);
        jPanel3.add(jLabel5);
        jComboBox2.addItem("男");
        jComboBox2.addItem("女");
        jPanel3.add(jComboBox2);
        jPanel3.add(jLabel6);
        jPanel3.add(jComboBox4);
        initComboBox1();
        initComboBox3();
        initComboBox4();
        jSplitPane1.add(jScrollPane1, JSplitPane.TOP);
        container.add(jSplitPane1, java.awt.BorderLayout.CENTER);
        jScrollPane1.getViewport().add(jTable1);
        container.add(jPanel1, java.awt.BorderLayout.NORTH);
        setSize(680, 580);
        setVisible(true);
        jSplitPane1.setDividerLocation(400);
        setVisible(true);
    }
    public void initComboBox1() {
        String gradeid = null, classid = null;
        String gradename = null, classname = null;
        String sqlStr = "select classID from tb_classinfo";
        RetrieveObject retrieve = new RetrieveObject();
        java.util.Collection collection = null;
        java.util.Iterator iterator = null;
        collection = retrieve.getTableCollection(sqlStr);
        iterator = collection.iterator();
        RetrieveObject retrive = new RetrieveObject();
        ClassID=new String[collection.size()];
        int i = 0;
        while (iterator.hasNext()) {
            java.util.Vector vdata = (java.util.Vector) iterator.next();
            classid = vdata.get(0).toString();
            ClassID[i]=classid;
            gradeid = classid.substring(0, 2);
            Vector vname=null;
            vname = retrive.getObjectRow("select className from tb_classinfo where classID = '" + classid + "'");
            classname = String.valueOf(vname.get(0));
            vname = retrive.getObjectRow("select gradeName from tb_gradeinfo where gradeID = '" + gradeid + "'");
            gradename = String.valueOf(vname.get(0));
            jComboBox1.addItem(gradename+classname);
            i++;
        }
    }
    public void initComboBox3(){
        int i=0;
        for(i=0;i<teaKnowledge.length;i++){
            jComboBox3.addItem(teaKnowledge[i]);
        }
    }
    public void initComboBox4(){
        int  i=0;
        for(i=0;i<teaKnowlevel.length;i++){
            jComboBox4.addItem(teaKnowlevel[i]);
        }

    }
    public void Table_MouseClick(){
        String id = null;
        String sqlStr = null;
        int selectrow = 0;
        selectrow = jTable1.getSelectedRow();
        if (selectrow < 0)
            return;
        id = jTable1.getValueAt(selectrow, 0).toString();
        sqlStr = "select * from tb_teacher where teaid = '" + id + "'";
        Vector vdata = null;
        RetrieveObject retrive = new RetrieveObject();
        vdata = retrive.getObjectRow(sqlStr);
        String gradeid = null, classid = null;
        String gradename = null, classname = null;
        Vector vname = null;
        classid = vdata.get(1).toString();
        gradeid = classid.substring(0, 2);
        vname = retrive.getObjectRow("select className from tb_classinfo where classID = '" + classid + "'");
        classname = String.valueOf(vname.get(0));
        vname = retrive.getObjectRow("select gradeName from tb_gradeinfo where gradeID = '" + gradeid + "'");
        gradename = String.valueOf(vname.get(0));
        jTextField1.setText(vdata.get(0).toString());
        jComboBox1.setSelectedItem(gradename + classname);
        jTextField3.setText(vdata.get(2).toString());
        jComboBox2.setSelectedItem(vdata.get(3).toString());
        jComboBox3.setSelectedItem(vdata.get(4).toString());
        jComboBox4.setSelectedItem(vdata.get(5).toString());
    }
    public void Refrush(){
        DefaultTableModel tablemodel = null;
        String[] name = { "教书编号", "班级编号", "教师姓名", "教师性别", "教师职称", "教师等级" };
        String sqlStr = "select * from tb_teacher ";
        RetrieveObject bdt = new RetrieveObject();
        tablemodel = bdt.getTableModel(name, sqlStr);
        jTable1.setModel(tablemodel);
        jTable1.setRowHeight(24);
    }
}