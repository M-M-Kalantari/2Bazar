package com.bitarantech.toobazar.backend.database.feature_based.image

import com.bitarantech.toobazar.backend.database.feature_based.ads.AdsEntity
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

@Service
class ImageService(
    val repository: ImageRepository
) {
    private val uploadDir = "uploads/images/"

    init {
        val file = File(uploadDir)
        if (!file.exists()) {
            file.mkdirs()
        }
    }

    fun save(file: MultipartFile, ads: AdsEntity?): ImageEntity {
        val allowedTypes = setOf(
            "image/jpeg",
            "image/png",
            "image/webp"
        )
        if (file.contentType !in allowedTypes) {
            throw IllegalArgumentException("Invalid image type")
        }

        val extension = file.originalFilename
            ?.substringAfterLast('.', "")
            ?.lowercase()
            ?: "jpg"
        val formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")
        val timestamp = LocalDateTime.now().format(formatter)

        val fileName = "IMG_${timestamp}_${UUID.randomUUID()}.$extension"
        val filePath = Paths.get(uploadDir, fileName)

        file.inputStream.use { input ->
            Files.copy(
                input,
                filePath,
                StandardCopyOption.REPLACE_EXISTING
            )
        }

        val image = ImageEntity(
            path = filePath.toString(),
            ads = ads
        )

        return repository.save(image)
    }

    fun saveAll(files: List<MultipartFile>, ads: AdsEntity): List<ImageEntity> {
        val images: MutableList<ImageEntity> = mutableListOf()
        files.forEach { file ->
            images.add(save(file, ads))
        }
        return images
    }
}