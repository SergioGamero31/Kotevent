package Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kotevent.R;

import java.util.ArrayList;

import Entidades.Servicio;

public class AdapterServicio extends RecyclerView.Adapter<AdapterServicio.ViewHolder> implements View.OnClickListener{

    ArrayList<Servicio> model;
    LayoutInflater inflater;

    //listener
    private View.OnClickListener listener;

    public AdapterServicio(Context context, ArrayList<Servicio> model){
        this.inflater = LayoutInflater.from(context);
        this.model = model;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.lista_servicios, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }
    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String nombre = model.get(position).getNombre();
        String desc = model.get(position).getDescrip();
        int imagen = model.get(position).getImagenId();
        holder.nombres.setText(nombre);
        holder.descripcion.setText(desc);
        holder.imagen.setImageResource(imagen);
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nombres, descripcion;
        ImageView imagen;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombres = itemView.findViewById(R.id.progra);
            descripcion = itemView.findViewById(R.id.progrades);
            imagen = itemView.findViewById(R.id.imagen_serv);
        }


    }
}
