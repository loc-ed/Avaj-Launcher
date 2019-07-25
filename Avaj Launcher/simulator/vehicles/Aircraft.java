package simulator.vehicles;

public class Aircraft {
	protected		Long	id;
	protected		String	name;
	protected		Coordinates coordinates;
	private	static	Long	_idCounter = 0L;

	public Aircraft() {
		
	}

	protected Aircraft(String name, Coordinates coordinates) {
		this.coordinates = coordinates;
		this.name = name;
		_idCounter = nextid();
		this.id = _idCounter;
	}

	private long nextid() {
		return (++_idCounter);
	}

	public Coordinates getCoordinates() {
		return this.coordinates;
	}

}
