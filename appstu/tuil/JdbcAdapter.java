package appstu.tuil;
import javax.swing.*;
import java.sql.*;
import Object.*;

public class JdbcAdapter {
    private boolean validataID(String id,String tname,String idvalue){
        String sqlStr="select * from "+tname+" where "+id+" = '"+idvalue+"'";
        try{
            Connection con=Commonajdbc.conection;
            Statement pstmt=con.prepareStatement(sqlStr);
            ResultSet rs=null;
            rs=pstmt.executeQuery(sqlStr);
            if(rs.next()){
                if(rs.getInt(1)>0)
                    return true;
            }
        }catch(java.sql.SQLException sql){
            sql.printStackTrace();
            return false;
        }
        return false;
    }
    public boolean  AdapterObject(String sqlStr,String infoStr){
        boolean flag=false;
        try{
            Connection con=Commonajdbc.conection;
            Statement pstmt=con.prepareStatement(sqlStr);
            pstmt.execute(sqlStr);
            flag=true;
            JOptionPane.showMessageDialog(null,infoStr+"数据加载成功！！！",
                    "系统提示",JOptionPane.INFORMATION_MESSAGE);
        }catch(java.sql.SQLException sql){
            sql.printStackTrace();
            flag=true;
        }
        return flag;
    }
    public boolean InsertOrUpject(Obj_student objstudent){
        String sqlStr=null;
        String infoStr;
        if(validataID("stuid","tb_studentinfo",objstudent.getStuid())) {
            sqlStr = "Update tb_studentinfo set stuid = '" + objstudent.getStuid() + "',classID = '" + objstudent.getClassID()
                    + "',stuname = '" + objstudent.getStuname() + "',sex = '" + objstudent.getSex() + "',age='" + objstudent.getAge() + "',addr = '" + objstudent.getAddress() +
                    "',phone='" + objstudent.getPhone() + "' where stuid='" + objstudent.getStuid().trim() + "'";
            infoStr = "更新学生信息";
        }
        else{
            sqlStr = "Insert into tb_studentinfo (stuid,classID,stuname,sex,age,addr,phone)" +
                    "values('" + objstudent.getStuid() + "','" + objstudent.getClassID()
                    + "','" + objstudent.getStuname() + "','" + objstudent.getSex() + "','" + objstudent.getAge() + "','" + objstudent.getAddress() +
                    "','" + objstudent.getPhone() + "')";
            infoStr = "添加学生信息";
        }
        return AdapterObject(sqlStr,infoStr);
    }
    public boolean InsertOrUpject(Obj_class objclass){
        String sqlStr=null;
        String infoStr;
        if(validataID("classID","tb_classinfo",objclass.getClassID())) {
            sqlStr = "Update tb_classinfo set classID = '" + objclass.getClassID() + "',gradeID = '" + objclass.getGradeID()
                    + "',className = '" + objclass.getClassName() + "' where classID='" + objclass.getClassID().trim() + "'";
            infoStr = "更新班级信息";
        }
        else{
            sqlStr = "Insert into tb_classinfo (classID,gradeID,className)" +
                    "values('" + objclass.getClassID() + "','" + objclass.getGradeID()
                    + "','" + objclass.getClassName() + "')";
            infoStr = "添加班级信息";
        }
        return AdapterObject(sqlStr,infoStr);
    }
    public boolean InsertOrUpject(Obj_examkinds objExamkinds){
        String sqlStr=null;
        String infoStr;
        if(validataID("kindID","tb_examkinds",objExamkinds.getKindID())) {
            sqlStr = "Update tb_examkinds set kindID = '" + objExamkinds.getKindID() + "',kindName = '" + objExamkinds.getKindName()
                    + "' where kindID='" + objExamkinds.getKindID().trim() + "'";
            infoStr = "更新考试信息";
        }
        else{
            sqlStr = "Insert into tb_examkinds (kindID,kindName)" +
                    "values('" + objExamkinds.getKindID() + "','" + objExamkinds.getKindName()+"')";
            infoStr = "添加考试信息";
        }
        return AdapterObject(sqlStr,infoStr);
    }
    public boolean InsertOrUpject(Obj_grade objGrade){
        String sqlStr=null;
        String infoStr;
        if(validataID("gradeID","tb_gradeinfo",objGrade.getGradeID())) {
            sqlStr = "Update tb_gradeinfo set gradeID = '" + objGrade.getGradeID() + "',classID = '" + objGrade.getGradeName()
                    + "' where gradeID='" + objGrade.getGradeID().trim() + "'";
            infoStr = "更新年级信息";
        }
        else{
            sqlStr = "Insert into tb_gradeinfo (gradeID,gradeName)" +
                    "values('" + objGrade.getGradeID() + "','" + objGrade.getGradeName()
                    + "')";
            infoStr = "添加年级信息";
        }
        return AdapterObject(sqlStr,infoStr);
    }
    public boolean InsertOrUpject(Obj_grade_sub objGradeSub){
        String sqlStr=null;
        String infoStr;
        if(validataID("stuid","tb_gradeinfo_sub",objGradeSub.getStuid())) {
            sqlStr = "Update tb_gradeinfo_sub set stuid = '" + objGradeSub.getStuid() + "',stuname = '" + objGradeSub.getStuname()
                    + "',kindID = '" + objGradeSub.getKindID() + "',code = '" + objGradeSub.getCode() + "',grade='" +
                    objGradeSub.getGrade() + "',examdate = '" + objGradeSub.getExamdate() + "' where stuid='" + objGradeSub.getStuid().trim() + "'";
            infoStr = "更新考试科目成绩信息";
        }
        else{
            sqlStr = "Insert into tb_gradeinfo_sub (stuid,stuname,kindID,code,grade,examdate)" +
                    "values('" + objGradeSub.getStuid() + "','" + objGradeSub.getStuname()
                    + "','" + objGradeSub.getKindID() + "','" + objGradeSub.getCode() + "','" + objGradeSub.getGrade() + "','" + objGradeSub.getExamdate() +
                     "')";
            infoStr = "添加考试科目成绩信息";
        }
        return AdapterObject(sqlStr,infoStr);
    }
    public boolean InsertOrUpject(Obj_subject objsubject){
        String sqlStr=null;
        String infoStr;
        if(validataID("code","tb_subject",objsubject.getCode())) {
            sqlStr = "Update tb_subject set code = '" + objsubject.getCode() + "',subject = '" + objsubject.getSubject()
                    + "' where code='" + objsubject.getCode().trim() + "'";
            infoStr = "更新考试科目信息";
        }
        else{
            sqlStr = "Insert into tb_subject (code,subject)" +
                    "values('" + objsubject.getCode() + "','" + objsubject.getSubject()
                    + "')";
            infoStr = "添加考试科目信息";
        }
        return AdapterObject(sqlStr,infoStr);
    }
    public boolean InsertOrUpject(Obj_teacher objteacher){
        String sqlStr=null;
        String infoStr;
        if(validataID("teaid","tb_teacher",objteacher.getTeaid())) {
            sqlStr = "Update tb_teacher set teaid = '" + objteacher.getTeaid() + "',classID = '" + objteacher.getClassID()
                    + "',teaname = '" + objteacher.getTeaname() + "',sex = '" + objteacher.getSex() + "',konwledge='" + objteacher.getKnowledge() + "',konwlevel = '"
                    + objteacher.getKnowlevel() + "' where teaid='" + objteacher.getTeaid().trim() + "'";
            infoStr = "更新教师信息";
        }
        else{
            sqlStr = "Insert into tb_teacher (teaid,classID,teaname,sex,konwledge,konwlevel)" +
                    "values('" + objteacher.getTeaid() + "','" + objteacher.getClassID()
                    + "','" + objteacher.getTeaname() + "','" + objteacher.getSex() + "','" + objteacher.getKnowledge() + "','" + objteacher.getKnowlevel() +
                    "')";
            infoStr = "添加教师信息";
        }
        return AdapterObject(sqlStr,infoStr);
    }
    public boolean InsertOrUpject(Obj_user objuser){
        String sqlStr=null;
        String infoStr;
        if(validataID("userid","tb_user",objuser.getUserid())) {
            sqlStr = "Update tb_user set userid = '" + objuser.getUserid() + "',username = '" + objuser.getPass()
                    + "' where userid='" + objuser.getUserid().trim() + "'";
            infoStr = "更新用户信息";
        }
        else{
            sqlStr = "Insert into tb_user (userid,username,pass)" +
                    "values('" + objuser.getUserid() + "','" + objuser.getUsername()
                    + "','" + objuser.getPass() + "')";
            infoStr = "添加用户信息";
        }
        return AdapterObject(sqlStr,infoStr);
    }
    public boolean InsertOrUpdata_Obj_gradeinfo_sub(Obj_grade_sub[] object){
        try{
            Connection con=Commonajdbc.conection;
            Statement stmt=con.createStatement();
            for(int i=0;i<object.length;i++){
                String sqlStr=null;
                if(validataID("stuid","tb_gradeinfo_sub",object[i].getStuid()))
                {
                    sqlStr="update tb_gradeinfo_sub set stuid = '"+object[i].getStuid()+"',stuname= '"+object[i].getStuname()+"',kindID='"
                            +object[i].getKindID()+"',code='"+object[i].getCode()+"',grade='"+object[i].getGrade()+"',examdate='"+object[i].getExamdate()
                    +"'where stuid='"+object[i].getStuid()+"' and kindID = '"+object[i].getKindID()+"' and code = '"+object[i].getCode()+"'";
                }
                else{
                    sqlStr="insert tb_gradeinfo_sub(stuid,stuname,kindID,code,grade,examdate) values('"+object[i].getStuid()+"','"+
                            object[i].getStuname()+"','"+object[i].getKindID()+"','"+object[i].getCode()+"','"+object[i].getGrade()+"','"+object[i].getExamdate()+"')";
                }
                System.out.println("sqlStr="+sqlStr);
                stmt.addBatch(sqlStr);
            }
            stmt.executeBatch();
            JOptionPane.showMessageDialog(null,"学生成绩存盘成功！！！","系统提示",JOptionPane.INFORMATION_MESSAGE);
        }catch(java.sql.SQLException sql){
            sql.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean Delete_gradeinfo_sub(Obj_grade_sub[] object) {
        try {
            Connection con = Commonajdbc.conection;
            Statement stmt = con.createStatement();
            for (int i = 0; i < object.length; i++) {
                String sqlStr=null;
                sqlStr = "delete from tb_gradeinfo_sub where stuid='" + object[i].getStuid() + "'and kindID='"
                        + object[i].getKindID() + "'and code='" + object[i].getCode() + "'";
                System.out.println("sqlStr=" + sqlStr);
                stmt.addBatch(sqlStr);
            }
            stmt.executeBatch();
            JOptionPane.showMessageDialog(null, "学生成绩数据删除成功！！！", "系统提示", JOptionPane.INFORMATION_MESSAGE);
        } catch (java.sql.SQLException sql) {
            sql.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean DeleteObject(String deleteSql){
        String infoStr="删除";
        return AdapterObject(deleteSql,infoStr);
    }
}
//缺失除学生成绩表的其他表的批量删除和添加操作；
