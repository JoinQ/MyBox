package com.box.box.customer.me.function;

import android.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.box.app.BoxActivity;
import com.box.box.R;
import com.box.box.customer.exress.functionfragment.query.QueryInfoActivity;
import com.box.mode.RankThing;
import com.box.view.DividerItemDecoration;
import com.box.widget.QueryInfoRecyclerAdapter;
import com.box.widget.RankRecyclerAdapter;

public class RankActivity extends BoxActivity {

    private RecyclerView recyclerView;
    private RankRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);

        ActionBar actionBar = this.getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setTitle("排行");
        init();
    }

    private void init() {
        RankThing[] rankthing = new RankThing[10];
        for (int i = 0; i < 10; i++) {
            rankthing[i] = new RankThing(i + 1, R.drawable.rank_head, "超级无敌金正恩", 1, 998);
        }

        recyclerView = (RecyclerView) findViewById(R.id.rank_rv);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(RankActivity.this));

        adapter = new RankRecyclerAdapter(rankthing, this);
        recyclerView.addItemDecoration(new DividerItemDecoration(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
