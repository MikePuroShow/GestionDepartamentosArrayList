import java.util.ArrayList;

public class Departamento {
	int dept_no;
	String dnombre;
	String localizacion;
	ArrayList empleados = new ArrayList();
	
	public Departamento(int dept_no, String dnombre, String localizacion) {
		this.dept_no = dept_no;
		this.dnombre = dnombre;
		this.localizacion = localizacion;
	}

	public int getDept_no() {
		return dept_no;
	}

	public void setDept_no(int dept_no) {
		this.dept_no = dept_no;
	}

	public String getDnombre() {
		return dnombre;
	}

	public void setDnombre(String dnombre) {
		this.dnombre = dnombre;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	@Override
	public String toString() {
		return "Departamento [dept_no=" + dept_no + ", dnombre=" + dnombre + ", localizacion=" + localizacion + "]";
	}

	
}
