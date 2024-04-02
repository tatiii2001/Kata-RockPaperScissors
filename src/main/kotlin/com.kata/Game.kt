package com.kata

enum class ElementType{
    ROCK, PAPER, SCISSORS, SPOCK;
}

class Game(private val player1: String, private val player2 : String) {

    fun whoWins(): String {
        if(!isTheCorrectElement()){
            return "It's not the correct element"
        }
        firstWinnerAndSecondLoserCombination.forEach {
            if (it.first == this.player1 && it.second == this.player2){
                return  "Player 1 win"
            }
            if (it.second == this.player1 && it.first == this.player2){
                return "Player 2 win"
            }
        }
        return "Draw!!"
    }

    private fun isTheCorrectElement() : Boolean{
        try {
            ElementType.valueOf(this.player1.uppercase())
            ElementType.valueOf(this.player2.uppercase())
            return true
        } catch (error : IllegalArgumentException){
            return false
        }
    }

    private val firstWinnerAndSecondLoserCombination = listOf(
        Pair("scissors", "paper"),
        Pair("paper", "rock"),
        Pair("rock", "scissors"),
        Pair("paper", "Spock")
    )

}
