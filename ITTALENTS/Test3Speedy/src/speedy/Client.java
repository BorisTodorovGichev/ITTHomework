package speedy;

import java.util.LinkedList;
import java.util.Queue;

import exceptions.ClientException;

public class Client extends Thread{
	private static int number=1;
	private String firstName;
	private String cellPhone;
	private String address;
	private String city;
	private Office office;
	private Queue<Client> recievers;
	
	
	public Client(String firstName, String cellPhone, String address) {
		this.setFirstName(firstName);
		this.setCellPhone(cellPhone);
		this.setAddress(address+number++);
		this.recievers= new LinkedList<Client>();
	}
	
	@Override
	public void run() {
		synchronized(this.getOffice()){
			this.getOffice().getServiceEmployee().takePack(new Pack(this, this.recievers.poll(), "lqlqlqlq"),this);
			
			
		}

	}
	
	public void  addReciever(Client client) {
		if (client!=null) {
			this.recievers.offer(client);
		}
	}
	public String getID(){
		return "EGN";
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName!=null&&firstName.trim().length()!=0) {
			this.firstName = firstName;
		}
		else{
			try {
				throw new ClientException("invalid name");
			} catch (ClientException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		if (cellPhone!=null&&cellPhone.trim().length()!=0) {
			this.cellPhone = cellPhone;
		}
		else{
			try {
				throw new ClientException("invalid gsm");
			} catch (ClientException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		if (address!=null&&address.trim().length()!=0) {
			this.address = address;
		}
		else{
			try {
				throw new ClientException("invalid address");
			} catch (ClientException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		if (city!=null&&city.trim().length()!=0) {
			this.city = city;
		}
		else{
			try {
				throw new ClientException("invalid city");
			} catch (ClientException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Office getOffice() {
		if (this.office!=null) {
			return office;
		}
		else{
			try {
				throw new ClientException("No office");
			} catch (ClientException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public void setOffice(Office office) {
		if (office!=null) {
			this.office = office;
			this.city=office.getCity();
		}
		else{
			try {
				throw new ClientException("invalid office");
			} catch (ClientException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public String toString() {
		return "Client [firstName=" + firstName + ", cellPhone=" + cellPhone
				+ ", address=" + address + ", city=" + city + ", getID()="
				+ getID() + "]";
	}
	
	
}
