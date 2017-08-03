package com.example.chiranshu.p9;

import android.provider.BaseColumns;

/**
 * Created by chiranshu on 12-05-2017.
 */
public final class HabitContract {

    public class HabitTable implements BaseColumns {
        public static final String TABLE_NAME = "HabitTable_CALUCLATOR";
        public static final String _ID = BaseColumns._ID;
        public static final String height = "HEIGHT";
        public static final String weight = "WEIGHT";
        public static final String doing_activity = "ACTIVITY_DONE";
        public static final String activity = "TIMES_THE_ACTIVITY_IN_A_WEEK";

    }
}