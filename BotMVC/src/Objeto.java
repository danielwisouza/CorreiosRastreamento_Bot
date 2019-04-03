
public class Objeto {
	private String name;
	private String codigo;
	
	public Objeto(String name, String codigo) {
		this.name = name;
		this.codigo = codigo;
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
