package grupp3.iths.se.sqllabb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewGroceryActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "nameOfGrocery";
    public static final String EXTRA_QUANTITY = "quantityOfGrocery";

    private EditText mEditGroceryView;
    private EditText mEditGroceryQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_grocery);

        mEditGroceryView = findViewById(R.id.edit_grocery_name);
        mEditGroceryQuantity = findViewById(R.id.edit_grocery_number);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditGroceryView.getText()) || TextUtils.isEmpty(mEditGroceryQuantity.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String groceryName = mEditGroceryView.getText().toString();
                    String groceryQuantity = mEditGroceryQuantity.getText().toString();
                    replyIntent.putExtra(EXTRA_NAME, groceryName);
                    replyIntent.putExtra(EXTRA_QUANTITY, groceryQuantity);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}
