package com.learnSpringFramework.restapiposts.controller;

import com.learnSpringFramework.restapiposts.model.Posts;
import com.learnSpringFramework.restapiposts.repository.PostsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class PostsController {

    private final PostsRepository postRepository;

    RestTemplate restTemplate = new RestTemplate();

    public PostsController(PostsRepository postRepository) {
        this.postRepository = postRepository;
    }

    // Fetch data from external API
    @GetMapping("/posts")
    public List<Posts> getDataFromEndpoint(){
        String url = "http://jsonplaceholder.typicode.com/posts";
        Posts[] response = restTemplate.getForObject(url, Posts[].class);
        List<Posts> postsList = Arrays.asList(response);
        postRepository.saveAll(postsList);
        if(response != null){
            return Arrays.asList(response);
        }else {
            return new ArrayList<>();
        }
    }

    // Fetch data from Database
    @GetMapping("/jpa/posts")
    public List<Posts> retrieveAllUsers() {
        return postRepository.findAll();
    }


}
