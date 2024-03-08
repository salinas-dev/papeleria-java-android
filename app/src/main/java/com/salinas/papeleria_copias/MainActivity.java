package com.salinas.papeleria_copias;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.salinas.papeleria_copias.model.TotalPago;

public class MainActivity extends AppCompatActivity {
    //Paso 1: Declarar los views a manipular.
    EditText txtCliente;
    EditText txtCantidad;
    Button btnCalcular;
    Button btnNuevo;
    Spinner cmbTipoPago;
    //Definimos los elementos del combo en un array
    String [] opcionesPago = {
            "-SELECCIONE METODO DE PAGO-",
            "Efectivo",
            "Vales de Despensa",
            "Targeta"
    };

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Paso 2: Inicializar los views con su ID del .xml
        //Se usa el metodo findViewById para inicializar.
        txtCliente = findViewById(R.id.EtCliente);
        txtCantidad = findViewById(R.id.EtCantidad);
        btnCalcular = findViewById(R.id.buttonCalcular);
        btnNuevo = findViewById(R.id.buttonNuevo);
        cmbTipoPago = findViewById(R.id.spTipoPago);

        ArrayAdapter<String> adapPagos = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item,opcionesPago);

        cmbTipoPago.setAdapter(adapPagos);


        //Paso 3: Crear evento clic para el boton calcular y boton nuevo.
        //Listener: escuchadores, metodos abstractos(OnCliclListener).
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //declarar variable tipo string
                String cliente;
                int cantidad;


                //Dato String: cliente.
                //Recibir el dato de los EditText.
                //(Objeto tipo editable).
                //Editable se quieta el error.
                //Pero lo necesitamos String.
                cliente = txtCliente.getText().toString();

                //Dato int: cantidad.
                //Parsear el dato int cantidad.
                //Se coloca el String, de string te lo pasa a un entero.
                //De un string lo comviertes a al tipo de dato.
                cantidad = Integer.parseInt(txtCantidad.getText().toString());

                //Comunicar con el TDA.
                //Nombre de mi clase "TotalPago".
                //Poner mi objeto "pago" e importarlo si esta en otra carpeta.
                //Cliente es publico, ya esta extrahido.
                //public String cliente;
                //copias no esta capsulado asi que se usa con el setCopias(private int copias).
                TotalPago pago= new TotalPago();
                pago.cliente = cliente;
                pago.setCopias(cantidad);
                //se pasa el set de la clase TipoPago.java y se extrae para el atributo pago
                pago.setTipoPago(cmbTipoPago.getSelectedItemPosition());

                //Imprimir mensaje emergente.
                //Clase(toas)
                //(makeText())
                //Contexto donde se va poner el mensaje(donde se ejecutara)
                //Error:Primer para metro pide contexto pide referencias no escrbir el context (es como una referencia)
                //Primero nuestro objeto y despues el recurso.
                //Recurso STRING calcular total en la clase TotalPago.
                //Tiempo de ejecucion Toas.LENGTH_LONG.
                //Mostrar .show()
                Toast.makeText(getApplicationContext(),
                        pago.calcularTotal(),
                        Toast.LENGTH_LONG ).show();


            }
        });


        Button buttonNuevo = findViewById(R.id.buttonNuevo);
        EditText txtCliente = findViewById(R.id.EtCliente);
        EditText txtCantidad = findViewById(R.id.EtCantidad);

        buttonNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Borrar el contenido de los campos de texto
                txtCliente.setText("");
                txtCantidad.setText("");

                // Aquí puedes agregar cualquier otro código que desees que se ejecute cuando se haga clic en el botón "Nuevo"
                Toast.makeText(getApplicationContext(), "¡Botón Nuevo clickeado!", Toast.LENGTH_SHORT).show();
            }
        });

    }



    public void salir(View v){
        finish();
    }
}