package paqueteParkingVehiculo;

public enum Horas {

	H6(6), H12(12), H18(18), H24(24);
	
	private final int horas;
	
	private Horas(int horas) {
		this.horas = horas;
	}
	
	public int getHotas() {
		
		return horas;
	}
	
}
