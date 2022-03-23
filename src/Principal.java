import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Principal {
    static ArrayList<Departamento> departamentos = new ArrayList();
    static ArrayList<Empleado> empleados1 = new ArrayList();
    static ArrayList<Empleado> empleados2 = new ArrayList();
    private static int numeroDepartamento;
    private static String nombreDepartamento;
    private static String localizacion;
    private static boolean salir1 = false;
    private static int numeroOpcion;

    public static void main(String[] args) throws IOException {
        //System.out.println(); ---> sout
        //Control + ALT + L FORMATEAR
        //cargaAutomatica(); // 3 departamentos
        //cargaAutomaticaAgregacion();
        cargaComposicion();
        mostrarDepartamentos();
    }

    private static void mostrarDepartamentos() {
        Iterator it = departamentos.iterator();
        while (it.hasNext()) {
            Departamento s = (Departamento) it.next();
            System.out.println(s.toString());
        }

    }

    private static void cargaInteractiva() throws IOException {
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Bienvenido al metodo de carga interactiva");
        while (!salir1) {
            try {
                System.out.println("Introduza el numero de departamento");
                numeroDepartamento = Integer.parseInt(br1.readLine());
            } catch (NumberFormatException ee) {
                System.out.println("Introduce un número válido" + " " + ee);
            }
            try {
                System.out.println("Introduzca el nombre de departamento");
                nombreDepartamento = br1.readLine();
            } catch (Exception e) {
                System.out.println("Nombre inválido" + e);
            }
            try {
                System.out.println("Introduzca la localizacion");
                localizacion = br1.readLine();
            } catch (Exception e) {
                System.out.println("Localizacion invalida" + " " + e);
            }
            departamentos.add(new Departamento(numeroDepartamento, nombreDepartamento, localizacion));
            System.out.println("SI QUIERES AÑADIR OTRO DEPARTAMENTO PULSE 1");
            System.out.println("SI NO QUIERES AÑADIR MAS DEPARTAMENTOS PULSE 2");
            numeroOpcion = Integer.parseInt(br1.readLine());
            if (numeroOpcion == 2) {
                salir1 = true;
            }
        }
    }


    private static void cargaAutomatica() {
        departamentos.add(new Departamento(14, "Ventas", "Sevilla"));
        departamentos.add(new Departamento(15, "Transporte", "Merida"));
        departamentos.add(new Departamento(16, "Quimica", "Barcelona"));

    }

    public static void cargaAutomaticaAgregacion() {
        empleados1.add(new Directivo(1, "Miguel", LocalDate.of(2022, 5, 4), 2000, null, 200));
        empleados1.add(new Directivo(2, "Saul", LocalDate.of(2022, 5, 4), 2000, null, 200));

        departamentos.add(new Departamento(12, "Esquiar", "Madrid", empleados1));

        empleados2.add(new Analista(3, "Juanma", LocalDate.of(2022, 5, 2), 1000, null));
        empleados2.add(new Analista(4, "Ezequiel", LocalDate.of(2022, 5, 2), 1000, null));
        departamentos.add(new Departamento(20, "Gatnie", "Sevilla", empleados2));

        empleados1.get(0).setDepartamento((Departamento) departamentos.get(0));
        empleados1.get(1).setDepartamento((Departamento) departamentos.get(0));
        empleados2.get(0).setDepartamento((Departamento) departamentos.get(1));
    }

    public static void cargaComposicion() {
        departamentos.add(new Departamento(21, "Call Of Dutty", "Alaska"));
    }

	/*public int borrarDepartamento(int numeroDep) {
		if (departamentos.contains(numeroDep)) {
			departamentos.contains(numeroDep)
		}*/


}
