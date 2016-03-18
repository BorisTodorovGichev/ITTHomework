package speedy;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import exceptions.ProtocolException;

public class Protocol {
	private static int Id=1;
	private int uniqueId;
	
	private Client from;
	private Client to;
	
	private String fromInfo;
	private String toInfo;
	private Timestamp timeCreated;
	
	private List<Pack> packs;
	
	
	
	public Protocol(Client from, Client to) {
		this.from=from;
		this.to=to;
		packs=new ArrayList<Pack>();
		this.uniqueId=Protocol.Id++;
		this.fromInfo=this.getFrom().toString();
		this.toInfo=this.getTo().toString();
		this.timeCreated= Timestamp.valueOf(LocalDateTime.now());
	}
	
	public List<Integer> getAllPackIds(){
		List<Integer> ids=new ArrayList<Integer>();
		for (Pack pack : packs) {
			ids.add(pack.getUniqueId());
		}
		return ids;
	}

	public int getUniqueId() {
		return uniqueId;
	}

	public Client getFrom() {
		return from;
	}

	public Client getTo() {
		return to;
	}
	
	public void addPack(Pack pack){
		if (pack!=null) {
			this.packs.add(pack);
		}
		else{
			try {
				throw new  ProtocolException("Invalid Pack");
			} catch (ProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public String toString() {
		String info="Protocol [fromInfo=" + fromInfo + ", toInfo=" + toInfo + "]";
		StringBuilder packs= new StringBuilder();
		packs.append("Ids of packs:");
		List<Integer> ids= this.getAllPackIds();
		for (Integer integer : ids) {
			packs.append(integer+";");
		}
		return info+packs.toString();
	}

	public Timestamp getTimeCreated() {
		return timeCreated;
	}



	
	
	
	

}