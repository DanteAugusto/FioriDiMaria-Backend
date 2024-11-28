package com.example.FioriDiMaria.mapper.venda;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

import com.example.FioriDiMaria.model.Usuario;
import com.example.FioriDiMaria.model.Venda;

@Mapper(componentModel= MappingConstants.ComponentModel.SPRING)
public interface VendaMapper {

    @Mapping(target = "data")
    Venda toVendaFromCreate(VendaCreate usuarioCreate);

    @Mapping(target = "data")
    Venda toVendaFromUpdate(VendaUpdate usuarioUpdate);

    
    @Mapping(target = "id")
    @Mapping(target = "data")
    @Mapping(target = "usuarioId", source = "usuario.id")
    VendaOutput toVendaOutput(Venda usuario);
    
}
