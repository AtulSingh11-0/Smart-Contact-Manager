package com.demo.smart_contact_manager.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String phoneNumber;
  private String address;

  @Column(length = 1000)
  private String imageUrl;

  @Column(length = 1000)
  private String description;
  private Boolean isFavorite=false;
  private Boolean isBlocked=false;

  @Column(length = 1000)
  private String websiteLink;

  @ManyToOne
  private User user;

  @OneToMany(
      mappedBy = "contact",
      cascade = CascadeType.ALL,
      fetch = FetchType.EAGER,
      orphanRemoval = true
  )
  private List<SocialLink> socialLinks=new ArrayList<>();

}
