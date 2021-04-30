package com.example.fragment_activity;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ListFrag extends ListFragment {
    private ChessPieceListener chessPieceListener;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.pieces)));


        if(this.getActivity().findViewById(R.id.layout_default)== null){
            chessPieceListener.onChessPieceSelected(0);

        }

    }
    public interface ChessPieceListener
    {
        public void onChessPieceSelected(int index);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{
            chessPieceListener = (ChessPieceListener) context;
        }
        catch(ClassCastException e){
            throw new ClassCastException(context.toString() + "must implement the interface called" + "ChessPieceListener!");
        }
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        chessPieceListener.onChessPieceSelected(position);
    }
}