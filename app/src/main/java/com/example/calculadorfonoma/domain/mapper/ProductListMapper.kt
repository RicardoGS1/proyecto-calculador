package com.example.calculadorfonoma.domain.mapper



//product->productEntry
//productEntry->productUI
interface ProductListMapper<I, O> : RatesBaseMapper<I, List<O>>
