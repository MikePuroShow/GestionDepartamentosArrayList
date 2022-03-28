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
    public static int dept_no_insertarEMPLEADO;

    public static void main(String[] args) throws IOException {
        //System.out.println(); ---> sout
        //Control + ALT + L FORMATEAR
        //cargaAutomatica(); // 3 departamentos
        departamentos.add(new Departamento(14, "Ventas", "Sevilla"));
        //departamentos.add(new Departamento(15, "Domicilios", "Merida"));
        mostrarDepartamentos();
        modificarEmpleadosInteractivo();
        //modificarEmpleadosInteractivo();
        mostrarDepartamentos();
        // System.out.println(compareToD(departamentos.get(1)));
        //System.out.println(insertarEmpleado());
        //mostrarDepartamentos();

    }

    private static void mostrarDepartamentos() {
        for (Departamento dep : departamentos) {
            System.out.println(dep);
            for (Empleado emp : dep.getEmpleados()) {
                System.out.println(emp);
            }
        }


    }

    private static void insertarInteractivaDepartamentos() throws IOException {
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Bienvenido al metodo de carga interactiva");
        while (!salir1) {
            try {
                System.out.println("Introduza el numero de departamento");
                numeroDepartamento = Integer.parseInt(br1.readLine());
                if (existeDepartamento(numeroDepartamento) == 1) {
                    System.out.println("El numero de departamento ya existe");
                    break;
                }
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
            insertarDepartamentoFuncional();
            System.out.println("SI QUIERES AÑADIR OTRO DEPARTAMENTO PULSE 1");
            System.out.println("SI NO QUIERES AÑADIR MAS DEPARTAMENTOS PULSE 2");
            numeroOpcion = Integer.parseInt(br1.readLine());
            if (numeroOpcion == 2) {
                salir1 = true;
            }
        }
    }

    private static void insertarDepartamentoFuncional() {

        departamentos.add(new Departamento(numeroDepartamento, nombreDepartamento, localizacion));
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

    public static int insertarEmpleado() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introduce el numero de Departamento donde vas a insertar el empleado");
        dept_no_insertarEMPLEADO = Integer.parseInt(br.readLine());
        boolean encontrado = false;
        int contador = 0;
        if (existeDepartamento(dept_no_insertarEMPLEADO) == 1) {
            System.out.println("Introduce el numero de Empleado");
            int empl_no = Integer.parseInt(br.readLine());
            if (existeEmpleado(empl_no) == -1) {
                System.out.println("PULSE 1 PARA AÑADIR ANALISTA Y DOS PARA AÑADIR DIRECTIVO");
                int opcionEm = Integer.parseInt(br.readLine());
                System.out.println("Introduzca el nombre del empleado");
                String nombreEm = br.readLine();
                System.out.println("Introduzca la fecha de alta");
                LocalDate fechaalta = LocalDate.parse(br.readLine());
                System.out.println("Introduzca el salario");
                int SalarioEm = Integer.parseInt(br.readLine());
                Empleado empl = null;
                switch (opcionEm) {
                    case 1:
                        empl = new Analista(dept_no_insertarEMPLEADO, nombreEm, fechaalta, SalarioEm, departamentos.get(buscarDepartamento(dept_no_insertarEMPLEADO)));
                        break;
                    case 2:
                        System.out.println("Introduzca la comision");
                        int comisionEm = Integer.parseInt(br.readLine());
                        empl = new Directivo(dept_no_insertarEMPLEADO, nombreEm, fechaalta, SalarioEm, departamentos.get(buscarDepartamento(dept_no_insertarEMPLEADO)), comisionEm);
                        break;
                }
                insertarEmpleadoFuncional(empl, departamentos.get(buscarDepartamento(dept_no_insertarEMPLEADO)));
            } else {
                return 0; //SI NO EXISTE EL EMPLEAOD
            }
        } else {
            return -1; //SI NO EXISTE EL DEPARTAMENTO
        }


        return 1;
    }

    private static int existeDepartamento(int dept_no) {
        boolean encontrado = false;
        int contador = 0;
        do {
            if (departamentos.size() == 0) {
                return -1;
            }
            if (departamentos.get(contador) != null && departamentos.get(contador).getDept_no() == dept_no) {
                encontrado = true;
            } else contador++;
        } while (!encontrado && contador < departamentos.size());
        if (encontrado) return 1;
        else return -1;
    }

    private static int buscarDepartamento(int dept_no) {
        boolean encontrado = false;
        int contador = 0;
        do {
            if (departamentos.get(contador) != null && departamentos.get(contador).getDept_no() == dept_no) {
                encontrado = true;
            } else contador++;
        } while (!encontrado && contador < departamentos.size());
        if (encontrado) {
            return contador;
        } else {
            return -1;
        }
    }

    private static int existeEmpleado(int empl_no) {
        int salida = 0;
        for (int i = 0; i < departamentos.size(); i++) {
            for (int j = 0; j < departamentos.get(i).getEmpleados().size(); j++) {
                if (departamentos.get(i).getEmpleados().get(j).getNumeroempleado() == empl_no) {
                    salida = 1;
                    break;
                } else salida = -1;
            }
        }
        return salida;
    }

    public static int insertarEmpleadoFuncional(Empleado empl, Departamento dept) {
        departamentos.get(buscarDepartamento(dept_no_insertarEMPLEADO)).getEmpleados().add(empl);
        return 1;
    }

    public static int compareToD(Departamento o) {
        int salida = 0;
        int e = 0;
        for (int i = 0; i < departamentos.size(); i++) {
            if (departamentos.get(0).getDept_no() == o.getDept_no()) {
                salida = 1;
            }
        }
        for (e = 0; e < departamentos.get(e).getEmpleados().size(); e++) {
            if (departamentos.get(e).getEmpleados().get(e).getNumeroempleado() == o.getEmpleados().get(e).getNumeroempleado()) {
                salida = 2;
                break;
            }
        }
        if (salida == 1) {
            System.out.println("El numero de departamento esta repetido, se aconseja cambiarlo");
        }
        if (salida == 2) {
            System.out.println("En este departamento hay empleados con el mismo numero de empleados que en el departamento" + " " + departamentos.get(e).toString());
        }
        return salida;
    }

    public static int borrarEmpleadoFuncional(int numeroEm) {
        for (Departamento departamento : departamentos) {
            departamento.getEmpleados().removeIf(i -> i.getNumeroempleado() == numeroEm);
        }
        return 1;
    }

    public static void borrarEmpleadoInteractivo() throws IOException {
        System.out.println("*******************************************");
        System.out.println("Bienvenido al método para borrar empleado");
        System.out.println("Introduzca el numero de Empleado, el cual quieres borrar");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num_emp = Integer.parseInt(br.readLine());
        if (existeEmpleado(num_emp) == 1) {
            borrarEmpleadoFuncional(num_emp);
        } else {
            System.out.println("No existe ese empleado");
        }
    }

    public static int borrarDepartamentoFuncional(int dept_no) {
        int salida = 0;
        for (int i = 0; i < departamentos.size(); i++) {
            if (departamentos.get(i).getDept_no() == dept_no) {
                departamentos.remove(i);
                salida = 1;
            } else {
                salida = 0;
            }
        }
        return salida;
    }

    public static void borrarDepartamentoInteractivo() throws IOException {
        System.out.println("*******************************************");
        System.out.println("Bienvenido al método para borrar departamento");
        System.out.println("Introduzca el numero de departamento, el cual quieres borrar");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num_dept = Integer.parseInt(br.readLine());
        if (existeDepartamento(num_dept) == 1) {
            borrarDepartamentoFuncional(num_dept);
        } else {
            System.out.println("El numero de departamento no existe");
        }
    }

    public static void modificarEmpleadosInteractivo() throws IOException {
        boolean salir = false;
        while (!salir) {
            System.out.println("*******************************************");
            System.out.println("Bienvenido al método para modificar Empleados");
            System.out.println("Escribe que operacion desea hacer");
            System.out.println("0.Para salir");
            System.out.println("1.Modificar numero de Empleado");
            System.out.println("2.Modificar nombre de Empleado");
            System.out.println("3.Modificar salario de Empleado");
            System.out.println("4.Modificar fecha de alta de Empleado");
            System.out.println("5.Modificar comision DIRECTIVO!!!!!!(ESTA OPCIÓN ES APLICABLE SOLO EN DIRECTIVOS)!!!!!");
            System.out.println("*******************************************");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int opcion = Integer.parseInt(br.readLine());
            switch (opcion) {
                case 0:
                    salir = true;
                    break;
                case 1:
                    System.out.println("Escribe el numero de empleado que quieres modificar");
                    int num_emp = Integer.parseInt(br.readLine());
                    if (existeEmpleado(num_emp) == 1) {
                        System.out.println("Introduce el nuevo numero de empleado");
                        int numeronuevo = Integer.parseInt(br.readLine());
                        if (modificarNumeroEmpleadosFuncional(num_emp, numeronuevo) == 1) {
                            System.out.println("Cambio realizado con exito");
                        }
                        break;
                    } else {
                        System.out.println("No existe ese numero de Empleado");
                    }
                case 2:
                    System.out.println("Escribe el numero de empleado que quieres modificar");
                    num_emp = Integer.parseInt(br.readLine());
                    if (existeEmpleado(num_emp) == 1) {
                        System.out.println("Introduce el nuevo nombre de empleado");
                        String nombreEmpleado = br.readLine();
                        if (modificarNombrEmpleadoFuncional(num_emp, nombreEmpleado) == 1) {
                            System.out.println("Cambio realizado con exito");
                            break;
                        } else {
                            System.out.println("No existe ese numero de Empleado o el nombre contiene caracteres inválidos");
                        }
                    }
                case 3:
                    System.out.println("Escribe el numero de empleado que quieres modificar");
                    num_emp = Integer.parseInt(br.readLine());
                    if (existeEmpleado(num_emp) == 1) {
                        System.out.println("Introduce el nuevo salario de empleado");
                        int salarionuevo = Integer.parseInt(br.readLine());
                        if (modificarSalarioFuncional(num_emp, salarionuevo) == 1) {
                            System.out.println("Cambio realizado con exito");
                        }
                        break;
                    } else {
                        System.out.println("No existe ese numero de Empleado");
                    }

                case 4:
                    System.out.println("Escribe el numero de empleado que quieres modificar");
                    num_emp = Integer.parseInt(br.readLine());
                    if (existeEmpleado(num_emp) == 1) {
                        System.out.println("Introduce la nueva fecha de empleado");
                        LocalDate fechanueva = LocalDate.parse(br.readLine());
                        if (modificarFechaFuncional(num_emp, fechanueva) == 1) {
                            System.out.println("Cambio realizado con exito");
                        }
                        break;
                    } else {
                        System.out.println("No existe ese numero de Empleado");
                    }
                case 5:
                    System.out.println("Escribe el numero de DIRECTIVO que quieres modificar");
                    num_emp = Integer.parseInt(br.readLine());
                    if (existeEmpleado(num_emp) == 1) {
                        System.out.println("Introduce la nueva comision de DIRECTIVO");
                        int cominueva = Integer.parseInt(br.readLine());
                        if (modificarComisionFuncional(num_emp, cominueva) == 1) {
                            System.out.println("Cambio realizado con exito");
                        }
                        break;
                    } else {
                        System.out.println("No existe ese numero de Empleado");
                    }
            }
        }
    }

    private static int modificarComisionFuncional(int num_emp, int comisionNueva) {
        int salida = 0;
        boolean encontrado = false;
        int contador = 0;
        if (departamentos.get(contador).getEmpleados().size() == 0) {
            salida = -2; //COMPROBACION SI HAY EMPLEADOS.
        }
        for (int i = 0; i < departamentos.size(); i++) {
            for (int e = 0; e < departamentos.get(i).getEmpleados().size(); e++) {
                if (departamentos.get(i).getEmpleados().get(e).getNumeroempleado() == num_emp) {
                    ((Directivo)departamentos.get(i).getEmpleados().get(e)).setComision(comisionNueva);
                    salida = 1;
                } else salida = 0;
            }
        }
        return salida;
    }

    private static int modificarFechaFuncional(int num_emp, LocalDate fechanueva) {
        int salida = 0;
        boolean encontrado = false;
        int contador = 0;
        if (departamentos.get(contador).getEmpleados().size() == 0) {
            salida = -2; //COMPROBACION SI HAY EMPLEADOS.
        }
        for (int i = 0; i < departamentos.size(); i++) {
            for (int e = 0; e < departamentos.get(i).getEmpleados().size(); e++) {
                if (departamentos.get(i).getEmpleados().get(e).getNumeroempleado() == num_emp) {
                    departamentos.get(i).getEmpleados().get(e).setFechaAlta(fechanueva);
                    salida = 1;
                } else salida = 0;
            }
        }
        return salida;
    }

    private static int modificarNumeroEmpleadosFuncional(int empl_no, int numeronuevo) {
        int salida = 0;
        boolean encontrado = false;
        int contador = 0;
        if (departamentos.get(contador).getEmpleados().size() == 0) {
            salida = -2; //COMPROBACION SI HAY EMPLEADOS.
        }
        for (int i = 0; i < departamentos.size(); i++) {
            for (int e = 0; e < departamentos.get(i).getEmpleados().size(); e++) {
                if (departamentos.get(i).getEmpleados().get(e).getNumeroempleado() == empl_no) {
                    departamentos.get(i).getEmpleados().get(e).setNumeroempleado(numeronuevo);
                    salida = 1;
                } else salida = 0;
            }
        }
        return salida;
    }

    private static int modificarNombrEmpleadoFuncional(int emplo_no, String nuevoNombre) {
        int salida = 0;
        boolean encontrado = false;
        int contador = 0;
        if (departamentos.get(contador).getEmpleados().size() == 0) {
            salida = -2; //COMPROBACION SI HAY EMPLEADOS.
        }
        for (int i = 0; i < departamentos.size(); i++) {
            for (int e = 0; e < departamentos.get(i).getEmpleados().size(); e++) {
                if (departamentos.get(i).getEmpleados().get(e).getNumeroempleado() == emplo_no) {
                    departamentos.get(i).getEmpleados().get(e).setNombre(nuevoNombre);
                    salida = 1;
                    break;
                } else salida = 0;
            }
        }
        return salida;
    }

    private static int modificarSalarioFuncional(int empl, int salario) {
        int salida = 0;
        boolean encontrado = false;
        int contador = 0;
        if (departamentos.get(contador).getEmpleados().size() == 0) {
            salida = -2; //COMPROBACION SI HAY EMPLEADOS.
        }
        for (int i = 0; i < departamentos.size(); i++) {
            for (int e = 0; e < departamentos.get(i).getEmpleados().size(); e++) {
                if (departamentos.get(i).getEmpleados().get(e).getNumeroempleado() == empl) {
                    departamentos.get(i).getEmpleados().get(e).setSalario(salario);
                    salida = 1;
                    break;
                } else salida = 0;
            }
        }
        return salida;
    }
}


