package co.edu.poli.examen2_caballero.controlador;

import java.time.format.DateTimeFormatter;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import co.edu.poli.examen2_caballero.modelo.*;
import co.edu.poli.examen2_caballero.servicios.DAOInmueble;
import co.edu.poli.examen2_caballero.servicios.DAOPropietario;

public class ControlForm {

    @FXML private TextField txtNumero;
    @FXML private DatePicker dateCompra;
    @FXML private ComboBox<Propietario> comboPropietario;
    @FXML private RadioButton rbCasa;
    @FXML private RadioButton rbApartamento;
    @FXML private TextField txtValor;

    private DAOInmueble dao = new DAOInmueble();
    private DAOPropietario daoP = new DAOPropietario();

    @FXML
    public void initialize() {

        // cargar propietarios
        comboPropietario.getItems().setAll(daoP.readAll());

        // agrupar radio buttons
        ToggleGroup group = new ToggleGroup();
        rbCasa.setToggleGroup(group);
        rbApartamento.setToggleGroup(group);
    }

    @FXML
    private void crear() {

        try {
            String numero = txtNumero.getText();
            String fecha = dateCompra.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Propietario p = comboPropietario.getValue();
            int valor = Integer.parseInt(txtValor.getText());

            Inmueble i;

            if (rbCasa.isSelected()) {
                i = new Casa(numero, fecha, "Disponible", p, valor);
            } else {
                i = new Apartamento(numero, fecha, "Disponible", p, valor);
            }

            boolean ok = dao.create(i);

            if (ok) {
                mostrar("Insertado correctamente");
            } else {
                mostrar("Error al insertar");
            }

        } catch (Exception e) {
            e.printStackTrace(); // 🔴 importante para debug
            mostrar("Error en los datos");
        }
    }

    private void mostrar(String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(msg);
        a.show();
    }
}