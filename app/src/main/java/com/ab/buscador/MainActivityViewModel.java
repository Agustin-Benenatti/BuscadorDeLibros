package com.ab.buscador;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ab.buscador.modelos.Libro;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private MutableLiveData <List<Libro>> listaMutable = null;
    private MutableLiveData<String> mensajeError = new MutableLiveData<>();

    private ArrayList<Libro> lista = new ArrayList<>();
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData <List<Libro>> getListaMutable(){
        if(listaMutable ==null){
            listaMutable = new MutableLiveData<>();
        }
        return listaMutable;
    }

    public LiveData<String> MensajeError(){
        return mensajeError;
    }

    //Metodo que carga los libros, en este caso cargue 4 libros por defecto..
    public void cargarLibro(){
        lista.add(new Libro("Martin Fierro","José Hernández",1872,"Narra la trágica vida de un gaucho perseguido. Martín Fierro pierde su hogar y familia al ser reclutado a la fuerza para defender la frontera, convirtiéndose en un desertor que denuncia las injusticias sociales, la pobreza y la pérdida de libertad frente al estado.",R.drawable.martinfierro));
        lista.add(new Libro("Caidos del Mapa","María Inés Falconi",1995," Narra la aventura de cuatro estudiantes de 7mo grado (Federico, Graciela, Paula y Fabián) que planean escaparse de la clase de Geografía para esconderse en el sótano de la escuela. El plan se complica cuando Miriam, una compañera conflictiva, descubre el escondite, generando situaciones divertidas y conflictos adolescentes.",R.drawable.caidosdelmapa));
        lista.add(new Libro("Juego de Tronos","George R. R. Martin",1996,"Juego de Tronos, primer libro de la saga Canción de hielo y fuego de George R.R. Martin, narra la lucha de varias casas nobles por el control del Trono de Hierro en Poniente. Lord Eddard Stark se une a la corte de Robert Baratheon, envuelto en traiciones mortales, mientras la magia ancestral regresa y el invierno se acerca.",R.drawable.juegodetronos));
        lista.add(new Libro("El Hobbit", "J.R.R Tolkien", 1937, "El Hobbit de J.R.R. Tolkien narra el viaje de Bilbo Bolsón, un hobbit cómodo y hogareño, quien es reclutado por el mago Gandalf y trece enanos, liderados por Thorin Escudo de Roble. Su objetivo es recuperar un tesoro robado por el dragón Smaug en la Montaña Solitaria. Durante la aventura, Bilbo encuentra un anillo mágico.", R.drawable.elhobbit));



    }

    //Metodo para buscar un libro, si el etBuscador esta null o vacio nos aparece el mensaje de error
    //de lo contrario recorre la lista y si el libro esta en la lista lo muestra, sino esta muestra otro mensaje
    public void buscarLibro(String texto){
       if(texto == null|| texto.isEmpty()){
           mensajeError.setValue("Ingrese un título para buscar..");
           return;
       }

       List<Libro> listaFiltrada = new ArrayList<>();
       for (Libro libro :lista){
           if(libro.getTitulo().toLowerCase().contains(texto.toLowerCase())){
               listaFiltrada.add(libro);
           }
       }
       if(listaFiltrada.isEmpty()){
           mensajeError.setValue("No se encontro ningun libro con ese título.");
       }
       listaMutable.setValue(listaFiltrada);
    }

}