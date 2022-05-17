package com.playground.kata.rockpaperscissors.domain;

class ScissorsChoice implements PlayersChoice {

  @Override
  public boolean bets (final PlayersChoice otherChoice) {
    return otherChoice instanceof PaperChoice;
  }

  @Override
  public String toString () {
    return "Scissors";
  }
}
