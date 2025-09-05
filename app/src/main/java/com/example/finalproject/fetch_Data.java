package com.example.finalproject;

import static com.example.finalproject.mainFragment.ShortList;
import static com.example.finalproject.mainFragment.moviesList;
import static com.example.finalproject.mainFragment.seriesList;
import android.app.Activity;
import android.os.AsyncTask;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.HttpUrl;

public class fetch_Data extends AsyncTask<ArrayList<String>, ArrayList<String>, ArrayList<String>> {

    private Activity contextRef;
    private OkHttpClient client;
    private String title;
    private ArrayList<String> result_data;
    private static final String API_KEY = "f9377f89";

    public fetch_Data(String title, Activity context) {
        this.title = title;
        this.contextRef = context;
        this.client = new OkHttpClient();
        this.result_data = new ArrayList<>();
    }

    @Override
    protected ArrayList<String> doInBackground(ArrayList<String>... arrayLists) {
        ArrayList<String> typeList = new ArrayList<>();
        typeList.add("movie");
        typeList.add("series");
        typeList.add("short");
        String url_final;
        for (int i = 0; i < typeList.size(); i++) {
            if (typeList.get(i) != "short"){
                url_final = CreateHTTP_URL("war",typeList.get(i) , "full");
            }else {
                url_final = CreateHTTP_URL("movies","movie" , "short");
            }

            System.out.println("data send  (FGDHD65y4yHER) : "+url_final);
            if (url_final != null) {
                try {
                    Request request = new Request.Builder().url(url_final).build();
                    Response response = client.newCall(request).execute();

                    if (response.body() != null) {
                        String body = response.body().string();
                        if (!body.isEmpty()) {
                            result_data.add(body);
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        System.out.println("data send  (FGDHDFGHER) : "+result_data.toString());
        return result_data;
    }

    @Override
    protected void onPostExecute(ArrayList<String> strings) {
        super.onPostExecute(strings);
        System.out.println("contaent  (ef3rf4ff4f): "+ strings.toString());

            if (!strings.isEmpty()) {
                Toast.makeText(contextRef, "Data Loaded Successfully", Toast.LENGTH_SHORT).show();

                for (int i = 0; i < strings.size(); i++) {
                    try {
                        JSONObject JSObject = new JSONObject(strings.get(i));
                        JSONArray JS_array = JSObject.getJSONArray("Search");
                        System.out.println("the title Error(4ef4fbvdvt4) : ");
                        for (int j = 0; j < JS_array.length(); j++) {
                            JSONObject movies = JS_array.getJSONObject(j);
                            System.out.println("the title Error(4ef4t4) : " + movies.getString("Title"));
                            switch (i) {
                                case 0:
                                    moviesList.add(new Movie(movies.getString("Title"), movies.getString("Poster"), movies.getString("Year"), null, movies.getString("Type")));
                                    break;
                                case 1:
                                    seriesList.add(new Movie(movies.getString("Title"), movies.getString("Poster"), movies.getString("Year"), null, movies.getString("Type")));
                                    System.out.println( "is add (dfgdfgdf)  +");
                                    break;
                                case 2:
                                    ShortList.add(new Movie(movies.getString("Title"), movies.getString("Poster"), movies.getString("Year"), null, movies.getString("Type")));
                                    break;
                            }
                        }
                    } catch (JSONException e) {
                        System.out.println("Error (43645fg4) : " + e);
                        throw new RuntimeException(e);
                    }
                }

                setupRecyclerView(contextRef, R.id.recycle2, moviesList);
                setupRecyclerView(contextRef, R.id.recycle, seriesList);
                setupRecyclerView(contextRef, R.id.recycle3, ShortList);
            }else {
                Toast.makeText(contextRef, "error Loaded data", Toast.LENGTH_SHORT).show();
            }


    }




    private void setupRecyclerView(Activity context, int recyclerId, ArrayList<Movie> dataList) {
        RecyclerView rv = context.findViewById(recyclerId);
        movies_Adapter adapter = new movies_Adapter(context, dataList);
        LinearLayoutManager manager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
        rv.setLayoutManager(manager);
        rv.setAdapter(adapter);
    }

    private String CreateHTTP_URL(String Title ,String type , String plot) {
            HttpUrl.Builder urlBuilder = HttpUrl.parse("https://www.omdbapi.com/").newBuilder();
            urlBuilder.addQueryParameter("s", Title);
            urlBuilder.addQueryParameter("page", "1");
            urlBuilder.addQueryParameter("type", type);
            urlBuilder.addQueryParameter("plot", plot);
            urlBuilder.addQueryParameter("apikey", API_KEY);
            String string = urlBuilder.build().toString();
        System.out.println("error is ourr (dfgdfgdfgdf) : "+ string.toString());
            return string;

    }

}
