import java.time.LocalDate;
public class Directivo extends Empleado {

    int comision;

    public Directivo(int numeroempleado, String nombre, LocalDate fechaAlta, double salario, Departamento departamento,
                     int comision) {
        super(numeroempleado, nombre, fechaAlta, salario, departamento);
        this.comision=comision;

    }

    @Override
    public String toString() {
        return "\tDirectivo Comision=" + comision + ", " + super.toString() + "";
    }

    public void presentarse() {
        System.out.println("Directivo presentandose");
    }
    public  double calcularSalario() {
        return getSalario()*14 + comision;
    }

    public int getComision() {
        return comision;
    }

    public void setComision(int comision) {
        this.comision = comision;
    }
}
