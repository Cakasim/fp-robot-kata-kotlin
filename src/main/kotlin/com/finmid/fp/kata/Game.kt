package com.finmid.fp.kata

import com.finmid.fp.kata.Direction.*

fun moveRobot(
    textMap: String,
    moveCommands: String,
) = serialiseMap(
    parseMap(textMap).let {
        it.copy(robot = moveNextPosition(it.robot, parseCommands(moveCommands).first()))
    }
)

private fun moveNextPosition(robotPosition: Position, direction: Direction) = when (direction) {
    LEFT -> robotPosition.moveLeft()
    RIGHT -> robotPosition.moveRight()
    DOWN -> robotPosition.moveDown()
    UP -> robotPosition.moveUp()
}

private fun Position.moveRight() = Position(x + 1, y)
private fun Position.moveLeft() = Position(x - 1, y)
private fun Position.moveDown() = Position(x, y + 1)
private fun Position.moveUp() = Position(x, y - 1)