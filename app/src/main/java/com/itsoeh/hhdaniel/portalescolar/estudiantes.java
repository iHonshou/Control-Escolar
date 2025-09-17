package com.itsoeh.hhdaniel.portalescolar;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link estudiantes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class estudiantes extends Fragment {

    private EditText txtMatricula, txtNombre, txtApellidoPaterno, txtApellidoMaterno, txtDireccion, txtCorreo, txtTelefono;

    private RadioButton rdbFemenino, rdbMasculino;

    private Button btnFecha;

    private FloatingActionButton fbtGuardar;

    private NavController navController;

    private CardView btnAtras;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public estudiantes() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment estudiantes.
     */
    // TODO: Rename and change types and number of parameters
    public static estudiantes newInstance(String param1, String param2) {
        estudiantes fragment = new estudiantes();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_estudiantes, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        linkComponents(view);
        setListeners(view);
    }

    private void linkComponents(View view) {

        txtMatricula = view.findViewById(R.id.form1_txtmat);
        txtNombre = view.findViewById(R.id.form1_txtnom);
        txtApellidoPaterno = view.findViewById(R.id.form1_txtapp);
        txtApellidoMaterno = view.findViewById(R.id.form1_txtapm);
        txtDireccion = view.findViewById(R.id.form1_txtdirec);
        txtCorreo = view.findViewById(R.id.form1_txtcorreo);
        txtTelefono = view.findViewById(R.id.form1_txttlf);
        rdbFemenino = view.findViewById(R.id.form1_rdbfemenino);
        rdbMasculino = view.findViewById(R.id.form1_rdbmasculino);
        btnFecha = view.findViewById(R.id.form1_btnfecha);
        fbtGuardar = view.findViewById(R.id.form1_fbtguardar);
        btnAtras = view.findViewById(R.id.cardRegresar);
        navController = Navigation.findNavController(view);

    }

    private void setListeners(View view) {

        btnFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickFecha(view);
            }
        });

        fbtGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickGuardar(view);
            }
        });

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                atras(view);
            }
        });

    }

    public void clickGuardar(View view) {

        String matricula = txtMatricula.getText().toString();
        String nombre = txtNombre.getText().toString();
        String apellidoPaterno = txtApellidoPaterno.getText().toString();
        String apellidoMaterno = txtApellidoMaterno.getText().toString();
        String direccion = txtDireccion.getText().toString();
        String correo = txtCorreo.getText().toString();
        String fechaNacimiento = btnFecha.getText().toString();
        String telefono = txtTelefono.getText().toString();
        String genero = "";
        if (rdbFemenino.isChecked()) {
            genero = "Femenino";
        } else if (rdbMasculino.isChecked()) {
            genero = "Masculino";
        }

        String datos =
                        "*DATOS ALUMNO*\n" +
                        "Matricula: " + matricula + "\n" +
                        "Nombre: " + nombre + "\n" +
                        "Apellido Paterno: " + apellidoPaterno + "\n" +
                        "Apellido Materno: " + apellidoMaterno + "\n" +
                        "Fecha de nacimiento: " + fechaNacimiento + "\n" +
                        "Dirección: " + direccion + "\n" +
                        "Correo: " + correo + "\n" +
                        "Teléfono: " + telefono + "\n" +
                        "Género: " + genero + "\n" +
                        "****************";

        CuadroDialogo dialogo = new CuadroDialogo(this.getContext());
        dialogo.setInfo(datos);

        limpiarCampos();

    }

    private void clickFecha(View view) {

        final Calendar calendario = Calendar.getInstance();
        int year = calendario.get(Calendar.YEAR);
        int month = calendario.get(Calendar.MONTH);
        int day = calendario.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(view.getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(android.widget.DatePicker datePicker, int year, int month, int dayOfMonth) {
                btnFecha.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
            }

            }, year, month, day);
            datePickerDialog.show();

    }

    private void limpiarCampos() {

        txtMatricula.setText("");
        txtNombre.setText("");
        txtApellidoPaterno.setText("");
        txtApellidoMaterno.setText("");
        txtDireccion.setText("");
        txtCorreo.setText("");
        txtTelefono.setText("");
        rdbFemenino.setChecked(false);
        rdbMasculino.setChecked(false);
        btnFecha.setText("");

    }

    private void atras(View view){
        navController.navigate(R.id.action_estudiantes_to_menu);
    }

}