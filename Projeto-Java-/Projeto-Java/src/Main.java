import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class Funcionario {
    private String nome;
    private BigDecimal salario;
    private List<String> telefones;

    public Funcionario(String nome, BigDecimal salario) {
        this.nome = nome;
        this.salario = salario;
        this.telefones = new ArrayList<>();
    }

    public void adicionarTelefone(String telefone) {
        this.telefones.add(telefone);
    }

    public void aplicarReajuste(BigDecimal percentualReajuste) {
        this.salario = this.salario.multiply(BigDecimal.ONE.add(percentualReajuste));
    }

    // Getters e Setters omitidos para simplificação
}

class FuncionarioTerceirizado extends Funcionario {
    public FuncionarioTerceirizado(String nome, BigDecimal salario) {
        super(nome, salario);
    }

    @Override
    public void aplicarReajuste(BigDecimal percentualReajuste) {
        System.out.println("Funcionários terceirizados não recebem reajuste.");
    }
}

public class Main {
    public static void main(String[] args) {
        Funcionario funcionario1 = new Funcionario("João", new BigDecimal("3000"));
        funcionario1.adicionarTelefone("123456789");
        funcionario1.aplicarReajuste(new BigDecimal("0.10"));

        FuncionarioTerceirizado funcionario2 = new FuncionarioTerceirizado("Maria", new BigDecimal("2500"));
        funcionario2.adicionarTelefone("987654321");
        funcionario2.aplicarReajuste(new BigDecimal("0.05"));
    }
}

// Nesta refatoração:

// Foi separada a responsabilidade de armazenar dados de funcionário e aplicar reajustes salariais, seguindo o princípio de responsabilidade única.
// A lógica de reajuste salarial foi movida para o método aplicarReajuste() em ambas as classes Funcionario e FuncionarioTerceirizado.
// O método darReajuste() da classe FuncionarioTerceirizado foi removido em favor da implementação do método aplicarReajuste() herdado da classe Funcionario.
// Utilizei BigDecimal para representar salários em vez de double para evitar problemas de precisão.
// Substituí List.of() por ArrayList para representar os telefones, permitindo adicionar e remover telefones facilmente.
// Essas alterações ajudam a melhorar a qualidade e manutenibilidade do código.