import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertFailsWith

internal class EllipseTest {

    @Test
    fun getterTests() {
        // Testing basic getter functions
        val testCenter1 = Point(1.0, 2.0)
        val testHRadius1 = 5.0
        val testVRadius1 = 10.0
        val testEllipse1 = Ellipse(testCenter1, testHRadius1, testVRadius1)

        assertEquals(testEllipse1.center.xValue, 1.0)
        assertEquals(testEllipse1.center.yValue, 2.0)
        assertEquals(testEllipse1.horizontalRadius, 5.0)
        assertEquals(testEllipse1.verticalRadius, 10.0)

        // Validate that ONLY works with Double inputs
        val testCenter2 = Point(Double.NaN, Double.NaN)
        val testHRadius2 = Double.NaN
        val testVRadius2 = Double.NaN
        val testEllipse2 = Ellipse(testCenter2, testHRadius2, testVRadius2)

        assertNotEquals(testEllipse2.center.xValue, 1.0)
        assertNotEquals(testEllipse2.center.yValue, 2.0)
        assertNotEquals(testEllipse2.horizontalRadius, 5.0)
        assertNotEquals(testEllipse2.verticalRadius, 10.0)
    }

    @Test
    fun calcArea() {
        val testCenter1 = Point(1.0, 2.0)
        val testHRadius1 = 5.0
        val testVRadius1 = 10.0
        val testEllipse1 = Ellipse(testCenter1, testHRadius1, testVRadius1)

        assertEquals(testEllipse1.calcArea(), 157.07963267948966)

        // Test radii flipped
        val testCenter2 = Point(1.0, 2.0)
        val testHRadius2 = 10.0
        val testVRadius2 = 5.0
        val testEllipse2 = Ellipse(testCenter2, testHRadius2, testVRadius2)

        assertEquals(testEllipse2.calcArea(), 157.07963267948966)
    }

    @Test
    fun testAreaZero() {
        // Test that an exception is thrown if Area == 0
        // Testing if Horizontal Radius == 0
        val testCenter1 = Point(1.0, 2.0)
        val testHRadius1 = 0.0
        val testVRadius1 = 10.0

        assertFailsWith<IllegalArgumentException> {
            Ellipse(testCenter1, testHRadius1, testVRadius1)
        }

        // Test if Vertical Radius == 0
        val testCenter2 = Point(1.0, 2.0)
        val testHRadius2 = 10.0
        val testVRadius2 = 0.0

        assertFailsWith<IllegalArgumentException> {
            Ellipse(testCenter2, testHRadius2, testVRadius2)
        }
    }

    @Test
    fun moveVertical() {
        // Test positive direction
        val testCenter1 = Point(1.0, 2.0)
        val testHRadius1 = 5.0
        val testVRadius1 = 10.0
        val testEllipse1 = Ellipse(testCenter1, testHRadius1, testVRadius1)
        testEllipse1.moveVertical(5.0)

        assertEquals(testEllipse1.center.xValue, 1.0)
        assertEquals(testEllipse1.center.yValue, 7.0)
        assertEquals(testEllipse1.horizontalRadius, 5.0)
        assertEquals(testEllipse1.verticalRadius, 10.0)

        // Test negative direction
        val testCenter2 = Point(1.0, 2.0)
        val testHRadius2 = 5.0
        val testVRadius2 = 10.0
        val testEllipse2 = Ellipse(testCenter2, testHRadius2, testVRadius2)
        testEllipse2.moveVertical(-5.0)

        assertEquals(testEllipse2.center.xValue, 1.0)
        assertEquals(testEllipse2.center.yValue, -3.0)
        assertEquals(testEllipse2.horizontalRadius, 5.0)
        assertEquals(testEllipse2.verticalRadius, 10.0)
    }

    @Test
    fun moveHorizontal() {
        // Test positive direction
        val testCenter1 = Point(1.0, 2.0)
        val testHRadius1 = 5.0
        val testVRadius1 = 10.0
        val testEllipse1 = Ellipse(testCenter1, testHRadius1, testVRadius1)
        testEllipse1.moveHorizontal(5.0)

        assertEquals(testEllipse1.center.xValue, 6.0)
        assertEquals(testEllipse1.center.yValue, 2.0)
        assertEquals(testEllipse1.horizontalRadius, 5.0)
        assertEquals(testEllipse1.verticalRadius, 10.0)

        // Test negative direction
        val testCenter2 = Point(1.0, 2.0)
        val testHRadius2 = 5.0
        val testVRadius2 = 10.0
        val testEllipse2 = Ellipse(testCenter2, testHRadius2, testVRadius2)
        testEllipse2.moveHorizontal(-5.0)

        assertEquals(testEllipse2.center.xValue, -4.0)
        assertEquals(testEllipse2.center.yValue, 2.0)
        assertEquals(testEllipse2.horizontalRadius, 5.0)
        assertEquals(testEllipse2.verticalRadius, 10.0)
    }
}