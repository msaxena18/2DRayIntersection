public Class MeasurementDevice {
	
	private Position devicePosition;
	private double offsetAngle;
	private double samplingFrequency;

	public MeasurementDevice(Position pos, double angle, double frequency) {
		devicePosition = pos;
		offsetAngle = angle;
		samplingFrequency = frequency;
	}

	public double changeOffsetAngle(double angle) {
		offsetAngle += angle;
	}

	private Position getDevicePosition() {
		return devicePosition;
	}

	private double getOffsetAngle() {
		return offsetAngle;
	}

	private double getSamplingFrequency() {
		return samplingFrequency;
	}
}