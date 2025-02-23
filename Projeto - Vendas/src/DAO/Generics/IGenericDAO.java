package DAO.Generics;

import DAO.Exceptions.TipoChaveNaoEncontradaException;
import Domain.Cliente;
import Domain.Persistente;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Kadson Lima on 29/01/2025
 *
 * @author Kadson Lima
 */
public interface IGenericDAO <T extends Persistente, E extends Serializable> {

    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException;

    public void excluir(E valor);

    public void alterar(T entity) throws TipoChaveNaoEncontradaException;

    public T consultar(E valor);

    public Collection<T> buscarTodos();
}
