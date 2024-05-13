package br.com.alura.codechella;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.gateway.UsuarioUseCaseMemoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.time.LocalDate;

public class MemoryPersistenceTest {

    @Test
    public void shouldExportUsuariosToTxtFile() {
        UsuarioUseCaseMemoryRepository useCaseRepository = new UsuarioUseCaseMemoryRepository();
        String line;

        useCaseRepository.register(new Usuario(
                "123.456.789-90",
                "Douglas",
                LocalDate.parse("1997-02-19"),
                "douglas@mail.com"));

        try {
            FileWriter fw = new FileWriter("usuarios.txt");
            fw.write(useCaseRepository.listAll().toString());
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileInputStream fileInputStream = new FileInputStream("usuarios.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            line = bufferedReader.readLine();
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals(useCaseRepository.listAll().toString(), line);
    }

}