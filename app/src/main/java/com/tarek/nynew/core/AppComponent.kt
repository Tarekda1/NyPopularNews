import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import com.tarek.nynew.App
import com.tarek.nynew.core.builder.ActivityBuilder
import com.tarek.nynew.core.builder.FragmentBuilder
import com.tarek.nynew.core.di.modules.*
import com.tarek.nynew.main.di.NyNewsDomain
import com.tarek.nynew.main.di.NyNewsPresentationModule
import com.tarek.nynew.main.di.NyRemoteModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        NetworkModule::class, ContextModule::class,
        CacheProvider::class,
        ActivityBuilder::class,
        SchedulersModule::class,
        CoroutinesThreadsProvider::class,
        FragmentBuilder::class,
        NyRemoteModule::class,
        NyNewsDomain::class,
        NyNewsPresentationModule::class
    ]
)
interface AppComponent {

    fun inject(app: App)

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

}