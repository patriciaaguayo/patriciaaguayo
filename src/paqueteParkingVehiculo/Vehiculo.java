package paqueteParkingVehiculo;

public interface Vehiculo {

	public double Factura();
	public boolean HayPlaza(Parking p);
	public void Aparca(Parking p);
	public void setTiempo(int t);
	
}
