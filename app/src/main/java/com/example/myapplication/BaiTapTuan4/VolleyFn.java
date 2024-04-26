package com.example.myapplication.BaiTapTuan4;

import android.content.Context;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class VolleyFn {
    String jsonStr;

    public void getAllData(Context context, TextView textView){
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        String url =  "https://hungnttg.github.io/array_json_new.json";
        JsonArrayRequest request = new JsonArrayRequest(url, response -> {
            for(int i = 0; i<response.length(); i++){
                try {
                    JSONObject person = response.getJSONObject(i);
                    String id = person.getString("id");
                    String name = person.getString("name");
                    String email = person.getString("email");
                    String gender = person.getString("gender");
                    jsonStr+= "id: " + id + '\n';
                    jsonStr+= "name: " + name + '\n';
                    jsonStr+= "email: " + email + '\n';
                    jsonStr+= "gender: "+ gender + '\n';
                    jsonStr += "\n";
                    textView.setText(jsonStr);
                }
                catch ( Exception exception){
                    exception.printStackTrace();
                }
            }

        }, error -> {
            error.printStackTrace();
        });
        requestQueue.add(request);
    }

}
