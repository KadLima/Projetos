package DAO.dao;

import DAO.Generics.GenericDAO;
import Domain.Cliente;

/**
 * Created by Kadson Lima on 28/01/2025
 *
 * @author Kadson Lima
 */

public class ClienteDAO extends GenericDAO<Cliente, Long> implements IClienteDAO {
    public ClienteDAO(){
        super();
    }

    @Override
    public Class<Cliente> getTipoClasse() {
        return Cliente.class;
    }

    @Override
    public void atualizarDados(Cliente entity, Cliente entityCadastrado) {

    }

}
