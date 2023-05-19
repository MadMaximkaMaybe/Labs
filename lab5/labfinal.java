import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class Student {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private Date birthdate;
    private String studentId;

    // конструктор, геттеры и сеттеры
}

public class StudentInfoProgram {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String DB_USER = "your_username";
    private static final String DB_PASSWORD = "your_password";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            List<Student> students = retrieveStudentsByBirthMonth(connection, 6);

            for (Student student : students) {
                System.out.println(student.getFirstName() + " " + student.getLastName());
            }

            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static List<Student> retrieveStudentsByBirthMonth(Connection connection, int month) throws SQLException {
        List<Student> students = new ArrayList<>();

        String query = "SELECT * FROM students WHERE MONTH(birthdate) = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, month);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setLastName(resultSet.getString("last_name"));
            student.setFirstName(resultSet.getString("first_name"));
            student.setMiddleName(resultSet.getString("middle_name"));
            student.setBirthdate(resultSet.getDate("birthdate"));
            student.setStudentId(resultSet.getString("student_id"));

            students.add(student);
        }

        resultSet.close();
        statement.close();

        return students;
    }
}
