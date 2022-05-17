package com.playground.kata.rockpaperscissors.infra.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameDTO {

  private Choice player1;

  private Choice player2;

}
