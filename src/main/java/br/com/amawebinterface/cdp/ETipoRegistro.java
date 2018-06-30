package br.com.amawebinterface.cdp;

public enum ETipoRegistro {
    CRM(1),
    CRN(2),
    CRO(3),
    CRP(4);

    private final int codigo;

    ETipoRegistro(int _valorOpcao) {
        this.codigo = _valorOpcao;
    }

    public int getCodigo() {
        return codigo;
    }

    public static ETipoRegistro getByCodigo(int cod) {
        for (ETipoRegistro es : values()) {
            if (es.codigo == cod) {
                return es;
            }
        }
        throw new IllegalArgumentException("Enum invalido: " + cod);
    }
}
