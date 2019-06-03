
public class Objeto {
	private String name;
	private String codigo;
	private String status;
	
	public Objeto(String name, String codigo, String status) {
		this.name = name;
		this.codigo = codigo;
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
