package org.hotelmanagement.hotelmanagementbackend.mapper

import org.hotelmanagement.hotelmanagementbackend.entity.ClientEntity
import org.hotelmanagement.hotelmanagementbackend.model.dto.ClientDto
import org.mapstruct.factory.Mappers
import spock.lang.Specification

class ClientMapperTest extends Specification {
    def mapper = Mappers.getMapper(ClientMapper.class)

    def "toEntity"() {
        given:
        def dto = new ClientDto(id: 1L, name: "Kcoeri", email: "test@example.com")

        when:
        def entity = mapper.toEntity(dto)

        then:
        entity != null
        entity.id == dto.id
        entity.name == dto.name
        entity.email == dto.email
    }

    def "toDto"() {
        given:
        def entity = new ClientEntity(id: 1L, name: "name", email: "test@example.com")

        when:
        def dto = mapper.toDto(entity)

        then:
        dto != null
        dto.id == entity.id
        dto.name == entity.name
        dto.email == entity.email
    }
}
