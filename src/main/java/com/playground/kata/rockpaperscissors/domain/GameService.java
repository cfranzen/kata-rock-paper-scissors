package com.playground.kata.rockpaperscissors.domain;

import org.springframework.stereotype.Service;

@Service
public class GameService {

  public GameResult determineWinner (final PlayersChoice choicePlayer1,
                                     final PlayersChoice choicePlayer2) {
    if (choicePlayer1.bets (choicePlayer2)) {
      return GameResult.PLAYER1_WINS;
    } else if (choicePlayer2.bets (choicePlayer1)) {
      return GameResult.PLAYER2_WINS;
    }
    return GameResult.NO_WINNER;
  }
}
