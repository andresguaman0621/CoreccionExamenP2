import javax.swing.*;
import java.util.ArrayList;

public class Menu {
    private ArrayList<Plato> platos;
    public Menu() {
        platos = new ArrayList<>();
    }

    public ArrayList<Plato> getPlatos() {
        return platos;
    }

    public boolean agregarPlato(Plato plato, JTextArea jt) {
        boolean nombreRepetido = false;

        for (Plato p : platos) {
            if (p.getNombre().equalsIgnoreCase(plato.getNombre())) {
                nombreRepetido = true;
                break;
            }
        }

        if (!nombreRepetido) {
            platos.add(plato);
            return true;
        } else {
            return false;
        }
    }


    public boolean eliminarPlato(Plato plato, JTextArea jt) {
        boolean eliminado = platos.remove(plato);

        if (eliminado) {
            jt.setText("Plato removido");
        } else {
            jt.setText("No se encontro el plato");
        }

        return eliminado;
    }

    public Plato buscarPorNombre(String nombre) {
        for (Plato plato : platos) {
            if (plato.nombre.equalsIgnoreCase(nombre)) {
                return plato;
            }
        }

        return null;

    }

    public Plato modificarPlato(Plato plato, double nuevoPrecio, double nuevasCalorias, int nuevoTiempoPreparacion) {
        plato.setPrecio(nuevoPrecio);
        plato.setCalorias(nuevasCalorias);
        plato.setTiempoPreparacion(nuevoTiempoPreparacion);

        return plato;
    }

    public void quemarDatos(JTextArea jt){

        platos.add(new Plato("Hamburguesa", 10.99, 500, 20));
        platos.add(new Plato("Pizza", 12.99, 800, 30));
        platos.add(new Plato("Desayuno", 8.99, 300, 15));
        platos.add(new Plato("Almuerzo", 15.99, 600, 40));
        platos.add(new Plato("Cafe", 9.99, 400, 25));

        jt.setText(platos.toString());
    }

}
