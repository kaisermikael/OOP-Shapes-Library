import org.junit.jupiter.api.Test

import org.junit.jupiter.api.*
import kotlin.test.assertFailsWith

internal class SquareTest {

    @Test
    fun isSquareSucceed() {
        // isSquare() is a private function. To test its functionality,
        // this test simply makes proper squares & improper squares
        // and tests for exceptions being thrown

        // Testing Square Throws Exception w/ Different Sides
        val testPoint1 = Point(1.0, 1.0)
        val testPoint2 = Point(20.0, 10.0)

        assertFailsWith<IllegalArgumentException> {
            Square(testPoint1, testPoint2)
        }

        // Testing creation of Square w/ Same Sides
        // If this test succeeds, then an exception was not thrown
        val testPoint3 = Point(1.0, 2.0)
        val testPoint4 = Point(3.0, 4.0)

        Square(testPoint3, testPoint4)
    }

    // Area == 0 Test Completed in RectangleTest.kt
    // Unnecessary to repeat here as well
}