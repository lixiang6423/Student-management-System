package JFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.util.Objects;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class JF_AppMain extends JFrame {
    private static final long serialVersionUID = -8348833890456775157L;
    JPanel contentPane;
    BorderLayout borderLayout1 = new BorderLayout();
    JDesktopPane desktop = new javax.swing.JDesktopPane();
    MenuBarEvent _MenuBarEvent = new MenuBarEvent();
    JMenuBar jMenuBarMain = new JMenuBar();
    JToolBar jToolBarMain = new JToolBar();
    public JF_AppMain() {
        try {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            BuildMenuBar();
            jbInit();
            loadBackgroundImage();
            BuildToolBar();
        }catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    protected void loadBackgroundImage(){
        ImageIcon icon =new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/wsy/main.png")));
        JLabel jl =new JLabel(icon);
        jl.setVisible(true);
        icon.setImage(icon.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT));

        jl.setIcon(icon);
        jl.setBounds(0, 0, 800, 600);
        desktop. add( jl,-2147483648);
        getContentPane().addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int width = e.getComponent().getWidth();
                int heigth = e.getComponent().getHeight();
                icon.setImage(icon.getImage().getScaledInstance(width,heigth, Image.SCALE_DEFAULT));
                jl.setBounds(0, 0,width,heigth);
            }
        });

    }
    private void jbInit() throws Exception {
        jToolBarMain. setFloatable(false);
        this. setJMenuBar(jMenuBarMain);
        contentPane =(JPanel)getContentPane();
        contentPane. setLayout(borderLayout1);
        setSize(new Dimension(570,450));
        setTitle("学生成绩管理系统");
        contentPane. add(desktop, java. awt. BorderLayout. CENTER);
        contentPane. add(jToolBarMain, java. awt. BorderLayout. NORTH);
        _MenuBarEvent.setDeskTop( desktop);
        Dimension screenSize =Toolkit. getDefaultToolkit(). getScreenSize();
        Dimension frameSize =getSize();
        if (frameSize. height >screenSize. height){
            frameSize. height =screenSize. height;
        }
        if (frameSize. width>screenSize. width){
            frameSize. width =screenSize. width;
        }
        setLocation(800,200);
        setVisible(true);
    }

    private void BuildMenuBar() {
        // TODO 自动生成的方法存根
        JMenu[] _jMenu={ new JMenu("【参数设置】"), new JMenu("【基本信息】"), new JMenu("【系统查询】"), new JMenu("【系统管理】")};
        JMenuItem[] _jMenuItem0={ new JMenuItem("【年级设置】"), new JMenuItem("【班级设置】"),new JMenuItem("【考试科目】"), new JMenuItem("【考试类别】")};
        String[] _jMenuItem0Name={" sys_grade"," sys_class"," sys_subject"," sys_examkinds"};
        JMenuItem[] _jMenuItem1={ new JMenuItem("【学生信息】"), new JMenuItem("【教师信息】"),new JMenuItem("【考试成绩】")};
        String[] _jMenuItem1Name={"JF_view_student","JF_view_teacher","JF_view_gradesub"};
        JMenuItem[] _jMenuItem2={ new JMenuItem("【基本信息】"), new JMenuItem("【成绩信息】"),new JMenuItem("【汇总查询】")};
        String[] _jMenuItem2Name={"JF_view_query_jbqk","JF_view_query_grade_mx","JF_view_query_grade_hz"};
        JMenuItem[] _jMenuItem3={ new JMenuItem("【用户维护】"), new JMenuItem("【系统退出】")};
        String[] _jMenuItem3Name={" sys_user_modify","JB_EXIT"};
        Font _MenuItemFont= new Font("宋体",0,12);
        for( int i=0;i<_jMenu.length;i++){
            _jMenu[i].setFont(_MenuItemFont);
            jMenuBarMain.add(_jMenu[i]);
        }
        for(int j=0;j< _jMenuItem0.length;j++){
            _jMenuItem0[j].setFont(_MenuItemFont);
            final String EventName1= _jMenuItem0Name[j];
            _jMenuItem0[j].addActionListener((ActionListener) _MenuBarEvent);
            _jMenuItem0[j].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    _MenuBarEvent.setEventName(EventName1);
                }
            });
            _jMenu[0]. add(_jMenuItem0[j]);
            if (j == 1) {
                _jMenu[0].addSeparator();
            }
        }
        for( int j=0;j<_jMenuItem1. length;j++){
            _jMenuItem1[j].setFont(_MenuItemFont);
            final String EventName1=_jMenuItem1Name[j];
            _jMenuItem1[j].addActionListener(_MenuBarEvent);
            _jMenuItem1[j].addActionListener( new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    _MenuBarEvent.setEventName(EventName1);
                }
            });
            _jMenu[1].add(_jMenuItem1[j]);
            if(j == 1) {
                _jMenu[1].addSeparator();
            }
        }
        for( int j=0;j<_jMenuItem2.length;j++){

            _jMenuItem2[j].setFont(_MenuItemFont);
            final String EventName2= _jMenuItem2Name[j];
            _jMenuItem2[j].addActionListener(_MenuBarEvent);
            _jMenuItem2[j].addActionListener( new ActionListener( ){
                @Override
                public void actionPerformed(ActionEvent e){
                    _MenuBarEvent.setEventName(EventName2);
                }
            });
            _jMenu[2]. add(_jMenuItem2[j]);
            if ( ( j == 0) ) {
                _jMenu[2].addSeparator();
            }
        }
        for( int j=0;j< _jMenuItem3. length;j++){
            _jMenuItem3[j].setFont(_MenuItemFont);
            final String EventName3=_jMenuItem3Name[j];
            _jMenuItem3[j].addActionListener(_MenuBarEvent);
            _jMenuItem3[j].addActionListener( new ActionListener( ){
                @Override
                public void actionPerformed(ActionEvent e){
                    _MenuBarEvent.setEventName(EventName3);

                }
            });
            _jMenu[3]. add(_jMenuItem3[j]);
            if ( j == 0) {
                _jMenu[3].addSeparator( );
            }
        }
    }
    private void BuildToolBar(){
        String ImageName[]={"1.png","2.png","3.png","4.png","5.png",
                "6.png","7.png","8.png"};
        String TipString[]={"成绩科目设置","学生班级设置","添加学生","录入考试成绩","基本信息查询",
                "考试成绩明细查询","年级成绩汇总","系统退出"};
        String ComandString[]={" sys_subject"," sys_class","JF_view_student","JF_view_gradesub",
                "JF_view_query_jbqk",
                "JF_view_query_grade_mx","JF_view_query_grade_hz","JB_EXIT"};
        for (int i =0;i <ComandString. length;i++){
            JButton jb =new JButton();
            ImageIcon image =new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/wsy/" + ImageName[i])));
            jb. setIcon(image);
            jb.setVisible(true);
            jb. setToolTipText(TipString[i]);
            jb. setActionCommand(ComandString[i]);
            jb.addActionListener(_MenuBarEvent);
            jToolBarMain. add(jb);
        }
    }
}
