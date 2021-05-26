package id.unhas.room_db.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.unhas.room_db.db.note.Note
import id.unhas.room_db.db.note.NoteDao

@Database(entities = [Note::class], exportSchema = false, version = 1)
abstract class Appdb : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {

        private const val DB_NAME = "NOTE_DB"
        private var instance: Appdb? = null

        fun getInstance(context: Context): Appdb? {
            if (instance == null) {
                synchronized(Appdb::class) {
                    instance = Room
                        .databaseBuilder(
                            context,
                            Appdb::class.java,
                            DB_NAME
                        )
                        .build()
                }
            }
            return instance
        }

    }
}







