package org.example.factory;

import org.example.servicos.ReajusteServico;
import org.example.strategy.ReajusteComumStrategy;
import org.example.strategy.ReajusteStrategy;
import org.example.strategy.ReajusteTerceirizadoStrategy;

// Camada de Factory
    // ReajusteServicoFactory encapsula a lógica de criação dos serviços de reajuste.
    // Segue o princípio da inversão de dependência (DIP) do SOLID, permitindo que a criação dos serviços seja configurável e flexível.


public class ReajusteServicoFactory {
    // Criacional: Factory
    // O Pattern Factory é utilizado para criar objetos sem expor a lógica de criação ao cliente.
    // ReajusteServicoFactory cria instâncias de ReajusteServico com base na necessidade (funcionário comum ou terceirizado).
    // Isso encapsula a lógica de criação, permitindo que a lógica de reajuste salarial seja configurada conforme necessário, sem modificar o código do cliente.
    // Problema: A lógica de criação de objetos pode variar e ser complexa, especialmente quando diferentes tipos de objetos precisam ser criados de maneira condicionada.
    // Solução: Utilizar o Pattern Factory para encapsular a lógica de criação de objetos, permitindo que novas regras de criação sejam adicionadas sem modificar o código do cliente.
    // Benefícios: Facilita a criação de objetos, reduz a complexidade

    public static ReajusteServico criarReajusteServico(boolean terceirizado) {
        ReajusteStrategy strategy = terceirizado ? new ReajusteTerceirizadoStrategy() : new ReajusteComumStrategy();
        return new ReajusteServico(strategy);
    }
}
