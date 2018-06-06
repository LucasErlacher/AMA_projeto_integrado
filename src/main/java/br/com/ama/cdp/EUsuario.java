package br.com.ama.cdp;

public enum EUsuario {
    AGENTESAUDE(1),
    PACIENTE(2);

    private final int codigo;

    EUsuario(int _valorOpcao) {
        this.codigo = _valorOpcao;
    }

    public int getCodigo() {
        return codigo;
    }
}
