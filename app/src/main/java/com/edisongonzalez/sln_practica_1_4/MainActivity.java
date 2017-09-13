package com.edisongonzalez.sln_practica_1_4;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //--------- Creamos los objetos y variables ----------------
    private Spinner sSpinner1, sSpinner2, sSpinner3, sSpinnerTol; //Objeto Tipo Spinner
    private String colorTol; //n1s, n2s, color1, color2, color3 - //Variables tipo String
    private int n1, n2, np;
    private Button bcalc;
    private TextView tres, tf1, tf2, tf3, tf4;

    /*Como hemos dicho antes, es el primer método que se llama cuando se crea una actividad, y es el lugar donde llamar
     a setContentView. Como ya te habrás podido imaginar, no es un buen sitio para poner cosas que vayan a cambiar cuando
      la aplicación esté dormida*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*setContentView, Este método solo se puede llamar desde onCreate, y además es un campo immutable. Solo se puede fijar
         la vista de la actividad una sola vez. Es la forma que tiene Android de obligarnos a tener una única vista por actividad.*/

        //----------- Permite encontrar el arreglo y asociarlo a su id ---------------
        sSpinner1 = (Spinner) findViewById(R.id.spinner1_strings_array);
        sSpinner2 = (Spinner) findViewById(R.id.spinner2_strings_array);
        sSpinner3 = (Spinner) findViewById(R.id.spinner3_strings_array);
        sSpinnerTol = (Spinner) findViewById(R.id.spinner_tol_strings_array);
        bcalc = (Button) findViewById(R.id.button_calc);
        tres = (TextView) findViewById(R.id.text_res);
        tf1 = (TextView) findViewById(R.id.id_t_fr1);
        tf2 = (TextView) findViewById(R.id.id_t_fr2);
        tf3 = (TextView) findViewById(R.id.id_t_fr3);
        tf4 = (TextView) findViewById(R.id.id_t_fr4);

        //--------------------------------------------------------------------
        //Especificar el diseño para usar cuando aparezca la lista de opciones
        final ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.spinner1y2_strings_array, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.spinner3_strings_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.spinner_tol_strings_array, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Aplicar el adaptador (adapter) al spinner (La ruleta)
        sSpinner1.setAdapter(adapter1);
        sSpinner2.setAdapter(adapter1);
        sSpinner3.setAdapter(adapter2);
        sSpinnerTol.setAdapter(adapter3);

        //--------------------------------------------------------------------
        //establecido en artículo seleccionado oyente, guardando lo elegido de los Spinners en los Strings
        sSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            //Nota las dos funciones internas (onItemSelected y onNothingSelected) se crean solas al ejecutar la linea anterior
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //adapterView recibe el adaptar, el view, la posicion
                //color1 = adapterView.getItemAtPosition(i).toString();
                n1 = i;
                //n1s = String.valueOf(i);
                //Tambien se puede: n1s = Integer.toString(i);
                switch(n1){
                    case 0:
                        tf1.setBackgroundColor(Color.argb(255, 0, 0, 0)); //Negro
                        break;
                    //tf1.setBackgroundColor(getColorStateList(R.color.chocolate));
                    //tf1.setBackgroundColor(getResources(R.color.azure));
                    //tf1.setBackground(getResources(R.color.aliceblue));
                    //Para ver las paletas de colores RGB se puede visitar: https://www.cerotec.net/tabla-colores-web/
                    case 1:
                        tf1.setBackgroundColor(Color.argb(255, 139, 69, 19)); //Marrón Silla
                        break;
                    case 2:
                        tf1.setBackgroundColor(Color.argb(255, 255, 0, 0)); //Rojo Puro
                        break;
                    case 3:
                        tf1.setBackgroundColor(Color.argb(255, 255, 165, 0)); //Naranja Puro
                        break;
                    case 4:
                        tf1.setBackgroundColor(Color.argb(255, 255, 255, 0)); //Amarillo Puro
                        break;
                    case 5:
                        tf1.setBackgroundColor(Color.argb(255, 0, 128, 0)); //Verde
                        break;
                    case 6:
                        tf1.setBackgroundColor(Color.argb(255, 0, 0, 205)); //Azul medio
                        break;
                    case 7:
                        tf1.setBackgroundColor(Color.argb(255, 148, 0, 211)); //Violeta Oscuro
                        break;
                    case 8:
                        tf1.setBackgroundColor(Color.argb(255, 128, 128, 128)); //Gris
                        break;
                    case 9:
                        tf1.setBackgroundColor(Color.argb(255, 248, 248, 255)); //Blanco Fantasma
                        break;
                    default:
                        tf1.setBackgroundColor(Color.argb(255, 0, 0, 0)); //Por defecto negro
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        sSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            //Nota las dos funciones internas (onItemSelected y onNothingSelected) se crean solas al ejecutar la linea anterior
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //adapterView recibe el adaptar, el view, la posicion
                //color2 = adapterView.getItemAtPosition(i).toString();
                n2 = i;
                //n2s = String.valueOf(i);
                switch(n2){
                    case 0:
                        tf2.setBackgroundColor(Color.argb(255, 0, 0, 0)); //Negro
                        break;
                    case 1:
                        tf2.setBackgroundColor(Color.argb(255, 139, 69, 19)); //Marrón Silla
                        break;
                    case 2:
                        tf2.setBackgroundColor(Color.argb(255, 255, 0, 0)); //Rojo Puro
                        break;
                    case 3:
                        tf2.setBackgroundColor(Color.argb(255, 255, 165, 0)); //Naranja Puro
                        break;
                    case 4:
                        tf2.setBackgroundColor(Color.argb(255, 255, 255, 0)); //Amarillo Puro
                        break;
                    case 5:
                        tf2.setBackgroundColor(Color.argb(255, 0, 128, 0)); //Verde
                        break;
                    case 6:
                        tf2.setBackgroundColor(Color.argb(255, 0, 0, 205)); //Azul medio
                        break;
                    case 7:
                        tf2.setBackgroundColor(Color.argb(255, 148, 0, 211)); //Violeta Oscuro
                        break;
                    case 8:
                        tf2.setBackgroundColor(Color.argb(255, 128, 128, 128)); //Gris
                        break;
                    case 9:
                        tf2.setBackgroundColor(Color.argb(255, 248, 248, 255)); //Blanco Fantasma
                        break;
                    default:
                        tf2.setBackgroundColor(Color.argb(255, 0, 0, 0)); //Por defecto negro
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        sSpinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            //Nota las dos funciones internas (onItemSelected y onNothingSelected) se crean solas al ejecutar la linea anterior
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //adapterView recibe el adaptar, el view, la posicion
                //color3 = adapterView.getItemAtPosition(i).toString();
                np = i;
                switch(np){
                    case 0:
                        tf3.setBackgroundColor(Color.argb(255, 0, 0, 0)); //Negro
                        break;
                    case 1:
                        tf3.setBackgroundColor(Color.argb(255, 139, 69, 19)); //Marrón Silla
                        break;
                    case 2:
                        tf3.setBackgroundColor(Color.argb(255, 255, 0, 0)); //Rojo Puro
                        break;
                    case 3:
                        tf3.setBackgroundColor(Color.argb(255, 255, 165, 0)); //Naranja Puro
                        break;
                    case 4:
                        tf3.setBackgroundColor(Color.argb(255, 255, 255, 0)); //Amarillo Puro
                        break;
                    case 5:
                        tf3.setBackgroundColor(Color.argb(255, 0, 128, 0)); //Verde
                        break;
                    case 6:
                        tf3.setBackgroundColor(Color.argb(255, 0, 0, 205)); //Azul medio
                        break;
                    case 7:
                        tf3.setBackgroundColor(Color.argb(255, 148, 0, 211)); //Violeta Oscuro
                        break;
                    case 8:
                        tf3.setBackgroundColor(Color.argb(255, 128, 128, 128)); //Gris
                        break;
                    case 9:
                        tf3.setBackgroundColor(Color.argb(255, 248, 248, 255)); //Blanco Fantasma
                        break;
                    case 10:
                        tf3.setBackgroundColor(Color.argb(255, 255, 215, 0)); //Amarillo Oro
                        break;
                    case 11:
                        tf3.setBackgroundColor(Color.argb(255, 192, 192, 192)); //Gris Plata
                        break;
                    default:
                        tf3.setBackgroundColor(Color.argb(255, 0, 0, 0)); //Por defecto negro
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        sSpinnerTol.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            //Nota las dos funciones internas (onItemSelected y onNothingSelected) se crean solas al ejecutar la linea anterior
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //adapterView recibe el adaptar, el view, la posicion
                colorTol = adapterView.getItemAtPosition(i).toString();
                switch(i){
                    case 0:
                        tf4.setBackgroundColor(Color.argb(255, 139, 69, 19)); //Marrón Silla
                        break;
                    case 1:
                        tf4.setBackgroundColor(Color.argb(255, 255, 0, 0)); //Rojo Puro
                        break;
                    case 2:
                        tf4.setBackgroundColor(Color.argb(255, 0, 128, 0)); //Verde
                        break;
                    case 3:
                        tf4.setBackgroundColor(Color.argb(255, 255, 215, 0)); //Amarillo Oro
                        break;
                    case 4:
                        tf4.setBackgroundColor(Color.argb(255, 192, 192, 192)); //Gris Plata
                        break;
                    default:
                        tf4.setBackgroundColor(Color.argb(255, 0, 0, 0)); //Por defecto negro
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        //.set... y adentro new luego ctrl + esp y escogemos onClickListener
        //Que se hace cuando se apreta el boton
        bcalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Clasificando según el color
                switch (np) {
                    case 0:
                        if (n1 == 0) {
                            if (n2 == 0) {
                                tres.setText("El valor de su resistencia es 0Ω" + " Con Tolerancia: " + colorTol);
                            } else {
                                tres.setText("El valor de su resistencia es: " + n2 + "Ω" + " Con Tolerancia: " + colorTol);
                            }
                        } else {
                            tres.setText("El valor de su resistencia es: " + n1 + n2 + "Ω" + " Con Tolerancia: " + colorTol);
                        }
                        break;
                    case 1:
                        if (n1 == 0) {
                            if (n2 == 0) {
                                tres.setText("El valor de su resistencia es 0Ω" + " Con Tolerancia: " + colorTol);
                            } else {
                                tres.setText("El valor de su resistencia es: " + n2 + "0Ω" + " Con Tolerancia: " + colorTol);
                            }
                        } else {
                            tres.setText("El valor de su resistencia es: " + n1 + n2 + "0Ω" + " Con Tolerancia: " + colorTol);
                        }
                        break;
                    case 2:
                        if (n1 == 0) {
                            if (n2 == 0) {
                                tres.setText("El valor de su resistencia es 0Ω" + " Con Tolerancia: " + colorTol);
                            } else {
                                tres.setText("El valor de su resistencia es: " + n2 + "00Ω" + " Con Tolerancia: " + colorTol);
                            }
                        } else {
                            tres.setText("El valor de su resistencia es: " + n1 + "." + n2 + "KΩ" + " Con Tolerancia: " + colorTol);
                        }
                        break;
                    case 3:
                        if (n1 == 0) {
                            if (n2 == 0) {
                                tres.setText("El valor de su resistencia es 0Ω" + " Con Tolerancia: " + colorTol);
                            } else {
                                tres.setText("El valor de su resistencia es: " + n2 + "KΩ" + " Con Tolerancia: " + colorTol);
                            }
                        } else {
                            tres.setText("El valor de su resistencia es: " + n1 + n2 + "KΩ" + " Con Tolerancia: " + colorTol);
                        }
                        break;
                    case 4:
                        if (n1 == 0) {
                            if (n2 == 0) {
                                tres.setText("El valor de su resistencia es 0Ω" + " Con Tolerancia: " + colorTol);
                            } else {
                                tres.setText("El valor de su resistencia es: " + n2 + "0KΩ" + " Con Tolerancia: " + colorTol);
                            }
                        } else {
                            tres.setText("El valor de su resistencia es: " + n1 + n2 + "0KΩ" + " Con Tolerancia: " + colorTol);
                        }
                        break;
                    case 5:
                        if (n1 == 0) {
                            if (n2 == 0) {
                                tres.setText("El valor de su resistencia es 0Ω" + " Con Tolerancia: " + colorTol);
                            } else {
                                tres.setText("El valor de su resistencia es: " + n2 + "00KΩ" + " Con Tolerancia: " + colorTol);
                            }
                        } else {
                            tres.setText("El valor de su resistencia es: " + n1 + "." + n2 + "MΩ" + " Con Tolerancia: " + colorTol);
                        }
                        break;
                    case 6:
                        if (n1 == 0) {
                            if (n2 == 0) {
                                tres.setText("El valor de su resistencia es 0Ω" + " Con Tolerancia: " + colorTol);
                            } else {
                                tres.setText("El valor de su resistencia es: " + n2 + "MΩ" + " Con Tolerancia: " + colorTol);
                            }
                        } else {
                            tres.setText("El valor de su resistencia es: " + n1 + n2 + "MΩ" + " Con Tolerancia: " + colorTol);
                        }
                        break;
                    case 7:
                        if (n1 == 0) {
                            if (n2 == 0) {
                                tres.setText("El valor de su resistencia es 0Ω" + " Con Tolerancia: " + colorTol);
                            } else {
                                tres.setText("El valor de su resistencia es: " + n2 + "0MΩ" + " Con Tolerancia: " + colorTol);
                            }
                        } else {
                            tres.setText("El valor de su resistencia es: " + n1 + n2 + "0MΩ" + " Con Tolerancia: " + colorTol);
                        }
                        break;
                    case 8:
                        if (n1 == 0) {
                            if (n2 == 0) {
                                tres.setText("El valor de su resistencia es 0Ω" + " Con Tolerancia: " + colorTol);
                            } else {
                                tres.setText("El valor de su resistencia es: " + n2 + "00MΩ" + " Con Tolerancia: " + colorTol);
                            }
                        } else {
                            tres.setText("El valor de su resistencia es: " + n1 + "." + n2 + "GΩ" + " Con Tolerancia: " + colorTol);
                        }
                        break;
                    case 9:
                        if (n1 == 0) {
                            if (n2 == 0) {
                                tres.setText("El valor de su resistencia es 0Ω" + " Con Tolerancia: " + colorTol);
                            } else {
                                tres.setText("El valor de su resistencia es: " + n2 + "GΩ" + " Con Tolerancia: " + colorTol);
                            }
                        } else {
                            tres.setText("El valor de su resistencia es: " + n1 + n2 + "GΩ" + " Con Tolerancia: " + colorTol);
                        }
                        break;
                    case 10:
                        if (n1 == 0) {
                            if (n2 == 0) {
                                tres.setText("El valor de su resistencia es 0Ω" + " Con Tolerancia: " + colorTol);
                            } else {
                                tres.setText("El valor de su resistencia es: " + n2 + "dΩ" + " Con Tolerancia: " + colorTol);
                            }
                        } else {
                            tres.setText("El valor de su resistencia es: " + n1 + n2 + "dΩ" + " Con Tolerancia: " + colorTol);
                        }
                        break;
                    case 11:
                        if (n1 == 0) {
                            if (n2 == 0) {
                                tres.setText("El valor de su resistencia es 0Ω" + " Con Tolerancia: " + colorTol);
                            } else {
                                tres.setText("El valor de su resistencia es: " + n2 + "cΩ" + " Con Tolerancia: " + colorTol);
                            }
                        } else {
                            tres.setText("El valor de su resistencia es: " + n1 + n2 + "cΩ" + " Con Tolerancia: " + colorTol);
                        }
                        break;
                    default:
                        tres.setText("El valor de su resistencia es: 0Ω" + " Con Tolerancia: " + colorTol);
                        break;
                }
            }
        });
    }
}