package com.example.myapplication.BaiTapTuan6;

import android.content.Context;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class T6VolleyFn2 {
    ArrayList<GiayInfo> arrayList = new ArrayList<>();

    public void getAllData(Context context, ListView listView){
        RequestQueue requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        String url =  "https://hungnttg.github.io/shopgiay.json";
        JsonObjectRequest request = new JsonObjectRequest(url, response -> {
            JSONArray jsonObject = new JSONArray();
            try {
                jsonObject = response.getJSONArray("products");
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
            for(int i = 0; i< response.length(); i++){
                try {
                    JSONObject obj = jsonObject.getJSONObject(i);
                    GiayInfo giayInfo = new GiayInfo();
                    giayInfo.setSearch_image(obj.getString("search_image"));
                    giayInfo.setStyleid(obj.getString("styleid"));
                    giayInfo.setBrands_filter_facet(obj.getString("brands_filter_facet"));
                    giayInfo.setPrice(obj.getString("price"));
                    giayInfo.setProduct_additional_info(obj.getString("product_additional_info"));
                    arrayList.add(giayInfo);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
            GiayInfoAdapter adapter = new GiayInfoAdapter(context.getApplicationContext(), arrayList);
            listView.setAdapter(adapter);

        }, error -> {
            error.printStackTrace();
        });
        requestQueue.add(request);
    }

}
