package com.obaydullah.ucm.entities;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Contact {

    @Id
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String picture;
    @Column(length = 10000 , columnDefinition = "TEXT")
    private String description;
    private boolean favorite = false;
    private String websiteLink;
    private String linkedinLink;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "contact",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    private List<SocialLink> links=new ArrayList<>();
}
