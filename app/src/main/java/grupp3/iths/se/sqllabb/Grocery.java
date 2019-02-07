package grupp3.iths.se.sqllabb;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "grocery_table")

public class Grocery {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "mGroceryName")
    public String mGroceryName;

    @NonNull
    @ColumnInfo(name = "mGroceryQuantity")
    public String mGroceryQuantity;

    public Grocery(@NonNull String mGroceryName, @NonNull String mGroceryQuantity) {
        this.mGroceryName = mGroceryName;
        this.mGroceryQuantity = mGroceryQuantity;
    }

    @NonNull
    public String getmGroceryName() {
        return mGroceryName;
    }

    @NonNull
    public String getmGroceryQuantity() {
        return mGroceryQuantity;
    }
}
