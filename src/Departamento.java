import java.time.LocalDate;
import java.util.ArrayList;

public class Departamento {
	int dept_no;
	String dnombre;
	String localizacion;
	ArrayList <Empleado> empleados = new ArrayList<Empleado>();


	public Departamento(int dept_no, String dnombre, String localizacion) {
		this.dept_no = dept_no;
		this.dnombre = dnombre;
		this.localizacion = localizacion;
		//this.empleados.add(new Analista(33,"Merde", LocalDate.of(2002,2,2),200,this));
		//this.empleados.add(new Analista(34,"Nuria", LocalDate.of(2002,2,2),200,this));
		//this.empleados.add(new Directivo(35,"Clara", LocalDate.of(2002,2,2),200,this,200));
	}

	public Departamento(int dept_no, String dnombre, String localizacion, ArrayList empleados) {
		this.dept_no = dept_no;
		this.dnombre = dnombre;
		this.localizacion = localizacion;
		this.empleados = empleados;
	}

	public int getDept_no() {
		return this.dept_no;
	}

	public void setDept_no(int dept_no) {
		this.dept_no = dept_no;
	}

	public String getDnombre() {
		return this.dnombre;
	}

	public void setDnombre(String dnombre) {
		this.dnombre = dnombre;
	}

	public String getLocalizacion() {
		return this.localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados = empleados;
	}

	@Override
	public String toString() {
		return "Departamento{" +
				"dept_no=" + dept_no +
				", dnombre='" + dnombre + '\'' +
				", localizacion='" + localizacion + '\'' +
				", empleados=" + empleados +
				'}';
	}
}
