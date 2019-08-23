package by.epam.task4;

public class Port {
	private int containerCapacity;
	Piar[] piar;

	{
		piar = new Piar[5];

		piar[0] = new Piar(this);
		piar[1] = new Piar(this);
		piar[2] = new Piar(this);
		piar[3] = new Piar(this);
		piar[4] = new Piar(this);
	}

	public Port() {

	}
	
	public Port(int containerCapacity) {
		this.containerCapacity = containerCapacity;
	}

	public void loadContainer(int containers) {
		if (containers + containerCapacity > 5) {
			this.containerCapacity += 5 - containerCapacity;
		} else {
			this.containerCapacity += containers;
		}
	}

	public void unloadContainer(int containers) {
		if (containerCapacity + containers > 0) {
			this.containerCapacity -= containers;
		}
	}

	public Piar getPairByNumber(int number) {
		return piar[number];
	}

	public int getMaxContainerCapacity() {
		return 5;
	}

	public int getContainerCapacity() {
		return containerCapacity;
	}

	public Piar[] getPiarList() {
		return piar;
	}

	public void setPiarList(Piar[] piarList) {
		this.piar = piarList;
	}
	
	public Piar getPiarByInt(int index) {
		return piar[index];
	}

	public void setContainerCapacity(int containerCapacity) {
		this.containerCapacity = containerCapacity;
	}

	@Override
	public String toString() {
		return "Port [containerCapacity=" + containerCapacity + "]";
	}
}
