package e.commerce.app.data

import androidx.lifecycle.LiveData

class UserdataRepository (private val userdataDao: UserdataDao){

    val readAllData: LiveData<List<Userdata>> = userdataDao.getAll()

    suspend fun addTodo(userItem: Userdata) {
        userdataDao.insert(userItem)
    }

    suspend fun updateTodo(userItem: Userdata) {
        userdataDao.update(userItem)
    }




}