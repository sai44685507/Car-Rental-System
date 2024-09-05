import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Welcome {
   Welcome() {
   }

   public void welcum() {
      try {
         BufferedReader var1 = new BufferedReader(new FileReader("welcome.txt"));

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

      System.out.println("\nStarting the program please wait.....");
      System.out.println("loading up files.....");
   }
}
