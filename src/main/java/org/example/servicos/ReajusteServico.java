package org.example.servicos;

import org.example.modelo.Funcionario;
import org.example.strategy.ReajusteStrategy;

// Camada de Serviços
    // ReajusteServico encapsula a lógica de negócio para reajustar salários.
    // A lógica de reajuste é separada das entidades, seguindo o princípio de responsabilidade única (SRP) do SOLID.

public class ReajusteServico {

    private ReajusteStrategy reajusteStrategy;

    public ReajusteServico(ReajusteStrategy reajusteStrategy) {
        this.reajusteStrategy = reajusteStrategy;
    }

    public boolean reajustarSalario(Funcionario funcionario, double percentual) {
        return reajusteStrategy.aplicarReajuste(funcionario, percentual);
    }
}
