package unl.projects.Util;
import java.time.LocalDate;

public class Viaje {
    
    private float distancia;
    private LocalDate fecha;
    private float costo;

    public Viaje(float distancia, LocalDate fecha, float costo) {
        this.distancia = distancia;
        this.fecha = fecha;
        this.costo = costo;
    }

    @Override
    public String toString() {
        return String.format("Viaje de %.2f km el %s | Costo: $%.2f", distancia, fecha, costo);
    }
}