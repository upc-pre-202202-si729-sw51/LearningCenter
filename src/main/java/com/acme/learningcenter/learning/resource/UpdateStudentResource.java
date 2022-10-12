package com.acme.learningcenter.learning.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UpdateStudentResource {

    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String name;

    @Min(18)
    private int age;

    @Size(max = 240)
    private String address;
}
