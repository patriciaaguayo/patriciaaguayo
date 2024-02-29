package paqueteParkingVehiculo;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class VehiculoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner leer = new Scanner(System.in);
		Scanner leer2 = new Scanner(System.in);

		Parking parking = new Parking("Parking Copo de Nieve", 10, 12);

		ArrayList<VehiculoCliente> vehiculos = new ArrayList<>();

		String eleccion = "";
		int n = 0;

		do {
			try {

				System.out.println("\nBienvenido, que desea hacer?\n\n1. Entrada de coche"
						+ "\n\n2. Cobro del parking\n\n3. Mostrar parking\n\n4. Salir del programa");

				eleccion = leer.nextLine();

				n = Integer.parseInt(eleccion);

				switch (n) {

				case 1:

					String m;
					String plaza;
					int p;

					try {

						System.out.print("\nIntroduzca la matricula del coche: ");
						m = leer.nextLine().toUpperCase();

						if (m.length() == 7) {

							VehiculoCliente vehiculo = new VehiculoCliente(m);

							if (vehiculo.HayPlaza(parking)) {

								boolean matriculaRepetida = false;

								for (VehiculoCliente v : vehiculos) {

									if (v.getMatricula().equals(m)) {
										matriculaRepetida = true;
										break;
									}
								}
								if (matriculaRepetida) {
									System.out.println("\nMatricula repetida");

								} else {
									vehiculo.Aparca(parking);
									vehiculos.add(vehiculo);
								}

							} else {
								System.out.println("\nNo hay plazas disponibles en el parking.");
							}

						} else {
							System.out.println("\nLongitud de matricula incorrecta");
						}

					} catch (Exception e) {

						System.out.println("Error: " + e.getMessage());
					}
					break;

				case 2:

					String ma;
					int t;

					try {
						System.out.print("\nIntroduzca la matricula del coche: ");
						ma = leer.nextLine().toUpperCase();

						if (ma.length() == 7) {

							boolean matriculaEncontrada = false;

							for (VehiculoCliente c : vehiculos) {

								if (c.getMatricula().equals(ma)) {
									matriculaEncontrada = true;
									System.out.println("\nMatricula encontrada");

									System.out.print("\nIntroduce los minutos que ha estado: ");
									t = leer2.nextInt();

									if (t <= 0) {

										System.out.println("\nIntroduce un numero positivo y mayor a 0");

									} else {
										c.setTiempo(t);
										double cobro = c.Factura();
										DecimalFormat formato = new DecimalFormat("#0.00");
										String cobroFormateado = formato.format(cobro);
										System.out.println("\nEl coche con matricula " + ma + " debe pagar "
												+ cobroFormateado + " euros.");
										
										parking.setPlazasOcupadas(parking.getPlazasOcupadas() -1);
									}
									break;
								}
							}
							if (!matriculaEncontrada) {
								System.out
										.println("\nLa matricula " + ma + " no se encuentra en la lista de vehículos.");
							}
						} else {
							System.out.println("\nLongitud de matricula incorrecta");
						}

					} catch (Exception e) {

						System.out.println("\nError: Introduce numeros no letras");
					}

					break;

				case 3:

					System.out.println(parking.toString());
					break;

				case 4:
					System.out.println("\nGracias por su visita y vuelva pronto");
					break;
				}

			} catch (NumberFormatException e) {
				System.out.println("\nIngresa un numero valido y no letras");
			}
			
		} while (n != 4);
	}
}
