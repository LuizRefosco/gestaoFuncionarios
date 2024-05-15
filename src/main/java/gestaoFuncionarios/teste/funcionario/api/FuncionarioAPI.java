package gestaoFuncionarios.teste.funcionario.api;

import gestaoFuncionarios.teste.funcionario.api.request.FuncionarioAlteracaoRequest;
import gestaoFuncionarios.teste.funcionario.api.request.FuncionarioRequest;
import gestaoFuncionarios.teste.funcionario.api.response.FuncionarioDetalhadoResponse;
import gestaoFuncionarios.teste.funcionario.api.response.FuncionarioResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/funcionario")
public interface FuncionarioAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    FuncionarioResponse postFuncionario(@Valid @RequestBody FuncionarioRequest FuncionarioRequest);

    @GetMapping(value = "/{idFuncionario}")
    @ResponseStatus(code = HttpStatus.OK)
    FuncionarioDetalhadoResponse getFuncionarioPorId(UUID id);

    @PatchMapping(value = "/{idFuncionario}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void patchAlteraFuncionario(@PathVariable UUID idFuncionario, @RequestBody @Valid FuncionarioAlteracaoRequest funcionarioAlteracaoRequest);

    @DeleteMapping(value = "/{idFuncionario}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaFuncionario(@PathVariable UUID idFuncionario);
}
