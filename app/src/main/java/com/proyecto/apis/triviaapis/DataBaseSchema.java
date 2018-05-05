package com.proyecto.apis.triviaapis;

import android.provider.BaseColumns;

/**
 * Created by carlo on 04/05/2018.
 */

public class DataBaseSchema {
    private DataBaseSchema() {}

    public static class PuntuacionesTable implements BaseColumns {
        public static final String TABLE_NAME = "Producto";
        //public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_PUNTOS = "puntos";
        public static final String COLUMN_NAME_FECHA = "fecha";
    }
}
