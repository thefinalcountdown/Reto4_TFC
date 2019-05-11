//package Modelo;
//
//import java.sql.ResultSet;
//import java.util.ArrayList;
//
//import javax.swing.JOptionPane;
//import javax.swing.ListModel;
//import javax.swing.event.ListDataListener;
//
//import Vista.Ventana;
//import metodos.GestorBD;
//
//public class ModeloListaHabitaciones implements ListModel {
//	Ventana ventana;
//	public ArrayList<String> arrayString = new ArrayList<String>();
//	public static ArrayList<Dormitorio> dormitorios = new ArrayList<Dormitorio>();
//
//	public void llenarListaDorm(int cod_hotel, String fecha_entrada, String fecha_salida) throws Exception {
//		dormitorios = obtenerHabitaciones(cod_hotel, fecha_entrada, fecha_salida);
//
//		for (int index = 0; index < dormitorios.size(); index++) {
//			makeObj(dormitorios.get(index).getNum_habitacion(), dormitorios.get(index).getCamaIndividual(),
//					dormitorios.get(index).getCamaInfantil(), dormitorios.get(index).getCamaMatrimonio());
//			arrayString.add("Habitacion: " + dormitorios.get(index).getNum_habitacion() + " Cama individual: "
//					+ dormitorios.get(index).getCamaIndividual() + "  Cama infantil: "
//					+ dormitorios.get(index).getCamaInfantil() + " Cama de matrimonio: "
//					+ dormitorios.get(index).getCamaMatrimonio());
//		}
//		if (arrayString.isEmpty()) {
//			JOptionPane.showMessageDialog(null,"Lo sentimos, el hotel seleccionado no tiene habitaciones disponibles.");
//		}
//	}
//
//	// crear el metodo para rellenar la lista con las habitaciones de la casa
//
////	public void llenarListaHab() {
////	}
//
//	//
//	
//	
//	public void vaciarLista() {
//
//		for (int index = arrayString.size() - 1; index >= 0; index--) {
//			dormitorios.remove(index);
//			arrayString.remove(index);
//		}
//	}
//
//	//crear objeto auxiliar con los items a introducir como parametro en el arraylist de string
//	
//	public static Object makeObj(int item1, int item2, int item3, int item4) {
//		return new Object() {
//			public String toString() {
//				return "" + item1 + item2 + item3 + item4;
//			}
//		};
//	}
//
//	//rellenar el ArrayList<Dormitorio> con las habitaciones de un hotel
//	
//	public static ArrayList<Dormitorio> obtenerHabitaciones(int cod_hotel, String fecha_entrada, String fecha_salida)
//			throws Exception {
//
//		String sentencia = "select * from Hab_Dormitorio HD inner join Hotel_habitacion HH "
//				+ "on HD.Cod_Habitacion = HH.Tipo_Habitacion " + "where Cod_Hotel = " + cod_hotel
//				+ " and Num_Habitacion not in (select rh.Num_Habitacion " + "from Reserva_habitacion rh "
//				+ "inner join Hotel_habitacion hh " + "on hh.Num_Habitacion=rh.Num_Habitacion "
//				+ "where Fecha_Inicio >= '" + fecha_entrada + "' and Fecha_Salida <= '" + fecha_salida + "') ";
//
//		ResultSet result = GestorBD.consulta(sentencia);
//
//		while (result.next()) {
//			dormitorios.add(new Dormitorio(result.getInt("Num_Habitacion"), result.getString("Cod_Habitacion"),
//					result.getFloat("Superficie"), result.getInt("Cama_individual"), result.getInt("Cama_infantil"),
//					result.getInt("Cama_matrimonio")));
//		}
//
//		return dormitorios;
//
//	}
//
//	@Override
//	public int getSize() {
//		// TODO Auto-generated method stub
//		return arrayString.size();
//	}
//
//	@Override
//	public Object getElementAt(int index) {
//		// TODO Auto-generated method stub
//		return arrayString.get(index);
//	}
//
//	@Override
//	public void addListDataListener(ListDataListener l) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void removeListDataListener(ListDataListener l) {
//		// TODO Auto-generated method stub
//
//	}
//
//}
