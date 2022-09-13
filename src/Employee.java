
public class Employee {
    private int id;
    private String name;
    private String surname;
    private String gender;

    public Employee(int id, String name, String surname, String gender) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

}







































