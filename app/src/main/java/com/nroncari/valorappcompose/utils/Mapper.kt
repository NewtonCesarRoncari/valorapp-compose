package com.nroncari.valorappcompose.utils

interface Mapper<S, T> {
    fun map(source: S): T
}
