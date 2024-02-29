package paqueteParkingVehiculo;

public class Parking {

	private String Nombre;
	private int CapacidadTotal;
	private int PlazasOcupadas;
	private int Hora;
	private Horas Horas;
	
	
	public Parking() {
        this.Nombre = "Pepa Pig";
        this.CapacidadTotal = 0;
        this.PlazasOcupadas = 0;
        this.Hora = 6;
    }
	
	public Parking(String n, int c, int h) {
		
		this.Nombre = n;
		this.setCapacidadTotal(c);
		this.setHora(h);
		this.PlazasOcupadas = 0;
	}
	
	public void setNombre(String n) {
		
	}
	
	public String getNombre () {
		
		return this.Nombre;
	}
	
	public void setHora(int h) {
		
		int aux = h;
		
		switch (aux) {
	    
        case 6:
        case 12:
        case 18:
        case 24:
        	
            this.Hora = aux;
            break;
            
        default:
        	
            this.Hora = 6;
            break;
    }
		
		
		this.Hora = h;
	}
	
	public int getHora() {
		
		return this.Hora;
	}
	
	public void setCapacidadTotal(int c) {
		
		this.CapacidadTotal = c;
	}
	
	public int getCapacidadTotal() {
		
		return this.CapacidadTotal;
	}
	
	public void setPlazasOcupadas(int p) {
		
		this.PlazasOcupadas = p;
	}
	
	public int getPlazasOcupadas() {
		
		return this.PlazasOcupadas;
	}
	
	// MÉTODOS
	
	public boolean Libre() {
		
		return this.PlazasOcupadas < this.CapacidadTotal;
	}
	
	public int Disponibles() {
		
		return this.CapacidadTotal - this.PlazasOcupadas;
	}

	@Override
	public String toString() {
		
		String resultado = "\n " + this.Nombre + "\n -------------------------\n";
		resultado += " Plazas totales: " + this.CapacidadTotal;
		resultado += "\n Plazas ocupadas: " + this.PlazasOcupadas;
		resultado += "\n Plazas libres: " + (this.CapacidadTotal - this.PlazasOcupadas);
		resultado += "\n Hora de apertura: " + this.Hora + ":00";
		
	    return resultado;
	}	
}
