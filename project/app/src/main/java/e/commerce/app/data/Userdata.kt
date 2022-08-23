package e.commerce.app.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "userdata_table")
data class Userdata(

    @PrimaryKey
    @ColumnInfo(name = "user_name")
    var name: String,

    //@ColumnInfo(name = "user_mail")
    //var email: String,


)