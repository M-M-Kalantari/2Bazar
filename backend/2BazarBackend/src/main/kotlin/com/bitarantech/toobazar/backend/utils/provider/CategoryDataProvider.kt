package com.bitarantech.toobazar.backend.utils.provider

import com.bitarantech.toobazar.backend.database.entities.CategoryEntity


data class CategoryData(
    val name: String,
    val icon: String = "",
    val children: List<CategoryData> = emptyList()
)


object CategoryDataProvider {

    private val data = listOf(

        // ─────────────────────────────────────────────
        // املاک
        // ─────────────────────────────────────────────
        CategoryData(
            name = "املاک",
            icon = "real_estate",
            children = listOf(

                CategoryData(
                    name = "اجاره مسکونی",
                    children = listOf(
                        CategoryData(name = "آپارتمان"),
                        CategoryData(name = "خانه و ویلا")
                    )
                ),

                CategoryData(
                    name = "فروش مسکونی",
                    children = listOf(
                        CategoryData(name = "آپارتمان"),
                        CategoryData(name = "خانه و ویلا")
                    )
                ),

                CategoryData(
                    name = "فروش اداری و تجاری",
                    children = listOf(
                        CategoryData(name = "دفتر کار و اتاق اداری"),
                        CategoryData(name = "مغازه و غرفه")
                    )
                )
            )
        ),

        // ─────────────────────────────────────────────
        // وسایل نقلیه
        // ─────────────────────────────────────────────
        CategoryData(
            name = "وسایل نقلیه",
            icon = "vehicles",
            children = listOf(

                CategoryData(
                    name = "خودرو",
                    children = listOf(
                        CategoryData(name = "سواری"),
                        CategoryData(name = "وانت")
                    )
                ),

                CategoryData(
                    name = "موتورسیکلت",
                    children = listOf(
                        CategoryData(name = "شهری"),
                        CategoryData(name = "سنگین")
                    )
                ),

                CategoryData(
                    name = "قطعات و لوازم یدکی",
                    children = listOf(
                        CategoryData(name = "قطعات خودرو"),
                        CategoryData(name = "قطعات موتورسیکلت")
                    )
                )
            )
        ),

        // ─────────────────────────────────────────────
        // کالای دیجیتال
        // ─────────────────────────────────────────────
        CategoryData(
            name = "کالای دیجیتال",
            icon = "electronic_devices",
            children = listOf(

                CategoryData(
                    name = "موبایل و تبلت",
                    children = listOf(
                        CategoryData(name = "موبایل"),
                        CategoryData(name = "تبلت")
                    )
                ),

                CategoryData(
                    name = "لپ‌تاپ و کامپیوتر",
                    children = listOf(
                        CategoryData(name = "لپ‌تاپ"),
                        CategoryData(name = "کامپیوتر رومیزی")
                    )
                ),

                CategoryData(
                    name = "لوازم جانبی دیجیتال",
                    children = listOf(
                        CategoryData(name = "هدفون و هندزفری"),
                        CategoryData(name = "شارژر و کابل")
                    )
                )
            )
        ),

        // ─────────────────────────────────────────────
        // خانه و آشپزخانه
        // ─────────────────────────────────────────────
        CategoryData(
            name = "خانه و آشپزخانه",
            icon = "home_kitchen",
            children = listOf(

                CategoryData(
                    name = "مبلمان و دکوراسیون",
                    children = listOf(
                        CategoryData(name = "مبل"),
                        CategoryData(name = "میز و صندلی")
                    )
                ),

                CategoryData(
                    name = "لوازم خانگی",
                    children = listOf(
                        CategoryData(name = "یخچال و فریزر"),
                        CategoryData(name = "ماشین لباسشویی")
                    )
                ),

                CategoryData(
                    name = "لوازم آشپزخانه",
                    children = listOf(
                        CategoryData(name = "ظروف"),
                        CategoryData(name = "لوازم پخت‌وپز")
                    )
                )
            )
        ),

        // ─────────────────────────────────────────────
        // وسایل شخصی
        // ─────────────────────────────────────────────
        CategoryData(
            name = "وسایل شخصی",
            icon = "personal_goods",
            children = listOf(

                CategoryData(
                    name = "پوشاک",
                    children = listOf(
                        CategoryData(name = "لباس مردانه"),
                        CategoryData(name = "لباس زنانه")
                    )
                ),

                CategoryData(
                    name = "کیف و کفش",
                    children = listOf(
                        CategoryData(name = "کیف"),
                        CategoryData(name = "کفش")
                    )
                ),

                CategoryData(
                    name = "زیورآلات و ساعت",
                    children = listOf(
                        CategoryData(name = "ساعت"),
                        CategoryData(name = "زیورآلات")
                    )
                )
            )
        )
    )


    fun getData(): List<CategoryEntity> {

        val categories = mutableListOf<CategoryEntity>()

        fun createCategories(
            categoryData: CategoryData,
            parent: CategoryEntity? = null
        ) {

            val category = CategoryEntity(
                name = categoryData.name,
                icon = categoryData.icon,
                parent = parent
            )

            categories.add(category)

            categoryData.children.forEach { child ->

                createCategories(
                    categoryData = child,
                    parent = category
                )
            }
        }

        data.forEach { categoryData ->
            createCategories(categoryData)
        }

        return categories
    }
}