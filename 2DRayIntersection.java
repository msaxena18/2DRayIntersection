
public class 2DRayIntersection {
	/* Returns the intersection of two 2D Rays */

	public Position get2DRayIntersection(MeasurementDevice deviceA, MeasurementDevice deviceB) {
		double angleA = deviceA.offsetAngle;
		double angleB = deviceB.offsetAngle;
		double cotThetaB = Math.cos(angleB)/Math.sin(angleB);
		double tanThetaA = Math.sin(angleA)/Math.cos(angleA);



	}


	
}