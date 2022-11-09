package it.step;

import java.time.LocalDate;

public class ArrEmployeeManager implements EmpInterface{

    Employee[] emps = new Employee[100];

    public ArrEmployeeManager() {}

    @Override
    public void view(int id,int type){
        try{
            if(type == 0) {
                System.out.println(id-1);
                System.out.println("Employee no."+emps[id-1].getId()+", name : " + emps[id-1].getName() + ", surname : " + emps[id-1].getSurname() + ", gender : " + emps[id-1].getGender() + ", birthdate : " + emps[id-1].getBirthdate());
            }else {
                if(id == 0) {
                    System.out.println("No Employees !");
                    return;
                }
                for(int i = 0;i< emps.length;i++)  {
                    System.out.println("Employee no."+emps[i].getId()+", name : " + emps[i].getName() + ", surname : " + emps[i].getSurname() + ", gender : " + emps[i].getGender() + ", birthdate : " + emps[i].getBirthdate());
                }
            }
        }catch (NullPointerException e) {}

    }

    @Override
    public void create(int id, String name, String surname,Gender gender, LocalDate birthday) {
        emps[id] = new Employee(id+1,name,surname,gender,birthday);
    }

    @Override
    public void update(int id, String name, String surname,Gender gender, LocalDate birthday) {
        emps[id].setName(name);
        emps[id].setSurname(surname);
        emps[id].setGender(gender);
        emps[id].setBirthdate(birthday);
    }

    @Override
    public void delete(int id) {
        try {
            Employee[] tempArr = new Employee[emps.length-1];

            for(int i = 0,k = 0;i< emps.length;i++) {
                if(i == id) {
                    continue;
                }
                tempArr[k++] = emps[i];

            }

            emps = tempArr;

            for(int i = 0;i<emps.length;i++) {
                try{
                    emps[i].setId(i+1);
                }catch (NullPointerException e) {}
            }
        }catch (NullPointerException e) {
            System.out.println("Enter an existing id !");
        }

    }
}
