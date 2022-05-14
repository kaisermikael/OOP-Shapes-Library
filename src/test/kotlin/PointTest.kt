import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class PointTest {

    @Test
    fun getXValue() {
        // Testing the basic getter functions
        val testPoint1 = Point(1.0, 2.0)
        val testPoint2 = Point(3.0, 4.0)

        assertEquals(testPoint1.xValue, 1.0)
        assertEquals(testPoint2.xValue, 3.0)

        // Validate that ONLY works with Double inputs
        val testPoint3 = Point(Double.NaN, Double.NaN)
        val testPoint4 = Point(Double.NaN, Double.NaN)
        assertNotEquals(testPoint3.xValue, 1.0)
        assertNotEquals(testPoint4.xValue, 3.0)
    }

    @Test
    fun getYValue() {
        // Testing the basic getter functions
        val testPoint1 = Point(1.0, 2.0)
        val testPoint2 = Point(3.0, 4.0)

        assertEquals(testPoint1.yValue, 2.0)
        assertEquals(testPoint2.yValue, 4.0)

        // Validate that ONLY works with Double inputs
        val testPoint3 = Point(Double.NaN, Double.NaN)
        val testPoint4 = Point(Double.NaN, Double.NaN)
        assertNotEquals(testPoint3.yValue, 2.0)
        assertNotEquals(testPoint4.yValue, 4.0)
    }

    @Test
    fun clonePoint() {
        // Testing point cloning functionality
        val testPoint1 = Point(1.0, 2.0)
        val testPoint2 = Point(3.0, 4.0)
        val point1Clone = testPoint1.clonePoint()
        val point2Clone = testPoint2.clonePoint()

        assertEquals(point1Clone.xValue, 1.0)
        assertEquals(point1Clone.yValue, 2.0)
        assertEquals(point2Clone.xValue, 3.0)
        assertEquals(point2Clone.yValue, 4.0)
    }

    @Test
    fun moveXValue() {
        // Test positive direction
        val testPoint1 = Point(1.0, 2.0)
        val testPoint2 = Point(3.0, 4.0)

        testPoint1.moveXValue(5.0)
        testPoint2.moveXValue(5.0)

        assertEquals(testPoint1.xValue, 6.0)
        assertEquals(testPoint2.xValue, 8.0)


        // Test negative direction
        val testPoint3 = Point(1.0, 2.0)
        val testPoint4 = Point(3.0, 4.0)

        testPoint3.moveXValue(-5.0)
        testPoint4.moveXValue(-5.0)

        assertEquals(testPoint3.xValue, -4.0)
        assertEquals(testPoint4.xValue, -2.0)
    }

    @Test
    fun moveYValue() {
        // Test positive direction
        val testPoint1 = Point(1.0, 2.0)
        val testPoint2 = Point(3.0, 4.0)

        testPoint1.moveYValue(5.0)
        testPoint2.moveYValue(5.0)

        assertEquals(testPoint1.yValue, 7.0)
        assertEquals(testPoint2.yValue, 9.0)


        // Test negative direction
        val testPoint3 = Point(1.0, 2.0)
        val testPoint4 = Point(3.0, 4.0)

        testPoint3.moveYValue(-5.0)
        testPoint4.moveYValue(-5.0)

        assertEquals(testPoint3.yValue, -3.0)
        assertEquals(testPoint4.yValue, -1.0)
    }
}