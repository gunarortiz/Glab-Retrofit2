package com.gunar.retro.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gunar.retro.retrofit.model.LoginE;
import com.gunar.retro.retrofit.model.LoginR;
import com.gunar.retro.retrofit.remote.APIService;
import com.gunar.retro.retrofit.remote.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText ETN;
    private EditText ETP;
    private TextView info;
    private TextView info2;

    private APIService mAPIService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ETN = (EditText)findViewById(R.id.editNombre);
        ETP = (EditText)findViewById(R.id.editPuesto);
        info = (TextView)findViewById(R.id.info);
        info2 = (TextView)findViewById(R.id.info2);
    }

    public void enviar(View v){
        mAPIService = ApiUtils.getApiServices();
        String tn=ETN.getText().toString().trim();
        String tp=ETP.getText().toString().trim();
        LoginE a=new LoginE();
        a.setName(tn);
        a.setJob(tp);

        Call<LoginR> respuesta = mAPIService.llamar(a);

        respuesta.enqueue(new Callback<LoginR>() {
            @Override
            public void onResponse(Call<LoginR> call, Response<LoginR> response) {
                info.setText(response.code()+"");
                if(response.isSuccessful()){
                    info2.setText(response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<LoginR> call, Throwable t) {

            }
        });

    }

}
