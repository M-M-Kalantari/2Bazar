package com.bitarantech.toobazar.network.model

data class FailureResponse(
    val status: Status = Status.Failure,
    val message: String = "",
    val errorCode: Int
)