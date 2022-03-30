/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.utiles;

import entidades.EstadoInmueble;
import entidades.TipoCliente;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Amalia Sanchez <du_hast_a@hotmail.com>
 */
public class Comunes {

    public static final String[] TIPO_DOCUMENTO = {"Desconocido", "DNI", "NIE", "CIF", "Permiso Residencia"};
    public static final String[] TIPO_INMUEBLE = {"Casa", "Chalet", "Garage", "Piso", "Local", "Oficina"};
    public static final String[] PROVINCIA = {"Madrid", "Toledo", "Segovia", "Ciudad Real"};//Puede ir aumentando
    public static final String[] LOCALIDAD_MADRID = {"Boadilla del Monte", "Bustarviejo", "Cercedilla", "Madrid", "Miraflores de la Sierra", "Rivas Vaciamadrid", "San Sebastian de los Reyes", "Soto del Real", "Torrelodones", "Villamanrique de Tajo"};
    public static final String[] ZONA = {"Arganzuela", "Centro", "Carabanchel", "Chamartin", "Chamberí", "Ciudad Lineal", "Cuatro Caminos", "Lista", "Hortaleza", "Moncloa-Aravaca", "Moratalaz", "Rivas-Vaciamadrid", "Retiro", "Salamanca", "San Blas", "Tetuán-Valdeacederas", "Usera"};
    public static final String[] TIPO_OPERACION = {"Venta", "Alquiler"};
    public static final String[] MEDIO = {"Web", "Fotocasa", "Pisos.com", "Idealista", "Mil Anuncios", "Publicidad Exterior", "Cartera"};
    public static final String[] MES = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    public static final String[] AÑO = {"2021", "2022", "2023", "2024", "2025", "2026"};
    public static final double PORCENTAJE_MAXIMO = 12;

    public static void ocultarColumnas(JTable tabla, int[] columnas) {
        for (int i = 0; i < columnas.length; i++) {
            int col = columnas[i];
            tabla.getColumnModel().getColumn(col).setMaxWidth(0);
            tabla.getColumnModel().getColumn(col).setMinWidth(0);
            tabla.getTableHeader().getColumnModel().getColumn(col).setMaxWidth(0);
            tabla.getTableHeader().getColumnModel().getColumn(col).setMinWidth(0);
        }
    }

    public static void mensaje(String msj, String icono) {
        ImageIcon icon = new ImageIcon();
        switch (icono) {
            case "ok":
                icon = new ImageIcon("src/presentacion/iconos/ok.png");
                break;
            case "warning":
                icon = new ImageIcon("src/presentacion/iconos/warning.png");
                break;
            case "error":
                icon = new ImageIcon("src/presentacion/iconos/error.png");
                break;
            default:
                throw new AssertionError();
        }
        JOptionPane.showMessageDialog(null, msj, "Mensaje", JOptionPane.PLAIN_MESSAGE, icon);
    }

    public static boolean preguntar(String msj) {
        boolean respuesta = false;
        //0 – Aceptar o Sí; 1- No; 2 – Cancelar
        if (JOptionPane.showConfirmDialog(null, msj, "Mensaje", JOptionPane.YES_NO_OPTION) == 0) {
            respuesta = true;
        }
        return respuesta;
    }

    public static void llenarComboboxGenerico(String[] array, JComboBox<String> comboBox) {
        for (String i : array) {
            comboBox.addItem(i);
        }
    }

    public static int getPosicionComboBoxGenerico(String[] arrayBuscar, String buscar) {
        int posicion = 0;
        for (int i = 0; i < arrayBuscar.length; i++) {
            if (arrayBuscar[i].equals(buscar)) {
                posicion = i;
            }
        }
        return posicion;
    }

    public static int getPosicionComboBoxTipos(List<TipoCliente> listaBuscar, String buscar) {
        int posicion = 0;
        for (int i = 0; i < listaBuscar.size(); i++) {
            if (listaBuscar.get(i).getNombreTipo().equals(buscar)) {
                posicion = i;
            }
        }
        return posicion;
    }

    public static void llenarComboboxTipos(List<TipoCliente> estados, JComboBox<String> comboBox) {
        for (TipoCliente i : estados) {
            comboBox.addItem(i.getNombreTipo());
        }
    }

     public static int getPosicionComboBoxEstados(List<EstadoInmueble> listaBuscar, String buscar) {
        int posicion = 0;
        for (int i = 0; i < listaBuscar.size(); i++) {
            if (listaBuscar.get(i).getEstado().equals(buscar)) {
                posicion = i;
            }
        }
        return posicion;
    }

     public static void llenarComboboxEstados(List<EstadoInmueble> estados, JComboBox<String> comboBox) {
        for (EstadoInmueble i : estados) {
            comboBox.addItem(i.getEstado());
        }
    }
     
     public static boolean esNumerico(String porcentaje) {
        int contador1 = 0;
        boolean esNumerico = true;
        for (int i = 0; i < porcentaje.length(); i++) {
            if (!Character.isDigit(porcentaje.charAt(i))) {
                if (porcentaje.charAt(i) == ',' || porcentaje.charAt(i) == '.') {
                    contador1++;
                } else {
                    esNumerico = false;
                }
            }
            if (contador1 > 1) {
                esNumerico = false;
            }
        }
        return esNumerico;
    }
}
