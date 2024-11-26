package com.example.FioriDiMaria.mapper.usuario;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

import com.example.FioriDiMaria.model.Usuario;
import com.example.FioriDiMaria.model.Venda;

@Mapper(componentModel= MappingConstants.ComponentModel.SPRING)
public interface UsuarioMapper {

    @Mapping(target = "nome")
    @Mapping(target = "login")
    @Mapping(target = "senha")
    @Mapping(target = "tipoUsuario")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "vendas", ignore = true)
    Usuario toUsuarioFromCreate(UsuarioCreate usuarioCreate);

    @Mapping(target = "nome")
    @Mapping(target = "login")
    @Mapping(target = "senha")
    @Mapping(target = "tipoUsuario")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "vendas", ignore = true)
    Usuario toUsuarioFromUpdate(UsuarioUpdate usuarioUpdate);

    
    @Mapping(target = "id")
    @Mapping(target = "nome")
    @Mapping(target = "login")
    @Mapping(target = "senha")
    @Mapping(target = "tipoUsuario")
    @Mapping(target = "vendasIds", source = "vendas", qualifiedByName = "vendasToIds")
    UsuarioOutput toUsuarioOutput(Usuario usuario);

    @Named("vendasToIds")
    default List<Long> vendasToIds(List<Venda> vendas) {
        if(vendas == null) {
            // nunca entra aqui (?)
            return null; 
        }
        return vendas.stream().map(Venda::getId).toList();
    }
}
