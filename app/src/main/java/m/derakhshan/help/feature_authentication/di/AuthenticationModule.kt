package m.derakhshan.help.feature_authentication.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import m.derakhshan.help.feature_authentication.domain.use_case.AuthenticationUseCases
import m.derakhshan.help.feature_authentication.domain.use_case.LoginUseCase
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AuthenticationModule {

    @Provides
    @Singleton
    fun provideAuthenticationUseCases(): AuthenticationUseCases {
        return AuthenticationUseCases(
            login = LoginUseCase()
        )
    }

}