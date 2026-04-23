package com.ab.buscador;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ab.buscador.databinding.ActivityDetalleBinding;
import com.ab.buscador.modelos.Libro;

public class DetalleActivity extends AppCompatActivity {

    private ActivityDetalleBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDetalleBinding.inflate(getLayoutInflater()); // inicializamos el binding inflando el layout
        setContentView(binding.getRoot());

        Libro libro = (Libro) getIntent().getSerializableExtra("Libro"); //recuperamos el libro que se envia desde el adapter mediante el intent

            //Cargamos los datos del libro..
            binding.tvDetalleTitulo.setText(libro.getTitulo());
            binding.tvDetalleAutor.setText("Autor: "+libro.getAutor());
            binding.tvDetalleAnio.setText("Año: " + libro.getAnio());
            binding.tvDetalleDescripcion.setText(libro.getDescripcion());
            binding.ivDetalleFoto.setImageResource(libro.getFoto());


        binding.btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); //cierra la activity actual para volver a la anterior
            }
        });

    }
}