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

	
	

	public void llenarLista(String ubicacion) throws Exception {
		casas = obtenerCasas(ubicacion);

		for (int index = 0; index < casas.size(); index++) 
		{
			makeObj(casas.get(index).getNombre(), casas.get(index).getPrecio(), casas.get(index).getNum_banos());
			arrayString.add("Nombre: "+casas.get(index).getNombre() + "  Precio: " + casas.get(index).getPrecio()
					+" \u20ac  Numero de ba\u00f1os: "+casas.get(index).getNum_banos());
		}
		hoteles= obtenerHoteles(ubicacion);
		for (int index = 0; index < hoteles.size(); index++) 
		{
			makeObj(hoteles.get(index).getNombre(), hoteles.get(index).getPrecio(), hoteles.get(index).getEstrellas());
			arrayString.add("Nombre: "+hoteles.get(index).getNombre() + "  Precio: " + hoteles.get(index).getPrecio()
					+" \u20ac  Estrellas: "+hoteles.get(index).getEstrellas());
		}
		
	}
	
	public void vaciarLista(){
		
		for(int index = arrayString.size()-1; index >= 0; index--)
		{

			arrayString.remove(index);
		}
		for(int index = hoteles.size()-1; index >= 0; index--)
		{

			hoteles.remove(index);
		}
		
		for(int index = casas.size()-1; index >= 0; index--)
		{

			casas.remove(index);
		}
		
		
	}

	
	public static ArrayList<Casa> obtenerCasas(String ubicacion) throws Exception {

		String sentencia = "select * from casa_apartamento where ubicacion='%s'";
		sentencia = String.format(sentencia, ubicacion);
		ResultSet result = GestorBD.consulta(sentencia);
		while (result.next()) 
		{
			casas.add(new Casa(result.getString("Nombre"), result.getString("Ubicacion"), result.getFloat("Precio"),
					result.getInt("Cod_Casa"), result.getInt("Num_banos"), result.getInt("Superficie"), result.getInt("Piso")));
		}
		return casas;

	}
	
	public static ArrayList<Hotel> obtenerHoteles(String ubicacion) throws Exception {

		String sentencia = "select * from hoteles where ubicacion='%s'";
		sentencia = String.format(sentencia, ubicacion);
		ResultSet result = GestorBD.consulta(sentencia);
		while (result.next()) 
		{
			hoteles.add(new Hotel(result.getString("nombre"), result.getString("ubicacion"), result.getFloat("precio"),
					result.getInt("Cod_Hotel"), result.getInt("estrellas")));
		}
		return hoteles;

	}

	public static Object makeObj(final String item, float item2, int item3) {
		return new Object() {
			public String toString() {
				return item+item2+item3;
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
