package Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kotevent.R;

import java.util.ArrayList;

import Adaptadores.AdapterServicio;
import Entidades.Servicio;

public class FragmentServicios extends Fragment {

    AdapterServicio adapterServicio;
    RecyclerView recyclerView;
    ArrayList<Servicio> listaServicios;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.servicios_fragment,container,false);
        recyclerView = view.findViewById(R.id.recycler);
        listaServicios = new ArrayList<>();
        //cargar lista
        cargarLista();
        //mostrar datos
        mostrarDatos();
        return view;
    }
    public void cargarLista(){
        listaServicios.add(new Servicio("Diseño Web","Creación, diseño e implementación de paginas web acorde a su empresa. Posicionamiento de sitio web.",R.drawable.ic_code));
        listaServicios.add(new Servicio("Programación","Análisis, diseño y desarrollo de aplicaciones desktop, web y móvil empresarial a medida.",R.drawable.ic_computer));
        listaServicios.add(new Servicio("Mensajeria","Servicio de SMS empresarial de alto desempeño envio de campañas SMS, alertas y codigos PIN todo por medio de un numero CORTO.",R.drawable.ic_email));
        listaServicios.add(new Servicio("Proyectos de Innovación","Tenemos un equipo innovador que esta presto a realizar proyectos de innovación para tu empresa.",R.drawable.ic_wb_incandescent));
        listaServicios.add(new Servicio("Personalización","Configuración y personalización de imagen corporativa en aplicaciones y sitios web para tu empresa.",R.drawable.ic_settings));
        listaServicios.add(new Servicio("Social Media ","Mejorar el posicionamiento de sus sitios web para recibir el mayor número de visitas, optimización de marcas a través de redes sociales y comunidades virtuales",R.drawable.ic_share));

    }
    public void mostrarDatos(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterServicio = new AdapterServicio(getContext(), listaServicios);
        recyclerView.setAdapter(adapterServicio);
    }
}
