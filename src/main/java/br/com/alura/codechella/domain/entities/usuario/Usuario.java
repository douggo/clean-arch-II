package br.com.alura.codechella.domain.entities.usuario;

import br.com.alura.codechella.domain.Endereco;

import java.time.LocalDate;
import java.util.Objects;

public class Usuario {

    private final String cpf;
    private final String nome;
    private final LocalDate nascimento;
    private final String email;
    private Endereco endereco;

    public Usuario(String cpf, String nome, LocalDate nascimento, String email) {
        Validator.validateData(cpf, nome, nascimento, email);
        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = nascimento;
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public String getEmail() {
        return email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", nascimento=" + nascimento +
                ", email='" + email + '\'' +
                ", endereco=" + endereco +
                '}';
    }

    static class Validator {

        public static void validateData(String cpf, String nome, LocalDate nascimento, String email) {
            validateCpf(cpf);
            validateNome(nome);
            validateDataNascimento(nascimento);
            validateEmail(email);
        }

        public static void validateCpf(String cpf) throws IllegalArgumentException {
            if (!Objects.isNull(cpf) && cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
                return;
            }
            throw new IllegalArgumentException("CPF não está no padrão aceito! (xxx.xxx.xxx-xx)");
        }

        public static void validateNome(String nome) throws IllegalArgumentException {
            if (!Objects.isNull(nome) && nome.matches("^[A-Z][a-zA-Z\\s]*$")) {
                return;
            }
            throw new IllegalArgumentException("Nome não foi informado ou não está de acordo com o aceito!");
        }

        public static void validateDataNascimento(LocalDate dataNascimento) throws IllegalArgumentException {
            if (!Objects.isNull(dataNascimento)) {
                return;
            }
            throw new IllegalArgumentException("Data de Nascimento não pode ser nula!");
        }

        public static void validateEmail(String email) {
            if (!Objects.isNull(email) && email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
                return;
            }
            throw new IllegalArgumentException("E-mail não está no padrão aceito!");
        }

    }

}