class Vehiculo extends Thread {
    private String nombre;
    private int posicion;
    private int velocidad;

    public Vehiculo(String nombre, int velocidad) {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.posicion = 0;
    }

    @Override
    public void run() {
        while (posicion < 100) { // La carretera tiene una longitud de 100 unidades
            posicion += velocidad;
            System.out.println(nombre + " esta en la posicion: " + posicion);
            try {
                Thread.sleep(500); // Pausa para simular tiempo real
            } catch (InterruptedException e) {
                System.out.println(nombre + " ha sido interrumpido.");
            }
        }
    }
}
