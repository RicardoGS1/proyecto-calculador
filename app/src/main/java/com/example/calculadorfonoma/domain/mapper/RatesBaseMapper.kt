package com.example.calculadorfonoma.domain.mapper

interface RatesBaseMapper<I, O> {
    fun map(input: I): O
}
