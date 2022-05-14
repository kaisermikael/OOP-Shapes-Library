import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertFailsWith

internal class RectangleTest {

    @Test
    fun getPoints() {
        // Testing the basic getter functions
        val testPoint1 = Point(1.0, 2.0)
        val testPoint2 = Point(3.0, 4.0)
        val testRectangle1 = Rectangle(testPoint1, testPoint2)

        assertEquals(testRectangle1.point1.xValue, 1.0)
        assertEquals(testRectangle1.point2.xValue, 3.0)
        assertEquals(testRectangle1.point1.yValue, 2.0)
        assertEquals(testRectangle1.point2.yValue, 4.0)

        // Validate that ONLY works with Double inputs
        val testPoint3 = Point(Double.NaN, Double.NaN)
        val testPoint4 = Point(Double.NaN, Double.NaN)
        val testRectangle2 = Rectangle(testPoint3, testPoint4)
        assertNotEquals(testRectangle2.point1.xValue, 1.0)
        assertNotEquals(testRectangle2.point2.xValue, 3.0)
        assertNotEquals(testRectangle2.point1.yValue, 2.0)
        assertNotEquals(testRectangle2.point2.yValue, 4.0)
    }

    @Test
    fun calcArea() {
        val testPoint1 = Point(1.0, 2.0)
        val testPoint2 = Point(3.0, 4.0)
        val testRectangle1 = Rectangle(testPoint1, testPoint2)

        assertEquals(testRectangle1.calcArea(), 4.0)

        // Test points flipped
        val testPoint3 = Point(3.0, 4.0)
        val testPoint4 = Point(1.0, 2.0)
        val testRectangle2 = Rectangle(testPoint3, testPoint4)

        assertEquals(testRectangle2.calcArea(), 4.0)
    }

    @Test
    fun testAreaZero() {
        // Test that an exception is thrown if Area == 0
        // Testing if width == 0
        val testPoint1 = Point(1.0, 2.0)
        val testPoint2 = Point(1.0, 4.0)

        assertFailsWith<IllegalArgumentException> {
            Rectangle(testPoint1, testPoint2)
        }

        // Test if height == 0
        val testPoint3 = Point(1.0, 4.0)
        val testPoint4 = Point(3.0, 4.0)

        assertFailsWith<IllegalArgumentException> {
            Rectangle(testPoint3, testPoint4)
        }
    }

    @Test
    fun moveVertical() {
        // Test positive direction
        val testPoint1 = Point(1.0, 2.0)
        val testPoint2 = Point(3.0, 4.0)
        val testRectangle1 = Rectangle(testPoint1, testPoint2)
        testRectangle1.moveVertical(5.0)

        assertEquals(testRectangle1.point1.xValue, 1.0)
        assertEquals(testRectangle1.point2.xValue, 3.0)
        assertEquals(testRectangle1.point1.yValue, 7.0)
        assertEquals(testRectangle1.point2.yValue, 9.0)

        // Test negative direction
        val testPoint3 = Point(1.0, 2.0)
        val testPoint4 = Point(3.0, 4.0)
        val testRectangle2 = Rectangle(testPoint3, testPoint4)
        testRectangle2.moveVertical(-5.0)

        assertEquals(testRectangle2.point1.xValue, 1.0)
        assertEquals(testRectangle2.point2.xValue, 3.0)
        assertEquals(testRectangle2.point1.yValue, -3.0)
        assertEquals(testRectangle2.point2.yValue, -1.0)
    }

    @Test
    fun moveHorizontal() {
        // Test positive direction
        val testPoint1 = Point(1.0, 2.0)
        val testPoint2 = Point(3.0, 4.0)
        val testRectangle1 = Rectangle(testPoint1, testPoint2)
        testRectangle1.moveHorizontal(5.0)

        assertEquals(testRectangle1.point1.xValue, 6.0)
        assertEquals(testRectangle1.point2.xValue, 8.0)
        assertEquals(testRectangle1.point1.yValue, 2.0)
        assertEquals(testRectangle1.point2.yValue, 4.0)

        // Test negative direction
        val testPoint3 = Point(1.0, 2.0)
        val testPoint4 = Point(3.0, 4.0)
        val testRectangle2 = Rectangle(testPoint3, testPoint4)
        testRectangle2.moveHorizontal(-5.0)

        assertEquals(testRectangle2.point1.xValue, -4.0)
        assertEquals(testRectangle2.point2.xValue, -2.0)
        assertEquals(testRectangle2.point1.yValue, 2.0)
        assertEquals(testRectangle2.point2.yValue, 4.0)
    }
}