public class Deposito {
    private int contadorCafe = 1;
    private int cantidad = 0;
    private final int capacidad = 5;

    public synchronized void depositar(){
        String cafe = "Café-" + contadorCafe++;
        while (cantidad == capacidad){
            System.out.println("El depósito está lleno.");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("El café se ha perdido.");
            }
        }
        cantidad ++;
        System.out.println("Cafetera prepara y deposita " +  cafe + ". En depósito: " + cantidad + ".");
        notifyAll();
    }

    public synchronized void retirar(String profesor){
        while (cantidad == 0){
            System.out.println("Depósito vacio. Profesor " + profesor + " en espera.");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("El profesor " + profesor + " ha sido interrumpido mientras esperaba.");
            }
        }
        cantidad --;
        String cafe = "Café-" + (contadorCafe -1);
        System.out.println("Profesor " + profesor + " retira " + cafe + ". En depósito: " + cantidad + ".");
        notifyAll();
    }
}
