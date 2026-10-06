package com.example.retake_kt5.controller;

import com.example.retake_kt5.model.Task;
import com.example.retake_kt5.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        model.addAttribute("title", "Список задач");
        return "tasks/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("categories", taskService.getAllCategories());
        model.addAttribute("title", "Новая задача");
        return "tasks/form";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute("task") Task task,
                         BindingResult bindingResult,
                         Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", taskService.getAllCategories());
            model.addAttribute("title", "Новая задача");
            return "tasks/form";
        }
        taskService.saveTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Task task = taskService.getTaskOrThrow(id);
        model.addAttribute("task", task);
        model.addAttribute("categories", taskService.getAllCategories());
        model.addAttribute("title", "Редактирование задачи");
        return "tasks/form";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id,
                         @Valid @ModelAttribute("task") Task task,
                         BindingResult bindingResult,
                         Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", taskService.getAllCategories());
            model.addAttribute("title", "Редактирование задачи");
            return "tasks/form";
        }
        task.setId(id);
        taskService.saveTask(task);
        return "redirect:/tasks";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }
}