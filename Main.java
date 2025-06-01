package unl.projects;

import java.time.LocalDate;
import java.util.Scanner;

import unl.projects.Util.Camion;
import unl.projects.Util.Carro;
import unl.projects.Util.Combustible;
import unl.projects.Util.Gestor;
import unl.projects.Util.Moto;
import unl.projects.Util.Vehicle;

public class Main {
    public static void main(String[] args) {
        Gestor flota = new Gestor();
        Scanner sc = new Scanner(System.in);

        int opt;

        do {
            System.out.println("\n~~~ | MENU DE GESTION DE FLOTA | ~~~");
            System.out.println("1. | ~ Registrar vehiculo");
            System.out.println("2. | ~ Registrar viaje");
            System.out.println("3. | ~ Actualizar mantenimiento");
            System.out.println("4. | ~ Mostrar todos los vehiculos");
            System.out.println("5. | ~ Salir");
            System.out.print("Seleccione: ");
            opt = sc.nextInt();
            sc.nextLine();

            switch (opt) {
                case 1:
                    System.out.println("1. | ~ Registrar vehiculo ~ |");
                    System.out.print("| - Tipo de vehiculo: ");
                    String tipo = sc.nextLine();

                    System.out.print("| - Placa del vehiculo:");
                    String placa = sc.nextLine();

                    System.out.print("| - Capacidad de carga (kg): ");
                    float carga = sc.nextFloat();

                    System.out.print("| - Consumo de combustible (gal/km): ");
                    float consumo = sc.nextFloat();
                    sc.nextLine();

                    System.out.print("| - Fecha de ultimo mantenimiento (AAAA-MM-DD): ");
                    String fecha = sc.nextLine();

                    System.out.print("| - Tipo de combustible (EXTRA, SUPER, DIESEL): ");
                    Combustible tipoComb = Combustible.valueOf(sc.nextLine().toUpperCase());
                    try {
                        if (tipo.equals("moto")) {
                            System.out.print("| - Indique la Cilindrada (cc): ");
                            int cc = sc.nextInt();
                            sc.nextLine();
                            flota.agregarVehiculo(new Moto(placa, carga, consumo, LocalDate.parse(fecha), tipoComb, cc));

                        } else if (tipo.equals("carro")) {
                            System.out.print("| - El vehiculo cuenta con traccion 4x4? (Si/No): ");
                            String aux = sc.nextLine().trim().toLowerCase();
                            boolean traccion = aux.equals("sí") || aux.equals("si");
                            flota.agregarVehiculo(new Carro(placa, carga, consumo, LocalDate.parse(fecha), tipoComb, traccion));

                        } else if (tipo.equals("camion")) {
                            System.out.print("| - Indique el numero de ejes: ");
                            int ejes = sc.nextInt();
                            sc.nextLine();
                            flota.agregarVehiculo(new Camion(placa, carga, consumo, LocalDate.parse(fecha), tipoComb, ejes));
                        } else {
                            System.out.println("| ~ Tipo no valido.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error: " +e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("| - Placa del vehiculo: ");
                    String placaV = sc.nextLine();
                    sc.nextLine();
                    Vehicle veh = flota.getVehiculo(placaV);
                    if (veh != null) {
                        System.out.print("| - Ingrese la distancia en km: ");
                        float distancia = sc.nextFloat();
                        sc.nextLine();
                        System.out.print("| - Fecha del viaje: ");
                        String fechaViaje = sc.nextLine();
                        try {
                            veh.registrarViaje(distancia, fechaViaje);
                            System.out.println("| ~ El viaje se ha registrado.");
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    } else {
                        System.out.println("| ~ Vehiculo no encontrado.");
                    }
                    break;
                case 3:
                    System.out.println("| - Ingrese la placa del vahiculo: ");
                    String placaMan = sc.nextLine();
                    Vehicle veh2 = flota.getVehiculo(placaMan);
                    if (veh2 != null) {
                        System.out.print("Fecha de mantenimiento (AAAA-MM-DD): ");
                        String nuevaFecha = sc.nextLine();
                        try {
                            veh2.actualizarMantenimiento(nuevaFecha);
                            System.out.println("Fecha actualizada.");
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    } else {
                        System.out.println("| ~ Vehiculo no encontrado.");
                    }
                    break;
                case 4:
                    flota.mostrarFlota();
                    break;
                case 5:
                    System.out.println("| ~ Saliendo...");
                    break;
                default:
                    System.out.println("| ~ Opcion no valida.");
                    break;
            }
        } while (opt != 5);
        sc.close();
    }
}