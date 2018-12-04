package com.lightbend.play.tools.javascript;

import org.gradle.api.internal.file.RelativeFile;
import org.gradle.api.tasks.compile.BaseForkOptions;

import java.io.File;
import java.io.Serializable;

public class DefaultJavaScriptCompileSpec implements JavaScriptCompileSpec, Serializable {

    private final Iterable<RelativeFile> sources;
    private final File destinationDir;
    private final BaseForkOptions forkOptions;

    public DefaultJavaScriptCompileSpec(Iterable<RelativeFile> sources, File destinationDir, BaseForkOptions forkOptions) {
        this.sources = sources;
        this.destinationDir = destinationDir;
        this.forkOptions = forkOptions;
    }

    @Override
    public Iterable<RelativeFile> getSources() {
        return sources;
    }

    @Override
    public File getDestinationDir() {
        return destinationDir;
    }

    @Override
    public BaseForkOptions getForkOptions() {
        return forkOptions;
    }
}