package gestaoFuncionarios.teste.funcionario.api.controller;

import gestaoFuncionarios.teste.funcionario.api.FuncionarioAPI;
import gestaoFuncionarios.teste.funcionario.api.request.FuncionarioRequest;
import gestaoFuncionarios.teste.funcionario.api.response.FuncionarioDetalhadoResponse;
import gestaoFuncionarios.teste.funcionario.api.response.FuncionarioResponse;
import gestaoFuncionarios.teste.funcionario.domain.Funcionario;
import gestaoFuncionarios.teste.funcionario.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@Log4j2
@RestController
@RequiredArgsConstructor
public class FuncionarioController implements FuncionarioAPI {
    private final FuncionarioService funcionarioService;

    @Override
    public FuncionarioResponse postFuncionario(FuncionarioRequest funcionarioRequest) {
        log.info("[inicia] FuncionarioController - postFuncionario");
        FuncionarioResponse funcionarioCriado = funcionarioService.criaFuncionario(funcionarioRequest);
        log.info("[finaliza] FuncionarioController - postFuncionario");
        return funcionarioCriado;
    }

    @Override
    public FuncionarioDetalhadoResponse getFuncionarioPorId(UUID id) {
        log.info("[inicia] FuncionarioController - getFuncionarioPorId");
        log.info("[ID_FUNCIONARIO] {}", id);
        Funcionario funcionario = funcionarioService.buscaFuncionarioPorId(id);
        log.info("[finaliza] FuncionarioController - getFuncionarioPorId");
        return new FuncionarioDetalhadoResponse(funcionario);
    }
}
