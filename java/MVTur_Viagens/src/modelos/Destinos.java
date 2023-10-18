package modelos;

public class Destinos {
	private int id;
	private String destino;
	private String origem;
	private String partida;
	private String chegada;
	
	public Destinos() {
	}

	public Destinos(int id, String destino, String origem, String partida, String chegada) {
		this.id = id;
		this.destino = destino;
		this.origem = origem;
		this.partida = partida;
		this.chegada = chegada;
	}

	public Destinos(String destino, String origem, String partida, String chegada) {
		this.destino = destino;
		this.origem = origem;
		this.partida = partida;
		this.chegada = chegada;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getPartida() {
		return partida;
	}

	public void setPartida(String partida) {
		this.partida = partida;
	}

	public String getChegada() {
		return chegada;
	}

	public void setChegada(String chegada) {
		this.chegada = chegada;
	}

	@Override
	public String toString() {
		return "Destinos [id=" + id + ", destino=" + destino + ", origem=" + origem + ", partida=" + partida
				+ ", chegada=" + chegada + "]";
	}
}
