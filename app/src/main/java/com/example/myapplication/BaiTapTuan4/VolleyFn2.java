package com.example.myapplication.BaiTapTuan4;

import android.content.Context;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.R;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class VolleyFn2 {
    String jsonStr;
    ArrayList<PersonInfo> arrayList = new ArrayList<>();

    public void getAllData(Context context, ListView listView){
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        String url =  "https://hungnttg.github.io/array_json_new.json";
        JsonArrayRequest request = new JsonArrayRequest(url, response -> {
            for(int i = 0; i< response.length(); i++){
                try {
                    JSONObject obj = response.getJSONObject(i);
                    PersonInfo personInfo = new PersonInfo();
                    personInfo.setId(obj.getString("id"));
                    personInfo.setName(obj.getString("name"));
                    personInfo.setEmail(obj.getString("email"));
                    personInfo.setAddress(obj.getString("address"));
                    personInfo.setGender(obj.getString("gender"));
                    arrayList.add(personInfo);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
            PersonInfoAdapter adapter = new PersonInfoAdapter(context.getApplicationContext(), arrayList);
            listView.setAdapter(adapter);

        }, error -> {
            error.printStackTrace();
        });
        requestQueue.add(request);
    }

}
