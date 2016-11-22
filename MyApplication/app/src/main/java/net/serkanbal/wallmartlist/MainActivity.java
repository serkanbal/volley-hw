package net.serkanbal.wallmartlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static net.serkanbal.wallmartlist.R.id.recyclerview;

public class MainActivity extends AppCompatActivity {
    public static final String GET_ITEMNAME = "http://api.walmartlabs.com/v1/search?format=json&apiKey=q8cpgj4hmeha6w47w4ab74e2&query=";
    public List<ResultItem> mList = new ArrayList<>();
    public Button mButtonPS4, mButtonXboxOne, mButtonWiiU;
    public RecyclerView mRecyclerView;
    public RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonPS4 = (Button) findViewById(R.id.buttonps4);
        mButtonXboxOne = (Button) findViewById(R.id.buttonxboxone);
        mButtonWiiU = (Button) findViewById(R.id.buttonwiiu);

        mButtonPS4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWalmartWithVolley("PS4");
            }
        });

        mButtonXboxOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWalmartWithVolley("Xbox+One");

            }
        });

        mButtonWiiU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWalmartWithVolley("Wii+U");

            }
        });
    }


    public void getWalmartWithVolley(String query) {
        RequestQueue queue = Volley.newRequestQueue(this);

        String finalQueryUrl = GET_ITEMNAME+query;

        JsonObjectRequest request = new JsonObjectRequest(com.android.volley.Request.Method.GET,
                finalQueryUrl, null, new com.android.volley.Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                mList.clear();
                try {
                    JSONArray newArray = response.getJSONArray("items");
                    for (int i = 0; i < newArray.length(); i++) {
                        JSONObject nameObj = newArray.getJSONObject(i);
                        String actualName = nameObj.getString("name");
                        mList.add(new ResultItem(actualName));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                mRecyclerView = (RecyclerView) findViewById(recyclerview);

                LinearLayoutManager linearLayoutManager =
                        new LinearLayoutManager(MainActivity.this,
                                LinearLayoutManager.VERTICAL,false);

                mRecyclerView.setLayoutManager(linearLayoutManager);

                mAdapter =
                        new SearchResultRecyclerViewAdapter(mList);
                mRecyclerView.setAdapter(mAdapter);

                mAdapter.notifyDataSetChanged();

            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //
            }
        });
        queue.add(request);
    }
}
