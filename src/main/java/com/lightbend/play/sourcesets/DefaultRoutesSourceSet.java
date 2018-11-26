package com.lightbend.play.sourcesets;

import groovy.lang.Closure;
import org.gradle.api.Action;
import org.gradle.api.file.SourceDirectorySet;
import org.gradle.api.model.ObjectFactory;

import static org.gradle.util.ConfigureUtil.configure;

public class DefaultRoutesSourceSet implements RoutesSourceSet {

    private final SourceDirectorySet routes;

    public DefaultRoutesSourceSet(String name, String displayName, ObjectFactory objectFactory) {
        routes = objectFactory.sourceDirectorySet(name, displayName +  " Routes source");
        routes.srcDirs("conf");
        routes.include("routes", "*.routes");
    }

    @Override
    public SourceDirectorySet getRoutes() {
        return routes;
    }

    @Override
    public RoutesSourceSet routes(Closure configureClosure) {
        configure(configureClosure, getRoutes());
        return this;
    }

    @Override
    public RoutesSourceSet routes(Action<? super SourceDirectorySet> configureAction) {
        configureAction.execute(getRoutes());
        return this;
    }
}