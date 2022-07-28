package  com.codecool.battleship;

import com.codecool.battleship.board.Board;
import com.codecool.battleship.board.BoardFactory;
import com.codecool.battleship.utils.Decoder;
import com.codecool.battleship.game.Game;
import com.codecool.battleship.ship.ShipType;
import com.codecool.battleship.utils.Display;
import com.codecool.battleship.utils.Input;
import com.codecool.battleship.utils.MenuSelector;


public class Battleship {
    public static void main(String[] args) {
        Input input = new Input();
        Display display = new Display(input);
        MenuSelector menu = new MenuSelector();
        Game game = new Game(input, display);

        boolean isRunning = true;
        while (isRunning) {
            display.printDisplayField(Display.WelcomeMsg);
            display.printMenu();
            int selectedMenuNumber = input.validateInput(3, 1);
            int selectedSubMenuNumber = menu.chooseMenu(selectedMenuNumber, display);
            switch (selectedSubMenuNumber){
                case 1:
                    display.printDisplayField(Display.SpecifyBoardSizeMsg);
                    int boardSize = input.validateInput(10, 5);
                    game.gameLoopAi(boardSize);
                    break;
                case 2:
                    display.printDisplayField(Display.SpecifyBoardSizeMsg);
                    boardSize = input.validateInput(10, 5);
                    game.gameLoop(boardSize);
                    break;
                case 3:
                    game.gameLoopDemo(5);
            }

            isRunning = false;
        }
    }
}