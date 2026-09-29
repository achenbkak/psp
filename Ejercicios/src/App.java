public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        String direccion = IO.readln("Escribe una direcçao");
        ProcessBuilder pb = new ProcessBuilder("ping ",direccion);
        Process p = pb.start();
        while (p.isAlive()){
            IO.println("TRABAJANDO QUE ES GERUNDIO");
            Thread.sleep(1000);
        } 
        //usamos exitvalue pq el while ya nos asegura que el process ha terminao
        int exitCode = p.exitValue();
        if (exitCode==0){
            IO.println("PROCESO OK BABY");
           
        } else {
            IO.println("ERROR FATAL");
        }
        //caca
        //pedodfdg
    }
}
