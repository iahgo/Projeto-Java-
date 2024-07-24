package org.example;

import org.example.adapter.TelefoneAdapter;
import org.example.builder.FuncionarioBuilder;
import org.example.builder.FuncionarioTerceirizadoBuilder;
import org.example.factory.ReajusteServicoFactory;
import org.example.modelo.Cargo;
import org.example.modelo.Funcionario;
import org.example.modelo.FuncionarioTerceirizado;
import org.example.modelo.Setor;
import org.example.servicos.ReajusteServico;

public class Main {

    public static void main(String[] args) {

        // Criação de um funcionário terceirizado usando o Pattern Builder
        FuncionarioTerceirizado func1 = new FuncionarioTerceirizadoBuilder()
                .setNome("Funci Terc1")
                .setEndereco("Rua abc, 100")
                .setSalario(1400.0)
                .setSetor(Setor.DEVOPS)
                .setCargo(Cargo.ESTAGIARIO)
                .setEmpresaContratada("ABC")
                .setTempoPrevistoPermanencia(6)
                .build();
        TelefoneAdapter telefoneAdapter5 = new TelefoneAdapter(func1);
        telefoneAdapter5.addPhone("4567-8901");

        // Criação de um funcionário terceirizado usando o Pattern Builder
        FuncionarioTerceirizado func2 = new FuncionarioTerceirizadoBuilder()
                .setNome("Func Terc2")
                .setEndereco("Rua cde, 123")
                .setSalario(2100.0)
                .setSetor(Setor.DEVOPS)
                .setCargo(Cargo.JUNIOR)
                .setEmpresaContratada("DDD")
                .setTempoPrevistoPermanencia(24)
                .build();
        TelefoneAdapter telefoneAdapter2 = new TelefoneAdapter(func2);
        telefoneAdapter2.addPhone("2222-3333");

        Funcionario func3 = new FuncionarioBuilder()
                .setNome("Funci 3")
                .setEndereco("Rua aaa, 456")
                .setSalario(9500.0)
                .setSetor(Setor.BANCO_DE_DADOS)
                .setCargo(Cargo.SENIOR)
                .build();
        TelefoneAdapter telefoneAdapter3 = new TelefoneAdapter(func3);
        telefoneAdapter3.addPhone("2345-6789");

        Funcionario func4 = new FuncionarioBuilder()
                .setNome("Funci 4")
                .setEndereco("Rua E, 101")
                .setSalario(5000.0)
                .setSetor(Setor.DESENVOLVIMENTO)
                .setCargo(Cargo.PLENO)
                .build();
        TelefoneAdapter telefoneAdapter4 = new TelefoneAdapter(func4);
        telefoneAdapter4.addPhone("3456-7890");

        // Criação do serviço de reajuste para funcionário COMUM usando o Pattern Factory
        ReajusteServico reajusteServicoComum = ReajusteServicoFactory.criarReajusteServico(false);

        // Criação do serviço de reajuste para funcionário TERCEIRIZADO usando o Pattern Factory
        ReajusteServico reajusteServicoTerceirizado = ReajusteServicoFactory.criarReajusteServico(true);

        // Aplicação de Clean Code
        // Métodos Curtos: O método aplicarReajuste é curto e realiza apenas uma tarefa, tornando-o fácil de entender e manter.
        // Responsabilidade Única: Cada classe e método tem uma única responsabilidade bem definida.
        aplicarReajuste(reajusteServicoTerceirizado, func1, 10);
        aplicarReajuste(reajusteServicoTerceirizado, func2, 10);
        aplicarReajuste(reajusteServicoComum, func3, 15);
        aplicarReajuste(reajusteServicoComum, func4, 20);
    }

     //Método para aplicar reajuste salarial e imprimir o novo salário
    private static void aplicarReajuste(ReajusteServico reajusteServico, Funcionario funcionario, double percentual) {
        boolean reajusteAplicado = reajusteServico.reajustarSalario(funcionario, percentual);
        if (reajusteAplicado) {
            System.out.println("Salário após reajuste de " + funcionario.getNome() + ": " + funcionario.getSalario());
        }
    }
}

//----------------------- DECISÕES ------------------
// Patterns 
    // Criacional: Builder
        // O Pattern Builder é utilizado para criar objetos complexos de maneira controlada e passo a passo.
        // Usei FuncionarioBuilder e FuncionarioTerceirizadoBuilder para criar instâncias de Funcionario e FuncionarioTerceirizado, garantindo que todas as propriedades necessárias sejam definidas antes de construir o objeto final.
        // Isso ajuda a evitar construtores longos e complexos, melhorando a legibilidade e a manutenção do código.
        // Problema: Criar objetos complexos com muitos parâmetros pode levar a construtores longos e difíceis de manter.
        // Solução: Utilizar o Pattern Builder para construir objetos passo a passo, garantindo que todos os parâmetros necessários sejam configurados antes da construção do objeto final.

    // Criacional: Factory
        // O Pattern Factory é utilizado para criar objetos sem expor a lógica de criação ao cliente.
        // ReajusteServicoFactory cria instâncias de ReajusteServico com base na necessidade (funcionário comum ou terceirizado).
        // Isso encapsula a lógica de criação, permitindo que a lógica de reajuste salarial seja configurada conforme necessário, sem modificar o código do cliente.
        // Problema: A lógica de criação de objetos pode variar e ser complexa, especialmente quando diferentes tipos de objetos precisam ser criados de maneira condicionada.
        // Solução: Utilizar o Pattern Factory para encapsular a lógica de criação de objetos, permitindo que novas regras de criação sejam adicionadas sem modificar o código do cliente.

    // Estrutural: Adapter
        // O Pattern Adapter é utilizado para adaptar uma interface existente para outra interface que o cliente espera.
        // TelefoneAdapter permite que telefones sejam adicionados a funcionários utilizando uma interface consistente, independente da implementação subjacente do método addTelefone de Funcionario.
        // Isso facilita a integração de diferentes sistemas ou módulos que podem ter interfaces incompatíveis.
        // Problema: Diferentes partes do sistema podem esperar interfaces diferentes, tornando a integração difícil.
        // Solução: Utilizar o Pattern Adapter para adaptar uma interface existente para a interface esperada pelo sistema, facilitando a integração e promovendo a reutilização de código.

    // Comportamental: Strategy
        // O Pattern Strategy é utilizado para definir uma família de algoritmos, encapsulá-los e torná-los intercambiáveis. 
        // Ele permite que o algoritmo varie independentemente dos clientes que o utilizam.
        // No nosso caso, ReajusteServico representa a interface Strategy, e as diferentes implementações de reajuste (comum e terceirizado) representam as estratégias concretas.
        // Isso facilita a adição de novas regras de reajuste no futuro, mantendo o código flexível e extensível.

// Camadas e Tomada de Decisão
    // Camada de Modelo
        // Contém as classes de domínio Funcionario e FuncionarioTerceirizado, que representam as entidades do sistema.
        // Cada entidade encapsula seus dados e comportamentos, seguindo os princípios de encapsulamento e coesão.

    // Camada de Serviços
        // ReajusteServico encapsula a lógica de negócio para reajustar salários.
        // A lógica de reajuste é separada das entidades, seguindo o princípio de responsabilidade única (SRP) do SOLID.

    // Camada de Factory
        // ReajusteServicoFactory encapsula a lógica de criação dos serviços de reajuste.
        // Segue o princípio da inversão de dependência (DIP) do SOLID, permitindo que a criação dos serviços seja configurável e flexível.

    // Camada de Adaptador
        // TelefoneAdapter adapta a interface de adição de telefones para a interface esperada pelo sistema.
        // Isso promove o princípio de substituição de Liskov (LSP) do SOLID, permitindo a substituição de diferentes implementações de maneira consistente.

    // Camada Principal (Main)
        // Responsável por orquestrar a criação de objetos, aplicação de lógica de negócio e interação entre diferentes camadas.
        // Mantém a lógica de aplicação isolada do código de domínio e serviços, seguindo o princípio da segregação de interfaces (ISP) do SOLID.

// Refatorações Gerais
    // Encapsulamento: O código foi organizado em diferentes pacotes (modelo, servicos, adapter, builder, factory) para manter o encapsulamento e separar as responsabilidades.
    // Builder Pattern: Utilizado para construir instâncias de Funcionario e FuncionarioTerceirizado de maneira controlada. Isso resolve o problema de construtores complexos e facilita a criação de objetos com muitos parâmetros.
    // Factory Pattern: ReajusteServicoFactory é utilizado para criar instâncias de ReajusteServico. Isso encapsula a lógica de criação e facilita a extensão futura (adicionar novas regras de reajuste, por exemplo).
    // Adapter Pattern: TelefoneAdapter permite adicionar telefones a Funcionario de maneira uniforme, encapsulando a lógica de adição de telefones e mantendo a interface consistente.

// Clean Code
    // Nomes Significativos: Os nomes das classes, métodos e variáveis foram escolhidos para serem autoexplicativos. Por exemplo, FuncionarioBuilder, ReajusteServicoFactory, TelefoneAdapter.
    // Métodos Curtos: O método aplicarReajuste é curto e realiza apenas uma tarefa, tornando-o fácil de entender e manter.
    // Responsabilidade Única: Cada classe e método tem uma única responsabilidade bem definida. Por exemplo, FuncionarioBuilder é responsável por construir um objeto Funcionario, e ReajusteServico é responsável por reajustar o salário de um funcionário.

// Bad Smells
    // Duplicated Code: Foi eliminada a duplicação de código utilizando padrões como Builder e Factory. Anteriormente, criar instâncias de Funcionario e FuncionarioTerceirizado poderia envolver código repetitivo.
    // Long Parameter List: Usar o Pattern Builder evita listas longas de parâmetros nos construtores.
    // Feature Envy: A lógica de reajuste salarial foi movida para ReajusteServico, evitando que as classes de domínio (como Funcionario) contenham lógica de negócio que não é de sua responsabilidade.


