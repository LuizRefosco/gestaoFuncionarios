package gestaoFuncionarios.teste.funcionario.infra;

import gestaoFuncionarios.teste.funcionario.domain.Funcionario;
import gestaoFuncionarios.teste.funcionario.repository.FuncionarioRepository;
import gestaoFuncionarios.teste.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Log4j2
@Repository
@RequiredArgsConstructor
public class FuncionarioInfraRepository implements FuncionarioRepository{
    private final FuncionarioSpringDataJpaRepository funcionarioSpringDataJpaRepository;

    @Override
    public Funcionario salvaFuncionario(Funcionario funcionario){
        log.info("[inicia] FuncionarioInfraRepository - salvaFuncionario");
        try {
            funcionarioSpringDataJpaRepository.save(funcionario);
        }catch (DataIntegrityViolationException e) {
            throw APIException.build(HttpStatus.BAD_REQUEST, "Existem dados duplicados! ");
        }
        log.info("[finaliza] FuncionarioInfraRepository - salvaFuncionario");
        return funcionario;
    }

    @Override
    public Funcionario buscaFuncionarioPorId(UUID id) {
        log.info("[inicia] FuncionarioInfraRepository - buscaFuncionarioPorId");
        Funcionario funcionario = funcionarioSpringDataJpaRepository.findById(id)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Funcionario não encontrado!"));
        log.info("[finaliza] FuncionarioInfraRepository - buscaFuncionarioPorId");
        return funcionario;
    }

    @Override
    public void deletaFuncionario(Funcionario funcionario) {
        log.info("[inicia] FuncionarioInfraRepository - deletaFuncionario");
        funcionarioSpringDataJpaRepository.delete(funcionario);
        log.info("[finaliza] FuncionarioInfraRepository - deletaFuncionario");
    }
}
