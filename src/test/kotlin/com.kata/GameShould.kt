package com.kata

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows

/*
    *   Meet the game ranking:
    *       - Scissors beats paper
    *       - Paper beats rock
    *       - Rock beats scissors
    *   It's the same element, they tie
    *
    *
     */
class GameShould : DescribeSpec({

    describe("Player 1 win when") {
        it("scissors beats paper") {
            val game = Game("scissors", "paper")

            val result = game.whoWins()

            result shouldBe "Player 1 win"
        }
        it("paper beats rock") {
            val game = Game("paper", "rock")

            val result = game.whoWins()

            result shouldBe "Player 1 win"
        }
        it("rock beats scissors") {
            val game = Game("rock", "scissors")

            val result = game.whoWins()

            result shouldBe "Player 1 win"
        }
        it("it's the same element") {
            val game = Game("rock", "rock")

            val result = game.whoWins()

            result shouldBe "Draw!!"
        }
    }

    describe("Player 2 win when") {
        it("rock beats scissors") {
            val game = Game("scissors", "rock")

            val result = game.whoWins()

            result shouldBe "Player 2 win"
        }
    }

    it("fail when any player make an incorrect choice") {
        val actualException = assertThrows<IllegalArgumentException> { Game("papa", "rock") }

        actualException.message shouldBe "Incorrect choice, 'papa'"
    }
})