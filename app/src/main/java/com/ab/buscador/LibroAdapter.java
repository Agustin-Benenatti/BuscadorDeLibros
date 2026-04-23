package com.ab.buscador;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ab.buscador.databinding.ItemBinding;
import com.ab.buscador.modelos.Libro;

import java.util.List;

public class LibroAdapter extends RecyclerView.Adapter<LibroAdapter.viewHolderLibro> {
private List<Libro> listado;
private Context context;
private LayoutInflater li;
    public LibroAdapter(List<Libro> listado,Context context,LayoutInflater li){
        this.listado = listado;
        this.context = context;
        this.li = li;
    }


    @NonNull
    @Override
    public viewHolderLibro onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView =li.inflate(R.layout.item,parent,false); //infla el layout item.xml
        return new viewHolderLibro(itemView);//devolvemos un viewHolder con esa vista
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderLibro holder, int position) {

        Libro libroActual = listado.get(position); //obtenemos el libro correspondiente a la posicion actual..

        //seteamos los datos del libro a los componentes de la vista
        holder.titulo.setText("Titulo: "+libroActual.getTitulo());
        holder.autor.setText("Autor: "+libroActual.getAutor());
        holder.foto.setImageResource(libroActual.getFoto());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetalleActivity.class); //intent para ir a la vista detalle
                intent.putExtra("Libro",libroActual);
                context.startActivity(intent); //iniciamos la nueva activity
            }
        });

    }

    @Override
    public int getItemCount() {
        return listado.size();
    }

    public class viewHolderLibro extends RecyclerView.ViewHolder{
        //componentes del layout item.xml
        TextView titulo,autor;
        ImageView foto;

        public viewHolderLibro(@NonNull View itemView) {
            super(itemView);
            //vinculamos los elementos del xlm con el codigo
            titulo= itemView.findViewById(R.id.tvTitulo);
            autor = itemView.findViewById((R.id.tvAutor));
            foto = itemView.findViewById(R.id.foto);
        }
    }
}
