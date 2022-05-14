import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertFailsWith

internal class LineTest {

    @Test
    fun getPoints() {
        // Testing the basic getter functions
        val testPoint1 = Point(1.0, 2.0)
        val testPoint2 = Point(3.0, 4.0)
        val testLine1 = Line(testPoint1, testPoint2)

        assertEquals(testLine1.point1.xValue, 1.0)
        assertEquals(testLine1.point2.xValue, 3.0)
        assertEquals(testLine1.point1.yValue, 2.0)
        assertEquals(testLine1.point2.yValue, 4.0)

        // Validate that ONLY works with Double inputs
        val testPoint3 = Point(Double.NaN, Double.NaN)
        val testPoint4 = Point(Double.NaN, Double.NaN)
        val testLine2 = Line(testPoint3, testPoint4)
        assertNotEquals(testLine2.point1.xValue, 1.0)
        assertNotEquals(testLine2.point2.xValue, 3.0)
        assertNotEquals(testLine2.point1.yValue, 2.0)
        assertNotEquals(testLine2.point2.yValue, 4.0)
    }

    @Test
    fun calcSlope() {
        val testPoint1 = Point(1.0, 2.0)
        val testPoint2 = Point(3.0, 4.0)
        val testLine1 = Line(testPoint1, testPoint2)

        assertEquals(testLine1.calcSlope(), 1.0)

        // Test with Points Flipped
        val testPoint3 = Point(3.0, 4.0)
        val testPoint4 = Point(1.0, 2.0)
        val testLine2 = Line(testPoint3, testPoint4)

        assertEquals(testLine2.calcSlope(), 1.0)

        // Test absolutely random line
        val testPoint5 = Point(65.32, 1045.256)
        val testPoint6 = Point(-5198.1, 34.01)
        val testLine3 = Line(testPoint5, testPoint6)

        assertEquals(testLine3.calcSlope(), 0.19212717206683108)
    }

    @Test
    fun calcLength() {
        val testPoint1 = Point(1.0, 2.0)
        val testPoint2 = Point(3.0, 4.0)
        val testLine1 = Line(testPoint1, testPoint2)

        assertEquals(testLine1.calcSlope(), 1.0)

        // Test points flipped
        val testPoint3 = Point(3.0, 4.0)
        val testPoint4 = Point(1.0, 2.0)
        val testLine2 = Line(testPoint3, testPoint4)

        assertEquals(testLine2.calcSlope(), 1.0)
    }

    @Test
    fun testLengthZero() {
        // Test that an exception is thrown if length == 0
        val testPoint1 = Point(1.0, 2.0)
        val testPoint2 = Point(1.0, 2.0)

        assertFailsWith<IllegalArgumentException> {
            Line(testPoint1, testPoint2)
        }
    }

    @Test
    fun moveVertical() {
        // Test positive direction
        val testPoint1 = Point(1.0, 2.0)
        val testPoint2 = Point(3.0, 4.0)
        val testLine1 = Line(testPoint1, testPoint2)
        testLine1.moveVertical(5.0)

        assertEquals(testLine1.point1.xValue, 1.0)
        assertEquals(testLine1.point2.xValue, 3.0)
        assertEquals(testLine1.point1.yValue, 7.0)
        assertEquals(testLine1.point2.yValue, 9.0)

        // Test negative direction
        val testPoint3 = Point(1.0, 2.0)
        val testPoint4 = Point(3.0, 4.0)
        val testLine2 = Line(testPoint3, testPoint4)
        testLine2.moveVertical(-5.0)

        assertEquals(testLine2.point1.xValue, 1.0)
        assertEquals(testLine2.point2.xValue, 3.0)
        assertEquals(testLine2.point1.yValue, -3.0)
        assertEquals(testLine2.point2.yValue, -1.0)
    }

    @Test
    fun moveHorizontal() {
        // Test positive direction
        val testPoint1 = Point(1.0, 2.0)
        val testPoint2 = Point(3.0, 4.0)
        val testLine1 = Line(testPoint1, testPoint2)
        testLine1.moveHorizontal(5.0)

        assertEquals(testLine1.point1.xValue, 6.0)
        assertEquals(testLine1.point2.xValue, 8.0)
        assertEquals(testLine1.point1.yValue, 2.0)
        assertEquals(testLine1.point2.yValue, 4.0)

        // Test negative direction
        val testPoint3 = Point(1.0, 2.0)
        val testPoint4 = Point(3.0, 4.0)
        val testLine2 = Line(testPoint3, testPoint4)
        testLine2.moveHorizontal(-5.0)

        assertEquals(testLine2.point1.xValue, -4.0)
        assertEquals(testLine2.point2.xValue, -2.0)
        assertEquals(testLine2.point1.yValue, 2.0)
        assertEquals(testLine2.point2.yValue, 4.0)
    }
}