package com.playground.kata.rockpaperscissors.infra.web;

import com.playground.kata.rockpaperscissors.domain.GameResult;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultDTO {

  private GameResult result;

}
