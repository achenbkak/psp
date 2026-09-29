import java.util.Scanner;

public class ProcesoEjemplo2{
    
    Scanner SC = new Scanner(System.in); 
    void main() throws Exception {
        boolean ok = true;
        while (ok) {
            IO.println("*******************\n"+
                    "(d) Crear Directorio\n"+
                    "(f) Crear Fichero\n"+
                    "*****************");
            String option = SC.nextLine();

            switch (option) {
                case "d":
                    System.out.println("Introduce el nombre del directorio a crear: ");
                    String dir = SC.nextLine();
                    ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "mkdir " + dir);
                    Process p = pb.start();

                    long pid = p.pid();
                    // Esperar a que acabe el proceso
                    int exitCode = p.waitFor();
            
                    if (exitCode == 0){
                        IO.println("[Proceso] pid: " + pid + " acabado correctamente.");
                    }
                    else{
                        IO.println("[Proceso] pid: " + pid + " con problema desconocido.");
                    }
                break;
                case "f":
                    IO.println("Introduce el nombre del archivo a crear: ");
                    String file = SC.nextLine();
                    ProcessBuilder pb2 = new ProcessBuilder("cmd", "/c", "type nul > " + file);
                    Process p2 = pb2.start();
                    long pid2 = p2.pid();
                    // Esperar a que acabe el proceso
                    int exitCode2 = p2.waitFor();
                    if (exitCode2 == 0){
                        IO.println("[Proceso] pid: " + pid2 + " acabado correctamente.");
                    }
                    else{
                        IO.println("[Proceso] pid: " + pid2 + " con problema desconocido.");
                    }
                break;
                default:
                    ok = false;
                break;
            }
        }
    }

}
