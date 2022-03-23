import java.time.LocalDate;

public abstract class Empleado {
	private int numeroempleado;
	private String nombre;
	private LocalDate fechaAlta;
	private double salario;
	public Departamento departamento;

	
	public Empleado(int numeroempleado, String nombre, LocalDate fechaAlta, double salario, Departamento departamento) {
		this.numeroempleado = numeroempleado;
		this.nombre = nombre;
		this.fechaAlta = fechaAlta;
		this.salario = salario;
		this.departamento = departamento;
	}

	public int getNumeroempleado() {
		return numeroempleado;
	}

	public void setNumeroempleado(int numeroempleado) {
		this.numeroempleado = numeroempleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	@Override
	public String toString() {
		return "Empleado [numeroempleado=" + numeroempleado + ", nombre=" + nombre + ", fechaAlta=" + fechaAlta
				+ ", salario=" + salario +"]";
	}


}
