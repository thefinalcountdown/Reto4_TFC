package Modelo;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

import Vista.Ventana;
import metodos.GestorBD;

public class ModeloListaAlojamiento implements ListModel {
	Ventana ventana;
	public ArrayList<String> arrayString = new ArrayList<String>();
	public static ArrayList<Casa> casas = new ArrayList<Casa>();
	public static ArrayList<Hotel> hoteles = new ArrayList<Hotel>();
	public static ArrayList<Casa> apartamentos = new ArrayList<Casa>();
	public static ArrayList<Servicios> servicios = new ArrayList<Servicios>();

	public void llenarLista(String ubicacion) throws Exception {
		casas = obtenerCasasyApt(ubicacion);

		
		
		for (int index = 0; index < casas.size(); index++) {
			makeObj(casas.get(index).getNombre(), casas.get(index).getNum_banos());
			arrayString.add("Nombre: " + casas.get(index).getNombre() + "; Numero de ba\u00f1os: "
					+ casas.get(index).getNum_banos() + "; Precio: " + casas.get(index).getPrecio() + "\u20ac");
			
			System.out.println(casas.get(index));
		}

		hoteles = obtenerHoteles(ubicacion);

		for (int index = 0; index < hoteles.size(); index++) {
			makeObj(hoteles.get(index).getNombre(), hoteles.get(index).getEstrellas());
			arrayString.add(
					"Nombre: " + hoteles.get(index).getNombre() + "; Estrellas: " + hoteles.get(index).getEstrellas());
			System.out.println("\n"+hoteles.get(index));

		}

	}

	public void llenarListaHoteles(String ubicacion) throws Exception {

		hoteles = obtenerHoteles(ubicacion);

		for (int index = 0; index < hoteles.size(); index++) {
			makeObj(hoteles.get(index).getNombre(), hoteles.get(index).getEstrellas());
			arrayString.add(
					"Nombre: " + hoteles.get(index).getNombre() + "; Estrellas: " + hoteles.get(index).getEstrellas());
		}

	}

	public void llenarListaCasas(String ubicacion) throws Exception {
		casas = obtenerCasas(ubicacion);

		for (int index = 0; index < casas.size(); index++) {
			makeObj(casas.get(index).getNombre(), casas.get(index).getNum_banos());
			arrayString.add("Nombre: " + casas.get(index).getNombre() + "; Numero de ba\u00f1os: "
					+ casas.get(index).getNum_banos() + "; Precio: " + casas.get(index).getPrecio() + "\u20ac");
		}

	}

	public void llenarListaApartamentos(String ubicacion) throws Exception {
		apartamentos = obtenerApartamentos(ubicacion);

		for (int index = 0; index < apartamentos.size(); index++) {
			makeObj(apartamentos.get(index).getNombre(), apartamentos.get(index).getNum_banos());
			arrayString.add("Nombre: " + apartamentos.get(index).getNombre() + "; Numero de ba\u00f1os: "
					+ apartamentos.get(index).getNum_banos() + "; Precio: " + apartamentos.get(index).getPrecio()
					+ "\u20ac");
		}

	}

	public void vaciarLista() {

		for (int index = arrayString.size() - 1; index >= 0; index--) {

			arrayString.remove(index);
		}
		for (int index = hoteles.size() - 1; index >= 0; index--) {

			hoteles.remove(index);
		}

		for (int index = casas.size() - 1; index >= 0; index--) {

			casas.remove(index);
		}
		for (int index = apartamentos.size() - 1; index >= 0; index--) {

			apartamentos.remove(index);
		}

	}
	public static ArrayList<Casa> obtenerCasasyApt(String ubicacion) throws Exception {

		String sentencia = "select A.Nombre, A.Ubicacion, A.Cod_Alojamiento, CA.Num_banos, CA.Superficie_casa, CA.Piso, CA.Precio_casa, S.* " + 
				"from Alojamiento A inner join vista_casa CA on A.Cod_Alojamiento=CA.Cod_Casa " + 
				"inner join Servicios S on A.Cod_Alojamiento = S.Cod_Alojamiento " + 
				"where ubicacion='"+ubicacion+"' \n";
		
		for (int cont = 0; cont < servicios.size(); cont++)
		{
			if(servicios.get(cont).isServicio_elegido())
			{
				sentencia += " and S."+servicios.get(cont).getTipo_servicio()+" = "+1+"\n";
			}		
		}
		
		sentencia = String.format(sentencia, ubicacion);
		ResultSet result = GestorBD.consulta(sentencia);
		while (result.next()) {
			casas.add(new Casa(result.getString("Nombre"), result.getString("Ubicacion"),
					result.getInt("Cod_Alojamiento"), result.getInt("Num_banos"), result.getDouble("Superficie_casa"),
					result.getInt("Piso"), result.getDouble("Precio_casa")));
		}
		return casas;

	}

	public static ArrayList<Casa> obtenerCasas(String ubicacion) throws Exception {

		String sentencia = "select A.Nombre, A.Ubicacion, A.Cod_Alojamiento, CA.Num_banos, CA.Superficie_casa, CA.Piso, CA.Precio_casa, S.* " + 
				"from Alojamiento A inner join vista_casa CA on A.Cod_Alojamiento=CA.Cod_Casa " + 
				"inner join Servicios S on A.Cod_Alojamiento = S.Cod_Alojamiento " + 
				"where ubicacion='"+ubicacion+"' and piso is null \n";
		
		for (int cont = 0; cont < servicios.size(); cont++)
		{
			if(servicios.get(cont).isServicio_elegido())
			{
				sentencia += " and S."+servicios.get(cont).getTipo_servicio()+" = "+1+"\n";
			}		
		}
		
		
		sentencia = String.format(sentencia, ubicacion);
		ResultSet result = GestorBD.consulta(sentencia);
		while (result.next()) {
			casas.add(new Casa(result.getString("Nombre"), result.getString("Ubicacion"),
					result.getInt("Cod_Alojamiento"), result.getInt("Num_banos"), result.getDouble("Superficie_casa"),
					result.getInt("Piso"), result.getDouble("Precio_casa")));
		}
		return casas;

	}

	public static ArrayList<Casa> obtenerApartamentos(String ubicacion) throws Exception {

		String sentencia = "select A.Nombre, A.Ubicacion, A.Cod_Alojamiento, CA.Num_banos, CA.Superficie_casa, CA.Piso, CA.Precio_casa, S.* " + 
				"from Alojamiento A inner join vista_casa CA on A.Cod_Alojamiento=CA.Cod_Casa " + 
				"inner join Servicios S on A.Cod_Alojamiento = S.Cod_Alojamiento " + 
				"where ubicacion='"+ubicacion+"' and piso is not null \n";
		
		for (int cont = 0; cont < servicios.size(); cont++)
		{
			if(servicios.get(cont).isServicio_elegido())
			{
				sentencia += " and S."+servicios.get(cont).getTipo_servicio()+" = "+1+"\n";
			}
		}
		
		
		sentencia = String.format(sentencia, ubicacion);
		ResultSet result = GestorBD.consulta(sentencia);
		while (result.next()) {
			apartamentos.add(new Casa(result.getString("Nombre"), result.getString("Ubicacion"),
					result.getInt("Cod_Alojamiento"), result.getInt("Num_banos"), result.getDouble("Superficie_casa"),
					result.getInt("Piso"), result.getDouble("Precio_casa")));
		}
		return apartamentos;

	}

	public static ArrayList<Hotel> obtenerHoteles(String ubicacion) throws Exception {
		
		String sentencia = "select A.Nombre, A.Ubicacion, A.Cod_Alojamiento, H.estrellas, S.* "
				+ "from Alojamiento A inner join Hotel H "
				+ "on A.Cod_alojamiento=H.Cod_Hotel "
				+ "inner join Servicios S "
				+ "on A.Cod_Alojamiento = S.Cod_Alojamiento "
				+ "where A.ubicacion = '"+ubicacion+"' \n";
		
		for (int cont = 0; cont < servicios.size(); cont++)
		{
			if(servicios.get(cont).isServicio_elegido())
			{
				sentencia += " and S."+servicios.get(cont).getTipo_servicio()+" = "+1+"\n";
			}
		}
		
		sentencia = String.format(sentencia, ubicacion);
		int cont = 0;
		ResultSet result = GestorBD.consulta(sentencia);
		while (result.next()) {
			hoteles.add(new Hotel(result.getString("nombre"), result.getString("ubicacion"),
					result.getInt("Cod_Alojamiento"), result.getInt("estrellas")));
		}
		return hoteles;

	}

	public static Object makeObj(final String item, int item2) {
		return new Object() {
			public String toString() {
				return item + item2;
			}
		};

	} 
	
	
	
	

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return arrayString.size();
	}

	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return arrayString.get(index);
	}

	@Override
	public void addListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub

	}

}
