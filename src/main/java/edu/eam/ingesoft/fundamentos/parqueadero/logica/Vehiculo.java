package edu.eam.ingesoft.fundamentos.parqueadero.logica;

/**
 * Clase que representa un vehículo registrado en el parqueadero.
 * El vehículo es responsable de conocer su tarifa según su tipo.
 */
public class Vehiculo {

    // ==================== ATRIBUTOS ====================

    private String placa;
    private int modelo;
    private String color;
    private Propietario propietario;
    private String tipo;

    // ==================== CONSTRUCTOR ====================

    /**
     * Crea una nueva instancia de Vehiculo.
     * @param placa Identificador único del vehículo
     * @param modelo Año del vehículo
     * @param color Color del vehículo
     * @param propietario Objeto Propietario dueño del vehículo
     * @param tipo Tipo de vehículo ("SEDAN", "SUV" o "CAMION")
     */
    public Vehiculo(String placa, int modelo, String color, Propietario propietario, String tipo) {
        this.placa = placa;
        this.modelo = modelo;
        this.color = color;
        this.propietario = propietario;
        this.tipo = tipo;
    }

    // ==================== GETTERS ====================

    public String getPlaca() {
        return placa;
    }

    public int getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public String getTipo() {
        return tipo;
    }

    // ==================== MÉTODOS DE NEGOCIO ====================

    /**
     * Determina la tarifa por hora de estacionamiento según el tipo de vehículo.
     * - SEDAN: $1,500
     * - SUV: $2,300
     * - CAMION: $3,000
     * @return La tarifa por hora
     */
    public double obtenerTarifaHora() {
        switch (tipo.toUpperCase()) {
            case "SEDAN":
                return 1500;
            case "SUV":
                return 2300;
            case "CAMION":
                return 3000;
            default:
               
                return 0;
        }
    }
}
