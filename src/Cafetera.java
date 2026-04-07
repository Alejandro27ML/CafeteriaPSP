public class Cafetera implements Runnable{
    private Deposito deposito;
    private final int totalCafe = 15;

    public Cafetera(Deposito deposito) {
        this.deposito = deposito;
    }

    @Override
    public void run() {
        try{
            for (int i = 0; i < totalCafe; i++){
                Thread.sleep((int)(500 + Math.random()*500));
                deposito.depositar();
            }
        }catch (InterruptedException e){
            System.out.println("El café de ha perdido.");
        }
    }
}
