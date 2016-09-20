public class Position {
	/* Models position of a point in Cartesian coordinates. */

	/* Cartesian coordinate representation of position: (x, y). */
	private double xCoordinate;
	private double yCoordinate;

	/* Initializes xCoordinate and yCoordinate. */
	public Position(double xCoor, double yCoor) {
		xCoordinate = xCoor;
		yCoordinate = yCoor;
	}

	/* Returns X Coordinate of Position. */
	public double getXCoordinate() {
		return xCoordinate;
	}

	/* Returns Y Coordinate of Position. */
	public double getYCoordinate() {
		return yCoordinate;
	}
}