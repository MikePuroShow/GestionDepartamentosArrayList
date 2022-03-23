public interface OperacionesEmpleado extends Operaciones {

    boolean empleadosVacio(Departamento dept);

    boolean empleadosLleno(Departamento dept);

    int existeEmpleado(int emp_no, int dept_no);

    void mostrarEmpleados(Departamento dept);
}
