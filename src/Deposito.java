public class Deposito {
    int capacidadActual = 0;
    int capacidadMaxima = 5;

    public synchronized void depositar(){
        while (capacidadActual == capacidadMaxima){
            System.out.println("El depósito está lleno.");
        }
        capacidadActual ++;
        System.out.println("Cafetera deposita café en depósito.");
    }
}
