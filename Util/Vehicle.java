package unl.projects.Util;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
    // tipo de combustible, precio
    protected String placa;
    protected float capCarga;
    protected float consCombustible;
    protected LocalDate fechaUltMantenimiento;
    protected Combustible tipoCombustible;
    protected List<Viaje> viajes;

    public Vehicle(String placa, float capCarga, float consCombustible, LocalDate fechaUltMantenimiento,
            Combustible tipoCombustible) {
        this.placa = placa;
        this.capCarga = capCarga;
        this.consCombustible = consCombustible;
        this.fechaUltMantenimiento = fechaUltMantenimiento;
        this.tipoCombustible = tipoCombustible;
        this.viajes = new ArrayList<>();
    }

    public void registrarViaje(float distancia, String fecha) {
        if (distancia < 0) {
            throw new IllegalArgumentException("La distancia debe de ser mayor a 0km");
        }
        LocalDate fechaViaje = parseFecha(fecha);
        float costo = calcCosto(distancia);
        viajes.add(new Viaje(distancia, fechaViaje, costo));
    }

    public abstract float calcCosto(float distancia);

    public void actualizarMantenimiento(String fecha) {
        this.fechaUltMantenimiento = parseFecha(fecha);
    }

    public boolean necesitaMantenimiento() {
        return fechaUltMantenimiento.plusMonths(6).isBefore(LocalDate.now());
    }

    public String mostrarEstado() {
        String estado = "-------------------------------\n";
        estado += "| ~ Placa:               " + placa + "\n";
        estado += "| ~ Tipo de Vehículo:    " + this.getClass().getSimpleName() + "\n";
        estado += "| ~ Combustible:         " + tipoCombustible.name() + " ($"
                + Math.round(tipoCombustible.getPrecio() * 1000) / 1000.0 + "/gal)\n";
        estado += "| ~ Ult. Mantenimiento:  " + fechaUltMantenimiento + "\n";
        estado += "| ~ Estado:              " + (necesitaMantenimiento() ? "Requiere mantenimiento" : "Correcto") + "\n";
        estado += "-------------------------------";
        return estado;
    }

    private LocalDate parseFecha(String fecha) {
        try {
            return LocalDate.parse(fecha);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Usar formato de fecha: AAAA-MM-DD");
        }
    }

    public String getPlaca() {
        return placa;
    }
}
