package org.example.builder;

import org.example.modelo.Cargo;
import org.example.modelo.Funcionario;
import org.example.modelo.Setor;

import java.util.ArrayList;
import java.util.List;

// Criacional: Builder
    // O Pattern Builder é utilizado para criar objetos complexos de maneira controlada e passo a passo.
    // Usei FuncionarioBuilder e FuncionarioTerceirizadoBuilder para criar instâncias de Funcionario e FuncionarioTerceirizado, garantindo que todas as propriedades necessárias sejam definidas antes de construir o objeto final.
    // Isso ajuda a evitar construtores longos e complexos, melhorando a legibilidade e a manutenção do código.
    // Problema: Criar objetos complexos com muitos parâmetros pode levar a construtores longos e difíceis de manter.
    // Solução: Utilizar o Pattern Builder para construir objetos passo a passo, garantindo que todos os parâmetros necessários sejam configurados antes da construção do objeto final.

public class FuncionarioBuilder {
    private String nome;
    private String endereco;
    private double salario;
    private Setor setor;
    private Cargo cargo;
    private List<String> telefones = new ArrayList<>();

    public FuncionarioBuilder setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public FuncionarioBuilder setEndereco(String endereco) {
        this.endereco = endereco;
        return this;
    }

    public FuncionarioBuilder setSalario(double salario) {
        this.salario = salario;
        return this;
    }

    public FuncionarioBuilder setSetor(Setor setor) {
        this.setor = setor;
        return this;
    }

    public FuncionarioBuilder setCargo(Cargo cargo) {
        this.cargo = cargo;
        return this;
    }

    public FuncionarioBuilder addTelefone(String telefone) {
        this.telefones.add(telefone);
        return this;
    }

    public Funcionario build() {
        Funcionario funcionario = new Funcionario(nome, endereco, salario, setor, cargo);
        for (String telefone : telefones) {
            funcionario.addTelefone(telefone);
        }
        return funcionario;
    }
}
