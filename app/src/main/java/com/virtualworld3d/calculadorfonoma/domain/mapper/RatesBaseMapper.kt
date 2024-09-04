package com.virtualworld3d.calculadorfonoma.domain.mapper

interface RatesBaseMapper<I, O> {
    fun map(input: I): O
}
