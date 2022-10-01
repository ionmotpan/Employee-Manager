package it.step;

import java.util.ArrayList;

public class ArrayListEmployeeManager implements EmployeeManager{

    ArrayList<Employee> employees = new ArrayList<>();

    @Override
    public  void create(int id, String name, String surname, String gender) {
        employees.add(new Employee(id+1,name,surname,gender));
    }

    @Override
    public void view(int id, String showEmployee) {
        if(showEmployee == "all") {
            for(int i=0; i<id; i++) {
                System.out.println("ID: "+employees.get(i).getId()+", NAME: "+employees.get(i).getName()+", SURNAME: "+employees.get(i).getSurname()+", GENDER: "+employees.get(i).getGender());

            }
        }else{
            System.out.println("ID: "+employees.get(id-1).getId()+", NAME: "+employees.get(id-1).getName()+", SURNAME: "+employees.get(id-1).getSurname()+", GENDER: "+employees.get(id-1).getGender());
        }

    }

    @Override
    public void update(int id, String name, String surname, String gender) {
        employees.get(id-1).setName(name);
        employees.get(id-1).setSurname(surname);
        employees.get(id-1).setGender(gender);
    }

    @Override
    public void delete(int id) {
        employees.remove(id-1);
    }
}
