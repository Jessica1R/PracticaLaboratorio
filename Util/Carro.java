package unl.projects.Util;
import java.time.LocalDate;

public class Carro extends Vehicle{

    public Boolean traccion;
    private static final float costoMantenimiento = 20;

    public Carro(String placa, float capCarga, float consCombustible, LocalDate fechaUltMantenimiento, Combustible tipoCombustible, Boolean traccion) {
        super(placa, capCarga, consCombustible, fechaUltMantenimiento, tipoCombustible);
        this.traccion = traccion;
    }


    @Override
    public float calcCosto(float distancia) {
        return distancia * consCombustible * tipoCombustible.getPrecio() + costoMantenimiento;
    }

}