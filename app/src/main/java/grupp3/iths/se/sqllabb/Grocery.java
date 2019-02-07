package grupp3.iths.se.sqllabb;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "grocery_table")

public class Grocery {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "grocery")

    private String mGroceryName;

    public Grocery(@NonNull String mGroceryName) {
        this.mGroceryName = mGroceryName;
    }

    @NonNull
    public String getmGroceryName() {
        return mGroceryName;
    }
}
