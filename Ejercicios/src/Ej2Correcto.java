import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Ej2Correcto {
    public static void main(String[] args) {
        String archivoBat = "./contar_palabras.bat";
        String fichero = "hola.txt";
        String palabra = "dani";

        ProcessBuilder pb = new ProcessBuilder(archivoBat,fichero,palabra);
        ProcessBuilder pb2 = new ProcessBuilder("cmd", "/c", "more >> resultados.txt");
        try{
            Process p = pb.start();
            Process p2 = pb2.start();
            try (
            InputStream inputStream = p.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(inputStreamReader);

            OutputStream outputStream = p2.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter bw = new BufferedWriter(outputStreamWriter);
            ){
                String cont = br.readLine();
                bw.write(cont);
                bw.newLine();
                bw.flush();
                
            }
        }
         catch (IOException e){
            System.out.println(e);
        }
    }
}
