
public class 2DRayIntersection {
	/* Models the intersection of two 2D Rays. */

	/* Two devices, deviceA and deviceB, and their intersection point, intersectPostion. */
	private MeasurementDevice deviceA;
	private MeasurementDevice deviceB;
	private Position intersectPosition;

	/* Constructor that initializes deviceA, deviceB, intersectPosition. */
	public 2DRayIntersection(MeasurementDevice deviceOne, MeasurementDevice deviceTwo) {
		deviceA = deviceOne;
		deviceB = deviceTwo;
		intersectPosition = new Position(0,0);
	}

	/* Sets intersectPosition to the intersect point of deviceA and deviceB. */
	public void set2DRayIntersection() {
		double angleA = deviceA.getOffsetAngle();
		double angleB = deviceB.getOffsetAngle();
		double yCoordinateA = deviceA.getDevicePosition().getYCoordinate();
		double xCoordinateA = deviceA.getDevicePosition.getXCoordinate();

		double yCoordinateB = deviceB.getDevicePosition().getYCoordinate();
		double xCoordinateB = deviceB.getDevicePosition.getXCoordinate();

		double tanThetaA = Math.sin(angleA)/Math.cos(angleA);
		double tanThetaB = Math.sin(angleB)/Math.cos(angleB);

		double interceptA = yCoordinateA - (xCoordinateA*tanThetaA);
		double interceptB = yCoordinateB - (xCoordinateB*tanThetaB);

		double xCoordinateIntersect = (-interceptA + interceptB) / (tanThetaA - tanThetaB);
		double yCoordinateIntersect = xCoordinateIntersect*tanThetaA + interceptA;

		Position intersection = new Position(xCoordinateIntersect, yCoordinateIntersect);
		intersectPosition = intersection;
	}

	/* Changes the offset angle for DeviceA and recalculates intersect position. */
	public void changeAngleForDeviceA(double angle) {
		deviceA.changeOffsetAngle(angle);
		set2DRayIntersection();
	}

	/* Changes the offset angle for DeviceB and recalculates intersect position. */
	public void changeAngleForDeviceB(double angle) {
		deviceB.changeOffsetAngle(angle);
		set2DRayIntersection();
	}

	/* Returns intersectionPosition for deviceA and deviceB. */
	public Position get2DRayIntersection() {
		return intersectPosition;
	}

	/* Returns X Coordinate of intersectionPoint. */
	public double get2DRayIntersectionXCoordinate() {
		return intersectPosition.getXCoordinate();
	}

	/* Returns Y Coordinate of intersectionPoint. */
	public double get2DRayIntersectionYCoordinate() {
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