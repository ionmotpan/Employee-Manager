package it.step;

public interface EmployeeManager {
    void create(int id, String name, String surname, String gender);
    void view(int id, String all);
    void update(int id, String name, String surname, String gender);
    void delete(int id);
}
