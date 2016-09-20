
public class 2DRayIntersection {
	/* Returns the intersection of two 2D Rays */

	public Position get2DRayIntersection(MeasurementDevice deviceA, MeasurementDevice deviceB) {
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
		return intersection;
	}


	
}