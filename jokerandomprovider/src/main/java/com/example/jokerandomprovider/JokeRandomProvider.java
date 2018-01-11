package com.example.jokerandomprovider;
import java.util.Random;

public class JokeRandomProvider {

    private static String[] randomJokes = {
            "What's the object-oriented way to become wealthy? Inheritance.",
            "What do you call a programmer from Finland? Nerdic.",
            "What is a programmer's favourite hangout place? Foo Bar",
            "Why did the programmer quit his job? Because he dind't get arrays (a raise).",
            "0 is false and 1 is true, right? 1."
    };

    public String getAJoke(){
        return randomJokes[new Random().nextInt(randomJokes.length - 1)];
    }
}
