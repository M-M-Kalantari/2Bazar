package com.bitarantech.toobazar.backend

import com.bitarantech.toobazar.backend.database.entities.LocProvinceEntity
import com.bitarantech.toobazar.backend.database.services.LocCityService
import com.bitarantech.toobazar.backend.database.services.LocNeighborhoodService
import com.bitarantech.toobazar.backend.database.services.LocProvinceService
import com.bitarantech.toobazar.backend.utils.provider.LocationDataProvider
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ConfigurableApplicationContext

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    val context = runApplication<Application>(*args)
    initLocations(context)
}

fun initLocations(context: ConfigurableApplicationContext) {
    val provinceService = context.getBean(LocProvinceService::class.java)
    val cityService = context.getBean(LocCityService::class.java)
    val neighborhoodService = context.getBean(LocNeighborhoodService::class.java)

    val tripleList = LocationDataProvider.getData()

    if (neighborhoodService.count() < 1){
        provinceService.saveAll(tripleList.first)
        cityService.saveAll(tripleList.second)
        neighborhoodService.saveAll(tripleList.third)
    }
}
