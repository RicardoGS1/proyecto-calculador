package com.virtualworld3d.calculadorfonoma.di.mappers


import com.virtualworld3d.calculadorfonoma.data.dto.Rates
import com.virtualworld3d.calculadorfonoma.data.mapper.ListRatesEntityRoomToRatesEntityMapper
import com.virtualworld3d.calculadorfonoma.data.mapper.RatesEntityToListRatesEntityRoomMapper
import com.virtualworld3d.calculadorfonoma.data.mapper.RatesToRatesEntityMapper
import com.virtualworld3d.calculadorfonoma.domain.entity.RatesEntity
import com.virtualworld3d.calculadorfonoma.domain.entity.RatesEntityRoom
import com.virtualworld3d.calculadorfonoma.domain.mapper.RatesBaseMapper
import com.virtualworld3d.calculadorfonoma.domain.mapper.RatesListToSingleMapper
import com.virtualworld3d.calculadorfonoma.domain.mapper.RatesSingleToListMapper
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
