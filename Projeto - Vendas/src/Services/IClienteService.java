package Services;

import DAO.Exceptions.TipoChaveNaoEncontradaException;
import Domain.Cliente;

/**
 * Created by Kadson Lima on 28/01/2025
 *
 * @author Kadson Lima
 */

public interface IClienteService {
    Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException;

    Cliente buscarPorCPF(Long cpf);

    void excluir(Long cpf);

    void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;
}
