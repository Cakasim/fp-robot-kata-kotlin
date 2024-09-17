package com.finmid.fp.kata

import com.finmid.fp.kata.Direction.DOWN
import com.finmid.fp.kata.Direction.LEFT
import com.finmid.fp.kata.Direction.RIGHT
import com.finmid.fp.kata.Direction.UP

fun moveRobot(
    textMap: String,
    moveCommands: String,
) = serialiseMap(
    parseMap(textMap).let { map ->
        parseCommands(moveCommands).fold(map) { currMap, cmd ->
            currMap.copy(robot = currMap.moveNextPosition(cmd))
        }
    }
)

private fun Map.moveNextPosition(direction: Direction) = when (direction) {
    LEFT -> robot.tryMoveLeft()
    RIGHT -> robot.tryMoveRight(width)
    DOWN -> robot.tryMoveDown(height)
    UP -> robot.tryMoveUp()
}

private fun Position.moveRight() = Position(x + 1, y)
private fun Position.moveLeft() = Position(x - 1, y)
private fun Position.moveDown() = Position(x, y + 1)
private fun Position.moveUp() = Position(x, y - 1)

private fun Position.canMoveLeft() = x > 0
private fun Position.canMoveRight(width: Int) = x < width - 1
private fun Position.canMoveDown(height: Int) = y < height - 1
private fun Position.canMoveUp() = y > 0

private fun Position.tryMoveLeft() = if (canMoveLeft()) moveLeft() else this
private fun Position.tryMoveRight(width: Int) = if (canMoveRight(width)) moveRight() else this
private fun Position.tryMoveDown(height: Int) = if (canMoveDown(height)) moveDown() else this
private fun Position.tryMoveUp() = if (canMoveUp()) moveUp() else this