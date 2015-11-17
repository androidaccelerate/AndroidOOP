package br.com.androidpro.androidoop.ui.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import br.com.androidpro.androidoop.R;

public class ConcorrenciaActivity extends AppCompatActivity {

    private static final String TAG = ConcorrenciaActivity.class.getSimpleName();
    ExecutorService threads = Executors.newFixedThreadPool(2);

    private void rodaLock() {

        final CountDownLatch lock = new CountDownLatch(1);

        threads.submit(new Runnable() {
            @Override
            public void run() {

                logaThread();
                Log.i(TAG, "Entrando no lock");
                try {
                    // trava
                    lock.await();
                    Log.i(TAG, "Passei do lock!");
                } catch (InterruptedException e) {
                    throw new RuntimeException("Interrupted");
                }
            }
        });

        Log.i(TAG, "Estou fora da thread!");
        Log.i(TAG, "Vou dormir!");

        dorme();

        Log.i(TAG, "Acordei!");
        Log.i(TAG, "Soltando o lock!");
        lock.countDown();
        Log.i(TAG, "Tudo pronto!");
    }

    private void rodaHandler() {

        logaThread();
        Log.i(TAG, "Mesma coisa que uma Thread?");

        new Handler().post(new Runnable() {
            @Override
            public void run() {

                logaThread();
                Log.i(TAG, "E se eu dormir?");
                dorme(); // qual thread irá dormir?
                Log.i(TAG, "Dormi bem obrigado...");
                mostraDialog();
            }
        });
    }

    private void rodaService() {
        logaThread();
        threads.submit(new Runnable() {
            @Override
            public void run() {

                logaThread();
                dorme();
                mostraDialog();
            }
        });
        Log.i(TAG, "Já retornei");
    }

    private void rodaThread() {
        logaThread();
        // Criando uma Thread. Recebe um Runnable.
        // Aqui o Runnable é um lambda :D
        new Thread(new Runnable() {
            @Override
            public void run() {

                logaThread();
                dorme();
                mostraDialog();
            }
        }).start();

        Log.i(TAG, "Já retornou");
    }

    private void rodaAsyncTask() {

        logaThread();

        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... params) {
                logaThread();
                dorme();
                mostraDialog();
                return null;
            }
        }.execute();
        Log.i(TAG, "Já retornei");
    }

    private void logaThread() {
        Log.i(TAG, "Minha Thread é: " + Thread.currentThread().getName());
    }

    private void mostraDialog() {
        // eita preula... método mágico... roda algo em outra thread?
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                new AlertDialog.Builder(ConcorrenciaActivity.this)
                        .setTitle("Apareci!")
                        .setMessage("apareci depois de 3 segundos")
                        .show();
                Log.i(TAG, "Mostrando diálogo");
            }
        });
    }

    private void dorme() {
        try {
            // Se fizer isso na Thread de UI dá xablau
            Thread.sleep(3000L);

        } catch (InterruptedException e) {
            throw new RuntimeException("Wrapped");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.concorrencia_activity);
        findViewById(R.id.roda_thread).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rodaThread();
            }
        });
        findViewById(R.id.roda_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rodaService();
            }
        });
        findViewById(R.id.roda_async_task).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rodaAsyncTask();
            }
        });
        findViewById(R.id.roda_handler).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rodaHandler();
            }
        });
        findViewById(R.id.roda_lock).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rodaLock();
            }
        });
    }
}
