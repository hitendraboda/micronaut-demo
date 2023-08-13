package com.boda.resource;

import com.boda.dto.PersonDto;
import com.boda.dto.PersonRequestDto;
import com.boda.entity.Person;
import com.boda.service.PersonService;
import com.boda.util.ObjectMapperUtils;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import jakarta.validation.Valid;

import java.util.List;

@Controller(value = "/api/persons")
public class PersonResource {

    @Inject
    PersonService personService;

    /**
     * Get All
     *
     * @return List of person
     */
    @Get(produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public HttpResponse<List<PersonDto>> getAll() {
        return HttpResponse.ok(ObjectMapperUtils.mapAll(personService.getAll(), PersonDto.class));
    }

    /**
     * Get By Person Id
     *
     * @param id
     * @return Person object
     */
    @Get(value = "/{id}", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public HttpResponse<PersonDto> getById(@PathVariable("id") long id) {
        return HttpResponse.ok(ObjectMapperUtils.map(personService.getById(id), PersonDto.class));
    }

    /**
     * Create person
     *
     * @param dto
     * @return Person object
     */
    @Post(produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public HttpResponse<PersonDto> create(@Valid @Body PersonRequestDto dto) {
        Person person = personService.create(ObjectMapperUtils.map(dto, Person.class));
        return HttpResponse.created(ObjectMapperUtils.map(person, PersonDto.class));
    }

    /**
     * Update person
     *
     * @param dto
     * @param id
     * @return Person object
     */
    @Put(value = "/{id}", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public HttpResponse<PersonDto> update(@Valid @Body PersonRequestDto dto, @PathVariable("id") long id) {
        Person person = personService.update(id, ObjectMapperUtils.map(dto, Person.class));
        return HttpResponse.ok(ObjectMapperUtils.map(person, PersonDto.class));
    }

    /**
     * Delete person
     *
     * @param id
     * @return No content
     */
    @Delete(value = "/{id}", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public HttpResponse<Void> delete(@PathVariable("id") long id) {
        personService.delete(id);
        return HttpResponse.noContent();
    }
}
