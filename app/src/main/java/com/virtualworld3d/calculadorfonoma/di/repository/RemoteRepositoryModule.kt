package com.virtualworld3d.calculadorfonoma.di.repository

import com.virtualworld3d.calculadorfonoma.data.repository.LocalRepository
import com.virtualworld3d.calculadorfonoma.data.repository.LocalRepositoryImp
import com.virtualworld3d.calculadorfonoma.data.repository.RemoteRepositoryImpl
import com.virtualworld3d.calculadorfonoma.data.repository.RemoteRepository
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

    @Binds
    @ViewModelScoped
    abstract fun bindLocalRepository(
        localRepository: LocalRepositoryImp,
    ): LocalRepository






}
