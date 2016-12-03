package app.hoangcuong.com.soundcircle.untils;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Irelia on 12/3/2016.
 */

public class SoundCircle {
    private static final String TAG = "SoundCircle";
    private static final String METHOD_CHART = "charts";
    private static final String METHOD_SEARCH_TRACK = "tracks.json";
    private static final String METHOD_SEARCH_PLAYLIST = "playlists.json";
    private static final String CLIENT_ID = "b3e58eefda17605c8215157fdc46266e";
    private static final Uri ENDPOINT = Uri
            .parse("https://api-v2.soundcloud.com/")
            .buildUpon()
            .appendQueryParameter("client_id", CLIENT_ID)
            .appendQueryParameter("limit", "50")
            .appendQueryParameter("offset", "0")
            .build();

    public byte[] getUrlBytes(String urlSpec) throws IOException {
        URL url = new URL(urlSpec);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream in = connection.getInputStream();
            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new IOException(connection.getResponseMessage() +
                        ": with " +
                        urlSpec);
            }
            int bytesRead = 0;
            byte[] buffer = new byte[1024];
            while ((bytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, bytesRead);
            }
            out.close();
            return out.toByteArray();
        } finally {
            connection.disconnect();
        }
    }

    public String getUrlString(String urlSpec) throws IOException {
        return new String(getUrlBytes(urlSpec));
    }

    private String buildUrlSearch(String query) {
        return ENDPOINT.buildUpon()
                .appendEncodedPath(METHOD_SEARCH_TRACK)
                .appendQueryParameter("q", query)
                .build().toString();
    }

    private String buildUrlCharts(String kind, String genre) {
        return ENDPOINT.buildUpon()
                .appendEncodedPath(METHOD_CHART)
                .appendQueryParameter("kind", kind)
                .appendQueryParameter("genre", genre)
                .build().toString();
    }

    private List<Song> downloadGalleryItems(String url) {
        List<Song> items = new ArrayList<>();

        try {
            String jsonString = getUrlString(url);
            Log.i(TAG, "Received JSON: " + jsonString);
            JSONArray jsonBody = new JSONArray(jsonString);
            parseItems(items, jsonBody);
        } catch (IOException ioe) {
            Log.e(TAG, "Failed to fetch items", ioe);
        } catch (JSONException je) {
            Log.e(TAG, "Failed to parse JSON", je);
        }

        return items;
    }

    private void parseItems(List<Song> items, JSONArray json)
            throws IOException, JSONException {

        for (int i = 0; i < json.length(); i++) {
            JSONObject track = json.getJSONObject(i);

            Song item = new Song();
            item.setId(track.getString("id"));
            item.setName(track.getString("title"));
            item.setPhoto(track.getString("waveform_url"));
            item.setUrl(track.getString("permalink_url"));
            items.add(item);
        }
    }

}
