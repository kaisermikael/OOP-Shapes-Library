import kotlin.math.abs
import kotlin.math.sqrt

class Triangle(point1: Point, point2: Point, point3: Point) : Shape() {
    // Getters are public so the user can get all attributes of this shape
    var point1: Point
        private set
    var point2: Point
        private set
    var point3: Point
        private set

    init {
        // Check if all x on same line
        if (point1.xValue == point2.xValue && point2.xValue == point3.xValue && point1.xValue == point3.xValue) {
            // If x's are the same, points on the same y-axis
            throw IllegalArgumentException("Points cannot be on the same y-axis. Triangle creation aborted.")
        } else if (point1.yValue == point2.yValue && point2.yValue == point3.yValue && point1.yValue == point3.yValue) {
            // If y's are the same, points on the same x-axis
            throw IllegalArgumentException("Points cannot be on the same x-axis. Triangle creation aborted.")
        } else {
            this.point1 = point1
            this.point2 = point2
            this.point3 = point3
            // Check if the determinant (area) == 0 with these points
            if (calcArea() == 0.0) {
                throw IllegalArgumentException("Points cannot be on the same axis. Triangle creation aborted.")
            }
        }
    }

    override fun calcArea(): Double {
        return abs(.5*((point2.xValue - point1.xValue)*(point3.yValue - point1.yValue)
                - (point3.xValue - point1.xValue)*(point2.yValue - point1.yValue)))
    }

    override fun moveVertical(deltaVertical: Double) {
        this.point1.moveYValue(deltaVertical)
        this.point2.moveYValue(deltaVertical)
        this.point3.moveYValue(deltaVertical)
    }

    override fun moveHorizontal(deltaHorizontal: Double) {
        this.point1.moveXValue(deltaHorizontal)
        this.point2.moveXValue(deltaHorizontal)
        this.point3.moveXValue(deltaHorizontal)
    }
}