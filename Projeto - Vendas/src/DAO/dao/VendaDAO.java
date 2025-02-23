package DAO.dao;

import DAO.Exceptions.TipoChaveNaoEncontradaException;
import DAO.Generics.GenericDAO;
import Domain.Venda;

import java.util.Collection;
import java.util.List;

/**
 * Created by Kadson Lima on 22/02/2025
 *
 * @author Kadson Lima
 */

public class VendaDAO extends GenericDAO<Venda, String> implements IVendaDAO {

    @Override
    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException {
        venda.setStatus(Venda.Status.CONCLUIDA);
        super.alterar(venda);
    }

    @Override
    public Class<Venda> getTipoClasse() {
        return null;
    }

    @Override
    public void atualizarDados(Venda entity, Venda entityCadastrado) {

    }

    @Override
    public Boolean cadastrar(Venda entity) throws TipoChaveNaoEncontradaException {
        return null;
    }

    @Override
    public void excluir(String valor) {

    }

    @Override
    public void alterar(Venda entity) throws TipoChaveNaoEncontradaException {

    }

    @Override
    public Venda consultar(String valor) {
        return null;
    }

    @Override
    public Collection<Venda> buscarTodos() {
        return List.of();
    }
}
