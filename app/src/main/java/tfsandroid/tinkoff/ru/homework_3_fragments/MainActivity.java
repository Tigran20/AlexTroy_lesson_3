package tfsandroid.tinkoff.ru.homework_3_fragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private int count;
    private Button add;
    private Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


        DocumentFragment fragment = (DocumentFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, DocumentFragment.newInstance(getString(R.string.empty_document)))
                    .commit();
        }

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, DocumentFragment.newInstance(getString(R.string.document) + " № " + count))
                        .addToBackStack(null)
                        .commit();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count > 0) {
                    count--;
                }
                getSupportFragmentManager().popBackStack();
            }
        });
    }

    private void init() {
        add = findViewById(R.id.add_document);
        delete = findViewById(R.id.delete_document);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", count);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        count = savedInstanceState.getInt("count");
    }
}
