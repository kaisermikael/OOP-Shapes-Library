import kotlin.math.sqrt

open class Rectangle(point1: Point, point2: Point) : Shape() {
    // Getters are public so the user can get all attributes of this shape
    var point1: Point
        protected set
    var point2: Point
        protected set

    init {
        // Check if width == 0
        if (point1.xValue == point2.xValue) {
            // If x's are the same, points on the same y-axis
            throw IllegalArgumentException("Points cannot be on the same y-axis. Rectangle creation aborted.")
        } else if (point1.yValue == point2.yValue) {
            // If y's are the same, points on the same x-axis
            throw IllegalArgumentException("Points cannot be on the same x-axis. Rectangle creation aborted.")
        } else {
            this.point1 = point1
            this.point2 = point2
        }
    }

    override fun calcArea(): Double {
        val width = sqrt((point2.xValue - point1.xValue) * (point2.xValue - point1.xValue))
        val height = sqrt((point2.yValue - point1.yValue) * (point2.yValue - point1.yValue))
        return (width * height)
    }

    override fun moveVertical(deltaVertical: Double) {
        this.point1.moveYValue(deltaVertical)
        this.point2.moveYValue(deltaVertical)
    }

    override fun moveHorizontal(deltaHorizontal: Double) {
        this.point1.moveXValue(deltaHorizontal)
        this.point2.moveXValue(deltaHorizontal)
    }
}