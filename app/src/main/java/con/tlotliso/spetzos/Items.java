package con.tlotliso.spetzos;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Items extends ActionBarActivity {

    private Toolbar toolbar;

    private final String recyclerViewTitleText[] = {"Android", "RecyclerView", "Android List", "GridView", "ListView", "Tutorial", "Example", "CardView", "Lollipop", "Marshmallow", "Custom ListView", "Custom GridView"
    };

    private final int recyclerViewImages[] = {
                                                     R.drawable.pepperoni_pizza_slice, R.drawable.pepperoni_pizza_slice, R.drawable.pepperoni_pizza_slice, R.drawable.pepperoni_pizza_slice, R.drawable.pepperoni_pizza_slice, R.drawable.pepperoni_pizza_slice,
                                                     R.drawable.pepperoni_pizza_slice, R.drawable.pepperoni_pizza_slice, R.drawable.pepperoni_pizza_slice, R.drawable.pepperoni_pizza_slice, R.drawable.pepperoni_pizza_slice, R.drawable.pepperoni_pizza_slice
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initRecyclerViews();
    }


    private void initRecyclerViews() {
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<AndroidVersion> av = prepareData();
        AndroidDataAdapter mAdapter = new AndroidDataAdapter(getApplicationContext(), av);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnItemTouchListener(
                                                    new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
                                                        @Override
                                                        public void onItemClick(View view, int i) {
                                                            Intent intent = new Intent(Items.this, Order.class);
                                                            intent.putExtra("item_title", recyclerViewTitleText[i]);
                                                            startActivity(intent);
                                                        }
                                                    })
        );

    }

    private ArrayList<AndroidVersion> prepareData() {

        ArrayList<AndroidVersion> av = new ArrayList<>();
        for (int i = 0; i < recyclerViewTitleText.length; i++) {
            AndroidVersion mAndroidVersion = new AndroidVersion();
            mAndroidVersion.setAndroidVersionName(recyclerViewTitleText[i]);
            mAndroidVersion.setrecyclerViewImage(recyclerViewImages[i]);
            av.add(mAndroidVersion);
        }
        return av;
    }


}
