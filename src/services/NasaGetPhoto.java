/* Скачивние фото на рабочий стол с сайта NASA на заданную дату
 */
package services;


import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NasaGetPhoto {

    public static void nasaGetPhoto(String dataNasa) throws IOException {
        String nasaUrl = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&date=" + dataNasa;
        String photoName = "C:/Users/user/Desktop/nasaPhoto.jpg";

        System.out.println(nasaUrl);
        String nasaPhoto = DownloadWebPage.downloadWebPage(nasaUrl);


        int urlBegin = nasaPhoto.lastIndexOf(",\"url\":");
        int urlEnd = nasaPhoto.lastIndexOf("}");
        nasaPhoto = nasaPhoto.substring(urlBegin + 8, urlEnd - 1);
        System.out.println(nasaPhoto);


        try (InputStream in = new URL(nasaPhoto).openStream()) {
            Files.copy(in, Paths.get(photoName));
        }
    }
}
