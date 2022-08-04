package com.sofka.tennis;

public class TennisGame2 implements TennisGame
{
    public int P1point = 0;
    public int P2point = 0;
    
    public String P1res = "";
    public String P2res = "";


    public TennisGame2() {

    }

    public String getScore(){
        String score = "";
        if (isEqualLow(P1point,P2point))
        {
            score = setPointRes(P1point).concat("-All");
        }
        else if (isEqualhigh(P1point, P2point)){
            score = "Deuce";
        }else{
            score = setPointRes(P1point)+"-"+setPointRes(P2point);
        }
        
        if (isAdvantage(P1point,P2point))
        {
            score = "Advantage player1";
        }
        
        if (isAdvantage(P2point,P1point))
        {
            score = "Advantage player2";
        }
        
        if (isWin(P1point,P2point))
        {
            score = "Win for player1";
        }
        if (isWin(P2point,P1point))
        {
            score = "Win for player2";
        }

        return score;
    }

    public boolean isWin(int p1, int p2){
        return p1>=4 && p2>=0 && (p1-p2)>=2;
    }
    public boolean isAdvantage(int p1, int p2) {
        return  p1 > p2 && p2 >= 3;
    }

    public void P1Score(){
        P1point++;
    }
    
    public void P2Score(){
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }

    public boolean isEqualLow(int p1, int p2){
        return p1 == p2 && p1 < 3;
    }

    public boolean isEqualhigh(int p1, int p2){
        return p1 == p2 && p1>=3;
    }

    public String setPointRes(int point){
        switch (point){
            case 0: return "Love";
            case 1: return "Fifteen";
            case 2: return "Thirty";
            default: return "Forty";
        }
    }
}