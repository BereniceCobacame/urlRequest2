package org.example;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Hello world!
 *
 */
public class App 
{
    OkHttpClient client = new OkHttpClient();

    String urlr(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static void main( String[] args ) throws IOException{

        App app = new App();
        String jsonr = app.urlr("https://pokeapi.co/api/v2/pokemon/1/");
        String jsona = app.urlr("https://pokeapi.co/api/v2/ability/4/");

        JSONObject obj = new JSONObject(jsonr);
        JSONObject obj2 = new JSONObject(jsona);

        JSONArray abilities = obj.getJSONArray("abilities");
        for (int i = 0; i < abilities.length(); i++) {
            String object = abilities.getJSONObject(i).toString();
            System.out.println(object);
        }
        JSONArray flavor = obj2.getJSONArray("flavor_text_entries");
        for (int i = 0; i < flavor.length(); i++) {
            String object = flavor.getJSONObject(i).getString("flavor_text");
            System.out.println(object);
        }

    }
}
