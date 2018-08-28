package com.example.admin.epr1;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText eva1, eva2, eva3, eva4, epr1, epr2, epe1, epe2,  promedio, notapresentacion;
    Button calcular;
    TextView mensajeEximido, mensajePresentacion, mensajeNecesitada ,mensajeNecesitada2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcular = (Button) findViewById(R.id.calcular);
        eva1 = (EditText) findViewById(R.id.eva1);
        eva1.setFilters(new InputFilter[]{new InputFilterMinMax("1.0", "7.0"), new InputFilter.LengthFilter(3)});
        eva2 = (EditText) findViewById(R.id.eva2);
        eva2.setFilters(new InputFilter[]{new InputFilterMinMax("1.0", "7.0"), new InputFilter.LengthFilter(3)});
        eva3 = (EditText) findViewById(R.id.eva3);
        eva3.setFilters(new InputFilter[]{new InputFilterMinMax("1.0", "7.0"), new InputFilter.LengthFilter(3)});
        eva4 = (EditText) findViewById(R.id.eva4);
        eva4.setFilters(new InputFilter[]{new InputFilterMinMax("1.0", "7.0"), new InputFilter.LengthFilter(3)});
        epr1 = (EditText) findViewById(R.id.epr1);
        epr1.setFilters(new InputFilter[]{new InputFilterMinMax("1.0", "7.0"), new InputFilter.LengthFilter(3)});
        epe1 = (EditText) findViewById(R.id.epe1);
        epe1.setFilters(new InputFilter[]{new InputFilterMinMax("1.0", "7.0"), new InputFilter.LengthFilter(3)});
        epr2 = (EditText) findViewById(R.id.epr2);
        epr2.setFilters(new InputFilter[]{new InputFilterMinMax("1.0", "7.0"), new InputFilter.LengthFilter(3)});
        epe2 = (EditText) findViewById(R.id.epe2);
        epe2.setFilters(new InputFilter[]{new InputFilterMinMax("1.0", "7.0"), new InputFilter.LengthFilter(3)});
        notapresentacion = (EditText) findViewById(R.id.notapresentacion);
        promedio = (EditText) findViewById(R.id.promedio);
        mensajeEximido = (TextView) findViewById(R.id.mensajeEximido);
        mensajePresentacion = (TextView) findViewById(R.id.mensajePresentacion);
        mensajeNecesitada = (TextView) findViewById(R.id.mensajeNecesitada);
        mensajeNecesitada2 = (TextView) findViewById(R.id.mensajeNecesitada2);


    }

    public void Limpiar(View v){

        eva1.setText("");
        eva1.invalidate();
        eva2.setText("");
        eva2.invalidate();
        eva3.setText("");
        eva3.invalidate();
        eva4.setText("");
        eva4.invalidate();
        epr1.setText("");
        epr1.invalidate();
        epe1.setText("");
        epe1.invalidate();
        epr2.setText("");
        epr2.invalidate();
        epe2.setText("");
        epe2.invalidate();
        notapresentacion.setText("");
        notapresentacion.invalidate();
        promedio.setText("");
        promedio.invalidate();
        mensajeEximido.setText("");
        mensajeEximido.invalidate();
        mensajePresentacion.setText("");
        mensajePresentacion.invalidate();
        mensajeNecesitada.setText("");
        mensajeNecesitada.invalidate();
        mensajeNecesitada2.setText("");
        mensajeNecesitada2.invalidate();



    }

    public class InputFilterMinMax implements InputFilter {
        private double min, max;

        public InputFilterMinMax(double min, double max) {
            this.min = min;
            this.max = max;
        }

        public InputFilterMinMax(String min, String max) {
            this.min = Double.parseDouble(min);
            this.max = Double.parseDouble(max);
        }

        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            try {
                Double input = Double.parseDouble(dest.toString() + source.toString());
                if (isInRange(min, max, input))
                    return null;
            } catch (NumberFormatException nfe) { }
            return "";
        }

        private boolean isInRange(double a, double b, double c) {
            return b > a ? c >= a && c <= b : c >= b && c <= a;
        }
    }


    public void CalcularPromedio(View v) {
        double eva_1 = Double.parseDouble(eva1.getText().toString());
        double eva_2 = Double.parseDouble(eva2.getText().toString());
        double eva_3 = Double.parseDouble(eva3.getText().toString());
        double eva_4 = Double.parseDouble(eva4.getText().toString());
        double epr_1 = Double.parseDouble(epr1.getText().toString());
        double epr_2 = Double.parseDouble(epr2.getText().toString());
        double epe_2 = Double.parseDouble(epe2.getText().toString());
        double epe_1 = Double.parseDouble(epe1.getText().toString());




        //Calculo de notas solemnes
        double notaEPR1 = epr_1 * 0.10;
        double notaEPR2 = epr_2 * 0.15;
        double notaEPE1 = epe_1 * 0.20;
        double notaEPE2 = epe_2 * 0.25;

        //calculo de promedio de notas de controles
        double promedioEVA = (((eva_1 + eva_2 + eva_3 + eva_4)/4) * 0.30);

        //calculo de promedio
        double PromedioFinal = (notaEPR1 + notaEPR2 + notaEPE1 + notaEPE2 + promedioEVA);

        promedio.setText("" + Math.floor(PromedioFinal));


        //validacion
        if (PromedioFinal >= 5.5 && epe_1 >= 4.0 && epe_2 >= 4.0 && epr_1 >= 4.0 && epr_2 >= 4.0) {
            mensajeEximido.setText("¡Felicidades! Estas Eximido/a");
            notapresentacion.setText("" + Math.floor(PromedioFinal));
        }
        else {
            //validacion presentacion
            double presentacion = (PromedioFinal * 0.70);
            notapresentacion.setText("Te presentas a examen con un: " + Math.floor(presentacion));

            //validacion nota necesitada
            double nota1 = (PromedioFinal * 0.70);
            double nota2 = (4 - nota1);
            double notanecesitada = (nota2 / 0.30);
            mensajeNecesitada.setText("Necesitas un " + Math.floor(notanecesitada) + " para aprobar la asignatura" );

                if(presentacion < 2.7){
                    mensajeNecesitada2.setText("Lamentablemente tus notas no alcanzan para aprobar la asignatura, aun rindiendo examen." );
                }


           // if (promedioEVA <= 4.0){
           //     Toast.makeText(getApplicationContext(), "El promedio de las evaluaciones acumulativas (EVAs) es inferior a 4.0, debe rendir examen", Toast.LENGTH_LONG).show();

           // }
            if (epe_1<= 4.0 || epe_2 <= 4.0 || epr_1 <= 4.0 || epr_2 <= 4.0){
                Toast.makeText(getApplicationContext(), "Una/s de sus evaluaciones solemnes es inferior a 4.0, debe rendir examen", Toast.LENGTH_LONG).show();

            }

        }



    }

}

