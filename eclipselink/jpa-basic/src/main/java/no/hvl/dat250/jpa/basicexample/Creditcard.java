package no.hvl.dat250.jpa.basicexample;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Data
public class Creditcard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer number;
    private Integer limit;
    private Integer balance;

    @ManyToOne
    private Person creditcardpersons;

    @ManyToOne
    private Bank creditcardbanks;

    @OneToOne
    private Pin creditcardpin;
    
}
