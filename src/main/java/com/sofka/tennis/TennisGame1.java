package com.sofka.tennis;

public class TennisGame1 implements TennisGame {
    
    private int mScore1 = 0;
    private int mScore2 = 0;


    public TennisGame1() {

    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            mScore1 += 1;
        else
            mScore2 += 1;
    }

    public String getScore() {
        String score = "";
        int tempScore=0;
        if (mScore1 == mScore2)
        {
            score = equalScore(mScore1);
        }
        else if(secondCase(mScore1, mScore2))
        {
            score = secondCaseScore();
        }
        else
        {
            score = setScore(mScore1) + "-" + setScore(mScore2);
        }
        return score;
    }

    private String setScore(int m_score){
        switch (m_score){
            case 0: return "Love";
            case 1: return "Fifteen";
            case 2: return "Thirty";
            default: return "Forty";
        }
    }

    private String equalScore(int m_score){
        switch (m_score)
        {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";

            default:
                return "Deuce";

        }
    }

    private String secondCaseScore(){
        int minusResult = mScore1 - mScore2;

        switch (minusResult){
            case 1:
            case -1: return advantage(minusResult);

        }
        if (minusResult>=2) return "Win for player1";
        else return "Win for player2";

    }

    private String advantage(int result){
        switch (result){
            case 1: return "Advantage player1";
            case -1: return "Advantage player2";
        }
        return "";
    }



    private boolean secondCase(int m_score1, int m_score2){

        return m_score1>=4 || m_score2>=4;
    }
}
