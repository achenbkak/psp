import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
//import java.util.ArrayList;
import java.util.List;

public class SumaCuadrados {
    public static void main(String[] args) {
                
        conPipeline();


    }


    public static void conPipeline(){
        ProcessBuilder pBuilder = new ProcessBuilder(
            "cmd", "/c", 
            "psp\\cuadrados.bat","1","2","3","4");
        
        ProcessBuilder pBuilder2 = new ProcessBuilder(
            "cmd", "/c", 
            "psp\\suma.bat");
        // opcion 1
        List<ProcessBuilder> pBuilders = List.of(pBuilder, pBuilder2);
        // opcion 2
        //pBuilders = new ArrayList<>();
        //pBuilders.add(pBuilder);
        //pBuilders.add(pBuilder2);
        try {
            List<Process> procesos = ProcessBuilder.startPipeline(pBuilders);
            Process last = procesos.getLast();//procesos.get(procesos.size()-1);
            
            InputStream iStream = last.getInputStream();
            InputStreamReader input = new InputStreamReader(iStream);
            BufferedReader bReader = new BufferedReader(input);

            String linea;
            while ((linea = bReader.readLine()) != null) {
                System.out.println(linea);
            }
            bReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

    public static void conPipelineyRedireccion(){
        ProcessBuilder pBuilder = new ProcessBuilder(
            "cmd", "/c", 
            "cuadrados.bat");
            File ficheroEntrada = new File("numeros.txt");
            pBuilder.redirectInput(ficheroEntrada);
        
        ProcessBuilder pBuilder2 = new ProcessBuilder(
            "cmd", "/c", 
            "suma.bat");
            File ficheroSalida = new File("solucion.txt");
            pBuilder2.redirectOutput(ficheroSalida);
        // opcion 1
        List<ProcessBuilder> pBuilders = List.of(pBuilder, pBuilder2);
        // opcion 2
        //pBuilders = new ArrayList<>();
        //pBuilders.add(pBuilder);
        //pBuilders.add(pBuilder2);
        try {
            List<Process> procesos = ProcessBuilder.startPipeline(pBuilders);
            Process last = procesos.getLast();
            last.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
