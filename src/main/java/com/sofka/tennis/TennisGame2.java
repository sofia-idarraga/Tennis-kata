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
        
        if (P1point > P2point && P2point >= 3)
        {
            score = "Advantage player1";
        }
        
        if (P2point > P1point && P1point >= 3)
        {
            score = "Advantage player2";
        }
        
        if (P1point>=4 && P2point>=0 && (P1point-P2point)>=2)
        {
            score = "Win for player1";
        }
        if (P2point>=4 && P1point>=0 && (P2point-P1point)>=2)
        {
            score = "Win for player2";
        }

        return score;
    }
    
    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P1Score();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P2Score();
        }
            
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

    public boolean p1GreaterP2Zero(int p1, int p2){
        return p1 > 0 && p2==0;
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