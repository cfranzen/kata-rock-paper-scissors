package com.playground.kata.rockpaperscissors;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.playground.kata.rockpaperscissors.domain.GameResult;
import com.playground.kata.rockpaperscissors.infra.web.Choice;
import com.playground.kata.rockpaperscissors.infra.web.GameDTO;
import com.playground.kata.rockpaperscissors.infra.web.ResultDTO;

@SpringBootTest (webEnvironment = WebEnvironment.RANDOM_PORT)
class KataApplicationTests {

  @Autowired
  private TestRestTemplate testRestTemplate;

  @ParameterizedTest
  @MethodSource ("combinations")
  void testPlayingGame (final Choice player1,
                        final Choice player2,
                        final GameResult expectedResult) {
    final var result = testRestTemplate.postForEntity ("/play", new GameDTO (player1, player2), ResultDTO.class);
    assertEquals (expectedResult, result.getBody ().getResult ());
  }

  private static Stream<Arguments> combinations () {
    return Stream.of (Arguments.of (Choice.ROCK, Choice.SCISSORS, GameResult.PLAYER1_WINS),
                      Arguments.of (Choice.PAPER, Choice.ROCK, GameResult.PLAYER1_WINS),
                      Arguments.of (Choice.SCISSORS, Choice.PAPER, GameResult.PLAYER1_WINS),
                      Arguments.of (Choice.ROCK, Choice.PAPER, GameResult.PLAYER2_WINS),
                      Arguments.of (Choice.PAPER, Choice.SCISSORS, GameResult.PLAYER2_WINS),
                      Arguments.of (Choice.SCISSORS, Choice.ROCK, GameResult.PLAYER2_WINS),
                      Arguments.of (Choice.SCISSORS, Choice.SCISSORS, GameResult.NO_WINNER),
                      Arguments.of (Choice.ROCK, Choice.ROCK, GameResult.NO_WINNER),
                      Arguments.of (Choice.PAPER, Choice.PAPER, GameResult.NO_WINNER));
  }
}
