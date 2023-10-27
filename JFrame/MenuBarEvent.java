package JFrame;
import appstu.tuil.Commonajdbc;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultDesktopManager;
import javax.swing.JOptionPane;
import javax.swing.event.AncestorListener;

public class MenuBarEvent implements ActionListener {
    private javax.swing.JDesktopPane JDeskTop = null;
    private String EventName = "";
    private DefaultDesktopManager desktopManager = new DefaultDesktopManager();
    public void setDeskTop(javax.swing.JDesktopPane deskTop) {
        this.JDeskTop = deskTop;
    }
    public void setEventName(String eventName) {
        this.EventName = eventName;
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("e.getActionCommand() = " + e.getActionCommand() + ";EventName = " + EventName);
        if(e.getActionCommand().equals("JB_EXIT") || EventName.equals("JB_EXIT")) {
            DefaultDesktopManager mnanager = new DefaultDesktopManager();
            int result = JOptionPane.showOptionDialog(null, "是否真的退出学生系统！！！", "系统提示ʾ", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,new String[] {"是","否"}, "否" );
            if(result == JOptionPane.YES_OPTION) {
                try {
                    Commonajdbc.conection.close();
                }catch(java.sql.SQLException sql) {
                    sql.printStackTrace();
                }
                System.exit(0);
            }
            return;
        }
        if(e.getActionCommand( ). equals(" sys_class")||EventName. equals(" sys_class")){
            JF_view_sysset_class jfInternalFrame= new JF_view_sysset_class();
            return;
        }
        if(e.getActionCommand( ). equals(" sys_grade")||EventName. equals(" sys_grade")){
            JF_view_sysset_grade jfInternalFrame= new JF_view_sysset_grade();
            jfInternalFrame. setLocation(800,200);
            jfInternalFrame. show();
            jfInternalFrame. setTitle("年级信息设置");
            return;
        }
        if(e.getActionCommand( ). equals(" sys_subject")||EventName. equals(" sys_subject")){
            JF_view_sysset_subject jfInternalFrame= new JF_view_sysset_subject();
            jfInternalFrame. setLocation(850,210);
            jfInternalFrame. show();
            jfInternalFrame. setTitle("考试科目信息设置");
            return;
        }
        if(e.getActionCommand( ). equals(" sys_examkinds")||EventName. equals(" sys_examkinds")){
            JF_view_sysset_examkinds jfInternalFrame= new JF_view_sysset_examkinds();
            jfInternalFrame. setLocation(800,200);
            jfInternalFrame. show();
            jfInternalFrame. setTitle("考试类别信息设置");
            return;
        }
        if(e.getActionCommand( ). equals("JF_view_student")||EventName. equals("JF_view_student")){
            JF_view_sysset_student jfInternalFrame= new JF_view_sysset_student();
            jfInternalFrame. setLocation(850,210);
            jfInternalFrame. show();
            jfInternalFrame. setTitle("学生信息设置");
            return;
        }
        if(e.getActionCommand( ). equals("JF_view_teacher")||EventName. equals("JF_view_teacher")){
            JF_view_sysset_teacher jfInternalFrame= new JF_view_sysset_teacher();
            jfInternalFrame. setLocation(850,210);
            jfInternalFrame. show();
            jfInternalFrame. setTitle("教师信息设置");
            return;
        }
        if(e.getActionCommand( ). equals("JF_view_gradesub")||EventName. equals("JF_view_gradesub")){
            JF_view_sysset_gradesub jfInternalFrame= new JF_view_sysset_gradesub();
            jfInternalFrame. setLocation(850,210);
            jfInternalFrame. show();
            jfInternalFrame. setTitle("考试成绩信息设置");
            return;
        }
        if(e.getActionCommand( ). equals("JF_view_query_jbqk")||EventName. equals("JF_view_query_jbqk")){
            JF_view_sysset_query_jbqk jfInternalFrame= new JF_view_sysset_query_jbqk();
            jfInternalFrame. setLocation(850,210);
            jfInternalFrame. show();
            jfInternalFrame. setTitle("基本信息查询");
            return;
        }
        if(e.getActionCommand( ). equals("JF_view_query_grade_mx")||EventName. equals("JF_view_query_grade_mx")){
            JF_view_sysset_query_grade_mx jfInternalFrame= new JF_view_sysset_query_grade_mx();
            jfInternalFrame. setLocation(850,210);
            jfInternalFrame. show();
            jfInternalFrame. setTitle("成绩信息查询");
            return;
        }
        if(e.getActionCommand( ). equals("JF_view_query_grade_hz")||EventName. equals("JF_view_query_grade_hz")){
            JF_view_sysset_query_grade_hz jfInternalFrame= new JF_view_sysset_query_grade_hz();
            jfInternalFrame. setLocation(850,210);
            jfInternalFrame. show();
            jfInternalFrame. setTitle("汇总信息查询");
            return;
        }
        if(e.getActionCommand( ). equals(" sys_user_modify")||EventName. equals(" sys_user_modify")){
            JF_view_sysset_user_modify jfInternalFrame= new JF_view_sysset_user_modify();
            jfInternalFrame. setLocation(850,210);
            jfInternalFrame. show();
            jfInternalFrame. setTitle("用户维护设置");
            return;
        }
    }
}
