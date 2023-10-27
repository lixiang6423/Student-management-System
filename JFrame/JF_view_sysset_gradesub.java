package JFrame;

import appstu.tuil.JdbcAdapter;
import appstu.tuil.RetrieveObject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.Date;
import Object.*;

import static java.lang.Float.parseFloat;

public class JF_view_sysset_gradesub extends JFrame {
    BorderLayout borderLayout1 = new BorderLayout();
    JSplitPane jSplitPane1 = new JSplitPane();
    JScrollPane jScrollPane2 = new JScrollPane();
    JPanel jPanel2 = new JPanel();
    FlowLayout flowLayout1 = new FlowLayout();
    JTable jTable1 = new JTable();
    JLabel jLabel1 = new JLabel();
    JComboBox jComboBox1 = new JComboBox();
    JLabel jLabel2 = new JLabel();
    JComboBox jComboBox2 = new JComboBox();
    JButton jBadd = new JButton();
    JButton jBsave = new JButton();
    JButton jBexit = new JButton();
    JScrollPane jScrollPane1 = new JScrollPane();
    JTable jTable2 = new JTable();
    String classid[] = null;
    String examkindid[] = null;
    String examkindname[] = null;
    String subjectcode[] = null;
    String subjectname[] = null;
    JLabel jLabel3 = new JLabel();
    JTextField jTextField1 = new JTextField();
    JButton jBdel = new JButton();
    public JF_view_sysset_gradesub(){
        Init();
    }
    private void Init(){
        setBounds(300,300,800,600);
        getContentPane();
        getContentPane().setLayout(borderLayout1);
        jSplitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setDividerSize(10);
        jPanel2.setLayout(flowLayout1);
        jLabel1.setText("选择班级:");
        jLabel2.setText("考试种类:");
        jBadd.setText("添加");
        jBadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currow;
                currow=jTable1.getSelectedRow();
                if(currow>=0){
                    DefaultTableModel  tableModel=null;
                    String[] name={"学生编号","学生姓名","考试类别","考试科目","考试成绩","考试时间"};
                    tableModel=new DefaultTableModel(name,0);
                    String sqlStr=null;
                    Collection collection=null;
                    Object[] objects=null;
                    Iterator iterator=null;
                    sqlStr="select subject from tb_subject";
                    RetrieveObject retrieveObject=new RetrieveObject();
                    Vector vdata=null;
                    vdata=retrieveObject.getObjectRow(sqlStr);
                    for(int i=0;i<vdata.size();i++){
                        Vector vector=new Vector();
                        if(i==0){
                            vector.addElement(jTable1.getValueAt(currow,0));
                            vector.addElement(jTable1.getValueAt(currow,2));
                            vector.addElement(jComboBox1.getSelectedItem());
                            vector.addElement(vdata.get(i));
                            vector.addElement("");
                            vector.addElement(jTextField1.getText().trim());
                        }else{
                            vector.addElement("");
                            vector.addElement("");
                            vector.addElement("");
                            vector.addElement(vdata.get(i));
                            vector.addElement("");
                            vector.addElement(jTextField1.getText().trim());
                        }
                        tableModel.addRow(vector);
                        jTable2.setModel(tableModel);
                        jTable2.setRowHeight(23);
                    }
                }

            }
        });
        jBsave.setText("存盘");
        jBsave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result=JOptionPane.showOptionDialog(null,"是否保存成绩数据？","系统提示",
                        JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,new String[]{"是","否"},"否");
                if(result==JOptionPane.NO_OPTION){
                    return;
                }
                int rcount=jTable2.getRowCount();
                if(rcount>0){
                    JdbcAdapter jdbcAdapter=new JdbcAdapter();
                    Obj_grade_sub[] object=new Obj_grade_sub[rcount];
                    for(int i=0;i<rcount;i++){
                        object[i]=new Obj_grade_sub();
                        object[i].setStuid(String.valueOf(jTable2.getValueAt(0,0)));
                        object[i].setKindID(examkindid[jComboBox1.getSelectedIndex()]);
                        object[i].setCode(subjectcode[i]);
                        object[i].setStuname(String.valueOf(jTable2.getValueAt(0,1)));
                        String grade2=String.valueOf(jTable2.getValueAt(i,4));
                        float grade= Float.parseFloat(grade2.trim());
                        object[i].setGrade( grade);
                        java.sql.Date rp=null;
                        try{
                            String strrq=String.valueOf(jTable2.getValueAt(i,5));
                            rp=java.sql.Date.valueOf(strrq);
                        }catch(Exception dt){
                            JOptionPane.showMessageDialog(null,"第【"+i+"】行输入的格式有误，请重新输入！！\n" +
                                    dt.getMessage(),"系统提示",JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        String rq=String.valueOf(rp);
                        object[i].setExamdate(rq);
                    }
                    jdbcAdapter.InsertOrUpdata_Obj_gradeinfo_sub(object);
                }
            }

        });
        jBexit.setText("退出");
        jBexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
            }
        });
        jLabel3.setText("考试日期:");
        jTextField1.setPreferredSize(new Dimension(96, 26));
        jTextField1.setText("");
        flowLayout1.setAlignment(FlowLayout.RIGHT);
        jBdel.setText("删除");
        jBdel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showOptionDialog(null, "是否删除成绩信息数据？", "系统提示",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"是", "否"}, "否");
                if (result == JOptionPane.NO_OPTION) {
                    return;
                }
                int rcount = jTable2.getRowCount();
                if (rcount > 0) {
                    JdbcAdapter jdbcAdapter = new JdbcAdapter();
                    Obj_grade_sub[] object = new Obj_grade_sub[rcount];
                    for (int i = 0; i < rcount; i++) {
                        object[i] = new Obj_grade_sub();
                        object[i].setStuid(String.valueOf(jTable2.getValueAt(0, 0)));
                        object[i].setKindID(examkindid[jComboBox1.getSelectedIndex()]);
                        object[i].setCode(subjectcode[i]);
                    }
                    jdbcAdapter.Delete_gradeinfo_sub(object);
                    DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                    model.setRowCount(0);
                }
            }
        });
        jSplitPane1.add(jScrollPane2, JSplitPane.TOP);
        jSplitPane1.add(jScrollPane1, JSplitPane.BOTTOM);
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int currow=jTable1.getSelectedRow();
                if(currow>=0){
                    DefaultTableModel tablemodel=null;
                    String[] name={"学生编号","学生类别","考试类别","考试科目","考试成绩","考试时间"};
                    tablemodel=new DefaultTableModel(name,0);
                    String sqlStr=null;
                    Collection collection=null;
                    Object[]  objects=null;
                    sqlStr="select * from tb_gradeinfo_sub where stuid= '"+jTable1.getValueAt(currow,0)+"' and kindID= '"+examkindid[jComboBox1.getSelectedIndex()]+"'";
                    RetrieveObject retrieveObject=new RetrieveObject();
                    collection=retrieveObject.getTableCollection(sqlStr);
                    objects=collection.toArray();
                    int findindex=0;
                    for(int i=0;i<objects.length;i++){
                        Vector  vector=new Vector();
                        Vector vdata=(Vector) objects[i];
                        String  sujcode=String.valueOf(vdata.get(3));
                        for(int aa=0;aa<subjectcode.length;aa++){
                            if(sujcode.equals(subjectcode[aa])){
                                findindex=aa;
                                System.out.println("findindex="+findindex  );
                            }
                        }
                        if(i==0){
                            vector.addElement(vdata.get(0));
                            vector.addElement(vdata.get(1));
                            vector.addElement(examkindname[Integer.parseInt(String.valueOf((vdata.get(2))))-1]);
                            vector.addElement(subjectname[findindex]);
                            vector.addElement(vdata.get(4));
                            String ksrq=String.valueOf(vdata.get(5));
                            ksrq=ksrq.substring(0,10);
                            System.out.println(ksrq);
                            vector.addElement(ksrq);
                        }else{
                            vector.addElement((""));
                            vector.addElement("");
                            vector.addElement("");
                            vector.addElement(subjectname[findindex]);
                            vector.addElement(vdata.get(4));
                            String ksrq=String.valueOf(vdata.get(5));
                            ksrq=ksrq.substring(0,10);
                            System.out.println(ksrq);
                        }
                        tablemodel.addRow(vdata);
                    }
                    jTable2.setModel(tablemodel);
                    jTable2.setRowHeight(22);
                }
            }
        });
        jScrollPane1.getViewport().add(jTable2);
        jPanel2.add(jLabel3);
        jPanel2.add(jTextField1);
        jPanel2.add(jLabel2);
        jPanel2.add(jComboBox1);
        jPanel2.add(jLabel1);
        jComboBox2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                buildTable();
            }
        });
        jPanel2.add(jComboBox2);
        jPanel2.add(jBadd);
        jPanel2.add(jBdel);
        jPanel2.add(jBsave);
        jPanel2.add(jBexit);
        jScrollPane2.getViewport().add(jTable1);
        add(jPanel2, java.awt.BorderLayout.NORTH);
        add(jSplitPane1, java.awt.BorderLayout.CENTER);
        initialize();
        setSize(700, 500);
        setVisible(true);
        jSplitPane1.setDividerLocation(159);
        setVisible(true);
    }
    public void initialize(){
        RetrieveObject retrieveObject=new RetrieveObject();
        Vector vdata=new Vector();
        String sqlStr=null;
        Collection  collection=null;
        Iterator iterator=null;
        sqlStr="select * from  tb_examkinds";
        collection=retrieveObject.getTableCollection(sqlStr);
        iterator=collection.iterator();
        examkindid=new String[collection.size()];
        examkindname=new String[collection.size()];
        int i=0;
        while(iterator.hasNext()){
            vdata=(Vector) iterator.next();
            examkindid[i]=String.valueOf(vdata.get(0));
            examkindname[i]=String.valueOf(vdata.get(1));
            jComboBox1.addItem(vdata.get(1));
            i++;
        }
        sqlStr = "select classID from tb_classinfo";
        RetrieveObject retrieve = new RetrieveObject();
        collection = null;
        iterator = null;
        collection = retrieve.getTableCollection(sqlStr);
        iterator = collection.iterator();
        RetrieveObject retrive = new RetrieveObject();
        String classname=null,gradename=null,classID=null,gradeid=null;
        classid=new String[collection.size()];
        i=0;
        while (iterator.hasNext()) {
            vdata = (java.util.Vector) iterator.next();
            classID = vdata.get(0).toString();
            classid[i]=classID;
            gradeid = classID.substring(0, 2);
            Vector vname=null;
            vname = retrive.getObjectRow("select className from tb_classinfo where classID = '" + classID + "'");
            classname = String.valueOf(vname.get(0));
            vname = retrive.getObjectRow("select gradeName from tb_gradeinfo where gradeID = '" + gradeid + "'");
            gradename = String.valueOf(vname.get(0));
            jComboBox2.addItem(gradename+classname);
            i++;
        }
        sqlStr="select * from tb_subject";
        collection=retrieveObject.getTableCollection(sqlStr);
        iterator=collection.iterator();
        subjectcode=new String[collection.size()];
        subjectname=new String[collection.size()];
        i=0;
        while(iterator.hasNext()){
            vdata=(Vector) iterator.next();
            subjectcode[i]=String.valueOf(vdata.get(0));
            subjectname[i]=String.valueOf(vdata.get(1));
            i++;
        }
        long nCurrentTime=System.currentTimeMillis();
        Calendar calendar=Calendar.getInstance(new Locale("CN"));
        calendar.setTimeInMillis(nCurrentTime);
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH)+1;
        int day=calendar.get(Calendar.DAY_OF_MONTH);
        String mm,dd;
        if(month<10){
            mm="0"+String.valueOf(month);
        }else{
            mm=String.valueOf(month);
        }
        if(day<10){
            dd="0"+String.valueOf(day);
        }else{
            dd=String.valueOf(day);
        }
        Date date=Date.valueOf(year+"-"+mm+"-"+dd);
        jTextField1.setText(String.valueOf(date));
        buildTable();
    }
    public void buildTable(){
        DefaultTableModel tablemodel=null;
        String[] name={"学生编号","班级编号","学生姓名","学生性别","学生年龄","家庭住址","联系电话"};
        if(jComboBox2.getItemCount()<=0){
            return;
        }
        int index=jComboBox2.getSelectedIndex();
        String classid=this.classid[index];
        String sqlStr="select * from tb_studentinfo where classID= '"+classid+"'";
        RetrieveObject bdt=new RetrieveObject();
        tablemodel=bdt.getTableModel(name,sqlStr);
        jTable1.setModel(tablemodel);
        return;
    }

}