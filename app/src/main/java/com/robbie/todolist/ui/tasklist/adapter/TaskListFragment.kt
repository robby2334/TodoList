package com.robbie.todolist.ui.tasklist.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.robbie.todolist.databinding.FragmentTaskListBinding
import com.robbie.todolist.ui.taskdetail.TaskDetailActivity
import com.robbie.todolist.utils.App

class TaskListFragment : Fragment() {
    private lateinit var binding: FragmentTaskListBinding
    private var isTaskCompleted: Boolean = false
    private lateinit var adapter: TaskAdapter

    private fun setupList() {
        adapter = TaskAdapter(
            { item, pos ->
                //onClickListener
                TaskDetailActivity.startActivity(context,item)
            },
            { item, pos ->
                //onLongClickListener
                // TODO: 01/10/2021 delete item , with show dialog delete
            }
        )
        binding.rvTask.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@TaskListFragment.adapter
        }
        getListData()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            isTaskCompleted = it.getBoolean(ARG_IS_TASK_COMPLETED)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentTaskListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSwipeRefresh()
        setupList()
    }

    private fun setupSwipeRefresh() {
        binding.srlTask.setOnRefreshListener {
            binding.srlTask.isRefreshing = false
            getListData()
        }
    }


    private fun getListData() {

        (activity?.application as App).getDataSource()?.getData(isTaskCompleted)?.let {
            adapter.items = it
        }

    }


    companion object {
        private const val ARG_IS_TASK_COMPLETED = "ARG_IS_TASK_COMPLETED"

        @JvmStatic
        fun newInstance(isTaskCompleted: Boolean) =
            TaskListFragment().apply {
                arguments = Bundle().apply {
                    putBoolean(ARG_IS_TASK_COMPLETED, isTaskCompleted)
                }
            }
    }
}