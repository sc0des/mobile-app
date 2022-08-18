package e.commerce.app.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface UserdataDao {

    @Query("SELECT * from userdata_table")
    fun getAll(): LiveData<List<Userdata>>

    @Query("SELECT * from userdata_table where userId = :id")
    fun getById(id: Int): Userdata?

    @Insert
    suspend fun insert(useritem: Userdata)

    @Update
    suspend fun update(useritem: Userdata)


}