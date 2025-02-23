package Services;

import DAO.dao.IProdutoDAO;
import Domain.Produto;
import Services.GenericsServices.GenericService;

/**
 * Created by Kadson Lima on 22/02/2025
 *
 * @author Kadson Lima
 */

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {
    public ProdutoService(IProdutoDAO dao) {
        super();
    }
}
