package m.derakhshan.help.feature_authentication.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import m.derakhshan.help.feature_authentication.data.repository.AuthenticationRepositoryImpl
import m.derakhshan.help.feature_authentication.domain.repository.AuthenticationRepository
import m.derakhshan.help.feature_authentication.domain.use_case.AuthenticationUseCases
import m.derakhshan.help.feature_authentication.domain.use_case.LoginUseCase
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AuthenticationModule {

    @Provides
    @Singleton
    fun provideAuthenticationRepository(): AuthenticationRepository {
        return AuthenticationRepositoryImpl()
    }


    @Provides
    @Singleton
    fun provideAuthenticationUseCases(repository: AuthenticationRepository): AuthenticationUseCases {
        return AuthenticationUseCases(
            login = LoginUseCase(repository = repository)
        )
    }

}