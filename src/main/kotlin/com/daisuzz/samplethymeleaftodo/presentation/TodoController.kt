package com.daisuzz.samplethymeleaftodo.presentation

import com.daisuzz.samplethymeleaftodo.configuration.ListStringEditor
import com.daisuzz.samplethymeleaftodo.usecase.*
import org.springframework.beans.propertyeditors.StringTrimmerEditor
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping
class TodoController(
        private val todoQueryService: TodoQueryService,
        private val todoCreateService: TodoCreateService,
        private val todoUpdateService: TodoUpdateService,
        private val todoDeleteService: TodoDeleteService
) {

    @InitBinder
    fun allowEmptyDataBinding(binder: WebDataBinder) {
        binder.registerCustomEditor(String::class.java, StringTrimmerEditor(true))
        binder.registerCustomEditor(List::class.java, ListStringEditor(List::class.java))
    }

    @GetMapping
    fun top(modelAndView: ModelAndView): ModelAndView {

        val todoList = todoQueryService.getAllTodo()

        modelAndView.addObject("todoList", todoList)
        modelAndView.addObject("todoCreateForm", TodoCreateForm())
        modelAndView.viewName = "top"
        return modelAndView
    }

    @PostMapping("todo")
    fun create(@Validated form: TodoCreateForm,
               bindingResult: BindingResult,
               modelAndView: ModelAndView): ModelAndView {

        if (bindingResult.hasErrors()) {
            val todoList = todoQueryService.getAllTodo()
            modelAndView.addObject("todoList", todoList)
            modelAndView.viewName = "top"
            return modelAndView
        }

        todoCreateService.createTodo(TodoCreateDto(form.title, form.detail))
        modelAndView.viewName = "redirect:/"
        return modelAndView
    }

    @PostMapping("todo/{id}")
    fun update(@PathVariable id: String, @RequestParam("isDone") isDone: Boolean, modelAndView: ModelAndView): ModelAndView {

        todoUpdateService.updateTodo(id, isDone)
        modelAndView.viewName = "redirect:/"
        return modelAndView
    }

    @DeleteMapping("todo/{id}")
    fun delete(@PathVariable id: String, modelAndView: ModelAndView): ModelAndView {

        todoDeleteService.deleteTodo(id)
        modelAndView.viewName = "redirect:/"
        return modelAndView
    }
}
