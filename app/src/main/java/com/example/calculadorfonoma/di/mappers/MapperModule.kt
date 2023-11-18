package com.example.calculadorfonoma.di.mappers


import com.example.calculadorfonoma.data.dto.Rates
import com.example.calculadorfonoma.data.mapper.ListRatesEntityRoomToRatesEntityMapper
import com.example.calculadorfonoma.data.mapper.RatesEntityToListRatesEntityRoomMapper
import com.example.calculadorfonoma.data.mapper.RatesToRatesEntityMapper
import com.example.calculadorfonoma.domain.entity.RatesEntity
import com.example.calculadorfonoma.domain.entity.RatesEntityRoom
import com.example.calculadorfonoma.domain.mapper.RatesBaseMapper
import com.example.calculadorfonoma.domain.mapper.RatesListToSingleMapper
import com.example.calculadorfonoma.domain.mapper.RatesSingleToListMapper
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
    abstract fun bindRatesToRatesEntityMapper(ratesToRatesEntityMapper: RatesToRatesEntityMapper): RatesBaseMapper<Rates, RatesEntity>


    @Binds
    @ViewModelScoped
    abstract fun bindRatesEntityToListRatesEntityRoomMapper(ratesEntityToListRatesEntityRoomMapper: RatesEntityToListRatesEntityRoomMapper): RatesSingleToListMapper<RatesEntity, RatesEntityRoom>


    @Binds
    @ViewModelScoped
    abstract fun bindListRatesEntityRoomToRatesEntityMapper(listRatesEntityRoomToRatesEntityMapper: ListRatesEntityRoomToRatesEntityMapper): RatesListToSingleMapper<RatesEntityRoom, RatesEntity >




}
