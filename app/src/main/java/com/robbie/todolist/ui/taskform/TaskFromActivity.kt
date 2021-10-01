package com.robbie.todolist.ui.taskform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.robbie.todolist.R
import com.robbie.todolist.databinding.ActivityTaskFromBinding
import com.robbie.todolist.model.data.Task
import com.robbie.todolist.utils.App
import kotlin.random.Random

class TaskFromActivity : AppCompatActivity() {

    private lateinit var binding : ActivityTaskFromBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityTaskFromBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setTitleActionBar()

        setClickListeners()

    }

    private fun setClickListeners() {
        binding.btnSaveTask.setOnClickListener { saveTodo() }
    }

    private fun saveTodo() {
        if(isFormTodoFilled()){
            val todo =  Task(
                Random.nextInt(),
                binding.etTaskName.text.toString(),
                binding.etTaskDesc.text.toString(),
                binding.etTaskHeaderImg.text.toString(),
                false
            )
            (application as App).getDataSource()?.add(todo)
            Toast.makeText(this, "Task Saved !", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun isFormTodoFilled(): Boolean {
        val title = binding.etTaskName.text.toString()
        val desc = binding.etTaskName.text.toString()
        val imgHeaderUrl = binding.etTaskName.text.toString()
        var isFormValid = true

        if (title.isEmpty()){
            isFormValid =false
            binding.tilTaskName.isErrorEnabled = true
            binding.tilTaskName.error = getString(R.string.text_error_field_task_name)
        }else{
            binding.tilTaskName.isErrorEnabled = false
        }
        if(desc.isEmpty()){
            isFormValid = false
            binding.tilTaskDesc.isErrorEnabled = true
            binding.tilTaskDesc.error = getString(R.string.text_error_field_task_desc)
        }else{
            binding.tilTaskDesc.isErrorEnabled = false
        }

        if(imgHeaderUrl.isEmpty()){
            isFormValid = false
            binding.tilTaskHeaderImg.isErrorEnabled = true
            binding.tilTaskHeaderImg.error = getString(R.string.text_error_field_task_header)
        }else{
            binding.tilTaskHeaderImg.isErrorEnabled = false
        }
        return isFormValid

    }

    private fun setTitleActionBar() {
        supportActionBar?.title = getString(R.string.text_title_task_form_activity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home ->{
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }


}