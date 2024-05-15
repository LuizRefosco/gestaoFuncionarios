package gestaoFuncionarios.teste.funcionario.repository;

import gestaoFuncionarios.teste.funcionario.domain.Funcionario;

import java.util.UUID;

public interface FuncionarioRepository {

    Funcionario salvaFuncionario(Funcionario funcionario);

    Funcionario buscaFuncionarioPorId(UUID id);

    void deletaFuncionario(Funcionario funcionario);
}
