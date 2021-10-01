package com.robbie.todolist.model.data.datasource

import com.robbie.todolist.model.data.Task

class TaskDataSource {

    private var tasks = mutableListOf<Task>().apply {
        add(
            Task(1,
            "Mencuci baju",
            "Banyak yang harus dicuci 1",
            "https://asset.kompas.com/crops/s1LgD7yFsQVsHD8FeBtG8fSpoQA=/276x184:2484x1656/750x500/data/photo/2020/10/12/5f840c9ba988a.jpg",
            true)
        )
        add(
        Task(2,
            "Mencuci baju",
            "Banyak yang harus dicuci 2",
            "https://asset.kompas.com/crops/s1LgD7yFsQVsHD8FeBtG8fSpoQA=/276x184:2484x1656/750x500/data/photo/2020/10/12/5f840c9ba988a.jpg",
            true)
        )
        add(
        Task(3,
            "Mencuci baju",
            "Banyak yang harus dicuci 3",
            "https://asset.kompas.com/crops/s1LgD7yFsQVsHD8FeBtG8fSpoQA=/276x184:2484x1656/750x500/data/photo/2020/10/12/5f840c9ba988a.jpg",
            true)
        )
        add(
        Task(4,
            "Mencuci baju",
            "Banyak yang harus dicuci 4",
            "https://asset.kompas.com/crops/s1LgD7yFsQVsHD8FeBtG8fSpoQA=/276x184:2484x1656/750x500/data/photo/2020/10/12/5f840c9ba988a.jpg",
            true)
        )
        add(
        Task(5,
            "Mencuci baju",
            "Banyak yang harus dicuci 5",
            "https://asset.kompas.com/crops/s1LgD7yFsQVsHD8FeBtG8fSpoQA=/276x184:2484x1656/750x500/data/photo/2020/10/12/5f840c9ba988a.jpg",
            true)
        )
        add(
        Task(6,
            "Mencuci baju",
            "Banyak yang harus dicuci 6",
            "https://asset.kompas.com/crops/s1LgD7yFsQVsHD8FeBtG8fSpoQA=/276x184:2484x1656/750x500/data/photo/2020/10/12/5f840c9ba988a.jpg",
            true)
        )
    }

    fun add(task : Task){
        tasks.add(task)
    }
    fun delete(taskId : Int){
        tasks.remove(tasks.first {
            it.id == taskId
        })
    }
    fun changeTaskStatus(taskId: Int){
        tasks.first {
            it.id == taskId
        }.apply {
            isTaskCompleted = isTaskCompleted.not()
        }
    }
    fun getData(isTaskCompleted : Boolean) :List<Task>{
        return tasks.filter { it.isTaskCompleted == isTaskCompleted }
    }
}