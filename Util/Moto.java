package unl.projects.Util;
import java.time.LocalDate;

public class Moto extends Vehicle {

    private int cilindrada;
    private static final float costoMantenimiento = 10;
    
    
    public Moto(String placa, float capCarga, float consCombustible, LocalDate fechaUltMantenimiento, Combustible tipoCombustible, int cilindrada) {
        super(placa, capCarga, consCombustible, fechaUltMantenimiento, tipoCombustible);
        this.cilindrada = cilindrada;
    }

    @Override
    public float calcCosto(float distancia) {
        return distancia * consCombustible * tipoCombustible.getPrecio() + costoMantenimiento;
    }

    
}