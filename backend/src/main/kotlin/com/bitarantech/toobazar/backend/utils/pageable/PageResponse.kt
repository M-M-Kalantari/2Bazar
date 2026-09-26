package com.bitarantech.toobazar.backend.utils.pageable

import org.springframework.data.domain.Page

data class PageResponse <T>(
    val content: List<T>,
    val totalPage: Int,
    val totalElements: Long,
    val isFirst: Boolean,
    val isLast: Boolean,
)

fun <T : Any, R> Page<T>.toPageResponse(
    mapper: (T) -> R
): PageResponse<R> {
    return PageResponse(
        content = content.map(mapper),
        totalPage = totalPages,
        totalElements = totalElements,
        isFirst = isFirst,
        isLast = isLast
    )
}