package com.robbie.todolist.model.data
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Task(
    val id : Int,
    val title : String,
    val desc : String,
    val imgHeaderUrl : String,
    var isTaskCompleted : Boolean
) : Parcelable
