package DAO.dao;

import DAO.Exceptions.TipoChaveNaoEncontradaException;
import DAO.Generics.IGenericDAO;
import Domain.Venda;

/**
 * Created by Kadson Lima on 22/02/2025
 *
 * @author Kadson Lima
 */

public interface IVendaDAO extends IGenericDAO<Venda, String> {

    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException;

}
