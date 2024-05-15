package gestaoFuncionarios.teste.funcionario.service;

import gestaoFuncionarios.teste.funcionario.api.request.FuncionarioAlteracaoRequest;
import gestaoFuncionarios.teste.funcionario.api.request.FuncionarioRequest;
import gestaoFuncionarios.teste.funcionario.api.response.FuncionarioResponse;
import gestaoFuncionarios.teste.funcionario.domain.Funcionario;

import java.util.UUID;


public interface FuncionarioService {

    FuncionarioResponse criaFuncionario(FuncionarioRequest funcionarioRequest);

    Funcionario buscaFuncionarioPorId(UUID id);

    void alteraFuncionario(UUID idFuncionario, FuncionarioAlteracaoRequest funcionarioAlteracaoRequest);

    void deletaFuncionario(UUID idFuncionario);
}
