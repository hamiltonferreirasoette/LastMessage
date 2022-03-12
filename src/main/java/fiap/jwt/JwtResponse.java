package fiap.jwt;

import java.io.Serializable;

public class JwtResponse implements Serializable {
	
	

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	private Integer codigo;
	

	public JwtResponse(String jwttoken, Integer codigo
			) {
		this.jwttoken = jwttoken;
		this.codigo = codigo;
	}




	public Integer getCodigo() {
		return codigo;
	}




	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public String getJwttoken() {
		return jwttoken;
	}
}