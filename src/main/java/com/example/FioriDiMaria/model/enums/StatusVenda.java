package com.example.FioriDiMaria.model.enums;

public enum StatusVenda {
    CONFIRMADO("confirmado"),
    PAGO("pago"),
    ENTREGUE("entregue"),
    CANCELADO("cancelado"),
    ENVIADO("enviado");

    private String status;

    public String getDescricao() {
        return status;
    }

    StatusVenda(String status) {
        this.status = status;
    }
}
