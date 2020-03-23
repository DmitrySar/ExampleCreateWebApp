package dao;

import users.Student;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;

public class DBStudent {

    private String driver = "org.h2.Driver";
    private String dbSource = "jdbc:h2:~/tech";
    private String login = "sa";
    private String password = "";

    public ArrayList<Student> getAllStudents() {
        String query = "SELECT * FROM STUDENTS ORDER BY ID";
        ArrayList<Student> students = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(dbSource, login, password);
             Statement statement = connection.createStatement()) {
            Class.forName(driver).getDeclaredConstructor().newInstance();
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                students.add(new Student(result.getInt("ID"),
                        result.getString("NAME"),
                        result.getInt("AGE"),
                        result.getInt("GROUP_NUMBER")));
            }
        } catch (SQLException | ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return students;
    }

    public boolean addStudent(Student student) {
        String query = String.format("INSERT INTO STUDENTS(NAME, AGE, GROUP_NUMBER) VALUES('%s', %d, %d)",
                student.getName(),
                student.getAge(),
                student.getGroupNumber());

        try (Connection connection = DriverManager.getConnection(dbSource, login, password);
             Statement statement = connection.createStatement()) {
            Class.forName(driver).getDeclaredConstructor().newInstance();
            return statement.execute(query);

        } catch (SQLException | ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return false;
    }
}
