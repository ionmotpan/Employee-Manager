package it.step;

import java.time.LocalDate;
import java.util.ArrayList;

public class ArrayListEmployeeManager implements EmpInterface{

    ArrayList<Employee> emps = new ArrayList<Employee>();

    @Override
    public void view(int id,int type) {
        try {
            if(emps.size() == 0) {
                System.out.println("No Employees !");
            }
            if(type == 1) {
                for(int i = 0;i< emps.size();i++)  {
                    System.out.println("Employee no."+emps.get(i).getId() +", name : " + emps.get(i).getName() + ", surname : " + emps.get(i).getSurname() + ", gender : " + emps.get(i).getGender() + ", birthdate : " + emps.get(i).getBirthdate());
                }
            }else if(type == 0) {
                System.out.println("Employee no."+emps.get(id-1).getId() +", name : " + emps.get(id-1).getName() + ", surname : " + emps.get(id-1).getSurname() + ", gender : " + emps.get(id-1).getGender() + ", birthdate : " + emps.get(id-1).getBirthdate());
            }

        }catch(NullPointerException e) {
            System.out.println("Enter an existing id !");
        }
    }

    @Override
    public void create(int id, String name, String surname, Gender gender, LocalDate birthday) {
        emps.add(new Employee(id+1,name,surname,gender,birthday));
    }

    @Override
    public void update(int id, String name, String surname, Gender gender, LocalDate birthday) {
        emps.get(id).setName(name);
        emps.get(id).setSurname(surname);
        emps.get(id).setGender(gender);
        emps.get(id).setBirthdate(birthday);
    }

    @Override
    public void delete(int id) {
        emps.remove(id);
    }
}
