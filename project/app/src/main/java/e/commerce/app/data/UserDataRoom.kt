package e.commerce.app.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [(Userdata::class)], version = 1)
abstract class UserDataRoom: RoomDatabase() {

    abstract fun userdataDao(): UserdataDao

    companion object {

        private var INSTANCE: UserDataRoom? = null

        fun getInstance(context: Context): UserDataRoom {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserDataRoom::class.java,
                        "username_database"
                    ).fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
