package com.learn.java.api.time;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.TimeZone;

/**
 * Created by grijesh.
 */
public class PlayWithTimeZones {

    public static void main(String... args) {

        //AEST time zone
        ZoneId aestZone = ZoneId.of("UTC+10"); //Australian Eastern Time
        LocalTime now = LocalTime.now(aestZone);
        System.out.println(now);

        //Asia/Kolkata
        ZoneId indiaZone = ZoneId.of("Asia/Kolkata");
        LocalTime now1 = LocalTime.now(indiaZone);
        System.out.println(now1);

        // Different way
        TimeZone timezone = TimeZone.getTimeZone("Asia/Kolkata");
        LocalTime now2 = LocalTime.now(timezone.toZoneId());
        System.out.println(now2);


        //Different Time Zones
        for (String zone : TimeZone.getAvailableIDs()) {
            TimeZone tz = TimeZone.getTimeZone(zone);
            //System.out.println(zone + ": " + "Daylight: False : " + tz.getDisplayName(false, TimeZone.SHORT) + "/" + " Daylight: True : "+ tz.getDisplayName(true, TimeZone.SHORT));
        }

    }
}
