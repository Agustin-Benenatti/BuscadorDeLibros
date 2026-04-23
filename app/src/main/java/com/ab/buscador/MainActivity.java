package com.ab.buscador;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.ab.buscador.databinding.ActivityMainBinding;
import com.ab.buscador.modelos.Libro;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater()); // inicializamos el binding
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);//

        setContentView(binding.getRoot());

        //observer a la lista de libros
        vm.getListaMutable().observe(this, new Observer<List<Libro>>() {
            @Override
            public void onChanged(List<Libro> libros) {
                LibroAdapter la = new LibroAdapter(libros,MainActivity.this,getLayoutInflater());

                GridLayoutManager glm = new GridLayoutManager(MainActivity.this,1,GridLayoutManager.VERTICAL,false);

                //configura el RecyclerView
                binding.lista.setLayoutManager(glm);
                binding.lista.setAdapter(la);

            }
        });

        //Observa el mensaje de error en el viewModel
        vm.MensajeError().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();
            }
        });

        binding.btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = binding.etBuscador.getText().toString(); //obtiene el texto que se ingresa por el usuario
                vm.cargarLibro(); //carga los libros
                vm.buscarLibro(texto); //filtra y busca los libros segun lo ingresado por el usuario

            }
        });


    }
}