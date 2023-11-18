package com.example.calculadorfonoma.di.mappers


import com.example.calculadorfonoma.data.dto.Rates
import com.example.calculadorfonoma.data.mapper.RatesEntityMapper
import com.example.calculadorfonoma.data.mapper.RatesEntityRoomMapper
import com.example.calculadorfonoma.domain.entity.RatesEntity
import com.example.calculadorfonoma.domain.entity.RatesEntityRoom
import com.example.calculadorfonoma.domain.mapper.ProductListMapper
import com.example.calculadorfonoma.domain.mapper.RatesBaseMapper
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
    abstract fun bindRatesEntityRoomMapper(ratesEntityRoomMapper: RatesEntityRoomMapper): ProductListMapper<RatesEntity, RatesEntityRoom>




}
