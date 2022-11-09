package it.step;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DbEmployeeManager implements EmpInterface {


    public Connection getConnection () {
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_manager", "root", "1984");
            System.out.println("Succesful connected !");
            return connection;
        } catch(SQLException ex) {
            System.out.println("Eroare de conexiune: " + ex.getMessage());
            return null;
        }
    }

    public int getCount() {
        int id = 0;
        String sql = "SELECT id, name, surname, gender, birthdate from employee order by id asc";

        try(Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            while(resultSet.next()) {
                id++;
            }

        } catch (SQLException ex) {
            System.out.println("Nu am putut face selectul!");
        }


        return id;
    }

    public List<Employee> selectAll() {
        List<Employee> result = new ArrayList<>();
        String sql = "SELECT id, name, surname, gender, birthdate from employee order by id asc";

        try(Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {

            // data
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String gender = resultSet.getString("gender");
                LocalDate birthdate = resultSet.getDate("birthdate").toLocalDate();
                result.add(new Employee(id, name, surname, Gender.getGender(gender), birthdate));
            }

        } catch (SQLException ex) {
            System.out.println("Nu am putut face selectul!");
        }


        return result;
    }

    @Override
    public void view(int id, int type) {
        boolean found = false;
        List<Employee> emps = selectAll();
        try {
            if(emps.size() == 0) {
                System.out.println("No Employees !");
            }
            if(type == 1) {
                for(int i = 0;i< emps.size();i++)  {
                    System.out.println(emps.get(i));
                }
            }else if(type == 0) {
                for(Employee e:emps) {
                    if(e.getId() == id) {
                        System.out.println(e);
                        found = true;
                        return;
                    }else {
                        found = false;
                    }
                }

                if(!found) {
                    System.out.println("Doest exist !");
                }
            }

        }catch(NullPointerException e) {
            System.out.println("Enter an existing id !");
        }
    }

    @Override
    public void create(int id, String name, String surname, Gender gender, LocalDate birthday) {

        try {
            String sql = "insert into employee(name,surname,gender,birthdate) values(?,?,?,?)";
            Connection connection = getConnection();
            if(connection!= null) {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1,name);
                statement.setString(2,surname);
                statement.setString(3,gender.toString());
                statement.setDate(4, Date.valueOf(birthday));
                statement.executeUpdate();
                connection.close();
            }

        }catch(SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }

    }

    @Override
    public void update(int id, String name, String surname, Gender gender, LocalDate birthday) {
        try {
            String sql = "update employee set name = ? , surname = ?,gender = ?,birthdate = ? where id = ?";
            Connection connection = getConnection();
            if(connection!= null) {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1,name);
                statement.setString(2,surname);
                statement.setString(3,gender.toString());
                statement.setDate(4, Date.valueOf(birthday));
                statement.setInt(5, id+1);
                statement.executeUpdate();
                connection.close();
            }

        }catch(SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "delete from employee where id = ?";
            Connection connection = getConnection();
            if(connection!= null) {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, id+1);
                statement.executeUpdate();
                connection.close();
            }

        }catch(SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
    }
}
