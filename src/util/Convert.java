package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Convert {

    /**
     * Convert string to date.
     *
     * @param dateToConvert
     * @return new Date with dd-MM-yyyy format
     */
    public static Date stringToDate(String dateToConvert) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date d = new Date();
        try {
            d = sdf.parse(dateToConvert);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;
    }

    /**
     * Convert util.Date to sql.Date
     *
     * @param d: util.Date
     * @return new sql.Date
     */
    public static java.sql.Date utilDateToSqlDate(Date d) {
        java.sql.Date dateConverted = new java.sql.Date(d.getTime());
        return dateConverted;
    }

    public static void main(String[] args) {
        // TODO test
    }

}
