package services;
import domain.Teacher;
import utils.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by MY PC on 2/28/2017.
 */
public class TeacherService {

    /*public Teacher getTeacher(String name, String password) {
        Teacher teacher = null;

        String query = "select * from teachers where name=? and password=?";

        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        try {
            pstm.setString(1, name);
            pstm.setString(2, password);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                teacher = new Teacher();
                teacher.setId(rs.getInt("id"));
                teacher.setName(rs.getString("name"));
                teacher.setPassword(rs.getString("password"));
                teacher.setRole(rs.getString("role"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacher;
    }
*/
   public Teacher getTeacher(int id) {
        Teacher teacher = null;

        String query = "select * from teachers where id=?";

        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        try {
            pstm.setInt(1, id);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                teacher = new Teacher();
                teacher.setId(rs.getInt("id"));
                teacher.setName(rs.getString("name"));
                teacher.setSubject(rs.getString("subject"));
                teacher.setQualification(rs.getString("qualification"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacher;
    }
    public List<Teacher> getTeacherList(){
        List<Teacher> teacherList = new ArrayList<Teacher>();
        String query = "select * from teachers";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        try {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(rs.getInt("id"));
                teacher.setName(rs.getString("name"));
                teacher.setSubject(rs.getString("subject"));
                teacher.setQualification(rs.getString("qualification"));

                teacherList.add(teacher);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return teacherList;
    }

    public void add(Teacher teacher) throws SQLException {
        String query = "insert into teachers (name,subject,qualification) values(?,?,?)";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        pstm.setString(1,teacher.getName());
        pstm.setString(2, teacher.getSubject());
        pstm.setString(3, teacher.getQualification());
        pstm.execute();
    }


    public void update(Teacher teacher) throws SQLException {
        String query = "update teachers set name=?, subject=?, qualification=? where id=?";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        pstm.setString(1, teacher.getName());
        pstm.setString(2, teacher.getSubject());
        pstm.setString(3, teacher.getQualification());
        pstm.setInt(4, teacher.getId());

        pstm.execute();

    }

    public void delete(int id) {
        String query = "delete from teachers where id=? ";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        try {
            pstm.setInt(1, id);
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

