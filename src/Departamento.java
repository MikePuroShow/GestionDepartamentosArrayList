public class Departamento {
        int dept_no;
        String dnombre;
        String localizacion;

        public Departamento(int dept_no, String dnombre, String localizacion) {
            this.dept_no = dept_no;
            this.dnombre = dnombre;
            this.localizacion = localizacion;
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

        public String toString() {
            return "Departamento [dept_no=" + this.dept_no + ", dnombre=" + this.dnombre + ", localizacion=" + this.localizacion + "]";
        }
}
