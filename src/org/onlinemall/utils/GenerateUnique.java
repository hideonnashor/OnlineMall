package org.onlinemall.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class GenerateUnique {

    public static String generateUserId() {
        String uuid = UUID.randomUUID().toString().replace("-","");
        Calendar calendar = Calendar.getInstance();
        String date = String.valueOf(calendar.get(Calendar.YEAR))+String.valueOf(calendar.get(Calendar.MONTH)+1)+String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));

        return date+"-"+uuid;
    }

    public static int generateItemId() {
        Date date = new Date();
        int time = (int) date.getTime();
        return time;
    }
}
