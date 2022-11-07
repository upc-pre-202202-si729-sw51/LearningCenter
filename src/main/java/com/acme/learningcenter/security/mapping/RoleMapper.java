package com.acme.learningcenter.security.mapping;

import com.acme.learningcenter.security.domain.model.entity.Role;
import com.acme.learningcenter.security.domain.model.enumeration.Roles;
import com.acme.learningcenter.security.resource.RoleResource;
import com.acme.learningcenter.shared.mapping.EnhancedModelMapper;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class RoleMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    Converter<Roles, String> roleToString = new AbstractConverter<Roles, String>() {
        @Override
        protected String convert(Roles role) {
            return role == null ? null : role.name();
        }
    };

    public RoleResource toResource(Role model) {
        mapper.addConverter(roleToString);
        return mapper.map(model, RoleResource.class);
    }

    public Page<RoleResource> modelListToPage(List<Role> modelList, Pageable pageable) {
        mapper.addConverter(roleToString);
        return new PageImpl<>(mapper.mapList(modelList, RoleResource.class), pageable, modelList.size());
    }
}
