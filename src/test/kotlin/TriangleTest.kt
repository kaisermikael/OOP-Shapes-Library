import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertFailsWith

internal class TriangleTest {

    @Test
    fun getPoints() {
        // Testing the basic getter functions
        val testPoint1 = Point(1.0, 10.0)
        val testPoint2 = Point(2.0, 5.0)
        val testPoint3 = Point(3.0, 10.0)
        val testTriangle1 = Triangle(testPoint1, testPoint2, testPoint3)

        assertEquals(testTriangle1.point1.xValue, 1.0)
        assertEquals(testTriangle1.point2.xValue, 2.0)
        assertEquals(testTriangle1.point3.xValue, 3.0)
        assertEquals(testTriangle1.point1.yValue, 10.0)
        assertEquals(testTriangle1.point2.yValue, 5.0)
        assertEquals(testTriangle1.point3.yValue, 10.0)

        // Validate that ONLY works with Double inputs
        val testPoint4 = Point(Double.NaN, Double.NaN)
        val testPoint5 = Point(Double.NaN, Double.NaN)
        val testPoint6 = Point(Double.NaN, Double.NaN)
        val testTriangle2 = Triangle(testPoint4, testPoint5, testPoint6)

        assertNotEquals(testTriangle2.point1.xValue, 1.0)
        assertNotEquals(testTriangle2.point2.xValue, 2.0)
        assertNotEquals(testTriangle2.point3.xValue, 3.0)
        assertNotEquals(testTriangle2.point1.yValue, 10.0)
        assertNotEquals(testTriangle2.point2.yValue, 5.0)
        assertNotEquals(testTriangle2.point3.yValue, 10.0)
    }

    @Test
    fun calcArea() {
        val testPoint1 = Point(1.0, 10.0)
        val testPoint2 = Point(2.0, 5.0)
        val testPoint3 = Point(3.0, 10.0)
        val testTriangle1 = Triangle(testPoint1, testPoint2, testPoint3)


        assertEquals(testTriangle1.calcArea(), 5.0)

        // Test points flipped
        val testPoint4 = Point(1.0, 10.0)
        val testPoint5 = Point(2.0, 5.0)
        val testPoint6 = Point(3.0, 10.0)
        val testTriangle2 = Triangle(testPoint6, testPoint5, testPoint4)


        assertEquals(testTriangle2.calcArea(), 5.0)
    }

    @Test
    fun testAreaZero() {
        // Test if the exception is thrown w/ area == 0
        val testPoint1 = Point(1.0, 2.0)
        val testPoint2 = Point(3.0, 4.0)
        val testPoint3 = Point(5.0, 6.0)
        assertFailsWith<IllegalArgumentException> {
            Triangle(testPoint1, testPoint2, testPoint3)
        }
    }

    @Test
    fun moveVertical() {
        // Test positive direction
        val testPoint1 = Point(1.0, 10.0)
        val testPoint2 = Point(2.0, 5.0)
        val testPoint3 = Point(3.0, 10.0)
        val testTriangle1 = Triangle(testPoint1, testPoint2, testPoint3)
        testTriangle1.moveVertical(5.0)

        assertEquals(testTriangle1.point1.xValue, 1.0)
        assertEquals(testTriangle1.point2.xValue, 2.0)
        assertEquals(testTriangle1.point3.xValue, 3.0)
        assertEquals(testTriangle1.point1.yValue, 15.0)
        assertEquals(testTriangle1.point2.yValue, 10.0)
        assertEquals(testTriangle1.point3.yValue, 15.0)

        // Test negative direction
        val testPoint4 = Point(1.0, 10.0)
        val testPoint5 = Point(2.0, 5.0)
        val testPoint6 = Point(3.0, 10.0)
        val testTriangle2 = Triangle(testPoint4, testPoint5, testPoint6)
        testTriangle2.moveVertical(-5.0)

        assertEquals(testTriangle2.point1.xValue, 1.0)
        assertEquals(testTriangle2.point2.xValue, 2.0)
        assertEquals(testTriangle2.point3.xValue, 3.0)
        assertEquals(testTriangle2.point1.yValue, 5.0)
        assertEquals(testTriangle2.point2.yValue, 0.0)
        assertEquals(testTriangle2.point3.yValue, 5.0)
    }

    @Test
    fun moveHorizontal() {
        // Test positive direction
        val testPoint1 = Point(1.0, 10.0)
        val testPoint2 = Point(2.0, 5.0)
        val testPoint3 = Point(3.0, 10.0)
        val testTriangle1 = Triangle(testPoint1, testPoint2, testPoint3)
        testTriangle1.moveHorizontal(5.0)

        assertEquals(testTriangle1.point1.xValue, 6.0)
        assertEquals(testTriangle1.point2.xValue, 7.0)
        assertEquals(testTriangle1.point3.xValue, 8.0)
        assertEquals(testTriangle1.point1.yValue, 10.0)
        assertEquals(testTriangle1.point2.yValue, 5.0)
        assertEquals(testTriangle1.point3.yValue, 10.0)

        // Test negative direction
        val testPoint4 = Point(1.0, 10.0)
        val testPoint5 = Point(2.0, 5.0)
        val testPoint6 = Point(3.0, 10.0)
        val testTriangle2 = Triangle(testPoint4, testPoint5, testPoint6)
        testTriangle2.moveHorizontal(-5.0)


        assertEquals(testTriangle2.point1.xValue, -4.0)
        assertEquals(testTriangle2.point2.xValue, -3.0)
        assertEquals(testTriangle2.point3.xValue, -2.0)
        assertEquals(testTriangle2.point1.yValue, 10.0)
        assertEquals(testTriangle2.point2.yValue, 5.0)
        assertEquals(testTriangle2.point3.yValue, 10.0)
    }
}