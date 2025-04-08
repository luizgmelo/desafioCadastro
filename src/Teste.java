package src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Teste {
    public static void main(String[] args) {
        Path path = Path.of("./READE.md");

        try {
            Files.createFile(path.getParent().resolve("pets/arquivoteste.txt"));
        } catch (IOException e) {
            throw new RuntimeException("Erro durante a criação do arquivo");
        }
    }
}
