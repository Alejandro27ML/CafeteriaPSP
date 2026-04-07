public class Main {
    public static void main(String[] args) {
        Deposito deposito = new Deposito();

        Thread cafetera = new Thread(new Cafetera(deposito));
        Thread p1 = new Thread(new Profesor("Luisa", deposito,8));
        Thread p2 = new Thread(new Profesor("José", deposito,3));
        Thread p3 = new Thread(new Profesor("Maria", deposito,4));

        cafetera.start();
        p1.start();
        p2.start();
        p3.start();

        try {
            cafetera.join();
            p1.join();
            p2.join();
            p3.join();
        } catch (InterruptedException e) {
            System.out.println("Se ha producido un error.");;
        }

        System.out.println("Todos los cafés han sido producidos y consumidos.");
    }
}