package com.playground.kata.rockpaperscissors.domain;

class PaperChoice implements PlayersChoice {

  @Override
  public boolean bets (final PlayersChoice otherChoice) {
    return otherChoice instanceof RockChoice;
  }

  @Override
  public String toString () {
    return "Paper";
  }
}
