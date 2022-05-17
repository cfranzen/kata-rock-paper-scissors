package com.playground.kata.rockpaperscissors.domain;

class RockChoice implements PlayersChoice {

  @Override
  public boolean bets (final PlayersChoice otherChoice) {
    return otherChoice instanceof ScissorsChoice;
  }

  @Override
  public String toString () {
    return "Rock";
  }
}
