package calc;

public class Ip {

	//Atributos
	private String ip, clase, pop, apipa, difusion, reservada, ipred, ipgw, ipbroad, hosts;
	private int mask;
	
	
	public Ip(String ip, String clase, String pop, String apipa, String difusion, String reservada, String ipred,
			String ipgw, String ipbroad, String hosts, int mask) {

		this.ip = ip;
		this.clase = clase;
		this.pop = pop;
		this.apipa = apipa;
		this.difusion = difusion;
		this.reservada = reservada;
		this.ipred = ipred;
		this.ipgw = ipgw;
		this.ipbroad = ipbroad;
		this.hosts = hosts;
		this.mask = mask;
	}


	public String getIp() {
		return ip;
	}


	public void setIp(String ip) {
		this.ip = ip;
	}


	public String getClase() {
		return clase;
	}


	public void setClase(String clase) {
		this.clase = clase;
	}


	public String getPop() {
		return pop;
	}


	public void setPop(String pop) {
		this.pop = pop;
	}


	public String getApipa() {
		return apipa;
	}


	public void setApipa(String apipa) {
		this.apipa = apipa;
	}


	public String getDifusión() {
		return difusion;
	}


	public void setDifusión(String difusión) {
		this.difusion = difusión;
	}


	public String getReservada() {
		return reservada;
	}


	public void setReservada(String reservada) {
		this.reservada = reservada;
	}


	public String getIpred() {
		return ipred;
	}


	public void setIpred(String ipred) {
		this.ipred = ipred;
	}


	public String getIpgw() {
		return ipgw;
	}


	public void setIpgw(String ipgw) {
		this.ipgw = ipgw;
	}


	public String getIpbroad() {
		return ipbroad;
	}


	public void setIpbroad(String ipbroad) {
		this.ipbroad = ipbroad;
	}


	public String getHosts() {
		return hosts;
	}


	public void setHosts(String hosts) {
		this.hosts = hosts;
	}


	public int getMask() {
		return mask;
	}


	public void setMask(int mask) {
		this.mask = mask;
	}
	
	
}
