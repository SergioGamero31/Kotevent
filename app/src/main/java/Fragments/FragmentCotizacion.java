package Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.kotevent.LoginActivity;
import com.example.kotevent.R;
import com.example.kotevent.SignupActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class FragmentCotizacion extends Fragment {

    private EditText TextName;
    private EditText TextDireccion;
    private EditText TextEmail;
    private EditText TextTelefono;
    private EditText TextDescrip;

    private Spinner SpCiudad;
    private Spinner SpServicio;
    private Spinner SpMetodo;

    private Button botonSolicitar;

    DatabaseReference mDatabase;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cotizacion_fragment,container,false);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        TextName = view.findViewById(R.id.etxtNomEmpresa);
        TextDireccion = view.findViewById(R.id.etxtDireccion);
        TextEmail = view.findViewById(R.id.etxtEmail);
        TextTelefono = view.findViewById(R.id.etxtTelefono);
        TextDescrip = view.findViewById(R.id.etxtDesc);

        SpCiudad = view.findViewById(R.id.spnCiudad);
        SpServicio = view.findViewById(R.id.spnTipoServicio);
        SpMetodo = view.findViewById(R.id.spnMedioPago);

        botonSolicitar = view.findViewById(R.id.btnSolicitar);

        botonSolicitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = TextName.getText().toString();
                String direccion = TextDireccion.getText().toString();
                String email = TextEmail.getText().toString();
                String telefono = TextTelefono.getText().toString();
                String descrip = TextDescrip.getText().toString();

                String ciudad = SpCiudad.getSelectedItem().toString();
                String servicio = SpServicio.getSelectedItem().toString();
                String metodo = SpMetodo.getSelectedItem().toString();

                Map<String, Object> map = new HashMap<>();
                map.put("nombre empresa",nombre);
                map.put("direccion ",direccion);
                map.put("email",email);
                map.put("telefono",telefono);
                map.put("descripcion",descrip);
                map.put("ciudad",ciudad);
                map.put("servicio",servicio);
                map.put("metodo pago",metodo);

                mDatabase.child("Cotizacion").push().setValue(map);
            }
        });
        return view;
    }
}
