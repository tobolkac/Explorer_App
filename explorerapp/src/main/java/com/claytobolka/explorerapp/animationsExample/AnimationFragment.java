package com.claytobolka.explorerapp.animationsExample;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.claytobolka.explorerapp.app.R;


public class AnimationFragment extends Fragment {

    private String animationType;

    private Animation myAnimation;

    private int position;

    TextView tv;




    public AnimationFragment(String type, int position) {
        // Required empty public constructor
        this.animationType = type;
        this.position = position;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_animation, container, false);
        // Inflate the layout for this fragment


        switch (position)
        {
            case 0:
                myAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_in);
                break;
            case 1:
                myAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_out);
                break;
            case 2:
                myAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.sequential);
                break;
            case 3:
                myAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.blink);
                break;
            case 4:
                myAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.zoom_in);
                break;
            case 5:
                myAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.zoom_out);
                break;
            case 6:
                myAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.rotate);
                break;
            case 7:
                myAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.move);
                break;
            case 8:
                myAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_up);
                break;
            case 9:
                myAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_down);
                break;
            case 10:
                myAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.bounce);
                break;

        }

        tv = (TextView) root.findViewById(R.id.animation_name);
        tv.setText(animationType);

        Button b = (Button) root.findViewById(R.id.animationButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateText(animationType);
            }
        });


        return root;

    }

    private void animateText(String animationType)
    {
        tv.startAnimation(myAnimation);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }
}
