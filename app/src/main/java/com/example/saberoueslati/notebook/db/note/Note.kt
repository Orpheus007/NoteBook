package com.example.saberoueslati.notebook.db.note

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
        @PrimaryKey(autoGenerate = true) var nid: Long,
        @ColumnInfo(name = "title") var title: String?,
        @ColumnInfo(name = "content") var content: String?,
        @ColumnInfo(name = "date") var date: String?,
        @ColumnInfo(name = "category") var category: String?,
        @ColumnInfo(name = "reminder") var reminder: Boolean?,
        @ColumnInfo(name = "reminderDate") var reminderDate: String?,
        @ColumnInfo(name = "reminderHour") var reminderHour: String?,
        @ColumnInfo(name = "reminderRepeat") var reminderRepeat: Boolean?,
        @ColumnInfo(name = "reminderDay") var reminderDay: String?
) {
    constructor() : this(0, "", "", "", "", false, "", "", false, "")

    constructor(title: String?,content: String?): this(0,title,content,null,null,null,null,null,null,null)

    override fun toString(): String {
        return "Note(nid=$nid, title=$title, content=$content, date=$date, category=$category, reminder=$reminder, reminderDate=$reminderDate, reminderHour=$reminderHour, reminderRepeat=$reminderRepeat, reminderDay=$reminderDay)"
    }
}