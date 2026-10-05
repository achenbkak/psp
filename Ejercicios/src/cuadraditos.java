import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class cuadraditos {
    public static void main(String[] args) {
        System.out.println("Ejercicio cuadrados");

        ProcessBuilder pb = new ProcessBuilder("cmd","/c","cuadrados.bat", "1","2","3");
        ProcessBuilder pb2 = new ProcessBuilder("cmd","/c","suma.bat");
        pb2.redirectOutput(new File("solucion.txt"));
        try{
            Process p = pb.start();
            Process p2 = pb2.start();
            try(
                InputStream is = p.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);

                OutputStream os = p2.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);

                //InputStream is2 = p2.getInputStream();
                //InputStreamReader isr2 = new InputStreamReader(is2);
                //BufferedReader br2 = new BufferedReader(isr2);
                
            ){
                String linea;
                while((linea=br.readLine())!=null){
                    bw.write(linea);
                    bw.newLine();
                }
                bw.flush();
                //while ((linea = br2.readLine())!=null) {
                    //System.out.println(linea);
                //}

            }
        } catch (IOException e){
            System.err.println(e);
        }
    }
}
