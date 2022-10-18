package ir.maktab74.phonebook.entity;

import ir.maktab74.phonebook.base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneBook extends BaseEntity<Long> implements Serializable {

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private User user;

    public PhoneBook(String name) {
        this.name = name;
    }
}
