package ce.android.com.factsfeed.runner;

import org.junit.runners.model.InitializationError;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.internal.bytecode.InstrumentationConfiguration;
import org.robolectric.manifest.AndroidManifest;

import java.lang.reflect.Method;

import ce.android.com.factsfeed.BuildConfig;
import ce.android.com.factsfeed.Utils.Utils;
import retrofit2.Call;

public class FactsFeedRobolectricTestRunner extends RobolectricGradleTestRunner {

    public FactsFeedRobolectricTestRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    public InstrumentationConfiguration createClassLoaderConfig() {
        InstrumentationConfiguration.Builder builder = InstrumentationConfiguration.newBuilder();
        builder.addInstrumentedClass(Call.class.getName());
        builder.addInstrumentedClass(Utils.class.getName());
        return builder.build();
    }

    @Override
    public Config getConfig(Method method) {
        Config config = super.getConfig(method);

        int sdk[] = new int[1];
        sdk[0] = 18;
        config = new Config.Implementation(sdk,
                config.manifest(),
                config.qualifiers(),
                config.packageName(),
                config.resourceDir(),
                config.assetDir(),
                config.shadows(),
                config.application(),
                config.libraries(),
                ensureBuildConfig(config.constants()));

        return config;
    }

    private Class<?> ensureBuildConfig(Class<?> constants) {
        if (constants == Void.class) return BuildConfig.class;
        return constants;
    }
}
