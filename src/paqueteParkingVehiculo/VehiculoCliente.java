package paqueteParkingVehiculo;

import java.text.DecimalFormat;

public class VehiculoCliente implements Vehiculo{

	private String Matricula;
	private int Tiempo; // Tiempo en minutos
	
	public VehiculoCliente(String m){
		
		this.setMatricula(m);
		this.Tiempo = 0;
	}
	
	// GETTERS Y SETTERS
	
	public void setMatricula(String m) {
		
		this.Matricula = m;
	}
	
	public String getMatricula() {
		
		return this.Matricula;
	}
	
	public int Tiempo() {
		
		return this.Tiempo;
	}
	
	// Métodos de la interfaz vehículo

	@Override
	public double Factura() {
		
	    double horas = this.Tiempo / 60.0; //Para saber cuantas horas ha estado  
	 
	    int dias = (int) horas / 24;
	    int minutosRestantes = this.Tiempo % 60;   // Para calcular el número de días completos y los minutos restantes
	    
	    double costoTotal = dias * 25.0;
	    
	    if (minutosRestantes > 0) {
	        costoTotal += (minutosRestantes / 60.0) * 1.2;
	    }
	    
	    return costoTotal;
	}

	@Override
	 public boolean HayPlaza(Parking p) {
		
        return p.Libre(); 
    }

	@Override
	public void Aparca(Parking p) {
		
		if (p.Libre()) {
			p.setPlazasOcupadas(p.getPlazasOcupadas() + 1);
            System.out.println("\nVehiculo aparcado en " + p.getNombre());
            
        } else {
            System.out.println("\nNo hay plazas disponibles en " + p.getNombre());
        }
	}

	@Override
	public void setTiempo(int t) {
		
	    this.Tiempo = t;
	}
}
