import kotlin.math.sqrt

open class Ellipse(center: Point, horizontalRadius: Double, verticalRadius: Double) : Shape() {
    // Getters are public so the user can get all attributes of this shape
    var center: Point
        protected set
    var horizontalRadius: Double
        protected set
    var verticalRadius: Double
        protected set

    init {
        // Check if either radius == 0
        if (horizontalRadius == 0.0) {
            // If radius == 0, then the area == 0
            throw IllegalArgumentException("Horizontal Radius cannot be 0. Ellipse creation aborted.")
        } else if (verticalRadius == 0.0) {
            // If radius == 0, then the area == 0
            throw IllegalArgumentException("Vertical Radius cannot be 0. Ellipse creation aborted.")
        } else {
            this.center = center
            this.horizontalRadius = horizontalRadius
            this.verticalRadius = verticalRadius
        }
    }

    override fun calcArea(): Double {
        // Ellipse area => pi * horizRadius * vertRadius
        return (Math.PI * horizontalRadius * verticalRadius)
    }

    override fun moveVertical(deltaVertical: Double) {
        this.center.moveYValue(deltaVertical)
    }

    override fun moveHorizontal(deltaHorizontal: Double) {
        this.center.moveXValue(deltaHorizontal)
    }
}