package by.epam.task4;

import java.util.concurrent.TimeUnit;

public class Piar {
	private Port port;

	public Piar(Port port) {
		this.port = port;
	}

	public void loadFromShip(Ship ship) throws InterruptedException {
		int containersForShip = 0;
		int containersForPort = 0;
		TimeUnit.SECONDS.sleep(2);
		int remider = ship.getContainerCapacity() - port.getMaxContainerCapacity();
		if(remider < 0) {
			containersForShip = 0;
		} else
		{
			containersForShip = remider;
		}
		if(remider < 0) {
			containersForPort += ship.getContainerCapacity();
		}
		else {
			containersForPort += port.getContainerCapacity() - port.getContainerCapacity();
		}
		
		ship.setContainerCapacity(containersForShip);
		port.setContainerCapacity(containersForPort);
	}

	public void unloadForShip(Ship ship) throws InterruptedException {
		int containersForPort = 0;
		TimeUnit.SECONDS.sleep(2);
		int remider = port.getContainerCapacity() - ship.getMaxContainerCapacity();
		int containersForShip = ship.getContainerCapacity();
	
		if(remider < 0) {
			containersForPort = 0;
		} else
		{
			containersForPort = remider;
		}
		if(remider < 0) {
			containersForShip += port.getContainerCapacity();
		}else {
			containersForShip += ship.getMaxContainerCapacity() - ship.getContainerCapacity();
		}
		
		ship.setContainerCapacity(containersForShip);
		port.setContainerCapacity(containersForPort);
	}
}
