package tfsandroid.tinkoff.ru.homework_3_fragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, DocumentFragment.newInstance(getString(R.string.empty_document)))
                .commit();

        Button add = findViewById(R.id.addDocument);
        Button delete = findViewById(R.id.deleteDocument);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Действия на кнопку добавить
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Действия на кнопку удалить
            }
        });
    }
}
