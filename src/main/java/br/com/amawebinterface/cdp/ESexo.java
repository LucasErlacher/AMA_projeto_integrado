package br.com.amawebinterface.cdp;

public enum ESexo {
    MASCULINO(1),
    FEMININO(2);

    public final int codigo;

    private ESexo(int _valorOpcao) {
        this.codigo = _valorOpcao;
    }

    public int getCodigo() {
        return codigo;
    }

    public static ESexo getByCodigo(int cod) {
        for (ESexo es : values()) {
            if (es.codigo == cod) {
                return es;
            }
        }
       throw new IllegalArgumentException("Enum invalido: " + cod);
       
    }
}
