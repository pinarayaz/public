package ch.epfl.sweng.dp3.ex5;

import ch.epfl.sweng.dp3.ex5.controller.Controller;
import ch.epfl.sweng.dp3.ex5.model.Model;
import ch.epfl.sweng.dp3.ex5.view.TextView;
import ch.epfl.sweng.dp3.ex5.view.View;

public class Main {

  /** Starts the "Rock Paper Scissors" game */
  public static void main(String[] args) {
    // TODO: instantiate MVC components so you can play the game
    Model model = new Model();
    Controller controller = new Controller(model);
    TextView view = new TextView(model, controller);
    view.createView();
  }
}
