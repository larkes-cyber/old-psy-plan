package lolka.example.PsyPath.di

import lolka.example.PsyPath.data.storage.database_for_goals.repository.DataBaseRepository
import dagger.Component
import lolka.example.PsyPath.presentation.fragment.*

@Component(modules = [AppModule::class,DomainModule::class, DataModule::class])
 interface AppComponent {
    fun injectDataBaseRepository(dataBaseRepository: DataBaseRepository)
    fun injectSomeFragment(authFragment: AuthFragment)
    fun injectPatientProfileFragment(patientFragment: ProfileOfPatientFragment)
    fun injectSignOrAuthFragment(signInOrAuth: SignInOrAuth)
    fun injectStateFragment(stateFragment: StateFragment)
    fun injectSignInFragment(signIn1: SignIn1)
}