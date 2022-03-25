public class buclesAnidados {
    static int[] animal = {1,2,3};
    static int animal1 [] = {5,6,7};


    public static void main(String[] args) {
        bucleAnidado();
    }

    private static void bucleAnidado() {
        for (int i=0; i<animal.length; i++){
            System.out.println(animal[i]);
            for (int j=0; j<animal1.length; j++ ){
                System.out.println(animal1[j]);
            }
        }
    }
    public static void arrayList(){

    }

}
