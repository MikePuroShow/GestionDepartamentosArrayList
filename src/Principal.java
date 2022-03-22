import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class Principal {
	static ArrayList departamentos = new ArrayList();
	private static int numeroDepartamento;
	private static String nombreDepartamento;
	private static String localizacion;
	private static boolean salir1 = false;
	private static int numeroOpcion;

	public static void main(String[] args) throws IOException {

		//cargaAutomatica(); // 3 departamentos
		cargaInteractiva();
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
		while(!salir1) {
		try {
			System.out.println("Introduza el numero de departamento");
			 numeroDepartamento = Integer.parseInt(br1.readLine());
		} catch (NumberFormatException ee) {
			System.out.println("Introduce un número válido" + " " + ee);
		}
		try {
			System.out.println("Introduzca el nombre de departamento");
			 nombreDepartamento = br1.readLine();
		}catch(Exception e){
			System.out.println("Nombre inválido" +e);
		}
		try {
			System.out.println("Introduzca la localizacion");
			 localizacion = br1.readLine();
		}catch (Exception e) {
			System.out.println("Localizacion invalida" +" " +e);
		}
		departamentos.add(new Departamento(numeroDepartamento,nombreDepartamento,localizacion));
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
	/*public int borrarDepartamento(int numeroDep) {
		if (departamentos.contains(numeroDep)) {
			departamentos.contains(numeroDep)
		}
	}*/

}
