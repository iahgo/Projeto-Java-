package org.example.strategy;

import org.example.modelo.Funcionario;
import org.example.modelo.FuncionarioTerceirizado;


public class ReajusteTerceirizadoStrategy implements ReajusteStrategy {

    @Override
    public boolean aplicarReajuste(Funcionario funcionario, double percentual) {
        if (funcionario instanceof FuncionarioTerceirizado) {
            System.out.println("Reajuste não aplicável para funcionários terceirizados.");
            return false;
        }
        return true;
    }
}
