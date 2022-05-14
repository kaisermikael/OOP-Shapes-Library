import kotlin.math.sqrt

class Square(point1: Point, point2: Point) : Rectangle(point1, point2) {
    // Inherits from Rectangle
    private fun isSquare(): Boolean {
        val width = sqrt((point2.xValue - point1.xValue) * (point2.xValue - point1.xValue))
        val height = sqrt((point2.yValue - point1.yValue) * (point2.yValue - point1.yValue))
        return width == height
    }

    init {
        // Check if width == 0
        // Overwriting Super-Class Initialization to use proper exception handling
        if (point1.xValue == point2.xValue) {
            // If x's are the same, points on the same y-axis
            throw IllegalArgumentException("Points cannot be on the same y-axis. Square creation aborted.")
        } else if (point1.yValue == point2.yValue) {
            // If y's are the same, points on the same x-axis
            throw IllegalArgumentException("Points cannot be on the same x-axis. Square creation aborted.")
        } else {
            this.point1 = point1
            this.point2 = point2
        }
        if (!isSquare()) {
            throw IllegalArgumentException("Coordinates do not form a square (width != height). Square creation aborted.")
        }
    }

}