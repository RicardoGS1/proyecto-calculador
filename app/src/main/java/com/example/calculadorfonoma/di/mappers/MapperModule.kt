package com.virtualworld.tienda_muebles_plastico.di.mappers

import com.example.calculadorfonoma.data.dto.Rates
import com.example.calculadorfonoma.data.mapper.RatesEntityMapper
import com.example.calculadorfonoma.domain.entity.RatesEntity
import com.example.calculadorfonoma.ui.mapper.RatesEntityToUiMapper
import com.example.calculadorfonoma.ui.uiData.RatesUiData


import com.virtualworld.tienda_muebles_plastico.domain.mapper.RatesBaseMapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class MapperModule {

    @Binds
    @ViewModelScoped
    abstract fun bindRatesEntityMapper(ratesEntityMapper: RatesEntityMapper): RatesBaseMapper<Rates, RatesEntity>


    @Binds
    @ViewModelScoped
    abstract fun bindRatesUiMapper(ratesEntityToUiMapper: RatesEntityToUiMapper): RatesBaseMapper<RatesEntity, RatesUiData>




}
