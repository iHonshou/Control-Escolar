package com.itsoeh.hhdaniel.portalescolar;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CuadroDialogo {
    private Dialog dialogo;
    private TextView txtinfo;
    private Button btnAceptar;
    private Context contexto;

    public CuadroDialogo(Context contexto) {

        this.contexto = contexto;
        dialogo = new Dialog(contexto);
        dialogo.setContentView(R.layout.cuadro_dialogo);
        txtinfo= dialogo.findViewById(R.id.cuadro_txtinfo);
        btnAceptar = dialogo.findViewById(R.id.cuadro_aceptar);
        dialogo.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogo.dismiss();
            }
        });
    }
    public void setInfo(String info) {
        dialogo.show();
        txtinfo.setText(info);

    }
}
