package e.commerce.app.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "userdata_table")
class Userdata {

    @PrimaryKey(autoGenerate = true)
    var userId: Int =0

    @ColumnInfo(name = "user_name")
    var usersName: String =""

}