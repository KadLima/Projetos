package Services.GenericsServices;

import DAO.Exceptions.TipoChaveNaoEncontradaException;
import Domain.Persistente;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Kadson Lima on 22/02/2025
 *
 * @author Kadson Lima
 */

public interface IGenericService<T extends Persistente, E extends Serializable> {
    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException;

    public void excluir(E valor);

    public void alterar(T entity) throws TipoChaveNaoEncontradaException;

    public T consultar(E valor);

    public Collection<T> buscarTodos();
}
