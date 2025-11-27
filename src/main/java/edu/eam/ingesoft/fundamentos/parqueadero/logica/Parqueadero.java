package edu.eam.ingesoft.fundamentos.parqueadero.logica;

import java.util.ArrayList;

public class Parqueadero {

    private ArrayList<Propietario> propietarios;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Servicio> servicios;

    public Parqueadero() {
        this.propietarios = new ArrayList<>();
        this.vehiculos = new ArrayList<>();
        this.servicios = new ArrayList<>();
    }

    public Propietario buscarPropietario(String cedula) {
        for (Propietario p : propietarios) {
            if (p.getCedula().equals(cedula)) {
                return p;
            }
        }
        return null;
    }

    public Vehiculo buscarVehiculo(String placa) {
        for (Vehiculo v : vehiculos) {
            if (v.getPlaca().equals(placa)) {
                return v;
            }
        }
        return null;
    }

    public boolean registrarPropietario(String cedula, String nombre) {
        if (buscarPropietario(cedula) != null) {
            return false;
        }
        propietarios.add(new Propietario(cedula, nombre));
        return true;
    }

    public boolean registrarVehiculo(String placa, int modelo, String color, String cedula, String tipo) {
        if (buscarVehiculo(placa) != null) {
            return false;
        }

        Propietario propietario = buscarPropietario(cedula);
        if (propietario == null) {
            return false;
        }

        Vehiculo vehiculo = new Vehiculo(placa, modelo, color, propietario, tipo);
        vehiculos.add(vehiculo);
        return true;
    }

    public boolean acumularHorasCliente(String cedula, int horas) {
        Propietario propietario = buscarPropietario(cedula);

        if (propietario == null) {
            return false;
        }

        propietario.acumularHoras(horas);
        return true;
    }

    public double registrarServicio(String placa, int horaIngreso, int horaSalida) {

        if (horaIngreso < 1 || horaIngreso > 22) {
            return -1;
        }

        if (horaSalida < 2 || horaSalida > 23) {
            return -1;
        }

        if (horaSalida <= horaIngreso) {
            return -1;
        }

        Vehiculo vehiculo = buscarVehiculo(placa);
        if (vehiculo == null) {
            return -1;
        }

        Servicio servicio = new Servicio(vehiculo , horaIngreso, horaSalida);

        int horas = horaSalida - horaIngreso;
        vehiculo.getPropietario().acumularHoras(horas);

        servicios.add(servicio);

        return servicio.getCosto();
    }

    public double calcularTotalRecaudado() {
        double total = 0;

        for (Servicio s : servicios) {
            total += s.getCosto();
        }

        return total;
    }

    public int contarClientesVIP() {
        int contador = 0;

        for (Propietario p : propietarios) {
            if (p.getCategoria().equals("VIP")) {
                contador++;
            }
        }

        return contador;
    }

    public Propietario obtenerClienteMasHoras() {
        if (propietarios.isEmpty()) {
            return null;
        }

        Propietario mayor = propietarios.get(0);

        for (Propietario p : propietarios) {
            if (p.getHorasAcumuladas() > mayor.getHorasAcumuladas()) {
                mayor = p;
            }
        }

        return mayor;
    }

    public ArrayList<Propietario> getPropietarios() {
        return propietarios;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }
}
