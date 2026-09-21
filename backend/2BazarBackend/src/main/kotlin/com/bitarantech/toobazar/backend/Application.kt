package com.bitarantech.toobazar.backend

import com.bitarantech.toobazar.backend.database.feature_based.category.CategoryService
import com.bitarantech.toobazar.backend.database.feature_based.location.service.LocCityService
import com.bitarantech.toobazar.backend.database.feature_based.location.service.LocNeighborhoodService
import com.bitarantech.toobazar.backend.database.feature_based.location.service.LocProvinceService
import com.bitarantech.toobazar.backend.database.feature_based.parameter.service.ParameterService
import com.bitarantech.toobazar.backend.utils.provider.CategoryDataProvider
import com.bitarantech.toobazar.backend.utils.provider.LocationDataProvider
import com.bitarantech.toobazar.backend.utils.provider.ParameterDataProvider
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ConfigurableApplicationContext

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    val context = runApplication<Application>(*args)
    initLocations(context)
    initCategories(context)
    initParameters(context)
}

fun initLocations(context: ConfigurableApplicationContext) {
    val provinceService = context.getBean(LocProvinceService::class.java)
    val cityService = context.getBean(LocCityService::class.java)
    val neighborhoodService = context.getBean(LocNeighborhoodService::class.java)

    val tripleList = LocationDataProvider.getData()

    if (neighborhoodService.count() < 1) {
        provinceService.saveAll(tripleList.first)
        cityService.saveAll(tripleList.second)
        neighborhoodService.saveAll(tripleList.third)
    }
}

fun initCategories(context: ConfigurableApplicationContext) {
    val categoryService = context.getBean(CategoryService::class.java)

    val list = CategoryDataProvider.getData()

    if (categoryService.count() < 1) {
        categoryService.saveAll(list)
    }
}

fun initParameters(context: ConfigurableApplicationContext) {
    val parameterService = context.getBean(ParameterService::class.java)
    val categoryService = context.getBean(CategoryService::class.java)

    val list = ParameterDataProvider.getData(categoryService.findAllEntities())

    if (parameterService.count() < 1) {
        parameterService.saveAll(list)
    }
}
