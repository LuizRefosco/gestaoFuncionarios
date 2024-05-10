package gestaoFuncionarios.teste.funcionario.api.response;

import gestaoFuncionarios.teste.funcionario.domain.Funcionario;
import lombok.Value;

import java.util.UUID;

@Value
public class FuncionarioDetalhadoResponse {
    private UUID id;
    private String nome;
    private double salario;
    private String endereco;
    private String telefone;

    public FuncionarioDetalhadoResponse(Funcionario funcionario) {
        this.id = funcionario.getId();
        this.nome = funcionario.getNome();
        this.salario = funcionario.getSalario();
        this.endereco = funcionario.getEndereco();
        this.telefone = funcionario.getNumeroTelefone();
    }
}
