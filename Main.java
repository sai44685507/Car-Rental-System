import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


class Customer {
    public String customername;
    public String carmodel;
    public String carnumber;
}


class Rent extends Customer {
    public int days = 0;
    public int rentalfee = 0;
    public Scanner sc = new Scanner(System.in);
    public void getData() {
        login();
        //Scanner sc = new Scanner(System.in);
            System.out.print("\t\t\t\tPlease Enter your Name: ");
            customername = sc.nextLine();
            System.out.println();
            do {
                System.out.println("\t\t\t\tPlease Select a Car");
                System.out.println("\t\t\t\tEnter 'A' for Tesla 20011.");
                System.out.println("\t\t\t\tEnter 'B' for Hyundai 2015.");
                System.out.println("\t\t\t\tEnter 'C' for Ford 2017.");
                System.out.println();
                System.out.print("\t\t\t\tChoose a Car from the above options: ");
                carmodel = sc.next();
                
                System.out.println();
                System.out.println("                                ----------------------------------");
                if (carmodel.equalsIgnoreCase("A")) {
                    System.out.println("\t\t                You have chosen Tesla model 2011");
                    displayCarDetails("A.txt");
                } else if (carmodel.equalsIgnoreCase("B")) {
                    System.out.println("\t\t                You have chosen Hyundai model 2015");
                    displayCarDetails("B.txt");
                } else if (carmodel.equalsIgnoreCase("C")) {
                    System.out.println("\t\t                You have chosen Ford model 2017");
                    displayCarDetails("C.txt");
                } else {
                    System.out.println("Invalid Car Model. Please try again!");
                }
            } while (!carmodel.equalsIgnoreCase("A") && !carmodel.equalsIgnoreCase("B")
                    && !carmodel.equalsIgnoreCase("C"));

            System.out.println("                                ----------------------------------");
            System.out.println("\t\t                Please provide the following information:");
            System.out.print("\t\t                Please select a Car No. : ");
            carnumber = sc.nextLine();
            System.out.print("\t\t                Number of days you wish to rent the car : ");
            days = sc.nextInt();
        
        System.out.println();
    }

    private void displayCarDetails(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void login() {
        String pass;
        do {
            pass = getPassword();
            if (pass.equals("pass")) {
                System.out.println("\n\n\n\t\t\t\t\t\tAccess Granted! \n");
            } else {
                System.out.println("\n\n\t\t\t\t\t\t\tAccess Aborted...\n\t\t\t\t\t\t\tPlease Try Again\n\n");
            }
        } while (!pass.equals("pass"));
    }
    private static String getPassword() { 
           try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\n\n\n\n\n\n\n\n\t\t\t\t\t       CAR RENTAL SYSTEM \n\n");
            System.out.println("\t\t\t\t\t------------------------------");
            System.out.println("\t\t\t\t\t\t     LOGIN \n");
            System.out.println("\t\t\t\t\t------------------------------\n\n");
            System.out.print("\t\t\t\t\tEnter Password: ");
            return sc.nextLine();
        }
        
        
    }


    public void calculate() {
       System.out.println("Calculating rent. Please wait......");
        if (carmodel.equalsIgnoreCase("A")) {
            rentalfee = days * 56;
        } else if (carmodel.equalsIgnoreCase("B")) {
            rentalfee = days * 60;
        } else if (carmodel.equalsIgnoreCase("C")) {
            rentalfee = days * 75;
        }
    }

    public void showRent() {
        System.out.println("\n\t\t                       Car Rental - Customer Invoice");
        System.out.println("\t\t	///////////////////////////////////////////////////////////");
        System.out.println("\t\t   | Invoice No. :" + "------------------|" + String.format("%10s", "#Cnb81353") + " |");
        System.out.println("\t\t	| Customer Name:" + "-----------------|" + String.format("%10s", customername) + " |");
        System.out.println("\t\t	| Car Model :" + "--------------------|" + String.format("%10s", carmodel) + " |");
        System.out.println("\t\t	| Car No. :" + "----------------------|" + String.format("%10s", carnumber) + " |");
        System.out.println("\t\t	| Number of days :" + "---------------|" + String.format("%10s", days) + " |");
        System.out.println("\t\t	| Your Rental Amount is :" + "--------|" + String.format("%10s", rentalfee) + " |");
        System.out.println("\t\t	| Caution Money :" + "----------------|" + String.format("%10s", 0) + " |");
        System.out.println("\t\t	| Advanced :" + "---------------------|" + String.format("%10s", 0) + " |");
        System.out.println("\t\t	 ____________________");
        System.out.println("\n");
        System.out.println("\t\t	| Total Rental Amount is :" + "-------|" + String.format("%10s", rentalfee) + " |");
        System.out.println("\t\t	 ____________________");
        System.out.println("\t\t	 # This is a computer-generated invoice and it does not");
        System.out.println("\t\t	 require an authorized signature #");
        System.out.println(" ");
        System.out.println("\t\t	///////////////////////////////////////////////////////////");
        System.out.println("\t\t	You are advised to pay up the amount before the due date.");
        System.out.println("\t\t	Otherwise penalty fee will be applied");
        System.out.println("\t\t	///////////////////////////////////////////////////////////");
        try (BufferedReader br = new BufferedReader(new FileReader("thanks.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Welcome {
    public void welcum() {
        try (BufferedReader br = new BufferedReader(new FileReader("welcome.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\nStarting the program please wait.....");
        System.out.println("loading up files.....");
    }
}

public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Welcome obj1 = new Welcome();
        obj1.welcum();
        Rent obj2 = new Rent();
        obj2.getData();
        obj2.calculate();
        obj2.showRent();
    }
    
    
}
