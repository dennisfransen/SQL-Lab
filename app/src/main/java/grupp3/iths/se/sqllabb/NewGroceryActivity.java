package grupp3.iths.se.sqllabb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewGroceryActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";

    private EditText mEditGroceryView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_grocery);

        mEditGroceryView = findViewById(R.id.edit_grocery_name);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditGroceryView.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String groceryName = mEditGroceryView.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY, groceryName);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}
