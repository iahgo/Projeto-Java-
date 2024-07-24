package org.example.strategy;

import org.example.modelo.Funcionario;

public class ReajusteComumStrategy implements ReajusteStrategy {

    @Override
    public boolean aplicarReajuste(Funcionario funcionario, double percentual) {
        double novoSalario = funcionario.getSalario() * (1 + percentual / 100);
        funcionario.setSalario(novoSalario);
        return true;
    }
}
