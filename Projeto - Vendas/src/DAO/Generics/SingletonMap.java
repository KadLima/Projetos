package DAO.Generics;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kadson Lima on 22/02/2025
 *
 * @author Kadson Lima
 */
public class SingletonMap {

        private static SingletonMap singletonMap;

        protected Map<Class, Map<?, ?>> map;

        private SingletonMap() {
            map = new HashMap<>();
        }

        public static SingletonMap getInstance() {
            if (singletonMap == null) {
                singletonMap = new SingletonMap();
            }
            return singletonMap;
        }

        public Map<Class, Map<?, ?>> getMap() {
            return this.map;
        }

}
