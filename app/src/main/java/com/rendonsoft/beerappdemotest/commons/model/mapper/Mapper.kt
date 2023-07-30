package com.rendonsoft.beerappdemotest.commons.model.mapper

interface Mapper<K, T> {
    fun map(input : K) : T
}