package guipractice;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Window;

public class GuiFXMLController implements Initializable {

    PlayersHand playerOneHand;
    public ArrayList PlayersHand;
    gameLogic game;
    Card card;
    Deck deck;
    int scorePlayerOne;
    int scorePlayerTwo;
    int scorePlayerThree;
    int scorePlayerFour;
    int scoreDealer;
    int moneyPlayerOne = 100;
    int moneyPlayerTwo = 100;
    int moneyPlayerThree = 100;
    int moneyPlayerFour = 100;
    int betPlayer1;
    int betPlayer2;
    int betPlayer3;
    int betPlayer4;

    private Label currentMoney;
    private Button hitButoon;
    private Button standButton;
    private Button DoubleDownButton;
    @FXML
    private Button playButton;
    @FXML
    private Label currentBet;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Label bettingLimit;
    @FXML
    private TextArea playerOneText;
    @FXML
    private Label currentScore1;
    @FXML
    private TextArea dealterText;
    @FXML
    private Label dealerScore;
    @FXML
    private TextArea playerTwoText;
    @FXML
    private TextArea playerThreeText;
    @FXML
    private TextArea playerFourText;
    @FXML
    private Label currentScore2;
    @FXML
    private Label currentScore3;
    @FXML
    private Label currentScore4;
    @FXML
    private Button hitButoon1;
    @FXML
    private Button standButton1;
    @FXML
    private Button DoubleDownButton1;
    @FXML
    private Button hitButoon2;
    @FXML
    private Button standButton2;
    @FXML
    private Button DoubleDownButton2;
    @FXML
    private Button hitButoon3;
    @FXML
    private Button standButton3;
    @FXML
    private Button DoubleDownButton3;
    @FXML
    private Button hitButoon4;
    @FXML
    private Button standButton4;
    @FXML
    private Button DoubleDownButton4;
    @FXML
    private ComboBox<String> amountOfPlayers;
    @FXML
    private TextField betAmuont1;
    @FXML
    private Label currentMoney1;
    @FXML
    private Label playerSelect;
    @FXML
    private Label currentMoney2;
    @FXML
    private TextField betAmuont2;
    @FXML
    private Label currentMoney3;
    @FXML
    private TextField betAmuont3;
    @FXML
    private Label currentMoney4;
    @FXML
    private TextField betAmuont4;
    @FXML
    private Label betError;
    FileChooser fileChooser = new FileChooser();
    ObservableList<String> players = FXCollections.observableArrayList("1 Player",
            "2 Players", "3 Players", "4 Players");

    @FXML
    private Label outcome1;
    @FXML
    private Label outcome2;
    @FXML
    private Label outcome3;
    @FXML
    private Label outcome4;
    @FXML
    private Button saveBtn;
    @FXML
    private Button homeBtn1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fileChooser.setInitialDirectory(new File
        ("C:\\Users\\andre\\Documents\\GitHub\\Stevens-n-Riberio-Final-Project-CIS-2151\\savedGames"));
        disableAllButtons();
        game = new gameLogic();
        card = new Card(Card.Face.ACE, Card.Suit.HEARTS);
        deck = new Deck(card);
        currentMoney1.setText("$ " + moneyPlayerOne);
        currentMoney2.setText("$ " + moneyPlayerTwo);
        currentMoney3.setText("$ " + moneyPlayerThree);
        currentMoney4.setText("$ " + moneyPlayerFour);
        betamounts(betAmuont1, betAmuont1.toString());
        amountOfPlayers.getItems().addAll(players);
        playerOneText.setDisable(true);
        playerTwoText.setDisable(true);
        playerThreeText.setDisable(true);
        playerFourText.setDisable(true);
        dealterText.setDisable(true);
        playButton.setDisable(true);
        betamounts(betAmuont1, betAmuont1.getText());
    }

    @FXML
    private void playClick(ActionEvent event) {
        //checkValidBet();
        outcome1.setText("");
        outcome2.setText("");
        outcome3.setText("");
        outcome4.setText("");
        enableAllButtons();
        scorePlayerOne = 0;
        scorePlayerTwo = 0;
        scorePlayerThree = 0;
        scorePlayerFour = 0;
        scoreDealer = 0;

        //Player One
        playerOneText.clear();
        Card playcard = deck.getRandomCard();
        scorePlayerOne += playcard.getCardValue(playcard);
        playerOneText.insertText(0, playcard.toString());
        playcard = deck.getRandomCard();
        playerOneText.insertText(0, playcard.toString());
        scorePlayerOne += playcard.getCardValue(playcard);
        currentScore1.setText(" " + scorePlayerOne);

        //Player Two
        playerTwoText.clear();
        playcard = deck.getRandomCard();
        scorePlayerTwo += playcard.getCardValue(playcard);
        playerTwoText.insertText(0, playcard.toString());
        playcard = deck.getRandomCard();
        playerTwoText.insertText(0, playcard.toString());
        scorePlayerTwo += playcard.getCardValue(playcard);
        String score2 = Integer.toString(scorePlayerTwo);
        currentScore2.setText(" " + score2);
        playButton.setDisable(true);

        //Player Three
        playerThreeText.clear();
        playcard = deck.getRandomCard();
        scorePlayerThree += playcard.getCardValue(playcard);
        playerThreeText.insertText(0, playcard.toString());
        playcard = deck.getRandomCard();
        playerThreeText.insertText(0, playcard.toString());
        scorePlayerThree += playcard.getCardValue(playcard);
        String score3 = Integer.toString(scorePlayerThree);
        currentScore3.setText(" " + score3);
        playButton.setDisable(true);

        //Player Four
        playerFourText.clear();
        playcard = deck.getRandomCard();
        scorePlayerFour += playcard.getCardValue(playcard);
        playerFourText.insertText(0, playcard.toString());
        playcard = deck.getRandomCard();
        playerFourText.insertText(0, playcard.toString());
        scorePlayerFour += playcard.getCardValue(playcard);
        String score4 = Integer.toString(scorePlayerFour);
        currentScore4.setText(" " + score4);
        playButton.setDisable(true);

        //Dealer
        dealterText.clear();
        playcard = deck.getRandomCard();
        scoreDealer += playcard.getCardValue(playcard);
        dealterText.insertText(0, playcard.toString());
        dealerScore.setText("???");

        //check amount of players and bets
        checkPlayers();
        amountOfPlayers.setDisable(true);
        // checkValidBet();
    }

    public void gameEnd() {
        playButton.setDisable(true);
        DoubleDownButton1.setDisable(true);
        standButton1.setDisable(true);
        hitButoon1.setDisable(true);
        currentMoney.setText("$0: GAME OVER");
    }

    public void enableAllButtons() {
        DoubleDownButton1.setDisable(false);
        standButton1.setDisable(false);
        hitButoon1.setDisable(false);
        DoubleDownButton2.setDisable(false);
        standButton2.setDisable(false);
        hitButoon2.setDisable(false);
        DoubleDownButton3.setDisable(false);
        standButton3.setDisable(false);
        hitButoon3.setDisable(false);
        DoubleDownButton4.setDisable(false);
        standButton4.setDisable(false);
        hitButoon4.setDisable(false);
    }

    public void disableAllButtons() {
        DoubleDownButton1.setDisable(true);
        standButton1.setDisable(true);
        hitButoon1.setDisable(true);
        DoubleDownButton2.setDisable(true);
        standButton2.setDisable(true);
        hitButoon2.setDisable(true);
        DoubleDownButton3.setDisable(true);
        standButton3.setDisable(true);
        hitButoon3.setDisable(true);
        DoubleDownButton4.setDisable(true);
        standButton4.setDisable(true);
        hitButoon4.setDisable(true);
    }

    @FXML
    private void hitClick1(ActionEvent event) {
        Card playcard = deck.getRandomCard();
        playerOneText.insertText(0, playcard.toString());
        DoubleDownButton1.setDisable(true);
        scorePlayerOne += playcard.getCardValue(playcard);
        currentScore1.setText(" " + scorePlayerOne);
        isPlayer1Over(scorePlayerOne);
        canPlayAgain();
    }

    @FXML
    private void standClick1(ActionEvent event) {
        hitButoon1.setDisable(true);
        DoubleDownButton1.setDisable(true);
        standButton1.setDisable(true);
        canPlayAgain();
    }

    @FXML
    private void dDownClick1(ActionEvent event) {
        Card playcard = deck.getRandomCard();
        playerOneText.insertText(0, playcard.toString());
        hitButoon1.setDisable(true);
        DoubleDownButton1.setDisable(true);
        standButton1.setDisable(true);
        scorePlayerOne += playcard.getCardValue(playcard);
        currentScore1.setText(" " + scorePlayerOne);
        isPlayer1Over(scorePlayerOne);
        canPlayAgain();
    }

    @FXML
    private void hitClick2(ActionEvent event) {
        Card playcard = deck.getRandomCard();
        // How to use gameLogic???  game.handHit(playcard);
        playerTwoText.insertText(0, playcard.toString());
        scorePlayerTwo += playcard.getCardValue(playcard);
        DoubleDownButton2.setDisable(true);
        currentScore2.setText(" " + scorePlayerTwo);
        isPlayer2Over(scorePlayerTwo);
        canPlayAgain();
    }

    @FXML
    private void standClick2(ActionEvent event) {
        hitButoon2.setDisable(true);
        DoubleDownButton2.setDisable(true);
        standButton2.setDisable(true);
        canPlayAgain();
    }

    @FXML
    private void dDownClick2(ActionEvent event) {
        Card playcard = deck.getRandomCard();
        playerTwoText.insertText(0, playcard.toString());
        hitButoon2.setDisable(true);
        DoubleDownButton2.setDisable(true);
        standButton2.setDisable(true);
        scorePlayerTwo += playcard.getCardValue(playcard);
        currentScore2.setText(" " + scorePlayerTwo);
        isPlayer2Over(scorePlayerTwo);
        canPlayAgain();
    }

    @FXML
    private void hitClick3(ActionEvent event) {
        Card playcard = deck.getRandomCard();
        playerThreeText.insertText(0, playcard.toString());
        scorePlayerThree += playcard.getCardValue(playcard);
        DoubleDownButton3.setDisable(true);
        currentScore3.setText(" " + scorePlayerThree);
        isPlayer3Over(scorePlayerThree);
        canPlayAgain();
    }

    @FXML
    private void standClick3(ActionEvent event) {
        hitButoon3.setDisable(true);
        DoubleDownButton3.setDisable(true);
        standButton3.setDisable(true);
        canPlayAgain();
    }

    @FXML
    private void dDownClick3(ActionEvent event) {
        Card playcard = deck.getRandomCard();
        playerThreeText.insertText(0, playcard.toString());
        hitButoon3.setDisable(true);
        DoubleDownButton3.setDisable(true);
        standButton3.setDisable(true);
        scorePlayerThree += playcard.getCardValue(playcard);
        currentScore3.setText(" " + scorePlayerThree);
        isPlayer3Over(scorePlayerThree);
        canPlayAgain();
    }

    @FXML
    private void hitClick4(ActionEvent event) {
        Card playcard = deck.getRandomCard();
        playerFourText.insertText(0, playcard.toString());
        scorePlayerFour += playcard.getCardValue(playcard);
        DoubleDownButton4.setDisable(true);
        currentScore4.setText(" " + scorePlayerFour);
        isPlayer4Over(scorePlayerFour);
        canPlayAgain();
    }

    @FXML
    private void standClick4(ActionEvent event) {
        hitButoon4.setDisable(true);
        DoubleDownButton4.setDisable(true);
        standButton4.setDisable(true);
        canPlayAgain();
    }

    @FXML
    private void dDownClick4(ActionEvent event) {
        Card playcard = deck.getRandomCard();
        playerFourText.insertText(0, playcard.toString());
        hitButoon4.setDisable(true);
        DoubleDownButton4.setDisable(true);
        standButton4.setDisable(true);
        scorePlayerFour += playcard.getCardValue(playcard);
        currentScore4.setText(" " + scorePlayerFour);
        isPlayer4Over(scorePlayerFour);
        canPlayAgain();
    }

    @FXML
    private void amountOfPlayers(ActionEvent event) {
        playButton.setDisable(false);
        if (amountOfPlayers.getValue().equals("1 Player")) {
            hitButoon2.setDisable(true);
            hitButoon3.setDisable(true);
            hitButoon4.setDisable(true);
            standButton2.setDisable(true);
            standButton3.setDisable(true);
            standButton4.setDisable(true);
            DoubleDownButton2.setDisable(true);
            DoubleDownButton3.setDisable(true);
            DoubleDownButton4.setDisable(true);
            playerTwoText.clear();
            playerThreeText.clear();
            playerFourText.clear();
            betAmuont2.setDisable(true);
            betAmuont3.setDisable(true);
            betAmuont4.setDisable(true);
        }
        if (amountOfPlayers.equals("2 Players")) {
            hitButoon3.setDisable(true);
            hitButoon4.setDisable(true);
            standButton3.setDisable(true);
            standButton4.setDisable(true);
            DoubleDownButton3.setDisable(true);
            DoubleDownButton4.setDisable(true);
            playerThreeText.clear();
            playerFourText.clear();
            betAmuont3.setDisable(true);
            betAmuont4.setDisable(true);
            currentMoney3.setText("");
            currentMoney4.setText("");

        }
        if (amountOfPlayers.equals("3 Players")) {
            hitButoon4.setDisable(true);
            standButton4.setDisable(true);
            DoubleDownButton4.setDisable(true);
            playerFourText.clear();
            betAmuont4.setDisable(true);
            currentMoney4.setText("");

        }
    }

    public void canPlayAgain() {
        if (DoubleDownButton1.isDisabled() && standButton1.isDisabled()
                && hitButoon1.isDisabled() && DoubleDownButton2.isDisabled()
                && standButton2.isDisabled() && hitButoon2.isDisabled()
                && DoubleDownButton3.isDisabled() && standButton3.isDisabled()
                && hitButoon3.isDisabled() && DoubleDownButton4.isDisabled()
                && standButton4.isDisabled() && hitButoon4.isDisabled()) {
            playButton.setDisable(false);
            betAmuont1.setDisable(false);
            betAmuont2.setDisable(false);
            betAmuont3.setDisable(false);
            betAmuont4.setDisable(false);

            //dealer logic
            while (scoreDealer < 17) {
                Card playcard = deck.getRandomCard();
                scoreDealer += playcard.getCardValue(playcard);
                dealterText.insertText(0, playcard.toString());
                dealerScore.setText("" + scoreDealer);
                if (scoreDealer > 21) {
                    dealerScore.setText("");
                    dealerScore.setText("OVER " + scoreDealer);
                }
            }

            winOrLossPlayer1(betPlayer1, moneyPlayerOne, scorePlayerOne);
            winOrLossPlayer2(betPlayer2, moneyPlayerTwo, scorePlayerTwo);
            winOrLossPlayer3(betPlayer3, moneyPlayerThree, scorePlayerThree);
            winOrLossPlayer4(betPlayer4, moneyPlayerFour, scorePlayerFour);
        }
    }

    public void isPlayer1Over(int score) {
        if (score > 21) {
            hitButoon1.setDisable(true);
            DoubleDownButton1.setDisable(true);
            standButton1.setDisable(true);
            currentScore1.setText("OVER: " + scorePlayerOne);
        }
    }

    public void isPlayer2Over(int score) {
        if (score > 21) {
            hitButoon2.setDisable(true);
            DoubleDownButton2.setDisable(true);
            standButton2.setDisable(true);
            currentScore2.setText("OVER: " + scorePlayerTwo);
        }
    }

    public void isPlayer3Over(int score) {
        if (score > 21) {
            hitButoon3.setDisable(true);
            DoubleDownButton3.setDisable(true);
            standButton3.setDisable(true);
            currentScore3.setText("OVER: " + scorePlayerThree);
        }
    }

    public void isPlayer4Over(int score) {
        if (score > 21) {
            hitButoon4.setDisable(true);
            DoubleDownButton4.setDisable(true);
            standButton4.setDisable(true);
            currentScore4.setText("OVER: " + scorePlayerFour);
        }
    }

    public void winOrLossPlayer1(int bet, int pot, int score) {
        //win
        if (score <= 21 && score > scoreDealer || score <= 21 && scoreDealer > 21) {
            pot += bet;
            outcome1.setText("YOU WIN");
        }
        //loss
        if (score <= 21 && scoreDealer <= 21 && score < scoreDealer || score > 21 && scoreDealer < 21) {
            pot -= bet;
            outcome1.setText("YOU LOSE");

        }
        //tie
        if (score == scoreDealer || score > 21 && scoreDealer > 21) {
            outcome1.setText("YOU TIE");

        }

    }

    public void winOrLossPlayer2(int bet, int pot, int score) {
        //win
        if (score <= 21 && score > scoreDealer || score <= 21 && scoreDealer > 21) {
            pot += bet;
            outcome2.setText("YOU WIN");
        }
        //loss
        if (score <= 21 && scoreDealer <= 21 && score < scoreDealer || score > 21 && scoreDealer < 21) {
            pot -= bet;
            outcome2.setText("YOU LOSE");

        }
        //tie
        if (score == scoreDealer || score > 21 && scoreDealer > 21) {
            outcome2.setText("YOU TIE");

        }

    }

    public void winOrLossPlayer3(int bet, int pot, int score) {
        //win
        if (score <= 21 && score > scoreDealer || score <= 21 && scoreDealer > 21) {
            pot += bet;
            outcome3.setText("YOU WIN");
        }
        //loss
        if (score <= 21 && scoreDealer <= 21 && score < scoreDealer || score > 21 && scoreDealer < 21) {
            pot -= bet;
            outcome3.setText("YOU LOSE");

        }
        //tie
        if (score == scoreDealer || score > 21 && scoreDealer > 21) {
            outcome3.setText("YOU TIE");

        }

    }

    public void winOrLossPlayer4(int bet, int pot, int score) {
        //win
        if (score <= 21 && score > scoreDealer || score <= 21 && scoreDealer > 21) {
            pot += bet;
            outcome4.setText("YOU WIN");
        }
        //loss
        if (score <= 21 && scoreDealer <= 21 && score < scoreDealer || score > 21 && scoreDealer <= 21) {
            pot -= bet;
            outcome4.setText("YOU LOSE");

        }
        //tie
        if (score == scoreDealer || score > 21 && scoreDealer > 21) {
            outcome4.setText("YOU TIE");

        }
    }

    public void checkValidBet() {
        //bet player 1
        int betnum1 = Integer.parseInt(betAmuont1.getText());
        if (betnum1 > 100 || betnum1 < 1 || betAmuont1.getText().isEmpty()) {
            hitButoon1.setDisable(true);
            DoubleDownButton1.setDisable(true);
            standButton1.setDisable(true);
            playerOneText.clear();
            betError.setText("Enter a valid bet");
        } else if (betnum1 < 100 || betnum1 > 1) {
            betError.setText("");
            //currentMoney1 =- betnum1;
        }

        //bet player 2
        int betnum2 = Integer.parseInt(betAmuont2.getText());
        if (betnum2 > 100 || betnum2 < 1 || betAmuont2.getText().isEmpty()) {
            hitButoon2.setDisable(true);
            DoubleDownButton2.setDisable(true);
            standButton2.setDisable(true);
            playerTwoText.clear();
            betError.setText("Enter a valid bet");
        } else if (betnum2 < 100 || betnum2 > 1) {
            betError.setText("");
            //currentMoney1 =- betnum1;
        }

        //bet player 3
        int betnum3 = Integer.parseInt(betAmuont3.getText());
        if (betnum3 > 100 || betnum3 < 1 || betAmuont3.getText().isEmpty()) {
            hitButoon3.setDisable(true);
            DoubleDownButton3.setDisable(true);
            standButton3.setDisable(true);
            playerThreeText.clear();
            betError.setText("Enter a valid bet");
        } else if (betnum3 < 100 || betnum3 > 1) {
            betError.setText("");
            //currentMoney1 =- betnum1;
        }

        //bet player 3
        int betnum4 = Integer.parseInt(betAmuont4.getText());
        if (betnum4 > 100 || betnum4 < 1 || betAmuont4.getText().isEmpty()) {
            hitButoon4.setDisable(true);
            DoubleDownButton4.setDisable(true);
            standButton4.setDisable(true);
            playerFourText.clear();
            betError.setText("Enter a valid bet");
        } else if (betnum4 < 100 || betnum4 > 1) {
            betError.setText("");
            //currentMoney1 =- betnum1;
        }
    }

    public void checkPlayers() {
        if (amountOfPlayers.getValue().equals("1 Player")) {
            hitButoon2.setDisable(true);
            hitButoon3.setDisable(true);
            hitButoon4.setDisable(true);
            standButton2.setDisable(true);
            standButton3.setDisable(true);
            standButton4.setDisable(true);
            DoubleDownButton2.setDisable(true);
            DoubleDownButton3.setDisable(true);
            DoubleDownButton4.setDisable(true);
            betAmuont4.setDisable(true);
            betAmuont3.setDisable(true);
            betAmuont2.setDisable(true);
            playerTwoText.clear();
            playerThreeText.clear();
            playerFourText.clear();
            currentScore2.setText("");
            currentScore3.setText("");
            currentScore4.setText("");
            currentMoney2.setText("");
            currentMoney3.setText("");
            currentMoney4.setText("");
            playButton.setDisable(false);

        }
        if (amountOfPlayers.getValue().equals("2 Players")) {
            hitButoon3.setDisable(true);
            hitButoon4.setDisable(true);
            standButton3.setDisable(true);
            standButton4.setDisable(true);
            DoubleDownButton3.setDisable(true);
            DoubleDownButton4.setDisable(true);
            betAmuont4.setDisable(true);
            betAmuont3.setDisable(true);
            playerThreeText.clear();
            playerFourText.clear();
            playButton.setDisable(false);
            currentScore3.setText("");
            currentScore4.setText("");
            currentMoney3.setText("");
            currentMoney4.setText("");

        }
        if (amountOfPlayers.getValue().equals("3 Players")) {
            hitButoon4.setDisable(true);
            standButton4.setDisable(true);
            DoubleDownButton4.setDisable(true);
            betAmuont4.setDisable(true);
            playerFourText.clear();
            playButton.setDisable(false);
            currentScore4.setDisable(true);
            currentMoney4.setText("");

        }
        if (amountOfPlayers.getValue().equals("4 Players")) {
            playButton.setDisable(false);

        } else {
            playButton.setDisable(true);
        }
    }

    //https://www.youtube.com/watch?v=cwJK_WpseKQ help from video
    public boolean betamounts(TextField text, String bet) {
        try {
            int input = Integer.parseInt(text.getText());
            System.out.println(input);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Error not number");
            return false;
        }

    }

    @FXML
    private void saveClick(ActionEvent event) {
        Window stageWindow = anchorPane.getScene().getWindow();
        fileChooser.setTitle("Saved Games");
        fileChooser.setInitialFileName("BlackJackGame");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter(".java", "*.java"));
        fileChooser.showSaveDialog(stageWindow);
        fileChooser.getInitialDirectory().getParentFile();
    }

    @FXML
    private void homeClick(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("homePage.fxml"));
        anchorPane.getChildren().setAll(pane);
    }
}
