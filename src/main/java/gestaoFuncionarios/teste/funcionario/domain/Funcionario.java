package gestaoFuncionarios.teste.funcionario.domain;

import gestaoFuncionarios.teste.funcionario.api.request.FuncionarioRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;
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

    public Funcionario(FuncionarioRequest funcionarioRequest) {
        this.nome = funcionarioRequest.getNome();
        this.designacao = funcionarioRequest.getDesignacao();
        this.salario = funcionarioRequest.getSalario();
        this.numeroTelefone = funcionarioRequest.getNumeroTelefone();
        this.endereco = funcionarioRequest.getEndereco();
    }
}
