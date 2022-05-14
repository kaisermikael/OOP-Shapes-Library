import kotlin.math.sqrt

class Circle(center: Point, horizontalRadius: Double, verticalRadius: Double) : Ellipse(center, horizontalRadius, verticalRadius) {
    // Inherits from Ellipse
    private fun isCircle(): Boolean {
        return horizontalRadius == verticalRadius
    }

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
        if (!isCircle()) {
            throw IllegalArgumentException("Radii do not form a circle (H.Radius != V.Radius). Circle creation aborted.")
        }
    }

}