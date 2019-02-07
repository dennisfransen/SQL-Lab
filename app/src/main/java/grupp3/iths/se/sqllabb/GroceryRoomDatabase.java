package grupp3.iths.se.sqllabb;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {Grocery.class}, version = 1)
public abstract class GroceryRoomDatabase extends RoomDatabase {

    public abstract GroceryDao groceryDao();

    private static volatile GroceryRoomDatabase INSTANCE;

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };


    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final GroceryDao mDao;

        PopulateDbAsync(GroceryRoomDatabase db) {
            mDao = db.groceryDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            mDao.deleteAll();
            Grocery grocery = new Grocery("Banana");
            mDao.insert(grocery);
            grocery = new Grocery("Coca-Cola");
            mDao.insert(grocery);
            return null;
        }
    }


    static GroceryRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (GroceryRoomDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            GroceryRoomDatabase.class, "grocery_database")
                            .addCallback(sRoomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }
}
