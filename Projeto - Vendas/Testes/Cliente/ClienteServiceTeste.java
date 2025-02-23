package Cliente;

import DAO.Exceptions.TipoChaveNaoEncontradaException;
import DAO.dao.IClienteDAO;
import DAOTest.ClienteDAOMock;
import Domain.Cliente;
import Services.ClienteService;
import Services.IClienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Kadson Lima on 28/01/2025
 *
 * @author Kadson Lima
 */

public class ClienteServiceTeste {

    private IClienteService clienteService;

    private Cliente cliente;

    public ClienteServiceTeste() {
        IClienteDAO dao = new ClienteDAOMock();
        clienteService = new ClienteService(dao);
    }

    @Before
    public void init() {
        cliente = new Cliente();
        cliente.setCPF(12312312312L);
        cliente.setNome("Kadson");
        cliente.setCidade("Recife");
        cliente.setEstado("PE");
        cliente.setEnd("Rua Fulano de Tal");
        cliente.setNumero(2509);
        cliente.setTel(8198989898L);
    }

    @Test
    public void pesquisarCliente() {

        Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCPF());
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException{
        Boolean retorno = clienteService.salvar(cliente);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente(){
        clienteService.excluir(cliente.getCPF());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Kadson Lima");
        clienteService.alterar(cliente);

        Assert.assertEquals("Kadson Lima", cliente.getNome());
    }
}
