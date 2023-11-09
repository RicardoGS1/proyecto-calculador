package com.example.calculadorfonoma.di

import com.virtualworld.tienda_muebles_plastico.data.repository.RemoteRepository
import com.example.calculadorfonoma.data.repository.RemoteRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RemoteRepositoryModule
{

    @Binds
    @ViewModelScoped
    abstract fun bindRemoteRepository(
        repository: RemoteRepositoryImpl,
    ): RemoteRepository




}
