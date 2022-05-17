package com.playground.kata.rockpaperscissors.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GameServiceTest {

  @ParameterizedTest
  @MethodSource ("combinations")
  void testChoiceCombinations (final PlayersChoice player1,
                               final PlayersChoice player2,
                               final GameResult expectedResult) {
    final var service = new GameService ();
    final var result = service.determineWinner (player1, player2);
    assertEquals (expectedResult, result);
  }

  private static Stream<Arguments> combinations () {
    final var factory = new PlayersChoiceFactory ();
    return Stream.of (Arguments.of (factory.rock (), factory.scissors (), GameResult.PLAYER1_WINS),
                      Arguments.of (factory.paper (), factory.rock (), GameResult.PLAYER1_WINS),
                      Arguments.of (factory.scissors (), factory.paper (), GameResult.PLAYER1_WINS),
                      Arguments.of (factory.rock (), factory.paper (), GameResult.PLAYER2_WINS),
                      Arguments.of (factory.paper (), factory.scissors (), GameResult.PLAYER2_WINS),
                      Arguments.of (factory.scissors (), factory.rock (), GameResult.PLAYER2_WINS),
                      Arguments.of (factory.scissors (), factory.scissors (), GameResult.NO_WINNER),
                      Arguments.of (factory.rock (), factory.rock (), GameResult.NO_WINNER),
                      Arguments.of (factory.paper (), factory.paper (), GameResult.NO_WINNER));
  }
}
