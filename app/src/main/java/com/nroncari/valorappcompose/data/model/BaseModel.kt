package com.nroncari.valorappcompose.data.model

data class BaseModel<T>(
    val status: Int,
    val data: T
)
