import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class ProcesosRegistroN {
     int notasIngresadas = 0;
     int estudiatesAprobados = 0;
     int estudiatesReprobados = 0;
     int estudiatesHabilitan = 0;
     int estudiantesSinHabilitacion = 0;

     int cantidadEstudiantes;
     ArrayList<String> estudiantes = new ArrayList<String>();
     HashMap<String, ArrayList<Double>> registroNotasEstudiantes;

    public  void iniciar() {
        cantidadEstudiantes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de estudiantes: "));
        almacenarNotas();
        definirAprobacion(estudiantes);
        estudiantesSinHabilitacion = estudiatesReprobados - estudiatesHabilitan;
        mensaje();
    }

    public  void almacenarNotas() {
        ArrayList<Double> notas = null;
        String nombre;
        registroNotasEstudiantes = new HashMap<String, ArrayList<Double>>();
        for (int i = 0; i < cantidadEstudiantes; i++) {
            nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante " + (i + 1));
            estudiantes.add(nombre);
            notas = new ArrayList<Double>();
            for (int j = 0; j < 3; j++) {
                double nota;
                do {
                    nota = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota " + (j + 1) + " de " + nombre + ":"));
                } while (!(nota >= 0 && nota <= 5));
                notas.add(nota);
                notasIngresadas++;
            }
            registroNotasEstudiantes.put(nombre, notas);
        }
    }

    public  double calcularDefinitiva(String key) {
        double suma = 0;
        double resultado = 0;
        if (registroNotasEstudiantes.containsKey(key)) {
            ArrayList<Double> notasEstudiante = registroNotasEstudiantes.get(key);
            for (int i = 0; i < notasEstudiante.size(); i++) {
                suma += notasEstudiante.get(i);
            }
            resultado = suma / (registroNotasEstudiantes.get(key).size());
        }

        return resultado;
    }

    public  void definirAprobacion(ArrayList<String> estudiantes) {
        for (int i = 0; i < estudiantes.size(); i++) {
            double definitiva = calcularDefinitiva(estudiantes.get(i));
            if (definitiva > 3.5) {
                estudiatesAprobados++;
            } else if (definitiva > 2.0) {
                estudiatesHabilitan++;
                estudiatesReprobados++;

            } else {
                estudiatesReprobados++;
            }
        }
    }

    public  double promedioNotasFinales(ArrayList<String> estudiantes) {
        double total = 0;
        for (int i = 0; i < estudiantes.size(); i++) {
            double notaEstudiante = calcularDefinitiva(estudiantes.get(i));
            total += notaEstudiante;
        }
        return total / estudiantes.size();
    }

    public  void mensaje() {
        String mensaje = "Cantidad de estudiantes validados: " + estudiantes.size() + "\n";
        mensaje += "Cantidad de notas ingresadas: " + notasIngresadas + "\n";
        mensaje += "Estudiantes aprobados: " + estudiatesAprobados + "\n";
        mensaje += "Cantidad estudiantes reprobados: " + estudiatesReprobados + "\n";
        mensaje += "Cantidad de estudiantes que pueden habilitar: " + estudiatesHabilitan + "\n";
        mensaje += "Cantidad de estudiantes que pierden sin habilitacion: " + estudiantesSinHabilitacion + "\n";
        mensaje += "Promedio de notas finales obtenidas: " + promedioNotasFinales(estudiantes);

        System.out.println(mensaje);
    }
}

