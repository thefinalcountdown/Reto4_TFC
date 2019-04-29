package Modelo;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

import Vista.Ventana;
import metodos.GestorBD;

public class ModeloListaHabitaciones implements ListModel {
	Ventana ventana;
	public ArrayList<String> arrayString = new ArrayList<String>();
	public static ArrayList<Dormitorio> dormitorios = new ArrayList<Dormitorio>();
	static Dormitorio dormi;

	public void llenarDormitorios(String cod_hab1, String cod_hab2, String cod_hab3, String cod_hab4, String cod_hab5,
			String cod_hab6, String cod_hab7, String cod_hab8, String cod_hab9, String cod_hab10) throws Exception {
		dormitorios = obtenerDormitorios(cod_hab1, cod_hab2, cod_hab3, cod_hab4, cod_hab5, cod_hab6, cod_hab7, cod_hab8,
				cod_hab9, cod_hab10);

		for (int index = 0; index < dormitorios.size(); index++) {
			makeObj(dormitorios.get(index).getCamaIndividual(), dormitorios.get(index).getCamaInfantil(),
					dormitorios.get(index).getCamaMatrimonio());
			arrayString.add("Camas individuales: " + dormitorios.get(index).getCamaIndividual()
					+ "  Camas de matrimonio:" + dormitorios.get(index).getCamaMatrimonio() + "  Camas infantiles: "
					+ dormitorios.get(index).getCamaInfantil());
		}
	}

	public void vaciarLista() {

		for (int index = arrayString.size() - 1; index >= 0; index--) {
			dormitorios.remove(index);
			arrayString.remove(index);
		}

	}

	public static ArrayList<Dormitorio> obtenerDormitorios(String cod_hab1, String cod_hab2, String cod_hab3,
			String cod_hab4, String cod_hab5, String cod_hab6, String cod_hab7, String cod_hab8, String cod_hab9,
			String cod_hab10) throws Exception {

		String sentencia = "select * from Hab_Dormitorio where Cod_Habitacion='%s'";
		if (cod_hab1 != null) {
			String sentencia1 = String.format(sentencia, cod_hab1);
			dormitorios.add(codigosHab(sentencia1));
		}
		if (cod_hab2 != null) {
			String sentencia2 = String.format(sentencia, cod_hab2);
			dormitorios.add(codigosHab(sentencia2));
		}
		if (cod_hab3 != null) {
			String sentencia3 = String.format(sentencia, cod_hab3);
			dormitorios.add(codigosHab(sentencia3));
		}
		if (cod_hab4 != null) {
			String sentencia4 = String.format(sentencia, cod_hab4);
			dormitorios.add(codigosHab(sentencia4));
		}
		if (cod_hab5 != null) {
			String sentencia5 = String.format(sentencia, cod_hab5);
			dormitorios.add(codigosHab(sentencia5));
		}
		if (cod_hab6 != null) {
			String sentencia6 = String.format(sentencia, cod_hab6);
			dormitorios.add(codigosHab(sentencia6));
		}
		if (cod_hab7 != null) {
			String sentencia7 = String.format(sentencia, cod_hab7);
			dormitorios.add(codigosHab(sentencia7));
		}
		if (cod_hab8 != null) {
			String sentencia8 = String.format(sentencia, cod_hab8);
			dormitorios.add(codigosHab(sentencia8));
		}
		if (cod_hab9 != null) {
			String sentencia9 = String.format(sentencia, cod_hab9);
			dormitorios.add(codigosHab(sentencia9));
		}
		if (cod_hab10 != null) {
			String sentencia10 = String.format(sentencia, cod_hab10);
			dormitorios.add(codigosHab(sentencia10));

			System.out.println(sentencia10);
		}

		return dormitorios;

	}

	public static Dormitorio codigosHab(String sentencia) throws Exception {

		ResultSet result = GestorBD.consulta(sentencia);
		while (result.next()) {
			dormi = new Dormitorio(result.getFloat("Superficie"), result.getString("Cod_Habitacion"),
					result.getInt("Cama_individual"), result.getInt("Cama_infantil"), result.getInt("Cama_matrimonio"));
		}

		return dormi;
	}

	public static Object makeObj(final int item, int item2, int item3) {
		return new Object() {
			public String toString() {
				return "" + item + item2 + item3;
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
