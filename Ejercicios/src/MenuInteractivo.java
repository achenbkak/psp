import java.io.IOException;

public class MenuInteractivo {
    public static void main(String[] args) {
        while (true) {
            System.out.println("-----------------------------------");
            System.out.println("--> Duermete niño en primer plano");
            System.out.println("--> Duermete niña en segundo plano");
            System.out.println("PIDs");
            System.out.println("-----------------------------------");

            String op = IO.readln();
            switch (op) {
                case "1":
                    primerPlano();
                    break;
                case "2":
                    segundoPlano();
                    break;
                default:
                    break;
            }

            
        }
        
        
    }

    private static void segundoPlano() {
        ProcessBuilder pb = new ProcessBuilder("cmd","c/","timeout /t 10");
            //ns
            try{
                Process p = pb.start();
               
            } catch (IOException e){
                System.out.println(e);
            } 
    }

    private static void primerPlano() {
        ProcessBuilder pb = new ProcessBuilder("cmd","c/","timeout /t 10");
            pb.inheritIO();
            try{
                Process p = pb.start();
                p.waitFor();
            } catch (IOException e){
                System.out.println(e);
            } catch (InterruptedException e){
            
            }
    }
}
