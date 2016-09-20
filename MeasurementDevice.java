public Class MeasurementDevice {
	/* Models Measurement Device, which can detect objects at certain angle 
		and at a certain sampling frequency. */
	
	/* The position, the offset angle, and the sampling frequency of a Measurement Device.*/
	private Position devicePosition;
	private double offsetAngle;
	private double samplingFrequency;

	/* Initializes devicePostion, offsetAngle, and samplingFrequency. */
	public MeasurementDevice(Position pos, double angle, double frequency) {
		devicePosition = pos;
		offsetAngle = angle;
		samplingFrequency = frequency;
	}

	/* Changes offsetAngle to angle. */
	public void changeOffsetAngle(double angle) {
		offsetAngle = angle;
	}

	/* Increments offsetAngle by angle. */
	public void incrementOffsetAngle(double angle) {
		offsetAngle += angle;
	}

	/* Decrements offsetAngle by angle. */
	public void decrementOffsetAngle(double angle) {
		offsetAngle -= angle;
	}

	/* Returns the position of the device, devicePosition. */
	private Position getDevicePosition() {
		return devicePosition;
	}

	/* Returns the offset angle of the device, offsetAngle. */
	private double getOffsetAngle() {
		return offsetAngle;
	}

	/* Returns the sampling frequency of the device, samplingFrequency. */
	private double getSamplingFrequency() {
		return samplingFrequency;
	}
}