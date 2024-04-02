package com.kata

interface Choice {
    val whoBeats: Choice
    fun beats(choice: Choice): Boolean = choice == whoBeats

    companion object {
        fun of(name: String): Choice = when(name.uppercase()) {
            "SCISSORS" -> Scissors
            "PAPER" -> Paper
            "ROCK" -> Rock
            else -> throw IllegalArgumentException("Incorrect choice, '$name'")
        }
    }

    object Scissors: Choice {
        override val whoBeats: Choice
            get() = Paper

    }

    object Paper: Choice {
        override val whoBeats: Choice
            get() = Rock

    }

    object Rock: Choice {
        override val whoBeats: Choice
            get() = Scissors

    }
}

class Game(firstPlayerChoice: String, secondPlayerChoice: String) {
    private val firstPlayerChoice: Choice = Choice.of(firstPlayerChoice)
    private val secondPlayerChoice: Choice = Choice.of(secondPlayerChoice)

    fun whoWins(): String {
        if (firstPlayerChoice == secondPlayerChoice) {
            return "Draw!!"
        }
        if (firstPlayerChoice.beats(secondPlayerChoice)) {
            return "Player 1 win"
        }
        return "Player 2 win"
    }
}
