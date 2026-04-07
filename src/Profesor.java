public class Profesor implements Runnable{
    private String nombre;
    private int cafeAConsumir;
    private Deposito deposito;

    public Profesor(String nombre, Deposito deposito, int cafeAConsumir) {
        this.nombre = nombre;
        this.deposito = deposito;
        this.cafeAConsumir = cafeAConsumir;
    }

    @Override
    public void run() {
        try{
            for(int i = 0; i < cafeAConsumir; i++){
                deposito.retirar(nombre);
                Thread.sleep((int)(500 + Math.random() * 1000));
            }
        }catch (InterruptedException e){
            System.out.println("El profesor " + nombre + " ha sido interrumpido mientras retiraba su café.");
        }
    }
}
