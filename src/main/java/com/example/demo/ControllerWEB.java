package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
@Controller
public class ControllerWEB {

    @GetMapping("")
    public String hello(Model model){
        model.addAttribute("answer","Server Started!");
        return "index";
    }

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

@GetMapping("/currentTime")
    public String getCurrentTime(Model model){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String date = LocalDateTime.now().format(formatter);
    System.out.println(date);
    model.addAttribute("answer",date);
        return "index";
}
@GetMapping("/api")
    public String getNumbersFromOneToN(Model model,int q){
        StringBuilder result = new StringBuilder();
        for(int i = 1;i<q+1;i++){
            result.append(" ").append(i);
        }
        model.addAttribute("answer",result);
        return "index";
}

@GetMapping("/random_number")
    public String randomNumber(Model model){
        Random random = new Random();
        model.addAttribute("answer",random.nextInt(1,500));
        return "index";
}

private final Solution solution = new Solution();
    @GetMapping("/fib")
    public String fib(Model model,int number){
        String result = "";
        if (number < 0){
            model.addAttribute("answer","Enter positive number");
        }
        int intResult = solution.fibonacci(number);
        result = Integer.toString(intResult);
        model.addAttribute("answer",result);
        return "index";
}

@GetMapping("/reversedString")
    public String reversedString(Model model,String s){
        StringBuilder reversed = new StringBuilder(s);
        reversed.reverse();
        String result = reversed.toString();
        model.addAttribute("answer",result);
        return "index";
}
@GetMapping("/guessNumber")
    public String guessNumber(Model model,int g){
        int q = 193;
        String Answer = "";
        if (g > q){
            Answer = "Number is Smaller";
        }else if(g<q){
            Answer = "Number is Bigger";
        } else if (q == g) {
            Answer = "Correct!";

            
        }
        model.addAttribute("answer",Answer);

    return "index";
}

}
