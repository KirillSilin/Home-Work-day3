package ru.specialist.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.specialist.spring.repository.PostRepository;

@Controller
public class PostController {

    private final PostRepository postRepository;

    @Autowired
    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @GetMapping
    public String blog(@RequestParam(name = "q", required = false) String param,
                       ModelMap model){
        model.put("posts",
                param != null ? postRepository.findByContentContainingIgnoreCase(param) : postRepository.findAll());
        return "blog";
    }

}
