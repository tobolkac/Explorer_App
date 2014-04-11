package com.claytobolka.explorerapp.progressbar;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.claytobolka.explorerapp.app.R;

public class ProgressFragment extends Fragment {

    private ProgressBar pBar1;
    private ProgressBar pBar2;

    private TextView text;
    private Button butn;

    public ProgressFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_progess_bar_with_runnable, container, false);

        pBar1 = (ProgressBar) rootView.findViewById(R.id.progressBar1);
        pBar2 = (ProgressBar) rootView.findViewById(R.id.progressBar2);
        text = (TextView) rootView.findViewById(R.id.textView1);
        butn = (Button) rootView.findViewById(R.id.button1);

        butn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startProgress();
            }
        });

        return rootView;
    }

    private void startProgress() {
        //create Runnable to do fake work
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i<=100; i++){
                    final int value = i;
                    doFakeWork();
                    pBar2.post(new Runnable() {
                        @Override
                        public void run() {
                            text.setText("Updating");
                            pBar1.setProgress(value);
                        }
                    });
                }
            }
        };
        new Thread(runnable).start();
    }

    private void doFakeWork(){
        try{
            Thread.sleep(500);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }

}
