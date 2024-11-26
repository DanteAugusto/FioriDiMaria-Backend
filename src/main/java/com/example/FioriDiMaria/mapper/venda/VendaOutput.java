package com.example.FioriDiMaria.mapper.venda;

import java.sql.Date;

public record VendaOutput(
    Long id,
    Date data,
    Long usuarioId)
{}