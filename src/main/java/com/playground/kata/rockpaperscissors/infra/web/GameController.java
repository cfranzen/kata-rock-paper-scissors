package com.playground.kata.rockpaperscissors.infra.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.playground.kata.rockpaperscissors.domain.GameService;
import com.playground.kata.rockpaperscissors.domain.PlayersChoice;
import com.playground.kata.rockpaperscissors.domain.PlayersChoiceFactory;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class GameController {

  private final GameService          service;

  private final PlayersChoiceFactory factory;

  @PostMapping ("/play")
  public ResultDTO playRound (@RequestBody final GameDTO request) {
    final var choice1 = mapChoice (request.getPlayer1 ());
    final var choice2 = mapChoice (request.getPlayer2 ());

    final var result = service.determineWinner (choice1, choice2);
    return new ResultDTO (result);
  }

  private PlayersChoice mapChoice (final Choice choice) {
    if (choice == null) {
      throw new IllegalArgumentException ("Choice may not be null");
    }

    switch (choice) {
      case ROCK:
        return factory.rock ();
      case PAPER:
        return factory.paper ();
      case SCISSORS:
        return factory.scissors ();
      default:
        throw new IllegalArgumentException ("Unable to handel choice " + choice);
    }
  }

}
