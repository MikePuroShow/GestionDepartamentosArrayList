import java.time.LocalDate;

public class Analista extends Empleado{



    public Analista(int numeroempleado, String nombre, LocalDate fechaAlta, double salario, Departamento departamento) {
        super(numeroempleado, nombre, fechaAlta, salario, departamento);

    }

    @Override
    public String toString() {
        return  "Analista" + super.toString() + "]";
    }
    public void presentarse() {
        System.out.println("Analista presentandose");
    }
    public  double calcularSalario() {
        return getSalario()*14;
    }

}
