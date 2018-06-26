package br.com.amawebinterface.cdp;

public enum EStatus {
    ABERTO(1),
    CANCELADO(2),
    CONCLUIDO(3);

    public final int codigo;

    private EStatus(int _valorOpcao) {
        this.codigo = _valorOpcao;
    }

    public int getCodigo() {
        return codigo;
    }

    public static EStatus getByCodigo(int cod) {
        for (EStatus ds : values()) {
            if (ds.codigo == cod) {
                return ds;
            }
        }
        throw new IllegalArgumentException("Enum invalido: " + cod);
    }
}
