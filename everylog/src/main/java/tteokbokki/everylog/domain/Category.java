package tteokbokki.everylog.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "CATEGORY")
@Entity
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "category_name")
    private String name; //카테고리 이름

    // 1 : N (카테고리)
    @OneToMany(mappedBy = "category")
    private List<Post> posts = new ArrayList<>();
}