package com.bitarantech.toobazar.backend.utils.provider

import com.bitarantech.toobazar.backend.database.entities.CategoryEntity
import com.bitarantech.toobazar.backend.database.entities.ParameterEntity
import com.bitarantech.toobazar.backend.database.other.ParameterDataType

object ParameterDataProvider {

    private fun List<String>.toAcceptedString(): String {
        return joinToString(", ")
    }

    private fun createParameterEntity(
        name: String,
        parameterDataType: ParameterDataType,
        category: CategoryEntity,
        acceptedOptions: List<String> = emptyList()
    ): ParameterEntity {
        return ParameterEntity(
            name = name,
            dataType = parameterDataType,
            acceptedOptions = acceptedOptions.takeIf { it.isNotEmpty() }?.toAcceptedString(),
            category = category
        )
    }

    fun getData(categories: List<CategoryEntity>): List<ParameterEntity> {

        val parameters = mutableListOf<ParameterEntity>()

        categories.find { it.name == "املاک" }?.let { category ->

            parameters += createParameterEntity(
                name = "نوع ملک",
                parameterDataType = ParameterDataType.FixedOption,
                acceptedOptions = listOf(
                    "آپارتمان",
                    "خانه و ویلا",
                    "دفتر کار",
                    "مغازه"
                ),
                category = category
            )

            parameters += createParameterEntity(
                name = "متراژ",
                parameterDataType = ParameterDataType.FloatInput,
                category = category
            )

            parameters += createParameterEntity(
                name = "تعداد اتاق",
                parameterDataType = ParameterDataType.FixedOption,
                acceptedOptions = listOf(
                    "بدون اتاق",
                    "یک",
                    "دو",
                    "سه",
                    "چهار",
                    "پنج و بیشتر"
                ),
                category = category
            )

            parameters += createParameterEntity(
                name = "سال ساخت",
                parameterDataType = ParameterDataType.FixedOption,
                acceptedOptions = (1405 downTo 1370).map { it.toString() } + "قبل از 1370",
                category = category
            )

            parameters += createParameterEntity(
                name = "پارکینگ",
                parameterDataType = ParameterDataType.FixedOption,
                acceptedOptions = listOf("دارد", "ندارد"),
                category = category
            )
        }

        categories.find { it.name == "وسایل نقلیه" }?.let { category ->

            parameters += createParameterEntity(
                name = "نوع وسیله",
                parameterDataType = ParameterDataType.FixedOption,
                acceptedOptions = listOf(
                    "خودرو",
                    "موتورسیکلت",
                    "قطعات یدکی"
                ),
                category = category
            )

            parameters += createParameterEntity(
                name = "برند و مدل",
                parameterDataType = ParameterDataType.StringInput,
                category = category
            )

            parameters += createParameterEntity(
                name = "مدل سال",
                parameterDataType = ParameterDataType.FixedOption,
                acceptedOptions = (1405 downTo 1370).map { it.toString() } + "قبل از 1370",
                category = category
            )

            parameters += createParameterEntity(
                name = "رنگ",
                parameterDataType = ParameterDataType.FixedOption,
                acceptedOptions = listOf(
                    "سفید",
                    "مشکی",
                    "خاکستری",
                    "نقره‌ای",
                    "آبی",
                    "قرمز",
                    "سبز",
                    "سایر"
                ),
                category = category
            )

            parameters += createParameterEntity(
                name = "وضعیت",
                parameterDataType = ParameterDataType.FixedOption,
                acceptedOptions = listOf(
                    "نو",
                    "کارکرده",
                    "نیاز به تعمیر"
                ),
                category = category
            )
        }

        categories.find { it.name == "کالای دیجیتال" }?.let { category ->

            parameters += createParameterEntity(
                name = "برند و مدل",
                parameterDataType = ParameterDataType.StringInput,
                category = category
            )

            parameters += createParameterEntity(
                name = "وضعیت",
                parameterDataType = ParameterDataType.FixedOption,
                acceptedOptions = listOf(
                    "نو",
                    "در حد نو",
                    "کارکرده",
                    "نیاز به تعمیر"
                ),
                category = category
            )

            parameters += createParameterEntity(
                name = "رنگ",
                parameterDataType = ParameterDataType.StringInput,
                category = category
            )

            parameters += createParameterEntity(
                name = "حافظه داخلی",
                parameterDataType = ParameterDataType.StringInput,
                category = category
            )

            parameters += createParameterEntity(
                name = "اصالت برند",
                parameterDataType = ParameterDataType.FixedOption,
                acceptedOptions = listOf(
                    "اصل",
                    "غیراصل"
                ),
                category = category
            )
        }

        categories.find { it.name == "خانه و آشپزخانه" }?.let { category ->

            parameters += createParameterEntity(
                name = "نوع کالا",
                parameterDataType = ParameterDataType.StringInput,
                category = category
            )

            parameters += createParameterEntity(
                name = "برند",
                parameterDataType = ParameterDataType.StringInput,
                category = category
            )

            parameters += createParameterEntity(
                name = "وضعیت",
                parameterDataType = ParameterDataType.FixedOption,
                acceptedOptions = listOf(
                    "نو",
                    "در حد نو",
                    "کارکرده",
                    "نیاز به تعمیر"
                ),
                category = category
            )

            parameters += createParameterEntity(
                name = "رنگ",
                parameterDataType = ParameterDataType.StringInput,
                category = category
            )

            parameters += createParameterEntity(
                name = "جنس",
                parameterDataType = ParameterDataType.StringInput,
                category = category
            )
        }

        categories.find { it.name == "وسایل شخصی" }?.let { category ->

            parameters += createParameterEntity(
                name = "نوع کالا",
                parameterDataType = ParameterDataType.StringInput,
                category = category
            )

            parameters += createParameterEntity(
                name = "برند",
                parameterDataType = ParameterDataType.StringInput,
                category = category
            )

            parameters += createParameterEntity(
                name = "وضعیت",
                parameterDataType = ParameterDataType.FixedOption,
                acceptedOptions = listOf(
                    "نو",
                    "در حد نو",
                    "کارکرده"
                ),
                category = category
            )

            parameters += createParameterEntity(
                name = "رنگ",
                parameterDataType = ParameterDataType.StringInput,
                category = category
            )

            parameters += createParameterEntity(
                name = "جنس",
                parameterDataType = ParameterDataType.StringInput,
                category = category
            )
        }

        return parameters
    }
}