package de.dafrit.dwb.faker.input.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Rubrik {

    @Id
    Long id;

    String nr;

}
