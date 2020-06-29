package com.daisuzz.samplethymeleaftodo.presentation

import com.daisuzz.samplethymeleaftodo.usecase.TodoCreateService
import com.daisuzz.samplethymeleaftodo.usecase.TodoDeleteService
import com.daisuzz.samplethymeleaftodo.usecase.TodoQueryService
import org.springframework.beans.propertyeditors.StringTrimmerEditor
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping("todo")
class TodoController(
        private val todoQueryService: TodoQueryService,
        private val todoCreateService: TodoCreateService,
        private val todoDeleteService: TodoDeleteService
) {

    @InitBinder()
    fun allowEmptyDataBinding(binder: WebDataBinder) {
        binder.registerCustomEditor(String::class.java, StringTrimmerEditor(true))
    }

    @GetMapping
    fun top(modelAndView: ModelAndView): ModelAndView {

        val todoList = todoQueryService.getAllTodo()

        modelAndView.addObject("todoList", todoList)
        modelAndView.addObject("todoCreateForm", TodoCreateForm())
        modelAndView.viewName = "top"
        return modelAndView
    }

    @PostMapping
    fun create(@Validated form: TodoCreateForm,
               bindingResult: BindingResult,
               modelAndView: ModelAndView): ModelAndView {

        if (bindingResult.hasErrors()) {
            val todoList = todoQueryService.getAllTodo()
            modelAndView.addObject("todoList", todoList)
            modelAndView.viewName = "top"
            return modelAndView
        }

        todoCreateService.createTodo(form)

        val todoList = todoQueryService.getAllTodo()

        modelAndView.addObject("todoList", todoList)
        modelAndView.viewName = "top"
        return modelAndView
    }

    @PostMapping("{id}")
    fun delete(@PathVariable id: String, modelAndView: ModelAndView): ModelAndView {

        todoDeleteService.deleteTodo(id)
        modelAndView.viewName = "redirect:/todo"
        return modelAndView
    }
}