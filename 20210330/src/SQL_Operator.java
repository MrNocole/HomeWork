package src;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQL_Operator {
    SQL_Connector sql;
    public SQL_Operator(SQL_Connector sql){
        this.sql = sql;
    }

    public void insertStudentByFullInfo(Student student) throws SQLException {
        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO students VALUES ('");
        sb.append(student.getStuID() + "','" + student.getStuName() + "','" + student.getStuSex() + "','" + student.getStuBirthday() + "','" + ((student.isTy())?"是":"否") + "','" + student.getStuLocation() + "')");
        sql.preparedStatement = sql.getConnection().prepareStatement(sb.toString());
        sql.preparedStatement.addBatch();
        sql.preparedStatement.execute();
        sql.preparedStatement.clearBatch();
    }

    public ResultSet getInfoByStuId(String stuId){
        ResultSet resultSet = null;
        try{
            sql.getConnection().setAutoCommit(false);
            StringBuffer sb = new StringBuffer();
            sb.append("SELECT stuID,stuName,stuSex,stuBirthday,stuTY,stuLocation FROM students WHERE stuID='");
            sb.append(stuId);
            sb.append("'");
            resultSet = sql.statement.executeQuery(sb.toString());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    public void updateStuById(String stuId,Student student){
        try{
            String sql_ = "UPDATE students SET stuName=? , stuSex=? , stuBirthday=? , stuTY=? , stuLocation=? WHERE stuID=?";
            PreparedStatement preparedStatement = sql.getConnection().prepareStatement(sql_);
            preparedStatement.setString(1,student.getStuName());
            preparedStatement.setString(2,student.getStuSex());
            preparedStatement.setString(3,student.getStuBirthday());
            preparedStatement.setString(4,student.isTy()?"是":"否");
            preparedStatement.setString(5,student.getStuLocation());
            preparedStatement.setString(6,stuId);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delStuById(String stuId){
        try {
            String sql_ = "DELETE  FROM students WHERE stuID=?";
            PreparedStatement preparedStatement = sql.getConnection().prepareStatement(sql_);
            preparedStatement.setString(1,stuId);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
