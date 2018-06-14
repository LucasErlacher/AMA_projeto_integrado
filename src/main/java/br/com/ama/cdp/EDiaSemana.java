package br.com.ama.cdp;

public enum EDiaSemana {
	DOMINGO(1),
	SEGUNDA(2),
	TERCA(3),
	QUARTA(4),
	QUINTA(5),
	SEXTA(6),
	SABADO(7);
	
 public final int codigo;

    private EDiaSemana(int _valorOpcao) {
        this.codigo = _valorOpcao;
    }

    public int getCodigo() {
        return codigo;
    }

    public static EDiaSemana getByCodigo(int cod) {
        for (EDiaSemana ds : values()) {
            if (ds.codigo == cod) {
                return ds;
            }
        }
        throw new IllegalArgumentException("Enum invalido: " + cod);
    }
}

