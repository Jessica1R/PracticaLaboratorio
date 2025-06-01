package unl.projects.Util;
import java.util.*;

public class Gestor {
    private Map<String, Vehicle> vehiculos;

    public Gestor() {
        vehiculos = new HashMap<>();
    }

    public void agregarVehiculo(Vehicle vehiculo) {
        if (vehiculos.containsKey(vehiculo.getPlaca())) {
            throw new IllegalArgumentException("Placa ya registrada.");
        }
        vehiculos.put(vehiculo.getPlaca(), vehiculo);
    }

    public void mostrarFlota() {
        for (Vehicle v : vehiculos.values()) {
            System.out.println(v.mostrarEstado());
        }
    }

    public Vehicle getVehiculo(String placa) {
        return vehiculos.get(placa);
    }
}
