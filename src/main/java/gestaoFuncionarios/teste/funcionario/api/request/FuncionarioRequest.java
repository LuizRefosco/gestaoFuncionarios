package gestaoFuncionarios.teste.funcionario.api.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class FuncionarioRequest {

    @NotBlank
    private String nome;
    @NotBlank
    private String designacao;
    @NotNull
    private double salario;
    @NotBlank
    private String numeroTelefone;
    @NotBlank
    private String endereco;
}
