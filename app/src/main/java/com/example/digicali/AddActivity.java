package com.example.digicali;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText nombreEvento, ubicacionEvento, descripcion;
    private Button agregar, salir;
    int dia=0, mes=0, anio=0;
    String NombreEven="Sin datos", Ubicacion="Sin datos", Descripcion="Sin datos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        nombreEvento = (EditText) findViewById(R.id.NombreEvento);
        ubicacionEvento = (EditText) findViewById(R.id.UbicacionEvento);
        descripcion = (EditText) findViewById(R.id.Descripcion);

        Bundle bundle = getIntent().getExtras();
        dia = bundle.getInt("dia");
        mes = bundle.getInt("mes");
        anio = bundle.getInt("anio");

        agregar = (Button) findViewById(R.id.Guardar);
        salir = (Button) findViewById(R.id.Salir);

        agregar.setOnClickListener(this);
        salir.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==agregar.getId()){
            //Guarrdar datos de los datos
            BDSQLite bd = new BDSQLite(getApplication(), "Agenda", null, 1);
            SQLiteDatabase db = bd.getWritableDatabase();

            String sql = "insert into eventos" +
                    "(nombreEvento, ubicacion, descripcion, dia, mes, year)" +
                    "values('" +
                    NombreEven+
                    "','" + Ubicacion +
                    "','" + Descripcion +
                    "','" + dia +
                    "','" + mes +
                    "','" + anio + "')";
            try {
                db.execSQL(sql);

                nombreEvento.setText("");
                ubicacionEvento.setText("");
                descripcion.setText("");
            }catch (Exception e){
                Toast.makeText(getApplication(), "Error "+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } else{
            this.finish();
            return;
        }
    }
}