package com.daisuzz.samplethymeleaftodo.domain.todo

data class Todo(val id: String, val title: String, val detail: String, val isDone: Boolean = false)
