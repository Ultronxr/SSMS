package dao.impl;

import dao.StudentDao;
import entity.Student;
import utils.MysqlUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public Student getStudentInfoById(String id){

        Student student = null;
        String sql="SELECT * FROM Student WHERE id=?";
        Connection con = MysqlUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                student = new Student();
                student.setId(rs.getString("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setSex(rs.getString("sex"));
                student.setInstitute(rs.getString("institute"));
                student.setMajor(rs.getString("major"));
                student.setStudentClass(rs.getString("studentClass"));
                student.setBirthday(rs.getString("birthday"));
                student.setStartTime(rs.getString("startTime"));
                student.setGrade(rs.getString("grade"));
                student.setCredit(rs.getInt("credit"));
                student.setSource(rs.getString("source"));
                student.setNationality(rs.getString("nationality"));
                student.setType(rs.getString("type"));
                student.setPoliticalStatus(rs.getString("politicalStatus"));
                student.setGpa(rs.getDouble("gpa"));
                student.setStatus(rs.getString("status"));
            }

        }catch (SQLException e){
            System.out.println("[x] src.main.java.dao.impl-StudentDaoImpl 通过学号获取学生实体类时，连接数据库出错！");
        }finally {
            MysqlUtils.closeConnection(rs, ps, con);
        }
        return student;
    }

    @Override
    public Student getStudentInfoByName(String name){
        Student student = null;
        String sql="SELECT * FROM Student WHERE name=?";
        Connection con = MysqlUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if(rs.next()){
                student = new Student();
                student.setId(rs.getString("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setSex(rs.getString("sex"));
                student.setInstitute(rs.getString("institute"));
                student.setMajor(rs.getString("major"));
                student.setStudentClass(rs.getString("studentClass"));
                student.setBirthday(rs.getString("birthday"));
                student.setStartTime(rs.getString("startTime"));
                student.setGrade(rs.getString("grade"));
                student.setCredit(rs.getInt("credit"));
                student.setSource(rs.getString("source"));
                student.setNationality(rs.getString("nationality"));
                student.setType(rs.getString("type"));
                student.setPoliticalStatus(rs.getString("politicalStatus"));
                student.setGpa(rs.getDouble("gpa"));
                student.setStatus(rs.getString("status"));
            }

        }catch (SQLException e){
            System.out.println("[x] src.main.java.dao.impl-StudentDaoImpl 通过姓名获取学生实体类时，连接数据库出错！");
        }finally {
            MysqlUtils.closeConnection(rs, ps, con);
        }
        return student;
    }

    @Override
    public List<Student> getStudentInfoByCon(String grade, String major, String studentClass){

        List students = new ArrayList<Student>();
        String sql = "SELECT * FROM Student WHERE grade LIKE ? and major LIKE ? and studentClass LIKE ?";
        Connection con = MysqlUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, "%"+grade+"%");
            ps.setString(2, "%"+major+"%");
            ps.setString(3, "%"+studentClass+"%");
            rs = ps.executeQuery();
            while(rs.next()){
                Student student=new Student();
                student = new Student();
                student.setId(rs.getString("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setSex(rs.getString("sex"));
                student.setInstitute(rs.getString("institute"));
                student.setMajor(rs.getString("major"));
                student.setStudentClass(rs.getString("studentClass"));
                student.setBirthday(rs.getString("birthday"));
                student.setStartTime(rs.getString("startTime"));
                student.setGrade(rs.getString("grade"));
                student.setCredit(rs.getInt("credit"));
                student.setSource(rs.getString("source"));
                student.setNationality(rs.getString("nationality"));
                student.setType(rs.getString("type"));
                student.setPoliticalStatus(rs.getString("politicalStatus"));
                student.setGpa(rs.getDouble("gpa"));
                student.setStatus(rs.getString("status"));
                students.add(student);
            }

        }catch (SQLException e){
            System.out.println("[x] src.main.java.dao.impl-StudentDaoImpl-getStudentInfoByCon 按条件搜索学生信息出错！");
        }finally {
            MysqlUtils.closeConnection(rs, ps, con);
        }
        return students;
    }

    @Override
    public boolean updateStatus(String id, String status) {
        String sql = "UPDATE Student SET status=? WHERE id=?";
        Connection con = MysqlUtils.getConnection();
        PreparedStatement ps = null;
        int result = -1;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, status);
            ps.setString(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("[x] src.main.java.dao.impl-StudentDaoImpl-updateStudent 修改学生状态时出错！");
            e.printStackTrace();
            return false;
        } finally {
            MysqlUtils.closeConnection(null, ps, con);
        }
        return true;
    }

    @Override
    public List<Student> getAllStudent(){
        List students=new ArrayList<Student>();
        String sql="SELECT * FROM Student ORDER BY id;";
        Connection con = MysqlUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement(sql);
//            ps.setString(1, name);
            rs = ps.executeQuery();
            while(rs.next()){
                Student student=new Student();
                student = new Student();
                student.setId(rs.getString("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setSex(rs.getString("sex"));
                student.setInstitute(rs.getString("institute"));
                student.setMajor(rs.getString("major"));
                student.setStudentClass(rs.getString("studentClass"));
                student.setBirthday(rs.getString("birthday"));
                student.setStartTime(rs.getString("startTime"));
                student.setGrade(rs.getString("grade"));
                student.setCredit(rs.getInt("credit"));
                student.setSource(rs.getString("source"));
                student.setNationality(rs.getString("nationality"));
                student.setType(rs.getString("type"));
                student.setPoliticalStatus(rs.getString("politicalStatus"));
                student.setGpa(rs.getDouble("gpa"));
                student.setStatus(rs.getString("status"));
                student.setStatus(rs.getString("status"));
                students.add(student);
            }

        }catch (SQLException e){
            System.out.println("[x] src.main.java.dao.impl-StudentDaoImpl 获取全体学生时出错，连接数据库出错！");
        }finally {
            MysqlUtils.closeConnection(rs, ps, con);
        }
        return students;
    }

    @Override
    public boolean insertStudent(Student student) {
        String sql="INSERT into Student VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        //INSERT into Student VALUES("16401010225","陈鸿宇",21,"男","电子与信息","计科","162","1998-01-01","2016-09-15","2020-01-01",88,"浙江","汉","普通本科生","团员","3.75")
        Connection con=MysqlUtils.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, student.getId());
            ps.setString(2, student.getName());
            ps.setString(3, Integer.toString(student.getAge()));
            ps.setString(4, student.getSex());
            ps.setString(5, student.getInstitute());
            ps.setString(6, student.getMajor());
            ps.setString(7, student.getStudentClass());
            ps.setString(8, student.getBirthday());
            ps.setString(9, student.getStartTime());
            ps.setString(10, student.getGrade());
            ps.setString(11, Double.toString(student.getCredit()));
            ps.setString(12,student.getStatus());
            ps.setString(13, student.getSource());
            ps.setString(14, student.getNationality());
            ps.setString(15, student.getType());
            ps.setString(16, student.getPoliticalStatus());
            ps.setString(17, Double.toString(student.getGpa()));

            ps.execute();
        }catch (SQLException e){
            System.out.println("[x] src.main.java.dao.impl-StudentDaoImpl 插入学生出错！");
            e.printStackTrace();
        }finally {
            MysqlUtils.closeConnection(rs, ps, con);
        }
        return false;
    }

    @Override
    public boolean updateStudent(Student student) {
        //String sql = "REPLACE INTO Student VALUES('16401010222', '方材', 21, '男', '电子与信息', '计科', '162', '1998-01-01', '2016-09-15', '2016', 88, '在读', '浙江', '汉', '普通本科生', '群众', 3.75)";
        String sql = "REPLACE INTO Student VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection con = MysqlUtils.getConnection();
        PreparedStatement ps = null;
        int result = -1;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, student.getId());
            ps.setString(2, student.getName());
            ps.setInt(3, student.getAge());
            ps.setString(4, student.getSex());
            ps.setString(5, student.getInstitute());
            ps.setString(6, student.getMajor());
            ps.setString(7, student.getStudentClass());
            ps.setString(8, student.getBirthday());
            ps.setString(9, student.getStartTime());
            ps.setString(10, student.getGrade());
            ps.setDouble(11, student.getCredit());
            ps.setString(12, student.getStatus());
            ps.setString(13, student.getSource());
            ps.setString(14, student.getNationality());
            ps.setString(15, student.getType());
            ps.setString(16, student.getPoliticalStatus());
            ps.setDouble(17, student.getGpa());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("[x] src.main.java.dao.impl-StudentDaoImpl-updateStudent 修改学生信息时出错！");
        } finally {
            MysqlUtils.closeConnection(null, ps, con);
        }
        if (result >= 1) return true;
        else return false;
    }

    @Override
    public boolean delStudentById(String id){
        Student student = getStudentInfoById(id);
        student.setStatus("辍学");
        String sql2 = "INSERT into DropStudent VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String sql3 = "DELETE FROM Student WHERE id=?";
        Connection con = MysqlUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            ps = con.prepareStatement(sql2);
            ps.setString(1, student.getId());
            ps.setString(2, student.getName());
            ps.setString(3, Integer.toString(student.getAge()));
            ps.setString(4, student.getSex());
            ps.setString(5, student.getInstitute());
            ps.setString(6, student.getMajor());
            ps.setString(7, student.getStudentClass());
            ps.setString(8, student.getBirthday());
            ps.setString(9, student.getStartTime());
            ps.setString(10, student.getGrade());
            ps.setString(11, Double.toString(student.getCredit()));
            ps.setString(12,student.getStatus());
            ps.setString(13, student.getSource());
            ps.setString(14, student.getNationality());
            ps.setString(15, student.getType());
            ps.setString(16, student.getPoliticalStatus());
            ps.setString(17, Double.toString(student.getGpa()));
            ps.executeUpdate();

            ps = con.prepareStatement(sql3);
            ps.setString(1, student.getId());
            ps.executeUpdate();

        }catch (SQLException e){
            System.out.println("[x] src.main.java.dao.impl-StudentDaoImpl-delStudentById 连接数据库出错！");
            e.printStackTrace();
        }finally {
            MysqlUtils.closeConnection(rs, ps, con);
        }
        return true;
    }
}
