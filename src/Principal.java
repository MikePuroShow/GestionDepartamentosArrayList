import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Principal {
    static ArrayList<Departamento> departamentos = new <Departamento>ArrayList();
    static ArrayList<Empleado> empleados1 = new <Empleado>ArrayList();
    static ArrayList<Empleado> empleados2 = new <Empleado>ArrayList();
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
        insertarEmpleado();
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

        /*empleados1.get(0).setDepartamento(departamentos.get(0));
        empleados1.get(1).setDepartamento(departamentos.get(0));
        empleados2.get(0).setDepartamento(departamentos.get(1));*/

        Iterator<Empleado> it = empleados1.iterator();
        while (it.hasNext()) {
            it.next().setDepartamento(departamentos.get(0));
        }
        Iterator<Empleado> its = empleados2.iterator();
        while (its.hasNext()) {
            its.next().setDepartamento(departamentos.get(1));
        }
    }

    public static void cargaComposicion() {
        departamentos.add(new Departamento(21, "Call Of Dutty", "Alaska"));
    }
    public static void insertarEmpleado() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introduce el numero de Departamento donde vas a insertar el empleado");
        int dept_no = Integer.parseInt(br.readLine());
        boolean encontrado = false;
        int contador = 0;
        System.out.println(existeDepartamento(dept_no));

    }

    private static int existeDepartamento(int dept_no) {
        boolean encontrado=false;
        int contador=0;
        do {
            if (departamentos.get(contador) != null && departamentos.get(contador).getDept_no() == dept_no) {
                encontrado = true;
            } else
                contador++;
        } while (!encontrado && contador < departamentos.size());
        if (encontrado) {
            return contador;
        }
        else{
            return -1;
        }
    }

}
