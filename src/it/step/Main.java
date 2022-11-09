package it.step;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    static EmpInterface manager;
    static EmployeeKeyboardReader reader;

    public static void main(String[] args) {

        manager = new ArrEmployeeManager();
        reader = new EmployeeKeyboardReader();
        String option = "";
        int id = 0;
        String name = "";
        String surname = "";
        String gender = "";
        String birthdate = "";
        String temp = "";

        temp = reader.readString("Enter which way you want (arr,listarr,database) !");

        if (temp.equalsIgnoreCase("arr")) {
            manager = new ArrEmployeeManager();
        }
        else if(temp.equalsIgnoreCase("listarr")){
            manager = new ArrayListEmployeeManager();
        }else if(temp.equalsIgnoreCase("database")){
            manager = new DbEmployeeManager();
            id = new DbEmployeeManager().getCount();
        }else{
            System.out.println("Enter an existing way !");
        }

    while(true){

            menu();
            option = reader.readString("");

            if (checkValidOption(option)) {
                switch (option) {
                    case "1":

                        System.out.println("Creating Employee No." + (id + 1));

                        name = reader.readString("Enter name: ");
                        surname = reader.readString("Enter surname: ");
                        do {
                            gender = reader.readString("Enter gender(M or F): ");
                        } while (!(gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("F")));
                        birthdate = reader.readString("Enter birthdate :");
                        manager.create(id, name, surname, Gender.getGender(gender), LocalDate.parse(birthdate, DateTimeFormatter.ofPattern("dd/MM/y")));
                        id++;
                        System.out.println("Employee Created succesful !");

                        break;
                    case "2":
                        try {
                            temp = reader.readString("Enter employee (0 - one emp , 1 - all emp): ");

                            if(Integer.parseInt(temp) == 0) {
                                temp = reader.readString("Enter emp id (0-exit)");

                                if(Integer.parseInt(temp) != 0)
                                    manager.view(Integer.parseInt(temp),0);
                            }else if(Integer.parseInt(temp) == 1) {
                                manager.view(id,1);
                            }else {
                                System.out.println("Enter an existing id !");
                            }
                        }catch (NumberFormatException e) {
                            System.out.println("Not a option !");
                        }


                        break;
                    case "3":
                        temp = reader.readString("Enter which emp u want to delete ?");
                        if (checkValidOption(temp)) {

                            manager.delete(Integer.parseInt(temp) - 1);
                            System.out.println("Employee Deleted succesful !");
                            id--;
                        } else {
                            System.out.println("Enter a validated id !");
                        }

                        break;
                    case "4":
                        manager.view(1,1);
                        temp = reader.readString("Enter which emp u want to update ?");
                        if (checkValidOption(temp)) {
                            try {
                                manager.update(Integer.parseInt(temp) - 1, name, surname, Gender.valueOf(gender),LocalDate.parse(birthdate,DateTimeFormatter.ofPattern("dd/MM/y")));

                                System.out.println("Editing Emp no." + (Integer.parseInt(temp)));

                                name = reader.readString("Enter new name: ");
                                surname = reader.readString("Enter new surname: ");
                                do {
                                    gender = reader.readString("Enter new gender(M or F): ");
                                } while (!(gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("F")));

                                birthdate = reader.readString("Enter birthdate :");
                                manager.update(Integer.parseInt(temp) - 1, name, surname, Gender.valueOf(gender),LocalDate.parse(birthdate,DateTimeFormatter.ofPattern("dd/MM/y")));

                                System.out.println("Employee updated succesful !");

                            } catch (NullPointerException e) {
                                System.out.println("Enter an existing id !");
                            }
                        } else {
                            System.out.println("Enter a validated id !");
                        }

                        break;
                    case "5":

                        System.exit(0);

                        break;
                    default:
                        System.out.println("Enter an existing option !");
                }
            } else {
                System.out.println("Enter a valid option !");
            }

        }

    }

    public static boolean checkValidOption(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static void menu() {

        System.out.println("\nEmployee Manager");
        System.out.println("1. Add Employee \n2. View Employee\n3. Delete Employee\n4. Edit Employee\n5. Exit");

    }

}