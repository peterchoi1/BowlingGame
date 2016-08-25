package ssa;

public class SimulatedBowling {

    // instance array that holds the scores, i used [i][11] to hold the total scores for each game
    private int bowlingScores[][] = new int[3][11];
    //private int frame[] = { 1,2,3,4,5,6,7,8,9,10 };

    
    // executes the bowling game and returns each game and total scores in a formatted output
    public void bowl() {

        for (int idxo = 0; idxo < bowlingScores.length; idxo++) {

            for (int idxi = 0; idxi < bowlingScores[idxo].length - 1; idxi++) {
                bowlingScores[idxo][idxi] = getPinsKnockedDown();
            }
        }
        
        System.out.println(print());

    }

//    private String frameFormat() {
//        String formatter = "";
//        for(int i = 0; i < frame.length; i++) {
//            formatter += frame[i] + "\t";
//        }
//        
//        return "Frames\t\t" + formatter + "Total";
//        
//    }
    
    // returns a string that prints out each game and the scores
    public String print() {
        return printTitle() + "\n" + printGame1() + "\n" 
                + printGame2() + "\n" + printGame3() + "\n" + printEnding();
    }

    // used within the print() method for title
    private String printTitle() {
        return "Frames\t\t1\t2\t3\t4\t5\t6\t7\t8\t9\t10\tTotal";
    }

 // used within the print() method for game1 score
    private String printGame1() {
        String game1Scores = "Game1\t\t";
        int game1TotalScore = 0;
        for (int idxo = 0; idxo < bowlingScores[0].length - 1; idxo++) {
            game1Scores += bowlingScores[0][idxo] + "\t";
            game1TotalScore += bowlingScores[0][idxo];
        }

        bowlingScores[0][10] = game1TotalScore;
        return game1Scores + game1TotalScore;
    }

 // used within the print() method for game 2 score
    private String printGame2() {
        String game2Scores = "Game2\t\t";
        int game2TotalScore = 0;
        for (int idxo = 0; idxo < bowlingScores[1].length - 1; idxo++) {
            game2Scores += bowlingScores[1][idxo] + "\t";
            game2TotalScore += bowlingScores[1][idxo];
        }
        bowlingScores[1][10] = game2TotalScore;
        return game2Scores + game2TotalScore;

    }

 // used within the print() method for game 3 score
    private String printGame3() {
        String game3Scores = "Game3\t\t";
        int game3TotalScore = 0;
        for (int idxo = 0; idxo < bowlingScores[2].length - 1; idxo++) {
            game3Scores += bowlingScores[2][idxo] + "\t";
            game3TotalScore += bowlingScores[2][idxo];
        }
        bowlingScores[2][10] = game3TotalScore;
        return game3Scores + game3TotalScore;

    }

 // used within the print() method for ending total scores
    private String printEnding() {
        String finalTotal = "Total Series\t\t\t\t\t\t\t\t\t\t\t";
        return finalTotal + (bowlingScores[0][10] + bowlingScores[1][10] + bowlingScores[2][10]);
    }

    // random number generator for pins knocked down, if first 
    // roll was not 10 then it runs the random number generator again
    // and adds it to totalKnockedDown
    private int getPinsKnockedDown() {
        int totalKnockedDown = 0;
        int mathRandomInt = (int) (Math.random() * 10);
        
        totalKnockedDown = mathRandomInt;

        if(mathRandomInt != 10) {
            int remainingPins = 10 - mathRandomInt;
            mathRandomInt = (int) (Math.random() * remainingPins);
            totalKnockedDown += mathRandomInt;
            
        }
        return totalKnockedDown;
    }

}
