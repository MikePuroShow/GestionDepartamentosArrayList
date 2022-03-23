public interface OperacionesDepartamento extends Operaciones  {

        void cargaAutomaticaConAgregacion();

        void cargaAutomaticaConComposicion();

        void mostrarDepartamentos();

        boolean departamentososVacio();

        boolean departamentosLLeno();

        int buscaHueco();

        int existeDepartamento(int num);

        int buscarDepartamento(String nombreDepartamento);
}
