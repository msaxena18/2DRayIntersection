
public class 2DRayIntersection {
	/* Returns the intersection of two 2D Rays */


	private MeasurementDevice deviceA;
	private MeasurementDevice deviceB;
	private Position intersectPosition;

	public 2DRayIntersection(MeasurementDevice deviceOne, MeasurementDevice deviceTwo) {
		deviceA = deviceOne;
		deviceB = deviceTwo;
		intersectPosition = new Position(0,0);
	}

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

	public void changeAngleForDeviceA(double angle) {
		deviceA.changeOffsetAngle(angle);
		set2DRayIntersection();
	}


	public void changeAngleForDeviceB(double angle) {
		deviceB.changeOffsetAngle(angle);
		set2DRayIntersection();
	}

	public Position get2DRayIntersection() {
		return intersectPosition;
	}

	public double get2DRayIntersectionXCoordinate() {
		return intersectPosition.getXCoordinate();
	}


	public double get2DRayIntersectionYCoordinate() {
		return intersectPosition.getYCoordinate();
	}

	public MeasurementDevice getDeviceA() {
		return deviceA;
	}

	public MeasurementDevice getDeviceB() {
		return deviceB;
	}


	
}