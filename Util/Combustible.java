package unl.projects.Util;

public enum Combustible {
    EXTRA(2.465f),
    SUPER(4.02f),
    DIESEL(1.74f);

    private final float precioGalon;

    Combustible(float precio) {
        this.precioGalon = precio;
    }

    public float getPrecio() {
        return precioGalon;
    }
}