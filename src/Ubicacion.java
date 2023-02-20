import java.util.HashMap;
import java.util.Map;

public class Ubicacion {
    private int id;
    private String descripcion;
    private Map<String, Integer> exits;

    public Ubicacion(int id, String des){
        this.id = id;
        this.descripcion = des;
        exits = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Map<String, Integer> getExits() {
        return exits;
    }

    public void addExit(String dir, int idUbicacion){
        exits.put(dir, idUbicacion);
    }
}
