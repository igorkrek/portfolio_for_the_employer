/* Производит анализ курса валют на  дату, предыдущую и следующую. Выводит, все три  курса,
величину падения и роста, наибольший и наименьшие значения из этих трех, сохраняет на рабочий стол
снимок NASA за эту дату
 */

import models.CurrencyRateModel;
import services.CurrencyRate;
import services.NasaGetPhoto;

import java.io.IOException;

public class Main {
    static CurrencyRateModel[] currencyRateModels = new CurrencyRateModel[3];

    public static void main(String[] args) throws IOException {

        String dataNasa = CurrencyRate.dataInit(currencyRateModels);
        CurrencyRate.currencyFluctuationsFind(currencyRateModels);
        NasaGetPhoto.nasaGetPhoto(dataNasa);
    }
}






