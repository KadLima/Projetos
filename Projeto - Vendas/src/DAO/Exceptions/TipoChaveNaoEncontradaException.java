package DAO.Exceptions;

/**
 * Created by Kadson Lima on 29/01/2025
 * @author Kadson Lima
 */

public class TipoChaveNaoEncontradaException extends Exception {
    public static final long serialVersionUID = -1389494676398525746L;

    public TipoChaveNaoEncontradaException(String msg) {
        this(msg, null);
    }

    public TipoChaveNaoEncontradaException(String msg, Throwable e) {
        super(msg, e);
    }
}
