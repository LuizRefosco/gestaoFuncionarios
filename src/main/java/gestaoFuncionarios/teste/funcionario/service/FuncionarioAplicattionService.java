package gestaoFuncionarios.teste.funcionario.service;

import gestaoFuncionarios.teste.funcionario.api.request.FuncionarioAlteracaoRequest;
import gestaoFuncionarios.teste.funcionario.api.request.FuncionarioRequest;
import gestaoFuncionarios.teste.funcionario.api.response.FuncionarioResponse;
import gestaoFuncionarios.teste.funcionario.domain.Funcionario;
import gestaoFuncionarios.teste.funcionario.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Log4j2
@Service
@RequiredArgsConstructor
public class FuncionarioAplicattionService implements FuncionarioService{
    private final FuncionarioRepository funcionarioRepository;
    @Override
    public FuncionarioResponse criaFuncionario(FuncionarioRequest funcionarioRequest) {
        log.info("[inicia] FuncionarioAplicattionService - criaFuncionario");
        Funcionario funcionario = funcionarioRepository.salvaFuncionario(new Funcionario(funcionarioRequest));
        log.info("[finaliza] FuncionarioAplicattionService - criaFuncionario");
        return FuncionarioResponse.builder().idFuncionario(funcionario.getId()).build();
    }

    @Override
    public Funcionario buscaFuncionarioPorId(UUID id) {
        log.info("[inicia]  FuncionarioController - buscaFuncionarioPorId");
        Funcionario funcionario = funcionarioRepository.buscaFuncionarioPorId(id);
        log.info("[finaliza] FuncionarioController - buscaFuncionarioPorId");
        return funcionario;
    }

    @Override
    public void alteraFuncionario(UUID idFuncionario, FuncionarioAlteracaoRequest funcionarioAlteracaoRequest) {
        log.info("[inicia]  FuncionarioController - alteraFuncionario");
        Funcionario funcionario = funcionarioRepository.buscaFuncionarioPorId(idFuncionario);
        funcionario.altera(funcionarioAlteracaoRequest);
        funcionarioRepository.salvaFuncionario(funcionario);
        log.info("[finaliza]  FuncionarioController - alteraFuncionario");

    }

    @Override
    public void deletaFuncionario(UUID idFuncionario) {
        log.info("[inicia]  FuncionarioController - alteraFuncionario");
        Funcionario funcionario = funcionarioRepository.buscaFuncionarioPorId(idFuncionario);
        funcionarioRepository.deletaFuncionario(funcionario);
        log.info("[finaliza]  FuncionarioController - alteraFuncionario");

    }
}
