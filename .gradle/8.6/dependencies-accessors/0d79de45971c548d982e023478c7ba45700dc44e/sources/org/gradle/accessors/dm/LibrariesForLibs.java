package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the {@code libs} extension.
 */
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final DevLibraryAccessors laccForDevLibraryAccessors = new DevLibraryAccessors(owner);
    private final IoLibraryAccessors laccForIoLibraryAccessors = new IoLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

    /**
     * Group of libraries at <b>dev</b>
     */
    public DevLibraryAccessors getDev() {
        return laccForDevLibraryAccessors;
    }

    /**
     * Group of libraries at <b>io</b>
     */
    public IoLibraryAccessors getIo() {
        return laccForIoLibraryAccessors;
    }

    /**
     * Group of versions at <b>versions</b>
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Group of bundles at <b>bundles</b>
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Group of plugins at <b>plugins</b>
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class DevLibraryAccessors extends SubDependencyFactory {
        private final DevLangchain4jLibraryAccessors laccForDevLangchain4jLibraryAccessors = new DevLangchain4jLibraryAccessors(owner);

        public DevLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>dev.langchain4j</b>
         */
        public DevLangchain4jLibraryAccessors getLangchain4j() {
            return laccForDevLangchain4jLibraryAccessors;
        }

    }

    public static class DevLangchain4jLibraryAccessors extends SubDependencyFactory {
        private final DevLangchain4jLangchain4jLibraryAccessors laccForDevLangchain4jLangchain4jLibraryAccessors = new DevLangchain4jLangchain4jLibraryAccessors(owner);

        public DevLangchain4jLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>dev.langchain4j.langchain4j</b>
         */
        public DevLangchain4jLangchain4jLibraryAccessors getLangchain4j() {
            return laccForDevLangchain4jLangchain4jLibraryAccessors;
        }

    }

    public static class DevLangchain4jLangchain4jLibraryAccessors extends SubDependencyFactory {

        public DevLangchain4jLangchain4jLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>ollama</b> with <b>dev.langchain4j:langchain4j-ollama</b> coordinates and
         * with version reference <b>dev.langchain4j.langchain4j.ollama</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getOllama() {
            return create("dev.langchain4j.langchain4j.ollama");
        }

    }

    public static class IoLibraryAccessors extends SubDependencyFactory {
        private final IoQuarkusLibraryAccessors laccForIoQuarkusLibraryAccessors = new IoQuarkusLibraryAccessors(owner);
        private final IoRestLibraryAccessors laccForIoRestLibraryAccessors = new IoRestLibraryAccessors(owner);

        public IoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.quarkus</b>
         */
        public IoQuarkusLibraryAccessors getQuarkus() {
            return laccForIoQuarkusLibraryAccessors;
        }

        /**
         * Group of libraries at <b>io.rest</b>
         */
        public IoRestLibraryAccessors getRest() {
            return laccForIoRestLibraryAccessors;
        }

    }

    public static class IoQuarkusLibraryAccessors extends SubDependencyFactory {
        private final IoQuarkusQuarkusLibraryAccessors laccForIoQuarkusQuarkusLibraryAccessors = new IoQuarkusQuarkusLibraryAccessors(owner);

        public IoQuarkusLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.quarkus.quarkus</b>
         */
        public IoQuarkusQuarkusLibraryAccessors getQuarkus() {
            return laccForIoQuarkusQuarkusLibraryAccessors;
        }

    }

    public static class IoQuarkusQuarkusLibraryAccessors extends SubDependencyFactory {
        private final IoQuarkusQuarkusResteasyLibraryAccessors laccForIoQuarkusQuarkusResteasyLibraryAccessors = new IoQuarkusQuarkusResteasyLibraryAccessors(owner);

        public IoQuarkusQuarkusLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>arc</b> with <b>io.quarkus:quarkus-arc</b> coordinates and
         * with version reference <b>io.quarkus.quarkus.arc</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getArc() {
            return create("io.quarkus.quarkus.arc");
        }

        /**
         * Dependency provider for <b>junit5</b> with <b>io.quarkus:quarkus-junit5</b> coordinates and
         * with version reference <b>io.quarkus.quarkus.junit5</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJunit5() {
            return create("io.quarkus.quarkus.junit5");
        }

        /**
         * Group of libraries at <b>io.quarkus.quarkus.resteasy</b>
         */
        public IoQuarkusQuarkusResteasyLibraryAccessors getResteasy() {
            return laccForIoQuarkusQuarkusResteasyLibraryAccessors;
        }

    }

    public static class IoQuarkusQuarkusResteasyLibraryAccessors extends SubDependencyFactory {
        private final IoQuarkusQuarkusResteasyReactiveLibraryAccessors laccForIoQuarkusQuarkusResteasyReactiveLibraryAccessors = new IoQuarkusQuarkusResteasyReactiveLibraryAccessors(owner);

        public IoQuarkusQuarkusResteasyLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.quarkus.quarkus.resteasy.reactive</b>
         */
        public IoQuarkusQuarkusResteasyReactiveLibraryAccessors getReactive() {
            return laccForIoQuarkusQuarkusResteasyReactiveLibraryAccessors;
        }

    }

    public static class IoQuarkusQuarkusResteasyReactiveLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public IoQuarkusQuarkusResteasyReactiveLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>reactive</b> with <b>io.quarkus:quarkus-resteasy-reactive</b> coordinates and
         * with version reference <b>io.quarkus.quarkus.resteasy.reactive</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("io.quarkus.quarkus.resteasy.reactive");
        }

        /**
         * Dependency provider for <b>jackson</b> with <b>io.quarkus:quarkus-resteasy-reactive-jackson</b> coordinates and
         * with version reference <b>io.quarkus.quarkus.resteasy.reactive.jackson</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJackson() {
            return create("io.quarkus.quarkus.resteasy.reactive.jackson");
        }

    }

    public static class IoRestLibraryAccessors extends SubDependencyFactory {
        private final IoRestAssuredLibraryAccessors laccForIoRestAssuredLibraryAccessors = new IoRestAssuredLibraryAccessors(owner);

        public IoRestLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.rest.assured</b>
         */
        public IoRestAssuredLibraryAccessors getAssured() {
            return laccForIoRestAssuredLibraryAccessors;
        }

    }

    public static class IoRestAssuredLibraryAccessors extends SubDependencyFactory {
        private final IoRestAssuredRestLibraryAccessors laccForIoRestAssuredRestLibraryAccessors = new IoRestAssuredRestLibraryAccessors(owner);

        public IoRestAssuredLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.rest.assured.rest</b>
         */
        public IoRestAssuredRestLibraryAccessors getRest() {
            return laccForIoRestAssuredRestLibraryAccessors;
        }

    }

    public static class IoRestAssuredRestLibraryAccessors extends SubDependencyFactory {

        public IoRestAssuredRestLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>assured</b> with <b>io.rest-assured:rest-assured</b> coordinates and
         * with version reference <b>io.rest.assured.rest.assured</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAssured() {
            return create("io.rest.assured.rest.assured");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final DevVersionAccessors vaccForDevVersionAccessors = new DevVersionAccessors(providers, config);
        private final IoVersionAccessors vaccForIoVersionAccessors = new IoVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.dev</b>
         */
        public DevVersionAccessors getDev() {
            return vaccForDevVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.io</b>
         */
        public IoVersionAccessors getIo() {
            return vaccForIoVersionAccessors;
        }

    }

    public static class DevVersionAccessors extends VersionFactory  {

        private final DevLangchain4jVersionAccessors vaccForDevLangchain4jVersionAccessors = new DevLangchain4jVersionAccessors(providers, config);
        public DevVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.dev.langchain4j</b>
         */
        public DevLangchain4jVersionAccessors getLangchain4j() {
            return vaccForDevLangchain4jVersionAccessors;
        }

    }

    public static class DevLangchain4jVersionAccessors extends VersionFactory  {

        private final DevLangchain4jLangchain4jVersionAccessors vaccForDevLangchain4jLangchain4jVersionAccessors = new DevLangchain4jLangchain4jVersionAccessors(providers, config);
        public DevLangchain4jVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.dev.langchain4j.langchain4j</b>
         */
        public DevLangchain4jLangchain4jVersionAccessors getLangchain4j() {
            return vaccForDevLangchain4jLangchain4jVersionAccessors;
        }

    }

    public static class DevLangchain4jLangchain4jVersionAccessors extends VersionFactory  {

        public DevLangchain4jLangchain4jVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>dev.langchain4j.langchain4j.ollama</b> with value <b>0.27.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getOllama() { return getVersion("dev.langchain4j.langchain4j.ollama"); }

    }

    public static class IoVersionAccessors extends VersionFactory  {

        private final IoQuarkusVersionAccessors vaccForIoQuarkusVersionAccessors = new IoQuarkusVersionAccessors(providers, config);
        private final IoRestVersionAccessors vaccForIoRestVersionAccessors = new IoRestVersionAccessors(providers, config);
        public IoVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.io.quarkus</b>
         */
        public IoQuarkusVersionAccessors getQuarkus() {
            return vaccForIoQuarkusVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.io.rest</b>
         */
        public IoRestVersionAccessors getRest() {
            return vaccForIoRestVersionAccessors;
        }

    }

    public static class IoQuarkusVersionAccessors extends VersionFactory  {

        private final IoQuarkusQuarkusVersionAccessors vaccForIoQuarkusQuarkusVersionAccessors = new IoQuarkusQuarkusVersionAccessors(providers, config);
        public IoQuarkusVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.io.quarkus.quarkus</b>
         */
        public IoQuarkusQuarkusVersionAccessors getQuarkus() {
            return vaccForIoQuarkusQuarkusVersionAccessors;
        }

    }

    public static class IoQuarkusQuarkusVersionAccessors extends VersionFactory  {

        private final IoQuarkusQuarkusResteasyVersionAccessors vaccForIoQuarkusQuarkusResteasyVersionAccessors = new IoQuarkusQuarkusResteasyVersionAccessors(providers, config);
        public IoQuarkusQuarkusVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>io.quarkus.quarkus.arc</b> with value <b>3.7.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getArc() { return getVersion("io.quarkus.quarkus.arc"); }

        /**
         * Version alias <b>io.quarkus.quarkus.junit5</b> with value <b>3.7.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJunit5() { return getVersion("io.quarkus.quarkus.junit5"); }

        /**
         * Group of versions at <b>versions.io.quarkus.quarkus.resteasy</b>
         */
        public IoQuarkusQuarkusResteasyVersionAccessors getResteasy() {
            return vaccForIoQuarkusQuarkusResteasyVersionAccessors;
        }

    }

    public static class IoQuarkusQuarkusResteasyVersionAccessors extends VersionFactory  {

        private final IoQuarkusQuarkusResteasyReactiveVersionAccessors vaccForIoQuarkusQuarkusResteasyReactiveVersionAccessors = new IoQuarkusQuarkusResteasyReactiveVersionAccessors(providers, config);
        public IoQuarkusQuarkusResteasyVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.io.quarkus.quarkus.resteasy.reactive</b>
         */
        public IoQuarkusQuarkusResteasyReactiveVersionAccessors getReactive() {
            return vaccForIoQuarkusQuarkusResteasyReactiveVersionAccessors;
        }

    }

    public static class IoQuarkusQuarkusResteasyReactiveVersionAccessors extends VersionFactory  implements VersionNotationSupplier {

        public IoQuarkusQuarkusResteasyReactiveVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>io.quarkus.quarkus.resteasy.reactive</b> with value <b>3.7.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> asProvider() { return getVersion("io.quarkus.quarkus.resteasy.reactive"); }

        /**
         * Version alias <b>io.quarkus.quarkus.resteasy.reactive.jackson</b> with value <b>3.7.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJackson() { return getVersion("io.quarkus.quarkus.resteasy.reactive.jackson"); }

    }

    public static class IoRestVersionAccessors extends VersionFactory  {

        private final IoRestAssuredVersionAccessors vaccForIoRestAssuredVersionAccessors = new IoRestAssuredVersionAccessors(providers, config);
        public IoRestVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.io.rest.assured</b>
         */
        public IoRestAssuredVersionAccessors getAssured() {
            return vaccForIoRestAssuredVersionAccessors;
        }

    }

    public static class IoRestAssuredVersionAccessors extends VersionFactory  {

        private final IoRestAssuredRestVersionAccessors vaccForIoRestAssuredRestVersionAccessors = new IoRestAssuredRestVersionAccessors(providers, config);
        public IoRestAssuredVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.io.rest.assured.rest</b>
         */
        public IoRestAssuredRestVersionAccessors getRest() {
            return vaccForIoRestAssuredRestVersionAccessors;
        }

    }

    public static class IoRestAssuredRestVersionAccessors extends VersionFactory  {

        public IoRestAssuredRestVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>io.rest.assured.rest.assured</b> with value <b>5.4.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getAssured() { return getVersion("io.rest.assured.rest.assured"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

}
