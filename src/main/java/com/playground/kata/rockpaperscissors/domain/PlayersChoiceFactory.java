package com.playground.kata.rockpaperscissors.domain;

import org.springframework.stereotype.Component;

@Component
public class PlayersChoiceFactory {

  public PlayersChoice rock () {
    return new RockChoice ();
  }

  public PlayersChoice paper () {
    return new PaperChoice ();
  }

  public PlayersChoice scissors () {
    return new ScissorsChoice ();
  }
}
