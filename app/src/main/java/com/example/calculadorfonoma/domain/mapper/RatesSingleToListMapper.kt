package com.example.calculadorfonoma.domain.mapper



//product->productEntry
//productEntry->productUI
interface RatesSingleToListMapper<I, O> : RatesBaseMapper<I, List<O>>
