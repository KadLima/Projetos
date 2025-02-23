package Anotacao;

import java.lang.annotation.*;

/**
 * Created by Kadson Lima on 22/02/2025
 *
 * @author Kadson Lima
 */

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)

public @interface TipoChave {
    String value();
}

