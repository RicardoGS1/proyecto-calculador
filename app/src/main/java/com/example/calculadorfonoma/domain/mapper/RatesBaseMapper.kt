package com.virtualworld.tienda_muebles_plastico.domain.mapper

interface RatesBaseMapper<I, O> {
    fun map(input: I): O
}
