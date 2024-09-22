package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class ControllerWEB {

@GetMapping("/2task")
    public String hello(@RequestParam(name = "name",defaultValue = "Guest")String name,Model model){
    model.addAttribute("answer","Hello " + name + "!");
    return "index";
}


@GetMapping("/4task/{id}")
    public String getUserById(@PathVariable("id") int userId , Model model){
    model.addAttribute("answer","User with ID "+ userId +  " found");
    return "index";
}

@PutMapping("/5task/{id}")
    public String updateUserInfo(@PathVariable("id") int userId,@RequestBody User user){

    return "User "+ userId + " updated.New name is: " + user.getName();
    }

@DeleteMapping("/6task/{id}")
public String deleteWithId(@PathVariable("id") int userId,@RequestBody User user){

    return "User " + userId + "has been deleted!";
}

@GetMapping("/7task")
public String throwException() {
    throw new CustomException("This is a custom exception message!");
}
}
