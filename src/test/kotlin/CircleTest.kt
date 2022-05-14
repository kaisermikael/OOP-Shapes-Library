import org.junit.jupiter.api.Test

import org.junit.jupiter.api.*
import kotlin.test.assertFailsWith

internal class CircleTest {

    @Test
    fun isCircleSucceed() {
        // isCircle() is a private function. To test its functionality,
        // this test simply makes proper Circles & improper Circles
        // and tests for exceptions being thrown

        // Testing Circle Throws Exception w/ Different Radii
        val testCenter1 = Point(1.0, 2.0)
        val testHRadius1 = 5.0
        val testVRadius1 = 10.0

        assertFailsWith<IllegalArgumentException> {
            Circle(testCenter1, testHRadius1, testVRadius1)
        }

        // Testing creation of Circle w/ Same Radii
        // If this test succeeds, then an exception was not thrown
        val testCenter2 = Point(1.0, 2.0)
        val testHRadius2 = 10.0
        val testVRadius2 = 10.0

        Circle(testCenter2, testHRadius2, testVRadius2)
    }

    // Area == 0 Test Completed in EllipseTest.kt
    // Unnecessary to repeat here as well
}