package Services;

import DAO.Exceptions.TipoChaveNaoEncontradaException;
import DAO.dao.IClienteDAO;
import Domain.Cliente;
import Services.GenericsServices.GenericService;
import java.util.Collection;
import java.util.List;

/**
 * Created by Kadson Lima on 28/01/2025
 *
 * @author Kadson Lima
 */

public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {

    private IClienteDAO clienteDAO;

    public ClienteService(IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @Override
    public Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException {
        return clienteDAO.cadastrar(cliente);
    }

    @Override
    public Cliente buscarPorCPF(Long cpf) {
        return this.clienteDAO.consultar(cpf);
    }

    @Override
    public Boolean cadastrar(Cliente entity) throws TipoChaveNaoEncontradaException {
        return null;
    }

    @Override
    public void excluir(Long cpf) {
        clienteDAO.excluir(cpf);
    }

    @Override
    public void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException {
        clienteDAO.alterar(cliente);
    }

    @Override
    public Cliente consultar(Long valor) {
        return null;
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return List.of();
    }
}
