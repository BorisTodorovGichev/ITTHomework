package speedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import exceptions.OfficeException;

public class Office {
	private static List<Pack> allPacks = new ArrayList<Pack>();
	private static List<Client> allClients = new ArrayList<Client>();
	private static List<Protocol> allProtocols = new ArrayList<Protocol>();
	private static List<Office> allOfices = new ArrayList<>();
	private WorkerClient workerClient;
	private WorkerDriver workerDriver;
	private List<Pack> officePacks;
	private List<Protocol> officeProtocols;
	private String city;

	public Office(String city) {
		this.setWorkerClient(new WorkerClient("Drago ot " + city + "service",
				"0887615547", "nadevda"));
		this.setDriverEmployee(new WorkerDriver("Drago ot " + city + "service",
				"0887615547", "nadevda"));
		this.officeProtocols = new ArrayList<Protocol>();
		this.officePacks = new ArrayList<Pack>();
		this.city = city;
		allOfices.add(this);
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public WorkerClient getServiceEmployee() {
		return workerClient;
	}

	public void setWorkerClient(WorkerClient serviceEmployee) {
		this.workerClient = serviceEmployee;
	}

	public WorkerDriver getDriverEmployee() {
		return workerDriver;
	}

	public void setDriverEmployee(WorkerDriver driverEmployee) {
		this.workerDriver = driverEmployee;
	}

	public Protocol generateProtocol(Pack pack, Client client) {
		Protocol temp = new Protocol(client, this.getServiceEmployee());
		this.addProtocol(temp);
		return temp;
	}

	public void addPack(Pack pack) {
		synchronized (allPacks) {
			Office.allPacks.add(pack);

		}

		synchronized (officePacks) {
			this.officePacks.add(pack);

		}

	}

	public void addProtocol(Protocol protocol) {
		synchronized (allProtocols) {
			Office.allProtocols.add(protocol);

		}

		synchronized (officeProtocols) {
			this.officeProtocols.add(protocol);

		}

	}

	public void showAllProtocolsForPack(Integer uniqueId) {
		if (uniqueId != null && uniqueId > 0) {
			for (Protocol protocol : Office.allProtocols) {
				List<Integer> ids = protocol.getAllPackIds();
				for (Integer id : ids) {
					if (uniqueId == id) {
						System.out.println(protocol.toString());
					}
				}
			}
		}

	}

	public void showAllProtocolsForPack(Pack pack) {
		this.showAllProtocolsForPack(pack.getUniqueId());

	}

	public void printAllClientsOrderedByNames() {

		Collections.sort(allClients, (c1,c2)->{
			return c1.getName().compareTo(c2.getName());
		});

		for (Client client : allClients) {
			System.out.println(client.toString());
		}

	}


	public void printAllPacksByTakenTime() {

		Collections.sort(allPacks, (p1,p2)->{
			return p1.getTimeTaken().compareTo(p2.getTimeTaken());
		});

		for (Pack pack : allPacks) {
			System.out.println(pack.toString());
		}

	}
	
	public void showInfoForPack(Integer id){
		if (id!=null&&id>0) {
			for (Pack pack : Office.allPacks) {
				if (pack.getUniqueId()==id) {
					System.out.println(pack.toString());
					return;
				}
			}
			System.out.println("Sorry no pack with such an ID");
		}
		else  { try {
			throw new OfficeException("Invalid ID");
		} catch (OfficeException e) {
			e.printStackTrace();
		}
			
		}
		
	}

}