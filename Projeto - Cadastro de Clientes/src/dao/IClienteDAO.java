package dao;

import Domain.Cliente;

import java.util.Collection;

/**
 * Created by Kadson Lima on 04/10/2024
 *
 * @author Kadson Lima
 */
public interface IClienteDAO {
    public Boolean cadastrar(Cliente cliente);

    public void excluir(Long cpf);

    public void alterar(Cliente cliente);

    public Cliente consultar(Long cpf);

    public Collection<Cliente> buscarTodos();
}
