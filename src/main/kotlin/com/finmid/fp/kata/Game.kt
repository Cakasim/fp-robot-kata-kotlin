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

fun moveNextPosition(robotPosition: Position, direction: Direction) = when (direction) {
    LEFT -> robotPosition.moveLeft()
    RIGHT -> robotPosition.moveRight()
    DOWN -> robotPosition.moveDown()
    else -> TODO()
}

fun Position.moveRight() = Position(x + 1, y)
fun Position.moveLeft() = Position(x - 1, y)
fun Position.moveDown() = Position(x, y + 1)