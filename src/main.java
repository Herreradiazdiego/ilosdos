import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class main extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        String name = file.toAbsolutePath().toString();

        if( name.endsWith(".txt")) {
            Thread conta = new Thread( new counter(name) );
            conta.start();
        }
        return super.visitFile(file, attrs);
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.printf("No es posibe procesar:%30s%n", file.toString()) ;
        return super.visitFileFailed(file, exc);
    }

    public static void main(String[] args) throws IOException {
        long tiempo1;
        long tiempo2 = 0;
        long linea1;
        long linea2 = 0;

        if (args.length == 0){
            System.exit(0);
        }



        Path startingDir = Paths.get(args[0]);
        main contadorLineas = new main();
        Files.walkFileTree(startingDir, contadorLineas);


    }
}