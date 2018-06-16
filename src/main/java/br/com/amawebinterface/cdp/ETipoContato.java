package br.com.amawebinterface.cdp;

public enum ETipoContato {
	TELEFONERESIDENCIAL(1),
	TELEFONECOMERCIAL(2),
	TELEFONERECADO(3),
        FACEBOOK(4),
        TWITTER(5),
        INSTAGRAM(6);
	
 public final int codigo;

    private ETipoContato(int _valorOpcao) {
        this.codigo = _valorOpcao;
    }

    public int getCodigo() {
        return codigo;
    }

    public static ETipoContato getByCodigo(int cod) {
        for (ETipoContato ds : values()) {
            if (ds.codigo == cod) {
                return ds;
            }
        }
        throw new IllegalArgumentException("Enum invalido: " + cod);
    }
}

