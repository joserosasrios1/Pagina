package com.example.pagina;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private WebView miVisorWeb;
    private Button Boton;
    String url ="https://materialesaramburo.mx/web/login";
    NotificationCompat.Builder notificacion;
    private static final int idUnica = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Boton = (Button) findViewById(R.id.boton);

        notificacion = new NotificationCompat.Builder (this);
        notificacion.setAutoCancel(true);

        miVisorWeb = (WebView) findViewById(R.id.visorWeb);
        final WebSettings ajustesVisorWeb = miVisorWeb.getSettings();
        ajustesVisorWeb.setJavaScriptEnabled(true);
        miVisorWeb.loadUrl(url);

        Boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setClickable(true);
                view.setOnClickListener(this);
                notificacion.setSmallIcon(R.mipmap.ic_launcher);
                notificacion.setTicker("Notificación Nueva");
                notificacion.setPriority(Notification.PRIORITY_HIGH);
                notificacion.setWhen(System.currentTimeMillis());
                notificacion.setContentTitle("Titulo Prueba");
                notificacion.setContentText("Este es un mensaje de prueba xd");

                Intent intent = new Intent(MainActivity.this,MainActivity.class);

                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                notificacion.setContentIntent(pendingIntent);

                NotificationManager nm = (NotificationManager)  getSystemService(NOTIFICATION_SERVICE);
                nm.notify(idUnica,notificacion.build());


            }
        });






    }


}