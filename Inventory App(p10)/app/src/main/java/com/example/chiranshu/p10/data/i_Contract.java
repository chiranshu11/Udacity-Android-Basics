package com.example.chiranshu.p10.data;

import android.net.Uri;
import android.content.ContentResolver;
import android.provider.BaseColumns;

/**
 * Created by chiranshu on 09-05-2017.
 */

public final class i_Contract {
    private i_Contract() {
    }
    public static final String CONTENT_AUTHORITY = "com.example.chiranshu.p10";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_I = "inventory";

    public static final class I_Entry implements BaseColumns {
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_I);
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_I;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_I;

        public final static String TABLE_NAME = "INVENTORY";

        public final static String _ID = BaseColumns._ID;

        public final static String COLUMN_I_NAME = "name";
        public final static String COLUMN_I_QUANTITY = "quantity";

        public final static String COLUMN_I_PRICE = "price";

        public final static String COLUMN_I_IMAGE = "img";

        public final static String COLUMN_I_MAIL = "mail";
    }

}