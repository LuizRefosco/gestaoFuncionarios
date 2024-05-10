package gestaoFuncionarios.teste.funcionario.api.response;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class FuncionarioResponse{

    private UUID idFuncionario;
}
