package com.bitarantech.toobazar.backend.database.entities

import jakarta.persistence.*

@Entity(name = "category")
data class CategoryEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,

    val icon: String = "",

    @ManyToOne()
    @JoinColumn(name = "parent_id", nullable = true)
    val parent: CategoryEntity? = null,

    @OneToMany(mappedBy = "parent")
    val children: List<CategoryEntity> = listOf(),
)