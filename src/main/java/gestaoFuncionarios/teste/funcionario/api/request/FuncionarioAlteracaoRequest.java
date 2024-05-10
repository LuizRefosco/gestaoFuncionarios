package gestaoFuncionarios.teste.funcionario.api.request;

import lombok.Value;

@Value
public class FuncionarioAlteracaoRequest {
    private String nome;
    private String designacao;
    private double salario;
    private String numeroTelefone;
    private String endereco;
}
