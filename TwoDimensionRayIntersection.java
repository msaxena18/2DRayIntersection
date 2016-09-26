public class TwoDimensionRayIntersection {
	/* Models the intersection of two 2D Rays. */

	/* Two devices, deviceA and deviceB, and their intersection point, intersectPostion. */
	private MeasurementDevice deviceA;
	private MeasurementDevice deviceB;
	private Position intersectPosition;

	/* Constructor that initializes deviceA, deviceB, intersectPosition. */
	public TwoDimensionRayIntersection(MeasurementDevice deviceOne, MeasurementDevice deviceTwo) {
		deviceA = deviceOne;
		deviceB = deviceTwo;
		intersectPosition = new Position(0,0);
	}

	/* Sets intersectPosition to the intersect point of deviceA and deviceB. */
	public void setTwoDimensionRayIntersection() {
		double angleA = deviceA.getOffsetAngle();
		double angleB = deviceB.getOffsetAngle();
		double yCoordinateA = deviceA.getDevicePosition().getYCoordinate();
		double xCoordinateA = deviceA.getDevicePosition().getXCoordinate();

		double yCoordinateB = deviceB.getDevicePosition().getYCoordinate();
		double xCoordinateB = deviceB.getDevicePosition().getXCoordinate();

		double tanThetaA = Math.sin(angleA)/Math.cos(angleA);
		double tanThetaB = Math.sin(angleB)/Math.cos(angleB);

		double interceptA = yCoordinateA - (xCoordinateA*tanThetaA);
		double interceptB = yCoordinateB - (xCoordinateB*tanThetaB);

		double xCoordinateIntersect = (-interceptA + interceptB) / (tanThetaA - tanThetaB);
		double yCoordinateIntersect = xCoordinateIntersect*tanThetaA + interceptA;

		Position intersection = new Position(xCoordinateIntersect, yCoordinateIntersect);
		
		if (!checkPositionIntersection(intersection, deviceA.getDevicePosition(), deviceB.getDevicePosition(),
			tanThetaA, tanThetaB)) {
			intersectionPosition = null;
		} else {
			intersectPosition = intersection;
		}
	}
	/* Checks whether the intersection point for the rays are valid. If the intersection point for the rays doesn't fall between
		these bounds, the rays would only intersect if they were lines.*/
	public boolean checkPositionIntersection(Position intersection, Position originA, Position originB,
		double slopeA, double slopeB) {

		if (slopeA > 0 && slopeB < 0) {
			boolean xCondition = intersection.getXCoordinate() > originA.getXCoordinate();
			boolean yCondition = intersection.getYCoordinate() > originA.getYCoordinate();
			return xCondition && yCondition
		}

		if (slopeA < 0 && slopeB > 0) {
			boolean xCondition = intersection.getXCoordinate() > originB.getXCoordinate();
			boolean yCondition = intersection.getYCoordinate() > originB.getYCoordinate();
			return xCondition && yCondition;
		}

		if (slopeA > 0 && slopeB > 0) {
			boolean rayACondition = intersection.getYCoordinate() > originA.getYCoordinate();
			boolean rayBCondition = intersection.getYCoordinate() > originB.getYCoordinate();
			return rayACondition && rayBCondition
		}

		if (slopeA < 0 && slopeB < 0) {
			boolean rayACondition = intersection.getYCoordinate() < originA.getYCoordinate();
			boolean rayBCondition = intersection.getYCoordinate() < originB.getYCoordinate();
			return rayACondition && rayBCondition;
		}

	}

	/* Changes the offset angle for device and recalculates intersect position. */
	public void changeAngleForDevice(MeasurementDevice device, double angle) {
		device.changeOffsetAngle(angle);
		setTwoDimensionRayIntersection();
	}

	/* Increments the offset angle of device by angle and recalculates intersect position. */
	public void incrementOffsetAngleOfDevice(MeasurementDevice device, double angle) {
		device.incrementOffsetAngle(angle);
		setTwoDimensionRayIntersection();
	}

	/* Decrements the offset angle of device by angle and recalculates intersect position. */
	public void decrementOffsetAngleOfDevice(MeasurementDevice device, double angle) {
		device.decrementOffsetAngle(angle);
		setTwoDimensionRayIntersection();
	}

	/* Returns intersectionPosition for deviceA and deviceB. */
	public Position getTwoDimensionRayIntersection() {
		return intersectPosition;
	}

	/* Returns X Coordinate of intersectionPoint. */
	public double getTwoDimensionRayIntersectionXCoordinate() {
		return intersectPosition.getXCoordinate();
	}

	/* Returns Y Coordinate of intersectionPoint. */
	public double getTwoDimensionRayIntersectionYCoordinate() {
		return intersectPosition.getYCoordinate();
	}

	/* Returns measurement device: deviceA. */
	public MeasurementDevice getDeviceA() {
		return deviceA;
	}

	/* Returns measurement device: deviceB. */
	public MeasurementDevice getDeviceB() {
		return deviceB;
	}
	
}