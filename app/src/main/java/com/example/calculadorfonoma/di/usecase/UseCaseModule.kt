package com.example.calculadorfonoma.di.usecase

import com.example.calculadorfonoma.domain.usecase.GetRatesUseCase
import com.example.calculadorfonoma.domain.usecase.GetRatesUseCaseImpl


import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {



    @Binds
    @ViewModelScoped
    abstract fun bindGetRatesUseCase(
        getRatesUseCaseImpl: GetRatesUseCaseImpl,
    ): GetRatesUseCase


}
