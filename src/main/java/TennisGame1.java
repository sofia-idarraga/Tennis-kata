
public class TennisGame1 implements TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        String score = "";
        int tempScore=0;
        if (m_score1==m_score2)
        {
            score = equalScore(m_score1);
        }
        else if(secondCase(m_score1,  m_score2))
        {
            score = secondCaseScore();
        }
        else
        {
            score = setScore(m_score1) + "-" + setScore(m_score2);
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
        int minusResult = m_score1-m_score2;
        /*
        if(Math.abs(minusResult)==1){
            return advantage(minusResult);
        }
        else

         */
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
