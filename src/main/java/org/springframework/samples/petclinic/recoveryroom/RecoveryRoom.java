package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.core.sym.Name;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class RecoveryRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotBlank
    @Size(min = 3, max = 50)
    String name;

    @NotNull
    @PositiveOrZero
    double size;

    @NotNull
    boolean secure;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "type_id")
    RecoveryRoomType roomType;
}
