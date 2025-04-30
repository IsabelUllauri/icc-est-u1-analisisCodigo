import java.util.Arrays;
import java.util.Random;

public class Benchmarking {


    private MetodosOrdenamiento metodosOrdenamiento;

    public Benchmarking(){
        long inicioMillis = System.currentTimeMillis();//tiempo que ha pasado desde tiemporeferencial epoch
        long inicioNano = System.nanoTime();//tiempo que ha pasado desde que se inicio la compu
        System.out.println(inicioMillis);
        System.out.println(inicioNano);
        
        metodosOrdenamiento = new MetodosOrdenamiento();
        int [] arreglo = generarArregloAleatorio(1000000);
        Runnable tarea = () -> metodosOrdenamiento.insercionPrimero(arreglo);

        double tiempoNano = medirTiempoConNanoTime(tarea);
        double tiempoMilis = medirConCurrentTimeMillis(tarea);
        System.out.println("tiempo con nanoTime: " + tiempoNano+ "segundos");
        System.out.println("tiempo con CurrentTimeMilis: " + tiempoMilis+ "segundos");

    }

    private int [] generarArregloAleatorio(int tamano){
        int [] arreglo = new int [tamano];
        Random random = new Random();
        for (int i =0; i< i; i++){
            arreglo [i]= random.nextInt(10000);
        }        
        return arreglo; 
    }

    //sacar el tiempo de respuesta de un metodo

    //Tiempousado nanoTime(en segundos)
    public double medirTiempoConNanoTime(Runnable tarea){
        long inicio = System.nanoTime();
        tarea.run();
        long fin = System.nanoTime();
        return (fin-inicio)/1000000000.0;//dividio para mil millones
        
        
    }

    //tiempo usado currentTimeMillis (en segundos)
    public double medirConCurrentTimeMillis(Runnable tarea){
        long inicio= System.currentTimeMillis();
        tarea.run();
        long fin=System.currentTimeMillis();
        return (fin- inicio)/1000.0;// se divide para 1000 pq es milisiegindos
    }

    public int[] burbujaTradicional(int[] arregloOriginal) {
        int[] arreglo = Arrays.copyOf(arregloOriginal, arregloOriginal.length);

        int n = arreglo.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arreglo[i] > arreglo[j]) {
                    // Intercambio de elementos
                    int temp = arreglo[i];
                    arreglo[i] = arreglo[j];
                    arreglo[j] = temp;
                }
            }
        }
        return arreglo;
    }

    public int[] insercionSegundo(int[] arregloOriginal) {
        int[] arreglo = Arrays.copyOf(arregloOriginal, arregloOriginal.length);
        for (int i = 1; i < arreglo.length; i++) {
            int actual = arreglo[i];
            int j = i - 1;

            while (j >= 0 && arreglo[j] > actual) {
                arreglo[j + 1] = arreglo[j];
                j--;
            }
            arreglo[j + 1] = actual;
        }
        return arreglo;
    }

}
