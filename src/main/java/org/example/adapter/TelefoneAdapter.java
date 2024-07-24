package org.example.adapter;

import org.example.modelo.Funcionario;

// Camada de Adaptador
    // TelefoneAdapter adapta a interface de adição de telefones para a interface esperada pelo sistema.
    // Isso promove o princípio de substituição de Liskov (LSP) do SOLID, permitindo a substituição de diferentes implementações de maneira consistente.

public class TelefoneAdapter {
    // Estrutural: Adapter
        // O Pattern Adapter é utilizado para adaptar uma interface existente para outra interface que o cliente espera.
        // TelefoneAdapter permite que telefones sejam adicionados a funcionários utilizando uma interface consistente, independente da implementação subjacente do método addTelefone de Funcionario.
        // Isso facilita a integração de diferentes sistemas ou módulos que podem ter interfaces incompatíveis.
        // Problema: Diferentes partes do sistema podem esperar interfaces diferentes, tornando a integração difícil.
        // Solução: Utilizar o Pattern Adapter para adaptar uma interface existente para a interface esperada pelo sistema, facilitando a integração e promovendo a reutilização de código.

    private Funcionario funcionario;

    public TelefoneAdapter(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void addPhone(String telefone) {
        funcionario.addTelefone(telefone);
    }
}
