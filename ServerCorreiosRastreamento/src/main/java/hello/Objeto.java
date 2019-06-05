package hello;

public class Objeto {
	private String name;
	private String codigo;
	private String status;
	private Integer id ;
	
	public Objeto(String name, String codigo, String status, Integer id) {
		this.name = name;
		this.codigo = codigo;
		this.status = status;
		this.id = id;
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
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
