package com.example.Blogging.models;

import com.example.Blogging.dto.UserDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "post")
@NoArgsConstructor
@Setter
@Getter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;

    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @Column(length = 10000, nullable = false)
    private String content;


    @Column(nullable = false)
    private Date addedDate;

    @ManyToOne
    private User user;


    //@OneToMany(mappedBy = "post")
//   @OneToOne(fetch = FetchType.LAZY)// remove this ...not needed...why ??
//   @JoinColumn(nullable = false , name = "fk_user_ID")
    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Comment> commentList = new HashSet<>();
}
