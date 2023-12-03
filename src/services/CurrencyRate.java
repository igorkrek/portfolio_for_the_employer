/* dataInit - инициализация даты, curRateInit - инициализация курса,
currencyFluctuationsFind - расчет изменения курса, нахождение min и max.
 */

package services;

import models.CurrencyRateModel;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class CurrencyRate {

    static private String url = "http://www.cbr.ru/scripts/XML_daily.asp?date_req=";

    public static String dataInit(CurrencyRateModel[] currencyRateModel) throws IOException {
        System.out.println("Введите год: ");
        Scanner scan = new Scanner(System.in);
        int year = scan.nextInt();
        System.out.println("Введите месяц: ");
        int month = scan.nextInt() - 1;
        System.out.println("Введите день: ");
        int day = scan.nextInt();
        Calendar calendar = new GregorianCalendar(year, month, day - 1);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat dfNasa = new SimpleDateFormat("yyyy-MM-dd");
        String dataNasa = dfNasa.format(calendar.getTime());
        System.out.println(dataNasa);
        for (int i = 0; i < 3; i++) {

            calendar.add(Calendar.DAY_OF_MONTH, 1);
            CurrencyRateModel cur = new CurrencyRateModel();
            cur.setData(df.format(calendar.getTime()));
            cur.setRate(curRateInit(cur.getData()));
            currencyRateModel[i] = cur;
            System.out.println(" / источник - " + url + df.format(calendar.getTime()));

            System.out.println(currencyRateModel[i].getData() + ": " + currencyRateModel[i].getRate());
        }
        return dataNasa;
    }

    public static Float curRateInit(String data) throws IOException {

        String result = DownloadWebPage.downloadWebPage(url + data);
        String rate = result.substring(result.indexOf("USD") + 64, result.indexOf("USD") + 71);
        return Float.valueOf(rate.replace(',', '.'));
    }

    public static void currencyFluctuationsFind(CurrencyRateModel[] currencyRateModel) {

        System.out.println("      USD Max: " + Math.max(currencyRateModel[0].getRate(),
                Math.max(currencyRateModel[1].getRate(),
                        currencyRateModel[2].getRate())) + "/ ");
        System.out.println("      USD Min:" + Math.min(currencyRateModel[0].getRate(),
                Math.min(currencyRateModel[1].getRate(),
                        currencyRateModel[2].getRate())) + "/ ");
        System.out.println("       Рост:" + (currencyRateModel[2].getRate() -
                currencyRateModel[0].getRate()));
    }

}












