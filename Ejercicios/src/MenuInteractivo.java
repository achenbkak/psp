import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MenuInteractivo {
    
    static List<Process> background_process = new ArrayList<>();
    public static void main(String[] args) {
        boolean terminado = false;
        while (terminado == false) {
            System.out.println("-----------------------------------");
            System.out.println("--> Duermete niño en primer plano");
            System.out.println("--> Duermete niña en segundo plano");
            System.out.println("--> Duermete niñe con los PIDs");
            System.out.println("--> Duermete niñx que hay que salir");
            System.out.println("-----------------------------------");

            String op = IO.readln();
            switch (op) {
                case "1":
                    primerPlano();
                    break;
                case "2":
                    segundoPlano();
                    break;
                case "3":
                    verPIDs();
                    break;
                case "4":
                    salir();
                    terminado = true;
                    break;
                default:
                    break;
            }
            
        } 
        
    }

    private static void salir() {
        for (Process p : background_process){
            if(p.isAlive()){
                try {
                    p.waitFor();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }

    private static void segundoPlano() {
        ProcessBuilder pb = new ProcessBuilder("ping", "www.google.es");
            //ns
            try{
                Process p = pb.start();
                System.out.println("Iniciando -> [PID] : " + p.pid() + " status : " + p.isAlive());
                background_process.add(p);
            } catch (IOException e){
                System.out.println(e);
            } 
    }

    private static void primerPlano() {
        ProcessBuilder pb = new ProcessBuilder("cmd","/c","timeout /t 10");
            pb.inheritIO();
            try{
                Process p = pb.start();
                p.waitFor();
            } catch (IOException e){
                System.out.println(e);
            } catch (InterruptedException e){
            
            }
        }
        
    public static void verPIDs(){

        for (Process p : background_process){
            System.out.println("[PID] : " + p.pid() + " status : " + p.isAlive()); 
            }

        }
    }

