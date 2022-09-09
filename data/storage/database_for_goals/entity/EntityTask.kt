package lolka.example.PsyPath.data.storage.database_for_goals.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class EntityTask(
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null,
    val text:String,
    val time:String
)