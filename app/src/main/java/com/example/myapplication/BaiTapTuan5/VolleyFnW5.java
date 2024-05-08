package com.example.myapplication.BaiTapTuan5;

import android.content.Context;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class VolleyFnW5 {

    String strJson;

    public void getDataIntoTextView(Context context, TextView textView){
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        String apiUrl = "http://192.168.1.16:8080/api/getData.php";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(apiUrl,response -> {
            for(int i = 0; i < response.length(); i++){
                try {
//                   Lấy ra một json Object
                    JSONObject jsonObject = response.getJSONObject(i);
                    // Bind data
                    String id = jsonObject.getString("id");
                    String lastname = jsonObject.getString("lastname");
                    String firstname = jsonObject.getString("firstname");
                    String email = jsonObject.getString("email");
                    strJson+= "id: " + id + '\n';
                    strJson+= "lastname: " + lastname + '\n';
                    strJson+= "firstname: " + firstname + '\n';
                    strJson+= "email: "+ email + '\n';
                    strJson += "\n";
                    textView.setText(strJson);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }


            }
        },error-> {
            error.printStackTrace();
        });
        requestQueue.add(jsonArrayRequest);
    }
}
