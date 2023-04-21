package com.UsersMVC.users.controllers;


import com.UsersMVC.users.models.User;
import com.UsersMVC.users.services.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;





@Controller
@RequestMapping("/")

public class UserController {

    private final UserServiceImpl userServiceImp;

    public UserController(UserServiceImpl userRepository) {
        this.userServiceImp = userRepository;
    }
    @GetMapping
    public String index(Model model) {

        model.addAttribute("users", userServiceImp.index());// user добавляем атрибут в html
        return "users/index";
    }
    @GetMapping("/{id}") // add slash /people/id
    public String show(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("user", userServiceImp.show(id));
        return "users/show";
    }
    @GetMapping("/new")
    public String newPerson(Model model)
    {
        model.addAttribute("user", new User());
        return "users/new";
    }
    @PostMapping()
    public String creat(@ModelAttribute("user") @Valid User person,
                         BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
            return "users/new";
        userServiceImp.save(person);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")

    public String edit(Model model, @PathVariable("id") int id)
    {
        model.addAttribute("user", userServiceImp.show(id));
        return "users/edit";
    }

    @PatchMapping ("/{id}")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                         @PathVariable("id") int id)
    {
        if (bindingResult.hasErrors())
            return "users/edit";
        userServiceImp.update(id, user);  // обновляем человека в базе даных который пришел на вход
        return "redirect:/";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") int id)
    {
        userServiceImp.delete(id);
        return "redirect:/";
    }


}

