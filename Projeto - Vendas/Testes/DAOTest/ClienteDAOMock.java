package DAOTest;

import DAO.Exceptions.TipoChaveNaoEncontradaException;
import DAO.dao.IClienteDAO;
import Domain.Cliente;
import java.util.Collection;


/**
 * Created by Kadson Lima on 28/01/2025
 *
 * @author Kadson Lima
 */

public class ClienteDAOMock implements IClienteDAO {


    @Override
    public Boolean cadastrar(Cliente entity) throws TipoChaveNaoEncontradaException {
        return true;
    }

    @Override
    public void excluir(Long valor) {

    }

    @Override
    public void alterar(Cliente entity) throws TipoChaveNaoEncontradaException {

    }

    @Override
    public Cliente consultar(Long valor) {
        Cliente cliente = new Cliente();
        cliente.setCPF(valor);
        return cliente;
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return null;
    }
}
