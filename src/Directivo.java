import java.time.LocalDate;
public class Directivo extends Empleado {
    int Comision;

    public Directivo(int numeroempleado, String nombre, LocalDate fechaAlta, double salario, Departamento departamento,
                     int comision) {
        super(numeroempleado, nombre, fechaAlta, salario, departamento);
        Comision = comision;
    }

    @Override
    public String toString() {
        return "Directivo [Comision=" + Comision + ", " + super.toString() + "]";
    }

    public void presentarse() {
        System.out.println("Directivo presentandose");
    }
    public  double calcularSalario() {
        return getSalario()*14 + Comision;
    }


}
