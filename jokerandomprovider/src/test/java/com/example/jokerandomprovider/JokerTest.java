package com.example.jokerandomprovider;
import org.junit.Test;

public class JokerTest {
    @Test
    public void test() {
        JokeRandomProvider joker = new JokeRandomProvider();
        assert joker.getAJoke().length() != 0;
    }
}
