import kotlin.math.*

class Line(point1: Point, point2: Point) {
    // Getters are public so the user can get all attributes of this line
    var point1: Point
        private set
    var point2: Point
        private set

    init {
        // Check if length == 0
        if (point1.xValue == point2.xValue && point1.yValue == point2.yValue) {
            throw IllegalArgumentException("Points cannot be on the same coordinates. Line creation aborted.")
        } else {
            this.point1 = point1
            this.point2 = point2
        }
    }

    fun calcSlope(): Double {
        return ((point2.yValue - point1.yValue) / (point2.xValue - point1.xValue))
    }

    fun calcLength(): Double {
        val xPart = (point2.xValue - point1.xValue) * (point2.xValue - point1.xValue)
        val yPart = (point2.yValue - point1.yValue) * (point2.yValue - point1.yValue)
        return sqrt(xPart + yPart)
    }

    fun moveVertical(deltaVertical: Double) {
        this.point1.moveYValue(deltaVertical)
        this.point2.moveYValue(deltaVertical)
    }

    fun moveHorizontal(deltaHorizontal: Double) {
        this.point1.moveXValue(deltaHorizontal)
        this.point2.moveXValue(deltaHorizontal)
    }

}