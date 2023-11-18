package com.example.calculadorfonoma.di.Source

import com.example.calculadorfonoma.data.source.remote.LocalDataSource
import com.example.calculadorfonoma.data.source.remote.LocalDataSourceImp
import com.virtualworld.tienda_muebles_plastico.data.source.remote.RemoteDataSource
import com.virtualworld.tienda_muebles_plastico.data.source.remote.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RemoteSourceModule {

    @Binds
    @ViewModelScoped
    abstract fun bindDataSource(
        dataSource: RemoteDataSourceImpl,
    ): RemoteDataSource


    @Binds
    @ViewModelScoped
    abstract fun bindLocalDataSource(
        localDataSource: LocalDataSourceImp,
    ): LocalDataSource
}
