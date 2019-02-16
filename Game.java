
package tma2;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author user
 */
@WebService(serviceName = "Game")
public class Game {

    private int num;
    private int attempt;
    private boolean done;

    @WebMethod(operationName = "startGame")
    public synchronized String startGame() {	//Method to start the game

        this.num = (int)(Math.random()*101);	//Generate random integer between 0 and 100
        this.attempt = 0;			//Initialize number of guesses to 0 when game is started
        this.done = false;			//To indicate game is not done
        return "game started";
    }


    @WebMethod(operationName = "playGame")
    public synchronized String playGame(@WebParam(name = "num") int num) {
        attempt++;	//Increment number of attempts made
        if(done)	//For when correct guess has been made
            return "A correct guess has been made already";
        if(attempt<=5) {	//For when less than 5 guesses made
            if(this.num<num)
                return "Should be less";	//Hint if number guessed is greater than number generated
            else if(this.num>num)
                return "Should be greater"; //Hint if number guessed is less than number generated
            else {
                done = true;
                return "Correct";
            }
        }
        else {
            return "You have made more than 5 guesses";
        }

 }


}
