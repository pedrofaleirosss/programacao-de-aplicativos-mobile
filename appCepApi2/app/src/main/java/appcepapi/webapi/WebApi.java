package appcepapi.webapi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class WebApi {
    private StringBuilder resposta = null;
    private Scanner scanner = null;
    private JSONObject jsondata = null;
    public JSONObject ReturnData(String urlAddress, String metodo) {
        try {
            resposta = new StringBuilder();
            URL url = new URL(urlAddress);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(metodo);
            connection.setAllowUserInteraction(true);
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestProperty("nome", "maria");
            connection.setConnectTimeout(5000);
            connection.connect();
            scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                resposta.append(scanner.next());
            }
            jsondata = new JSONObject(resposta.toString());
        }
        catch (MalformedURLException mfe) {

        }
        catch (IOException | JSONException exception) {

        }
        return jsondata;
    }
}
