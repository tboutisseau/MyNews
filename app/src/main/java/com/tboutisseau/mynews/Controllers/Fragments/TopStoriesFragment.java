package com.tboutisseau.mynews.Controllers.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tboutisseau.mynews.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopStoriesFragment extends Fragment {


    public TopStoriesFragment() {
        // Required empty public constructor
    }

    public static TopStoriesFragment newInstance() {
        
        Bundle args = new Bundle();
        
        TopStoriesFragment fragment = new TopStoriesFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top_stories, container, false);
    }

}
