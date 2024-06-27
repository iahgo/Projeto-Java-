import java.util.ArrayList;
import java.util.List;

enum Setor {
    DESENVOLVIMENTO, DEVOPS, BANCO_DE_DADOS
}

enum Cargo {
    ESTAGIARIO, JUNIOR, PLENO, SENIOR
}

class Funcionario {
    private String nome;
    private List<String> telefones;
    private String endereco;
    private double salario;
    private Setor setor;
    private Cargo cargo;

    public Funcionario(String nome, List<String> telefones, String endereco, double salario, Setor setor, Cargo cargo) {
        this.nome = nome;
        this.telefones = telefones;
        this.endereco = endereco;
        this.salario = salario;
        this.setor = setor;
        this.cargo = cargo;
    }

    public void darReajuste(double percentual) {
        this.salario *= (1 + percentual);
    }
}

class FuncionarioTerceirizado extends Funcionario {
    private String empresaContratada;
    private int tempoPrevistoPermanencia;

    public FuncionarioTerceirizado(String nome, List<String> telefones, String endereco, double salario, Setor setor, Cargo cargo, String empresaContratada, int tempoPrevistoPermanencia) {
        super(nome, telefones, endereco, salario, setor, cargo);
        this.empresaContratada = empresaContratada;
        this.tempoPrevistoPermanencia = tempoPrevistoPermanencia;
    }

    @Override
    public void darReajuste(double percentual) {
        // Funcionário terceirizado não recebe reajuste
        System.out.println("Funcionário terceirizado não recebe reajuste.");
    }
}

public class Main {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario("João", List.of("123456789"), "Rua A, 123", 3000.0, Setor.DESENVOLVIMENTO, Cargo.PLENO);
        FuncionarioTerceirizado funcionarioTerceirizado = new FuncionarioTerceirizado("Maria", List.of("987654321"), "Rua B, 456", 2500.0, Setor.DEVOPS, Cargo.JUNIOR, "Empresa X", 12);

        funcionario.darReajuste(0.1); // Exemplo de reajuste para funcionário
        funcionarioTerceirizado.darReajuste(0.1); // Exemplo de tentativa de reajuste para funcionário terceirizado
    }
}

// bad smells: 

// Mistura de Responsabilidades: A classe Funcionario possui a responsabilidade de armazenar dados de um funcionário e também de aplicar reajustes salariais. Isso viola o princípio de responsabilidade única.

// Código Duplicado: A lógica de reajuste salarial está sendo duplicada nas classes Funcionario e FuncionarioTerceirizado. Isso pode levar a problemas de manutenção no futuro se a lógica precisar ser alterada.

// Tipos primitivos em vez de tipos de dados mais apropriados: Em vez de usar double para representar salários, pode ser mais apropriado usar BigDecimal para evitar problemas de precisão de ponto flutuante.

// Utilização de List.of() para telefones: O uso de List.of() com strings para representar telefones pode ser limitante, uma vez que não permite adicionar ou remover telefones facilmente. Seria mais adequado usar uma lista mutável, como ArrayList.

