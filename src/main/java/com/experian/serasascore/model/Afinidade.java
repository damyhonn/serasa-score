package com.experian.serasascore.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Afinidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(unique=true)
    private String regiao;
    @ElementCollection
    @CollectionTable(name = "estados", joinColumns = @JoinColumn(name = "id"))
    private List<String> estados;

}
