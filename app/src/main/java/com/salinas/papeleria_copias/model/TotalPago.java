package com.salinas.papeleria_copias.model;

public class TotalPago {
    private int copias;
    public String cliente;

    public void setTipoPago(int tipoPago) {
        this.tipoPago = tipoPago;
    }

    public  int tipoPago;


    public void setCopias(int copias) {
        this.copias = copias;
    }

    public int getCopias() {
        return copias;
    }

    public String calcularTotal() {

        double total=0;

        if(copias<=50) {
            total = copias * 0.50;
        }else if(copias<=100) {
            total = (50*0.50) + ((copias - 50) * 0.40);
        }else{
            total = (50*0.50) + (50*0.40) + ((copias - 100) * 0.30);
        }
        //hacer una pequeña comision al uso de la targeta.
        if(tipoPago==3){
            total = total * 1.03;
        }
        return "Cliente: " + cliente +
                "\nNo. Copias: " + copias +
                "\nTotal a pagar: $" + total ;
    }
}
