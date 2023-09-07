/*
 * Fecha de creacion: 05/09/2023 15:10:43
 * Version: v.0.1
 * Detalles: 
 */
package controlador;

import datos.Usuario;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Willy Stbn
 */
public class Controlador implements Initializable {
    
    @FXML
    private TableColumn<Usuario, String> colApellidos;

    @FXML
    private TableColumn<Usuario, Integer> colEdad;

    @FXML
    private TableColumn<Usuario, String> colEstatus;

    @FXML
    private TableColumn<Usuario, String> colNombre;

    @FXML
    private TableColumn<Usuario, String> colPass;

    @FXML
    private TableColumn<Usuario, String> colUsuario;

    @FXML
    private Label label_Error;

    @FXML
    private Label label_Fecha;

    @FXML
    private TableView<Usuario> tablaContenedor;

    @FXML
    private ToggleButton toggleEstatus;

    @FXML
    private TextField txtEdad;
    
    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtNombre;

    @FXML
    private PasswordField txtPass;

    @FXML
    private TextField txtUsuario;
    
    
    Usuario user;
    List<Usuario> datosList = new ArrayList<>();

    @FXML
    void btnEstatus(ActionEvent event) {
        if(toggleEstatus.getText().equals("Inactivo")){
            toggleEstatus.getStyleClass().remove("estatus-text");
            toggleEstatus.getStyleClass().add("estatus-cambio");
            toggleEstatus.setText("Activo");
        } else {
            toggleEstatus.getStyleClass().remove("estatus-cambio");
            toggleEstatus.getStyleClass().add("estatus-text");
            toggleEstatus.setText("Inactivo");
        }
    }

    @FXML
    void btnNuevo(ActionEvent event) {
        
        System.out.println(VerificarCampos());
        if(VerificarCampos()){
            
            label_Error.setVisible(false);
            ObtenerDatos();
            datosList.add(user);
            ObservableList<Usuario> datosTabla = FXCollections.observableArrayList(datosList);
            tablaContenedor.setItems(datosTabla);
            
            colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            colApellidos.setCellValueFactory(new PropertyValueFactory<>("Apellido"));
            colEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
            colEstatus.setCellValueFactory(new PropertyValueFactory<>("estatus"));
            colUsuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
            colPass.setCellValueFactory(new PropertyValueFactory<>("pass"));
            
        } else {
            label_Error.setVisible(true);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Fecha();
        label_Error.setVisible(false);
        
    }   
    
    
    private void Fecha(){
        Date fec = new Date();
        SimpleDateFormat fecha = new SimpleDateFormat("dd-MM-YYYY");
        label_Fecha.setText(fecha.format(fec));
    }
    
    private boolean VerificarCampos(){
        boolean nombre = !txtNombre.getText().isBlank();
        boolean apellido = !txtApellido.getText().isBlank();
        boolean edad = !txtEdad.getText().isBlank();
        boolean us = !txtUsuario.getText().isBlank();
        boolean pas = !txtPass.getText().isBlank();
        
        return nombre && apellido && edad && us && pas;
    }
    
    private void ObtenerDatos(){
        user = new Usuario();
        user.setNombre(txtNombre.getText().trim());
        user.setApellido(txtApellido.getText().trim());
        user.setEdad(Integer.parseInt(txtEdad.getText().trim()));
        user.setUsuario(txtUsuario.getText().trim());
        String pass = "";
        for (int i = 0; i < txtPass.getText().trim().length(); i++) {
            pass += "*";
        }
        user.setPass(pass);
        
        boolean estatus = toggleEstatus.isSelected();
        if(estatus){
            user.setEstatus("Activo");
        } else {
            user.setEstatus("Inactivo");
        }
    }
    
    
    private void LimpiarCampos(){
        txtNombre.clear();
        txtApellido.clear();
        txtEdad.clear();
        txtPass.clear();
        txtUsuario.clear();
        label_Error.setVisible(false);
        toggleEstatus.isSelected();
    }
}
