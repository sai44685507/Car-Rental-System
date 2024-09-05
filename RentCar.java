import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

class Rent extends Customer {
   public int days = 0;
   public int rentalfee = 0;

   Rent() {
   }

   public void getData() {
      login();
      Scanner var1 = new Scanner(System.in);

      try {
         System.out.print("\t\t\t\tPlease Enter your Name: ");
         this.customername = var1.next();
         System.out.println();
         while(true) {
            System.out.println("\t\t\t\tPlease Select a Car");
            System.out.println("\t\t\t\tEnter 'A' for Tesla 20011.");
            System.out.println("\t\t\t\tEnter 'B' for Hyundai 2015.");
            System.out.println("\t\t\t\tEnter 'C' for Ford 2017.");
            System.out.println();
            System.out.print("\t\t\t\tChoose a Car from the above options: ");
            this.carmodel = var1.nextLine();
            System.out.println();
            System.out.println("                                ----------------------------------");
            if (this.carmodel.equalsIgnoreCase("A")) {
               System.out.println("\t\t                You have chosen Tesla model 2011");
               this.displayCarDetails("A.txt");
            } else if (this.carmodel.equalsIgnoreCase("B")) {
               System.out.println("\t\t                You have chosen Hyundai model 2015");
               this.displayCarDetails("B.txt");
            } else if (this.carmodel.equalsIgnoreCase("C")) {
               System.out.println("\t\t                You have chosen Ford model 2017");
               this.displayCarDetails("C.txt");
            } else {
               System.out.println("Invalid Car Model. Please try again!");
            }

            if (this.carmodel.equalsIgnoreCase("A") || this.carmodel.equalsIgnoreCase("B") || this.carmodel.equalsIgnoreCase("C")) {
               System.out.println("                                ----------------------------------");
               System.out.println("\t\t                Please provide the following information:");
               System.out.print("\t\t                Please select a Car No. : ");
               this.carnumber = var1.nextLine();
               System.out.print("\t\t                Number of days you wish to rent the car : ");
               this.days = var1.nextInt();
               break;
            }
         }
      } catch (Throwable var5) {
         try {
            var1.close();
         } catch (Throwable var4) {
            var5.addSuppressed(var4);
         }

         throw var5;
      }

      var1.close();
      System.out.println();
   }

   private void displayCarDetails(String var1) {
      try {
         BufferedReader var2 = new BufferedReader(new FileReader(var1));

         String var3;
         try {
            while((var3 = var2.readLine()) != null) {
               System.out.println(var3);
            }
         } catch (Throwable var6) {
            try {
               var2.close();
            } catch (Throwable var5) {
               var6.addSuppressed(var5);
            }

            throw var6;
         }

         var2.close();
      } catch (IOException var7) {
         var7.printStackTrace();
      }

   }

   private static void login() {
      String var0;
      do {
         var0 = getPassword();
         if (var0.equals("pass")) {
            System.out.println("\n\n\n\t\t\t\t\t\tAccess Granted! \n");
         } else {
            System.out.println("\n\n\t\t\t\t\t\t\tAccess Aborted...\n\t\t\t\t\t\t\tPlease Try Again\n\n");
         }
      } while(!var0.equals("pass"));

   }

   private static String getPassword() {
      Scanner var0 = new Scanner(System.in);

      String var1;
      try {
         System.out.print("\n\n\n\n\n\n\n\n\t\t\t\t\t       CAR RENTAL SYSTEM \n\n");
         System.out.println("\t\t\t\t\t------------------------------");
         System.out.println("\t\t\t\t\t\t     LOGIN \n");
         System.out.println("\t\t\t\t\t------------------------------\n\n");
         System.out.print("\t\t\t\t\tEnter Password: ");
         var1 = var0.nextLine();
      } catch (Throwable var4) {
         try {
            var0.close();
         } catch (Throwable var3) {
            var4.addSuppressed(var3);
         }

         throw var4;
      }

      var0.close();
      return var1;
   }

   public void calculate() {
      System.out.println("Calculating rent. Please wait......");
      if (this.carmodel.equalsIgnoreCase("A")) {
         this.rentalfee = this.days * 56;
      } else if (this.carmodel.equalsIgnoreCase("B")) {
         this.rentalfee = this.days * 60;
      } else if (this.carmodel.equalsIgnoreCase("C")) {
         this.rentalfee = this.days * 75;
      }

   }

   public void showRent() {
      System.out.println("\n\t\t                       Car Rental - Customer Invoice");
      System.out.println("\t\t\t///////////////////////////////////////////////////////////");
      PrintStream var10000 = System.out;
      Object[] var10002 = new Object[]{"#Cnb81353"};
      var10000.println("\t\t   | Invoice No. :------------------|" + String.format("%10s", var10002) + " |");
      var10000 = System.out;
      var10002 = new Object[]{this.customername};
      var10000.println("\t\t\t| Customer Name:-----------------|" + String.format("%10s", var10002) + " |");
      var10000 = System.out;
      var10002 = new Object[]{this.carmodel};
      var10000.println("\t\t\t| Car Model :--------------------|" + String.format("%10s", var10002) + " |");
      var10000 = System.out;
      var10002 = new Object[]{this.carnumber};
      var10000.println("\t\t\t| Car No. :----------------------|" + String.format("%10s", var10002) + " |");
      var10000 = System.out;
      var10002 = new Object[]{this.days};
      var10000.println("\t\t\t| Number of days :---------------|" + String.format("%10s", var10002) + " |");
      var10000 = System.out;
      var10002 = new Object[]{this.rentalfee};
      var10000.println("\t\t\t| Your Rental Amount is :--------|" + String.format("%10s", var10002) + " |");
      var10000 = System.out;
      var10002 = new Object[]{0};
      var10000.println("\t\t\t| Caution Money :----------------|" + String.format("%10s", var10002) + " |");
      var10000 = System.out;
      var10002 = new Object[]{0};
      var10000.println("\t\t\t| Advanced :---------------------|" + String.format("%10s", var10002) + " |");
      System.out.println("\t\t\t ____________________");
      System.out.println("\n");
      var10000 = System.out;
      var10002 = new Object[]{this.rentalfee};
      var10000.println("\t\t\t| Total Rental Amount is :-------|" + String.format("%10s", var10002) + " |");
      System.out.println("\t\t\t ____________________");
      System.out.println("\t\t\t # This is a computer-generated invoice and it does not");
      System.out.println("\t\t\t require an authorized signature #");
      System.out.println(" ");
      System.out.println("\t\t\t///////////////////////////////////////////////////////////");
      System.out.println("\t\t\tYou are advised to pay up the amount before the due date.");
      System.out.println("\t\t\tOtherwise penalty fee will be applied");
      System.out.println("\t\t\t///////////////////////////////////////////////////////////");

      try {
         BufferedReader var1 = new BufferedReader(new FileReader("thanks.txt"));

         String var2;
         try {
            while((var2 = var1.readLine()) != null) {
               System.out.println(var2);
            }
         } catch (Throwable var5) {
            try {
               var1.close();
            } catch (Throwable var4) {
               var5.addSuppressed(var4);
            }

            throw var5;
         }

         var1.close();
      } catch (IOException var6) {
         var6.printStackTrace();
      }

   }
}

