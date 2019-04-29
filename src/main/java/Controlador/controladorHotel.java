package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import Modelo.Hotel_habitacion;
import Modelo.modelo;
import Vista.Ventana;
import metodos.GestorBD;

public class controladorHotel {
	private ArrayList<String> misNombreHoteles = new ArrayList<String>();

	private Ventana ventana;
	private modelo modelo;
	public static Hotel_habitacion Hotel1;

	public controladorHotel() {
	}

	public controladorHotel(Ventana ventana, modelo modelo) {
		this.ventana = ventana;
		this.modelo = modelo;

		ventana.hotel.btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

//				float precio_reserva = Float.parseFloat(separarString(vistaHoteles.listaHoteles)[1]);

//				ventana.reserva.textField_precio.setText(Float.toString(precio_reserva*Integer.parseInt(ventana.raiz.txthuesped.getText())));
//				ventana.reserva.textField_hotelseleccionado.setText(separarString(vistaHoteles.listaHoteles)[0]);
				int index = 0;
				index = ventana.hotel.listaHoteles.getSelectedIndex();

				if (index == -1) {
					JOptionPane.showMessageDialog(null, "Seleccione algun hotel.");
				} else {
					ventana.reserva.textField_hotelseleccionado
							.setText(modelo.modeloListaHotel.hoteles.get(index).getNombre());
					ventana.reserva.textField_precio
							.setText(Float.toString(modelo.modeloListaHotel.hoteles.get(index).getPrecio()));
					ventana.cambio_panel(ventana.hotel, ventana.reserva);
				}

			}
		});

		ventana.hotel.btnHabitaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// vaciamos la lista cada vez que se le da al boton para que no conserve lo de
				// otros hoteles seleccionados
				try {
					modelo.modeloListaHabitacion.vaciarLista();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// Este sysout era para ver que cogia el codHotel, podemos borrarlo
				System.out.println(modelo.modeloListaHotel.hoteles.get(ventana.hotel.listaHoteles.getSelectedIndex())
						.getCod_alojamiento());
				Hotel1 = new Hotel_habitacion();
				// el Hotel1 que es el objeto Hotel_Habitacion se rellena
				try {
					obtenerHabitaciones(modelo.modeloListaHotel.hoteles
							.get(ventana.hotel.listaHoteles.getSelectedIndex()).getCod_alojamiento());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// usamos el metodo para rellenar el modelo lista con los dormitorios, ahora
				// mismo solo coge la Habitacion1 con el getter
				try {
					modelo.modeloListaHabitacion.llenarDormitorios(Hotel1.getHabitacion1(), Hotel1.getHabitacion2(),
							Hotel1.getHabitacion3(), Hotel1.getHabitacion4(), Hotel1.getHabitacion5(),
							Hotel1.getHabitacion6(), Hotel1.getHabitacion7(), Hotel1.getHabitacion8(),
							Hotel1.getHabitacion9(), Hotel1.getHabitacion10());

					ventana.hotel.listaHabitaciones.setModel(modelo.modeloListaHabitacion);

				} catch (Exception e1) {
					System.out.println("el ArrayList de dormitorios no ha sido rellenado");
					e1.printStackTrace();
				}
				// Sysout para ver que se rellena el objeto correctamente
				System.out.println(Hotel1.toString() + "heyyyy");

			}
		});

		ventana.hotel.btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambio_panel(ventana.hotel, ventana.raiz);
				try {
					modelo.modeloListaHabitacion.vaciarLista();
					modelo.modeloListaHotel.vaciarLista();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ventana.hotel.listaHoteles.setModel(modelo.modeloListaHotel);

			}
		});

	}

	// metodo para rellenar el objeto

	public static Hotel_habitacion obtenerHabitaciones(int i) throws Exception {

		String sentencia = "select * from Hotel_habitacion where Cod_Hotel='%s'";
		sentencia = String.format(sentencia, i);
		ResultSet result = GestorBD.consulta(sentencia);
		while (result.next()) {
			Hotel1 = new Hotel_habitacion(result.getInt("Cod_Hotel"), result.getString("Habitacion1"),
					result.getString("Habitacion2"), result.getString("Habitacion3"), result.getString("Habitacion4"),
					result.getString("Habitacion5"), result.getString("Habitacion6"), result.getString("Habitacion7"),
					result.getString("Habitacion8"), result.getString("Habitacion9"), result.getString("Habitacion10"));
		}
		return Hotel1;
	}

}
