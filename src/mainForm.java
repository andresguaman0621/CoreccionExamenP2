import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class mainForm extends JFrame {

    private JPanel mainPanel;
    private JTabbedPane tabbedPane1;
    private JTextField textIngresoNombre;
    private JButton ingresarPlatoButton;
    private JTextArea textAIngresoPlatos;
    private JButton QuemarDatosButton;
    private JTextField textIngresoPrecio;
    private JTextField textIngresoCalorias;
    private JTextField textIngresoPreparacion;
    private JButton buscarModifButton;
    private JButton modificarModifButton;
    private JTextField textoModifNombre;
    private JTextField textoModifPrecio;
    private JTextField textoModifCalorias;
    private JTextField textoModifPreparacion;
    private JTextArea textAModif;
    private JButton ButtonBuscarEliminar;
    private JTextField textNombreEliminar;
    private JTextArea textAEliminar;
    private JButton eliminarButton;
    private JComboBox comboBoxOrder;
    private JButton mostrarButton;
    private JTextArea textAMostrar;
    private JButton buscarButton;
    private JTextField textBuscarPlatoOrden;
    private Plato platoModificar;
    private Plato platoEliminar;
    private Menu m = new Menu();
    private Ordenamiento ord = new Ordenamiento();
    private ArrayList ordPorNombre;
    private ArrayList ordPorPrecio;
    private ArrayList ordPorCalorias;
    private ArrayList ordPorTiempoPreparacion;

    public mainForm() {

        ingresarPlatoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!textIngresoNombre.getText().isEmpty() && !textIngresoPrecio.getText().isEmpty() &&
                        !textIngresoCalorias.getText().isEmpty() && !textIngresoPreparacion.getText().isEmpty()){
                    Plato p2 = new Plato(textIngresoNombre.getText(), Double.parseDouble(textIngresoPrecio.getText()),
                            Double.parseDouble(textIngresoCalorias.getText()),
                            Integer.parseInt(textIngresoPreparacion.getText()));

                    boolean agregado = m.agregarPlato(p2, textAIngresoPlatos);
                    if(agregado==true){
                        textAIngresoPlatos.setText(p2.toString());
                    }else{
                        textAIngresoPlatos.setText("Un plato con ese nombre ya existe");
                    }

                }else{
                    textAIngresoPlatos.setText("Datos incompletos para el ingreso");
                }


            }
        });
        QuemarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.quemarDatos(textAIngresoPlatos);
                QuemarDatosButton.setEnabled(false);

            }
        });
        buscarModifButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                platoModificar = m.buscarPorNombre(textoModifNombre.getText());
                if(platoModificar!=null){
                    textAModif.setText(platoModificar.toString());
                    textoModifCalorias.setEditable(true);
                    textoModifPreparacion.setEditable(true);
                    textoModifPrecio.setEditable(true);
                }else{
                    textAModif.setText("No se encontro ese plato");
                }

            }
        });
        modificarModifButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    if(!textoModifPrecio.getText().isEmpty()&&!textoModifCalorias.getText().isEmpty()&&
                    !textoModifPreparacion.getText().isEmpty() && platoModificar!=null){

                            m.modificarPlato(platoModificar, Double.parseDouble(textoModifPrecio.getText()),
                                    Double.parseDouble(textoModifCalorias.getText()),
                                    Integer.parseInt(textoModifPreparacion.getText()));

                        int opcion = JOptionPane.showOptionDialog(null, "¿Deseas modificar el nombre del plato?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Sí", "No"}, "Sí");
                        if (opcion == JOptionPane.YES_OPTION) {

                            String texto = JOptionPane.showInputDialog(null, "Ingresa el nuevo nombre");
                            platoModificar.setNombre(texto);
                            JOptionPane.showMessageDialog(null,"El nombre se ha modificado");


                        } else if (opcion == JOptionPane.NO_OPTION) {
                            JOptionPane.showMessageDialog(null,"El nombre no se ha modificado");

                        } else {

                            JOptionPane.showMessageDialog(null,"El nombre no se ha modificado");
                        }
                            textAModif.setText(platoModificar.toString());
                            textoModifCalorias.setText("");
                            textoModifPreparacion.setText("");
                            textoModifPrecio.setText("");
                            textoModifCalorias.setEditable(false);
                            textoModifPreparacion.setEditable(false);
                            textoModifPrecio.setEditable(false);


                    }else{
                        textAModif.setText("Datos incompletos para la modificacion");
                    }


            }
        });
        ButtonBuscarEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                platoEliminar = m.buscarPorNombre(textNombreEliminar.getText());
                if(platoEliminar!=null){
                    textAEliminar.setText("Plato encontrado: \n" +platoEliminar.toString());
                }else{
                    textAEliminar.setText("No se encontro ese plato");
                }
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.eliminarPlato(platoEliminar, textAEliminar);
            }
        });
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(comboBoxOrder.getSelectedIndex()==0){
                    ordPorNombre= ord.ordenarPorNombre(m.getPlatos());
                    textAMostrar.setText(ordPorNombre.toString());
                    buscarButton.setEnabled(true);

                }else if(comboBoxOrder.getSelectedIndex()==1){
                    ordPorPrecio= ord.ordenarPorPrecio(m.getPlatos());
                    textAMostrar.setText(ordPorPrecio.toString());
                    buscarButton.setEnabled(true);

                }else if(comboBoxOrder.getSelectedIndex()==2){
                    ordPorCalorias=ord.ordenarPorCalorias(m.getPlatos());
                    textAMostrar.setText(ordPorCalorias.toString());
                    buscarButton.setEnabled(true);
                }else if(comboBoxOrder.getSelectedIndex()==3){
                    ordPorTiempoPreparacion=ord.ordenarPorTiempoPreparacion(m.getPlatos());
                    textAMostrar.setText(ordPorTiempoPreparacion.toString());
                    buscarButton.setEnabled(true);
                }
            }
        });

        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(comboBoxOrder.getSelectedIndex()==0){
                    String nombre = textBuscarPlatoOrden.getText();


                }else if(comboBoxOrder.getSelectedIndex()==1){
                    ordPorPrecio= ord.ordenarPorPrecio(m.getPlatos());
                    textAMostrar.setText(ordPorPrecio.toString());
                    buscarButton.setEnabled(true);

                }else if(comboBoxOrder.getSelectedIndex()==2){
                    ordPorCalorias=ord.ordenarPorCalorias(m.getPlatos());
                    textAMostrar.setText(ordPorCalorias.toString());
                    buscarButton.setEnabled(true);
                }else if(comboBoxOrder.getSelectedIndex()==3){
                    ordPorTiempoPreparacion=ord.ordenarPorTiempoPreparacion(m.getPlatos());
                    textAMostrar.setText(ordPorTiempoPreparacion.toString());
                    buscarButton.setEnabled(true);
                }
            }
        });
    }

    //Get mainPanel
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
