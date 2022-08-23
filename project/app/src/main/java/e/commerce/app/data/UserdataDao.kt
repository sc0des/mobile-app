package e.commerce.app.data

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface UserdataDao {

    // saves user registration name and email for profile_screen
    @Insert
    suspend fun insert(useritem: Userdata)


}