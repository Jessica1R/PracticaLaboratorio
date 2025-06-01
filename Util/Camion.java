package unl.projects.Util;
import java.time.LocalDate;

public class Camion extends Vehicle{
    
    private int numEjes;
    private static final float costoMantenimiento = 50;
    
    
    public Camion(String placa, float capCarga, float consCombustible, LocalDate fechaUltMantenimiento, Combustible tipoCombustible, int numEjes) {
        super(placa, capCarga, consCombustible, fechaUltMantenimiento, tipoCombustible);
        this.numEjes = numEjes;
    }

    @Override
    public float calcCosto(float distancia) {
        return distancia * consCombustible * tipoCombustible.getPrecio() + costoMantenimiento;
    }
    
    
}
