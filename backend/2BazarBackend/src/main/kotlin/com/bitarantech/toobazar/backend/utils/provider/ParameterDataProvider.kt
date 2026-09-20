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

        categories.find { it.name == "موبایل" }?.let { category ->

            parameters += createParameterEntity(
                name = "سیستم عامل",
                parameterDataType = ParameterDataType.FixedOption,
                acceptedOptions = listOf(
                    "Android",
                    "iOS"
                ),
                category = category
            )

            parameters += createParameterEntity(
                name = "ظرفیت باتری",
                parameterDataType = ParameterDataType.StringInput,
                category = category
            )

            parameters += createParameterEntity(
                name = "تعداد سیم‌کارت",
                parameterDataType = ParameterDataType.FixedOption,
                acceptedOptions = listOf(
                    "تک سیم‌کارت",
                    "دو سیم‌کارت"
                ),
                category = category
            )
        }

        categories.find { it.name == "لپ‌تاپ" }?.let { category ->

            parameters += createParameterEntity(
                name = "پردازنده",
                parameterDataType = ParameterDataType.StringInput,
                category = category
            )

            parameters += createParameterEntity(
                name = "حافظه RAM",
                parameterDataType = ParameterDataType.FixedOption,
                acceptedOptions = listOf(
                    "4 GB",
                    "8 GB",
                    "16 GB",
                    "32 GB",
                    "64 GB"
                ),
                category = category
            )

            parameters += createParameterEntity(
                name = "اندازه صفحه‌نمایش",
                parameterDataType = ParameterDataType.FixedOption,
                acceptedOptions = listOf(
                    "13 اینچ",
                    "14 اینچ",
                    "15.6 اینچ",
                    "16 اینچ",
                    "17 اینچ"
                ),
                category = category
            )
        }

        categories.find { it.name == "آپارتمان" }?.let { category ->

            parameters += createParameterEntity(
                name = "طبقه",
                parameterDataType = ParameterDataType.StringInput,
                category = category
            )

            parameters += createParameterEntity(
                name = "آسانسور",
                parameterDataType = ParameterDataType.FixedOption,
                acceptedOptions = listOf(
                    "دارد",
                    "ندارد"
                ),
                category = category
            )

            parameters += createParameterEntity(
                name = "انباری",
                parameterDataType = ParameterDataType.FixedOption,
                acceptedOptions = listOf(
                    "دارد",
                    "ندارد"
                ),
                category = category
            )
        }

        categories.find { it.name == "سواری" }?.let { category ->

            parameters += createParameterEntity(
                name = "نوع گیربکس",
                parameterDataType = ParameterDataType.FixedOption,
                acceptedOptions = listOf(
                    "دستی",
                    "اتوماتیک"
                ),
                category = category
            )

            parameters += createParameterEntity(
                name = "نوع سوخت",
                parameterDataType = ParameterDataType.FixedOption,
                acceptedOptions = listOf(
                    "بنزینی",
                    "دوگانه‌سوز",
                    "هیبریدی",
                    "برقی"
                ),
                category = category
            )

            parameters += createParameterEntity(
                name = "کارکرد",
                parameterDataType = ParameterDataType.StringInput,
                category = category
            )
        }

        categories.find { it.name == "کفش" }?.let { category ->

            parameters += createParameterEntity(
                name = "سایز",
                parameterDataType = ParameterDataType.FixedOption,
                acceptedOptions = listOf(
                    "36",
                    "37",
                    "38",
                    "39",
                    "40",
                    "41",
                    "42",
                    "43",
                    "44",
                    "45"
                ),
                category = category
            )

            parameters += createParameterEntity(
                name = "جنس رویه",
                parameterDataType = ParameterDataType.StringInput,
                category = category
            )

            parameters += createParameterEntity(
                name = "نوع کفش",
                parameterDataType = ParameterDataType.FixedOption,
                acceptedOptions = listOf(
                    "روزمره",
                    "ورزشی",
                    "مجلسی",
                    "کوهستان"
                ),
                category = category
            )
        }

        return parameters
    }
}