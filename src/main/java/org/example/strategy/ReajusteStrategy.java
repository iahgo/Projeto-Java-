package org.example.strategy;

import org.example.modelo.Funcionario;

public interface ReajusteStrategy {
    // Comportamental: Strategy
        // O Pattern Strategy é utilizado para definir uma família de algoritmos, encapsulá-los e torná-los intercambiáveis. 
        // Ele permite que o algoritmo varie independentemente dos clientes que o utilizam.
        // No nosso caso, ReajusteServico representa a interface Strategy, e as diferentes implementações de reajuste (comum e terceirizado) representam as estratégias concretas.
        // Isso facilita a adição de novas regras de reajuste no futuro, mantendo o código flexível e extensível.
    boolean aplicarReajuste(Funcionario funcionario, double percentual);
}
