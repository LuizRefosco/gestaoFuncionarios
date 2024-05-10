package gestaoFuncionarios.teste.funcionario.infra;

import gestaoFuncionarios.teste.funcionario.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FuncionarioSpringDataJpaRepository extends JpaRepository <Funcionario, UUID> {
}
