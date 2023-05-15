package com.unsa;

public class Cajera {
    private String nombre;
    public Cajera() {
    }
    public Cajera(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void procesarCompra(Cliente cliente, long timeStamp) {
        System.out.println("La Cajera '" + this.nombre +
            "' COMIENZA A PROCESAR LA COMPRA DEL CLIENTE '" + cliente.getNombre() +
            "' EN EL TIEMPO: " + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
        for (int i = 0 ; i < cliente.getCarroCompra().length ; i++) {
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesado el Producto " + (i + 1) + " de " + cliente.getNombre()
                + "-> Tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
        }
        System.out.println("La Cajera '" + this.nombre + "' HA TERMINADO DE PROCESAR EL PEDIDO DEL CLIENTE '" +
            cliente.getNombre() + "' EN EL TIEMPO: " + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
    }
    private void esperarXsegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}