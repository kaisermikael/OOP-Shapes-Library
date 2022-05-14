# OOP-Shapes-Library

Here are some important notes for this:

* As per instructions, all shapes are able to *move*. This means that they can be translated- not sheared, warped, scaled, or modified in any other way- by using moveVertical()
* and moveHorizontal(). Individual points are still able to be moved, however these are only possible directly with a single point object itself.
* All getters are public. All setters are private.
* For Ellipses/ Circles and Rectangles/ Squares, the testing of most implementations are satisfactory through the super-class tests. As such, the only tests performed
* directly on Circles and Squares are the tests to validate that an exception is thrown whenever a circle or square is attempted to be created without following their
* attributal requirements (radii are same length and sides are same length).
* ALL inputs are based on Doubles. Exceptions will be thrown for inappropriate inputs, and this is explicitly tested for.
* All shapes (meaning not points and not lines) inherit from the abstract Shape class. This is to unify the implementation across all the various shapes.
* All shapes (including Lines) are composed of individual Points, and this is illustrated with multiplicity in the UML diagram.
