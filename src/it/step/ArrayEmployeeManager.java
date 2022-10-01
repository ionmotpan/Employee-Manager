package it.step;

public class ArrayEmployeeManager implements EmployeeManager{
    Employee[] employees = new Employee[19];


    @Override
    public  void create(int id, String name, String surname, String gender) {
        employees[id] = new Employee(id+1, name, surname, gender);
    }

    @Override
    public void view(int id, String showEmployee) {
        if(showEmployee == "all") {
            for(int i=0; i<id; i++) {
                System.out.println("ID: "+employees[i].getId()+", NAME: "+employees[i].getName()+", SURNAME: "+employees[i].getSurname()+", GENDER: "+employees[i].getGender());
            }
        }else{
            System.out.println("ID: "+employees[id-1].getId()+", NAME: "+employees[id-1].getName()+", SURNAME: "+employees[id-1].getSurname()+", GENDER: "+employees[id-1].getGender());
        }

    }

    @Override
    public void update(int id, String name, String surname, String gender) {
        employees[id-1].setName(name);
        employees[id-1].setSurname(surname);
        employees[id-1].setGender(gender);
    }

    @Override
    public void delete(int id) {
        Employee[] temp = new Employee[employees.length-1];

        for(int i=0, k=0; i<employees.length; i++) {
            if(i == (id-1)) {
                continue;
            }
            temp[k++] = employees[i];
        }
        employees = temp;

        for(int i=0;i<employees.length; i++) {
            if(employees[i] != null) {
                employees[i].setId(i+1);
            }
        }
    }

}