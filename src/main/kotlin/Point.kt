class Point(xValue: Double, yValue: Double) {
    // Getters are public so the user can get all attributes of this point
    var xValue: Double
        private set
    var yValue: Double
        private set

    init {
        this.xValue = xValue
        this.yValue = yValue
    }

    fun clonePoint(): Point {
        return Point(xValue, yValue)
    }
    fun moveXValue(deltaX: Double) {
        this.xValue += deltaX
    }
    fun moveYValue(deltaY: Double) {
        this.yValue += deltaY
    }
}