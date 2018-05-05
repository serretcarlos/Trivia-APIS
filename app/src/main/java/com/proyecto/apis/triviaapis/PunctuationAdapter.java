package com.proyecto.apis.triviaapis;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by carlo on 04/05/2018.
 */

public class PunctuationAdapter extends ArrayAdapter<Punctuation> {

    private Context context;
    public PunctuationAdapter(Context context, ArrayList<Punctuation> punctuations){
        super(context, 0, punctuations);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row, parent, false);
        }

        TextView tvPuntos = convertView.findViewById(R.id.text_puntos);
        TextView tvFecha =  convertView.findViewById(R.id.text_fecha);
        Punctuation punctuation = getItem(position);
        tvPuntos.setText(String.valueOf(punctuation.getmPunctation()));
        tvFecha.setText(punctuation.getmDate());
        return convertView;
    }
}
