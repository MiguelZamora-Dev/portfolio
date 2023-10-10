package gestorIDs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GestorIDs {
    private HashMap<Integer, Object> idMap = new HashMap<Integer, Object>();
    private List<Integer> vacios = new ArrayList<Integer>();

    public GestorIDs () {
    }
    public Object getId (int id) {
        Object objeto;
        try {
            objeto = this.idMap.get(id);
        } catch ( Exception e ) {
            objeto = null;
            System.out.println("ID no encontrado");
        }
        return objeto;
    }
    public int setId (Object objeto) {
        int id;
        if (this.vacios.size() > 0) {
            id = this.vacios.get(0);
            idMap.put(id, objeto);
            this.vacios.remove(0);
        } else {
            id = idMap.size() + 1;
            idMap.put(id, objeto);
        }
        return id;
    }
    public void checkIds () {
        int i = 0;
        while (i < this.idMap.size()) {
            try {
                this.idMap.get(i);
            } catch ( Exception e ) {
                this.vacios.add(i);
            }
            i++;
        }
    }
}
