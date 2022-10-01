package it.step;

public class Main {
    static EmployeeManager  manager;
    static ManagerKeyboardReader reader;

    public static void main(String[] args) {

        reader = new ManagerKeyboardReader();
        int id= 0;
        boolean endOfCycle;
        String showEmployee;
        String name="";
        String surname="";
        String gender="";
        String arrayListOption;



        do{
            arrayListOption = reader.readString("Alege cu ce doresti sa lucrezi?(ArrayList OR Array)");
           if(arrayListOption.equalsIgnoreCase("ArrayList")) {
               manager = new ArrayListEmployeeManager();
           }else if(arrayListOption.equalsIgnoreCase("Array")) {
               manager = new ArrayEmployeeManager();
           }
        }while((!arrayListOption.equalsIgnoreCase("ArrayList")) && (!arrayListOption.equalsIgnoreCase("Array")));


        while (true) {
            try {
                System.out.println("********** EMPLOYEE  MANAGEMENT SYSTEM **********");
                System.out.println("\t You have the right to hire a maximum of 20 employees.");
                System.out.println("1). Create Employee\n" +
                        "2). View Employee \n" +
                        "3). Update Employee \n" +
                        "4). Delete  Employees \n" +
                        "5). EXIT\n");
                String optionStr = reader.readString("Enter your choice:");
                int option = Integer.parseInt(optionStr);
                switch (option) {
                    case 1:

                        if(id >19) {
                            System.out.println("Employees are no longer needed.");
                            System.exit(0);
                        }else{
                            name = reader.readString(" \nEnter name of employee ID: " + (id+1));
                            surname = reader.readString("Enter surname of employee ID: " + (id+1));
                            gender = reader.readString("Enter gender of employee ID: " + (id+1));
                            manager.create(id, name, surname, gender);
                            id++;
                        }
                        break;
                    case 2:
                        endOfCycle=true;
                        while(endOfCycle){
                            String optionCase = reader.readString("\nEnter your choice: \n"+
                                    "1). Viewing all employees \n" +
                                    "2). Viewing one employee \n" +
                                    "3). Exit");
                                switch (optionCase) {
                                    case "1":
                                        if(id != 0) {
                                            showEmployee = "all";
                                            manager.view(id, showEmployee);
                                        }else{
                                            System.out.println("The number of employee in the system is : " + id);
                                        }
                                        break;
                                    case "2":
                                        if(id != 0) {
                                            String tempID1;
                                            int tempID2 =0;
                                            showEmployee = "one";
                                            do {
                                                try {
                                                    tempID1 = reader.readString("\n Enter the employee id, the number must be greater than 0 and less than or equal to "+ id);
                                                    tempID2 = Integer.parseInt(tempID1);
                                                }catch (NumberFormatException e) {
                                                    System.out.println("Input String cannot be parsed to Integer.");
                                                }
                                            }while (tempID2 > id || tempID2 <= 0 );
                                            manager.view(tempID2, showEmployee);
                                        }else{
                                            System.out.println("The number of employee in the system is : " + id);
                                        }
                                        break;
                                    case "3":
                                        endOfCycle=false;
                                        break;
                                    default:
                                        System.out.println("Please enter one of the options (1, 2, 3)");
                                        break;
                                }
                        }
                        break;
                    case 3:

                        endOfCycle=true;
                        while(endOfCycle){
                            if(id != 0) {
                                String tempID1;
                                int tempID2 =0;
                                showEmployee = "one";
                                do {
                                    try {
                                        tempID1 = reader.readString("\n Enter the employee id you want to update: \n The number must be greater than 0 and less than or equal to "+ id);
                                        tempID2 = Integer.parseInt(tempID1);
                                    }catch (NumberFormatException e) {
                                        System.out.println("Input String cannot be parsed to Integer.");
                                    }
                                }while (tempID2 > id || tempID2 <= 0 );
                                manager.view(tempID2, showEmployee);
                                //endOfCycle = false;

                            }else{
                                System.out.println("The number of employee in the system is : " + id);
                            }
                            endOfCycle = false;
                        }

                        endOfCycle = true;
                        while(endOfCycle) {
                            try {
                                String attrUpdate =  reader.readString("Choose which of the information you want to update: \n" +
                                        "1). name \n"+
                                        "2). surname \n"+
                                        "3). gender\n" +
                                        "4). EXIT");

                                int attrOption = Integer.parseInt(attrUpdate);
                                switch (attrOption) {
                                    case 1:
                                         name = reader.readString("Enter new Name?");
                                        break;
                                    case 2:
                                         surname = reader.readString("Enter new Surname?");
                                        break;
                                    case 3:
                                         gender = reader.readString("Enter new Gender?");
                                        break;
                                    case 4:
                                        manager.update(id, name, surname, gender);
                                        endOfCycle = false;
                                        break;
                                    default:
                                        System.out.println("Please enter one of the options (1, 2, 3)");
                                        break;
                                }
                            }catch (NumberFormatException e) {
                                System.out.println("Input String cannot be parsed to Integer.");
                            }
                        }

                        break;
                    case 4:
                        String tempID1;
                        int tempID2 =0;
                        endOfCycle=true;
                        while(endOfCycle){
                            if(id != 0) {

                                showEmployee = "one";
                                do {
                                    try {
                                        tempID1 = reader.readString("\n Enter the employee id you want to delete: \n The number must be greater than 0 and less than or equal to "+ id);
                                        tempID2 = Integer.parseInt(tempID1);
                                    }catch (NumberFormatException e) {
                                        System.out.println("Input String cannot be parsed to Integer.");
                                    }
                                }while (tempID2 > id || tempID2 <= 0 );
                                manager.view(tempID2, showEmployee);
                            }else{
                                System.out.println("The number of employee in the system is : " + id);
                            }
                            endOfCycle = false;
                        }
                        
                        manager.delete(tempID2);
                        id--;
                        break;
                    case 5:
                        System.out.println("Thank you for choosing our employee data entry system.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Please enter one of the options (1, 2, 3, 4, 5)");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input String cannot be parsed to Integer.");
            }
        }
    }
}









































