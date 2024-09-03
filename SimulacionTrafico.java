import java.util.Scanner;

public class SimulacionTrafico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Entrada de velocidades
            System.out.println("Ingrese la velocidad del carro 1:");
            int v1 = Integer.parseInt(scanner.nextLine());

            System.out.println("Ingrese la velocidad del carro 2:");
            int v2 = Integer.parseInt(scanner.nextLine());

            System.out.println("Ingrese la velocidad del carro 3:");
            int v3 = Integer.parseInt(scanner.nextLine());

            // Creación de vehículos
            Vehiculo carro1 = new Vehiculo("Carro 1", v1);
            Vehiculo carro2 = new Vehiculo("Carro 2", v2);
            Vehiculo carro3 = new Vehiculo("Carro 3", v3);

            // Imprimir el estado inicial de cada hilo antes de iniciarlo
            System.out.println(carro1.getName() + " estado inicial: " + carro1.getState());
            System.out.println(carro2.getName() + " estado inicial: " + carro2.getState());
            System.out.println(carro3.getName() + " estado inicial: " + carro3.getState());

            // Iniciar los hilos
            carro1.start();
            carro2.start();
            carro3.start();

            // Monitorear el estado de los hilos mientras están en ejecución
            while (carro1.isAlive() || carro2.isAlive() || carro3.isAlive()) {
                System.out.println(carro1.getName() + " estado actual: " + carro1.getState());
                System.out.println(carro2.getName() + " estado actual: " + carro2.getState());
                System.out.println(carro3.getName() + " estado actual: " + carro3.getState());
                try {
                    Thread.sleep(500); // Pausa para evitar demasiadas impresiones en consola
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Imprimir el estado final de cada hilo después de que hayan terminado
            System.out.println(carro1.getName() + " estado final: " + carro1.getState());
            System.out.println(carro2.getName() + " estado final: " + carro2.getState());
            System.out.println(carro3.getName() + " estado final: " + carro3.getState());

        } catch (NumberFormatException e) {
            System.out.println("No son caracteres numéricos, por favor ingrese números válidos.");
        } finally {
            scanner.close();
        }
    }
}