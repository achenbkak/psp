
import java.io.File;


public class ContarAparaciones {
    public static void main(String[] args) {
        String archivoBat = "C:\\Users\\DAM2\\Desktop\\psps\\psp\\contar_palabras.bat";
        String palabra = "in";
        String f = "C:\\Users\\DAM2\\Desktop\\psps\\psp\\Ejercicios\\src\\loreipsum.txt";
        ProcessBuilder pBuilder = new ProcessBuilder( 
                archivoBat, palabra);
        pBuilder.redirectInput(new File(f));
        pBuilder.redirectOutput(new File("C:\\Users\\DAM2\\Desktop\\psps\\resultado.txt"));
      
        try{
            Process process = pBuilder.start();
            process.waitFor();
            
        }catch (Exception e) {
            System.out.println(e);
        }
        
    }
}
