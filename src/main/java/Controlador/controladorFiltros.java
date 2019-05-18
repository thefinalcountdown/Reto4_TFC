package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.modelo;
import Vista.Ventana;

public class controladorFiltros {
	private Ventana ventana;
	private modelo modelo;
	private Controlador controlador;
	
	public controladorFiltros() {
	}

	public controladorFiltros(Ventana ventana, modelo modelo, Controlador controlador) {
		this.ventana = ventana;
		this.modelo = modelo;
		this.controlador = controlador;

		ventana.alojamiento.comboTipo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String ubicacionSeleccionada = ventana.raiz.comboBoxUbicacion.getSelectedItem().toString();
				// vaciamos la lista y la tabla
				modelo.modeloListaAlojamiento.vaciarLista();
				modelo.habitacion.vaciarTabla(ventana.alojamiento.modeloTabla);

				// diferentes listas dependiendo del alojamiento seleccionado

				if (ventana.alojamiento.comboTipo.getSelectedItem().toString() == "Todos") {
					try {
						controlador.controladorHotel.estrellas_elegidas = 0;
						ventana.alojamiento.comboEstrellas.setSelectedIndex(0);
						modelo.modeloListaAlojamiento.vaciarLista();
						modelo.modeloListaAlojamiento.llenarLista(ubicacionSeleccionada);
						ventana.alojamiento.listaAlojamientos.setModel(modelo.modeloListaAlojamiento);
						ventana.alojamiento.comboEstrellas.setVisible(false);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else if (ventana.alojamiento.comboTipo.getSelectedItem().toString() == "Apartamento") {
					try {
						controlador.controladorHotel.estrellas_elegidas = 0;
						ventana.alojamiento.comboEstrellas.setSelectedIndex(0);
						modelo.modeloListaAlojamiento.vaciarLista();
						modelo.modeloListaAlojamiento.llenarListaApartamentos(ubicacionSeleccionada);
						ventana.alojamiento.listaAlojamientos.setModel(modelo.modeloListaAlojamiento);
						ventana.alojamiento.comboEstrellas.setVisible(false);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (ventana.alojamiento.comboTipo.getSelectedItem().toString() == "Casa") {
					try {
						controlador.controladorHotel.estrellas_elegidas = 0;
						ventana.alojamiento.comboEstrellas.setSelectedIndex(0);
						modelo.modeloListaAlojamiento.vaciarLista();
						modelo.modeloListaAlojamiento.llenarListaCasas(ubicacionSeleccionada);
						ventana.alojamiento.listaAlojamientos.setModel(modelo.modeloListaAlojamiento);
						ventana.alojamiento.comboEstrellas.setVisible(false);
						
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (ventana.alojamiento.comboTipo.getSelectedItem().toString() == "Hotel") {
					try {
						modelo.modeloListaAlojamiento.vaciarLista();
						modelo.modeloListaAlojamiento.llenarListaHoteles(ubicacionSeleccionada);
						ventana.alojamiento.listaAlojamientos.setModel(modelo.modeloListaAlojamiento);
						ventana.alojamiento.comboEstrellas.setVisible(true);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

				// volvemos a asignarle el modelo a la lista
				ventana.alojamiento.listaAlojamientos.setModel(modelo.modeloListaAlojamiento);
			}

		});

	}
}
