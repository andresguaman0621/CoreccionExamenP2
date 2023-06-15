import java.util.ArrayList;
import java.util.Comparator;

public class Ordenamiento {
    public ArrayList ordenarPorNombre(ArrayList<Plato> platos) {

        int n = platos.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                Plato platoActual = platos.get(j);
                Plato platoSiguiente = platos.get(j + 1);

                Comparator<Plato> comparador = Comparator.comparing(plato -> plato.getNombre(), String.CASE_INSENSITIVE_ORDER);
                if (comparador.compare(platoActual, platoSiguiente) > 0) {
                    // Intercambiar los platos
                    platos.set(j, platoSiguiente);
                    platos.set(j + 1, platoActual);
                }
            }
        }
        return platos;
    }

    public ArrayList ordenarPorPrecio(ArrayList<Plato> platos) {
        int n = platos.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                Plato platoActual = platos.get(j);
                Plato platoSiguiente = platos.get(j + 1);

                Comparator<Plato> comparador = Comparator.comparingDouble(plato -> plato.getPrecio());
                if (comparador.compare(platoActual, platoSiguiente) > 0) {
                    // Intercambiar los platos
                    platos.set(j, platoSiguiente);
                    platos.set(j + 1, platoActual);
                }
            }
        }
        return platos;
    }

    public ArrayList ordenarPorCalorias(ArrayList<Plato> platos) {
        int n = platos.size();

        for (int i = 1; i < n; i++) {
            Plato platoActual = platos.get(i);
            int j = i - 1;

            Comparator<Plato> comparador = Comparator.comparingDouble(plato -> plato.getCalorias());
            while (j >= 0 && comparador.compare(platos.get(j), platoActual) > 0) {
                platos.set(j + 1, platos.get(j));
                j--;
            }

            platos.set(j + 1, platoActual);
        }
        return platos;
    }

    public ArrayList ordenarPorTiempoPreparacion(ArrayList<Plato> platos) {
        int n = platos.size();

        for (int i = 1; i < n; i++) {
            Plato platoActual = platos.get(i);
            int j = i - 1;

            Comparator<Plato> comparador = Comparator.comparingInt(plato -> plato.getTiempoPreparacion());
            while (j >= 0 && comparador.compare(platos.get(j), platoActual) > 0) {
                platos.set(j + 1, platos.get(j));
                j--;
            }

            platos.set(j + 1, platoActual);
        }
        return platos;
    }


    public Plato buscarPorNombre(ArrayList<Plato> platos, String nombre) {
        int izquierda = 0;
        int derecha = platos.size() - 1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            int comparacion = platos.get(medio).getNombre().compareToIgnoreCase(nombre);

            if (comparacion == 0) {
                return platos.get(medio);
            }

            if (comparacion < 0) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }

        return null;
    }

    public Plato buscarPorPrecio(ArrayList<Plato> platos, double precio) {
        int centro, primero, ultimo;
        double valorCentro;
        primero = 0;
        ultimo = platos.size() - 1;
        while (primero <= ultimo) {
            centro = (primero + ultimo) / 2;
            valorCentro = platos.get(centro).getPrecio();
            if (precio == valorCentro) {
                return platos.get(centro);
            } else if (precio < valorCentro) {
                ultimo = centro - 1;
            } else {
                primero = centro + 1;
            }
        }
        return null;
    }


    public Plato buscarPorCalorias(ArrayList<Plato> platos, double calorias) {
        int centro, primero, ultimo;
        double valorCentro;
        primero = 0;
        ultimo = platos.size() - 1;
        while (primero <= ultimo) {
            centro = (primero + ultimo) / 2;
            valorCentro = platos.get(centro).getCalorias();
            if (calorias == valorCentro) {
                return platos.get(centro);
            } else if (calorias < valorCentro) {
                ultimo = centro - 1;
            } else {
                primero = centro + 1;
            }
        }
        return null;
    }


    public Plato buscarPorTiempo(ArrayList<Plato> platos, double tiempo) {
        int centro, primero, ultimo;
        double valorCentro;
        primero = 0;
        ultimo = platos.size() - 1;
        while (primero <= ultimo) {
            centro = (primero + ultimo) / 2;
            valorCentro = platos.get(centro).getTiempoPreparacion();
            if (tiempo == valorCentro) {
                return platos.get(centro);
            } else if (tiempo < valorCentro) {
                ultimo = centro - 1;
            } else {
                primero = centro + 1;
            }
        }
        return null;
    }

}
