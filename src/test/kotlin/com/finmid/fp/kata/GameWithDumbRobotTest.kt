package com.finmid.fp.kata

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class GameWithDumbRobotTest {
    @Test
    fun `robot moves to the right`() {
        val result =
            moveRobot(
                """
                R..
                ...
                ...
                """.trimIndent(),
                "R",
            )

        result shouldBe
                """
            .R.
            ...
            ...
            """.trimIndent()
    }

    @Test
    fun `robot moves to the left`() {
        val result =
            moveRobot(
                """
                .R.
                ...
                ...
                """.trimIndent(),
                "L",
            )

        result shouldBe
                """
            R..
            ...
            ...
            """.trimIndent()
    }

    @Test
    fun `robot moves to the down`() {
        val result =
            moveRobot(
                """
                R..
                ...
                ...
                """.trimIndent(),
                "D",
            )

        result shouldBe
                """
            ...
            R..
            ...
            """.trimIndent()
    }

    @Test
    fun `robot moves to the up`() {
        val result =
            moveRobot(
                """
                ...
                R..
                ...
                """.trimIndent(),
                "U",
            )

        result shouldBe
                """
            R..
            ...
            ...
            """.trimIndent()
    }

    @Test
    fun `given robot tries to move to the left without space should stay on place`() {
        val result =
            moveRobot(
                """
                R..
                ...
                ...
                """.trimIndent(),
                "L",
            )

        result shouldBe """
            R..
            ...
            ...
            """.trimIndent()
    }

    @Test
    fun `given robot tries to move to the right without space should stay on place`() {
        val result =
            moveRobot(
                """
                ..R
                ...
                ...
                """.trimIndent(),
                "L",
            )

        result shouldBe """
            ..R
            ...
            ...
            """.trimIndent()
    }

    @Test
    fun `robot moves multiple times`() {
        val result =
            moveRobot(
                """
                R..
                ...
                ...
                """.trimIndent(),
                "RDRDLU",
            )

        result shouldBe
                """
            ...
            .R.
            ...
            """.trimIndent()
    }

    @Test
    fun `robot moves multiple times and hits the wall`() {
        val result =
            moveRobot(
                """
                R..
                ...
                ...
                """.trimIndent(),
                "RRRRRRRR",
            )

        result shouldBe
                """
            ..R
            ...
            ...
            """.trimIndent()
    }

    @Test
    fun `robot moves and hits the tree`() {
        val result =
            moveRobot(
                """
                R..
                .T.
                ...
                """.trimIndent(),
                "RD",
            )

        result shouldBe
                """
            .R.
            .T.
            ...
            """.trimIndent()
    }
}
