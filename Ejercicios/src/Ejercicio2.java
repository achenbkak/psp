import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Ejercicio2 {
    public static void main(String[] args) {
        ProcessBuilder pBuilder = new ProcessBuilder("cmd", "/c", "contar_palabras.bat hola.txt dani");

        try {
            // 1. Iniciamos el proceso fuera del try-with-resources
            Process process2 = pBuilder.start();

            // 2. Pasamos al try-with-resources solo los objetos AutoCloseable
            try (
                BufferedReader bReader2 = new BufferedReader(new InputStreamReader(process2.getInputStream()));
                BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\DAM2\\Desktop\\resultados.txt"));
                BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\DAM2\\Desktop\\resultados.txt"))
            ) {
                String linea1;
                while ((linea1 = bReader2.readLine())!=null) {
                    bw.write(linea1);           // Escribe en el archivo
                    bw.newLine();
                }
                
                String linea;
                // Leemos toda la salida del proceso línea por línea
                while ((linea = br2.readLine()) != null) {
                    System.out.println(linea); // Imprime por consola
                    
                }
            }

            // Opcional: Esperar a que el proceso secundario finalice
            process2.waitFor();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
