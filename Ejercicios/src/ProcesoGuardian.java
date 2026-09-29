import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class ProcesoGuardian {

    public static void main(String[] args) {

        while (true) {
            ProcessBuilder pBuilder2 = new ProcessBuilder("cmd", "/c", "tasklist");
            ProcessBuilder pBuilder3 = new ProcessBuilder("cmd", "/c", "findstr firefox");
            try{
                Process process2 = pBuilder2.start();
                Process process3 = pBuilder3.start();
                try (
                // tasklist -> solo leemos la salida
                
                InputStream inputStream2 = process2.getInputStream();   
                InputStreamReader inputStreamReader2 = new InputStreamReader(inputStream2);
                BufferedReader bReader2 = new BufferedReader(inputStreamReader2); 
                // findstr firefox -> escribimos la entrada y leemos la salida
                
                OutputStream outputStream3 = process3.getOutputStream();
                OutputStreamWriter outputStreamWriter3 = new OutputStreamWriter(outputStream3);
                BufferedWriter bWriter3 = new BufferedWriter(outputStreamWriter3);
                InputStream inputStream3 = process3.getInputStream();   
                InputStreamReader inputStreamReader3 = new InputStreamReader(inputStream3);
                BufferedReader bReader3 = new BufferedReader(inputStreamReader3)
                ) {
                    String salida2;
                    while ((salida2 = bReader2.readLine()) != null) {
                        bWriter3.write(salida2);
                        bWriter3.flush();
                    }
                    
                    String salida3 = bReader3.readLine();
                    if (salida3 == null){
                    abrirFirefox();
                    }
                }
            
            
            } catch (Exception e) {
                System.out.println(e);
            } 
        
    }
    
    }

    public static void abrirFirefox(){
        ProcessBuilder pBuilder = new ProcessBuilder("cmd", "/c", "start firefox https://www.youtube.com/watch?v=djV11Xbc914&list=RDdjV11Xbc914&start_radio=1");
        try {
            pBuilder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}