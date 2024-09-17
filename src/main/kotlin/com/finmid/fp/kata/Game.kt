package com.finmid.fp.kata

fun moveRobot(
    textMap: String,
    moveCommands: String,
) = serialiseMap(
    parseMap(textMap).let {
        it.copy(robot = moveNextPosition(it.robot, parseCommands(moveCommands).first()))
    }
)

fun moveNextPosition(robotPosition: Position, direction: Direction) = when (direction) {
    Direction.LEFT -> Position(robotPosition.x - 1, robotPosition.y)
    Direction.RIGHT -> Position(robotPosition.x + 1, robotPosition.y)
    else -> TODO()
}
