package com.finmid.fp.kata

@Suppress("UNUSED_PARAMETER")
fun moveRobot(
    textMap: String,
    moveCommands: String,
) = serialiseMap(
    parseMap(textMap).let {
        it.copy(robot = Position(it.robot.x + 1, it.robot.y))
    }
)
