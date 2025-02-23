package DAOTest;

import DAO.dao.ClienteDAO;
import DAO.Exceptions.TipoChaveNaoEncontradaException;
import DAO.dao.IClienteDAO;
import Domain.Cliente;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by Kadson Lima on 29/01/2025
 *
 * @author Kadson Lima
 */

public class ClienteDAOTeste {
    private IClienteDAO clienteDAO;

    private Cliente cliente;

    public ClienteDAOTeste() {
        clienteDAO = new ClienteDAO();
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        cliente = new Cliente();
        cliente.setCPF(12312312312L);
        cliente.setNome("Kadson");
        cliente.setCidade("Recife");
        cliente.setEstado("PE");
        cliente.setEnd("Rua Fulano de Tal");
        cliente.setNumero(2509);
        cliente.setTel(8198989898L);

        clienteDAO.cadastrar(cliente);
    }

    @Test
    public void pesquisarCliente() {
        Cliente clienteConsultado = clienteDAO.consultar(cliente.getCPF());
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        Boolean retorno = clienteDAO.cadastrar(cliente);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() {
        clienteDAO.excluir(cliente.getCPF());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Kadson Lima");
        clienteDAO.alterar(cliente);

        Assert.assertEquals("Kadson Lima", cliente.getNome());
    }
}
