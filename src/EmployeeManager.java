import java.util.Arrays;
import java.util.Scanner;

public class EmployeeManager {
    Scanner scanner = new Scanner(System.in);
    Employee[] employees = new Employee[19];
    int id = 0;

    public EmployeeManager() {
        welcome();
    }
    public  void welcome() {
        while(true){
                try {
                    System.out.println("********** EMPLOYEE  MANAGEMENT SYSTEM **********");
                    System.out.println("\t You have the right to hire a maximum of 20 employees.");
                    System.out.println("1). Add Employee to the DataBase\n" +
                            "2). Edit Employee details\n" +
                            "3). Delete Employee \n" +
                            "4). Display  Employees working in this company\n" +
                            "5). EXIT\n");
                    System.out.println("Enter your choice: ");
                    String optionStr = scanner.next();
                    int option = 0;
                    option = Integer.parseInt(optionStr);
                    switch (option) {
                        case 1:
                            employeeAdds();
                            break;
                        case 2:
                            employeeEditing();
                            break;
                        case 3:
                            employeeDelete();
                            break;
                        case 4:
                            employeesShow();
                            break;
                        case 5:
                            exitTheSystem();
                            break;
                        default:
                            System.out.println("Please enter one of the options (1, 2, 3, 4, 5)");
                    }
                }catch(NumberFormatException e) {
                    System.out.println("Input String cannot be parsed to Integer.");
                }
            }
        }

        public void employeeAdds(){
            id++;
            if(id > 19) {
                System.out.println("Employees are no longer needed.");
                return;
            }else{
                System.out.println("Enter name of employee ID = " + id);
                String name = scanner.next();
                System.out.println("Enter surname of employee ID = " + id);
                String surname = scanner.next();
                System.out.println("Enter gender of employee ID = " + id);
                String gender = scanner.next();
                employees[id-1] = new Employee(id, name, surname,gender);
            }

        }

        public void employeeEditing(){
            while(true) {
                try {
                    System.out.println("Enter the employee ID you want to change?");
                    int id = scanner.nextInt();
                    System.out.println("Editing employee Nr. " + employees[id-1].getId());
                    System.out.println("Choose which of the information you want to modify: \n" +
                            "1). name \n"+
                            "2). surname \n"+
                            "3). gender\n" +
                            "4). EXIT");
                    String optionStr = scanner.next();
                    int option = Integer.parseInt(optionStr);
                    switch (option){
                        case 1:
                            System.out.println("Enter new name?");
                            String newName = scanner.next();
                            employees[id-1].setName(newName);
                            break;
                        case 2:
                            System.out.println("Enter new surname?");
                            String newSurname = scanner.next();
                            employees[id-1].setSurname(newSurname);
                            break;
                        case 3:
                            System.out.println("Enter new gender?");
                            String newGender = scanner.next();
                            employees[id-1].setGender(newGender);
                            break;
                        case 4:
                            welcome();
                        default:
                            System.out.println("Please enter one of the options (1 or 2 or 3 or 4)");
                    }
                }catch(NumberFormatException e) {
                    System.out.println("Input String cannot be parsed to Integer.");
                }catch (NullPointerException  e){
                    System.out.println("The entered id does not exist.");
                }
            }
        }

        public void employeeDelete(){
            System.out.println(id + " employees are registered in the database!");
            System.out.println("\n Enter the employee ID you want to delete?");
            int idDelete = scanner.nextInt();
            try{

                for(int i = idDelete; i < employees.length - 1; i++){
                    employees[i] = employees[i + 1];

                }
                System.out.println("Employee no." + (employees[id].getId()-1) + " was deleted !");
                id--;
            }catch (NullPointerException e) {
                System.out.println("Enter an existing id !");
            }
        }

        public void employeesShow(){
            while(true) {
                try {
                    System.out.println("1). Viewing all employees \n" +
                            "2). Viewing one employee \n" +
                            "3). Exit");
                    System.out.println("Enter your choice : ");
                    String optionStr = scanner.next();
                    int option = Integer.parseInt(optionStr);
                    switch (option) {
                        case 1:
                            for (int i = 0; i <= id; i++) {
                                System.out.println("Employee id: " + employees[i].getId() + " name: " + employees[i].getName() + " surname: " + employees[i].getSurname() + " gender: " + employees[i].getGender() + ";");
                            }
                            break;
                        case 2:
                            System.out.println("Enter the employee id?");
                            int i = scanner.nextInt();
                            System.out.println("Employee id: " + employees[i].getId() + " name: " + employees[i].getName() + " surname: " + employees[i].getSurname() + " gender: " + employees[i].getGender() + ";");
                            break;
                        case 3:
                            welcome();
                            break;
                        default:
                            System.out.println("Please enter one of the options (1, 2, 3)");
                    }
                }catch(NumberFormatException e) {
                    System.out.println("Input String cannot be parsed to Integer.");
                }catch (NullPointerException  e){
                    System.out.println("The entered id does not exist.");
                }
            }
        }
        public void exitTheSystem(){
            System.out.println("Thank you for choosing our employee data entry system.");
            System.exit(0);
        }
    }











































