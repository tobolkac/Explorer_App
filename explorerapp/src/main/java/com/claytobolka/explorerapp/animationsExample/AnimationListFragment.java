package com.claytobolka.explorerapp.animationsExample;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.claytobolka.explorerapp.app.R;


public class AnimationListFragment extends Fragment {

    private ListView animationsList;

    Context context;

    String[] animationNames = {"Fade In", "Fade Out", "Sequential", "Blink",
            "Zoom In", "Zoom Out", "Rotate", "Move", "Slide Up", "Slide Down", "Bounce"};


    public AnimationListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_animation_list, container, false);

        animationsList = (ListView) root.findViewById(R.id.animations_list_view);

        animationsList.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,
                animationNames));

        animationsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment fragment = new AnimationFragment(animationNames[position], position);
                FragmentManager fragmentManager = getActivity().getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.animation_main_frame, fragment).commit();
            }
        });


        return root;



    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }


}
